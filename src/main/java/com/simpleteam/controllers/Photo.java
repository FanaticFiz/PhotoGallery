package com.simpleteam.controllers;

import com.simpleteam.core.PhotoGallery;
import com.simpleteam.utils.DirectoryHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Photo controller.
 * Also redirect '/' to photo...
 */
@Controller
public class Photo {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(Photo.class);

    /**
     * Use PhotoGallery class.
     */
    @Autowired
    private PhotoGallery gallery;

    /**
     * Use Directory handler.
     */
    @Autowired
    private DirectoryHandler dirHandler;

    /**
     * Just redirect to '/photo'.
     *
     * @return 'photo' template
     */
    @RequestMapping("/")
    public final String home() {
        log.debug("redirect to '/photo' ");

        return "redirect:/photo";
    }

    /**
     * Catches GET request to '/photo'.
     *
     * @param model Map for add attributes
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo")
    public final String photo(final Model model) {
        log.debug("RequestMethod GET");

        model.addAttribute("showPhoto", 0);
        return "photo";
    }

    /**
     * Catches POST request to '/photo'.
     *
     * @param model Map for add attributes
     * @param path  way to directory
     * @param redirectAttr for send attribute.
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public final String photoHandler(final Model model, final RedirectAttributes redirectAttr,
                                     @RequestParam("photoDir") final String path) {
        log.debug("RequestMethod POST. Value: " + path);
        if (path == null || !dirHandler.isPathValid(path)) {
            log.warn("Incoming path is incorrect.");
            redirectAttr.addFlashAttribute("hasError", "Incoming path is incorrect.");
            return "redirect:/photo";
        }

        gallery.collectAllFilesByMask(path);

        model.addAttribute("showPhoto", 1)
             .addAttribute("photos", new int[gallery.getPhotos().size()]);
        return "photo";
    }

    /**
     * Return Photo by id as byte[].
     *
     * @param id number photo in list
     * @return Photo as byte[]
     */
    @RequestMapping("/photo/{id}")
    @ResponseBody
    public final HttpEntity<byte[]> getPicture(@PathVariable final int id) {
        byte[] image = null;
        HttpHeaders headers = new HttpHeaders();

        try {
            image = gallery.getPhotos().get(id);
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(image.length);
        } catch (Exception e) {
            log.error("Error get byte[] of image. ", e);
        }
        return new HttpEntity<byte[]>(image, headers);
    }
}
