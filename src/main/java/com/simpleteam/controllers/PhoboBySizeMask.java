package com.simpleteam.controllers;

import com.simpleteam.core.PhotoGallery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Photo by size mask.
 *
 * @author Fiz
 * @version 0.1
 */
@Controller
public class PhoboBySizeMask {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(PhoboBySizeMask.class);

    /**
     * Default size X.
     */
    private final int defaultX = 200;

    /**
     * Default size Y.
     */
    private final int defaultY = 200;

    /**
     * Use PhotoGallery class.
     */
    @Autowired
    private PhotoGallery gallery;

    /**
     * Catch size mask of photo.
     * @param model Map for add attributes
     * @param sizeMask mask for photo size
     * @return view
     */
    @RequestMapping("/photo/wh/{sizeMask}")
    public final String bySize(final Model model, @PathVariable("sizeMask") final String sizeMask) {
        log.info("GET");

        int sizeX = defaultX;
        int sizeY = defaultY;
        try {
            String[] sizeXY = sizeMask.split("x");
            sizeX = Integer.parseInt(sizeXY[0]);
            sizeY = Integer.parseInt(sizeXY[1]);
        } catch (Exception e) {
            log.error("Wrong size: " + sizeMask + "  ", e);
        }

        model.addAttribute("sizeX", sizeX)
             .addAttribute("sizeY", sizeY)
             .addAttribute("photos", new int[gallery.getPhotos().size()]);
        return "photoBySizeMask";
    }

}
