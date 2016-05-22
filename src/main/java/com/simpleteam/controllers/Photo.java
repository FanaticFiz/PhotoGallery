package com.simpleteam.controllers;

import com.simpleteam.utils.DirectoryHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
     * Use DirectoryHandler.
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
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public final String photoHandler(final Model model, @RequestParam("photoDir") final String path) {
        log.debug("RequestMethod POST. Value: " + path);

        if (path == null) {
            log.warn("Incoming path is null");
        }

        List<String> allFilesByMask = dirHandler.findAllFilesByMask(path, ".png");
        allFilesByMask.stream().forEach(System.out::println);

        model.addAttribute("showPhoto", 1)
             .addAttribute("photoCounter", allFilesByMask.size());
        return "photo";
    }

}
