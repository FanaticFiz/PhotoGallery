package com.simpleteam.controllers;

import com.simpleteam.core.PhotoGallery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Black background controller.
 */
@Controller
public class Blackbackground {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(Blackbackground.class);

    /**
     * Use PhotoGallery class.
     */
    @Autowired
    private PhotoGallery gallery;

    /**
     * Black background.
     * @param model Map for add attributes
     * @return view
     */
    @RequestMapping("/photo/blackbackground")
    public final String blackbackground(final Model model) {
        log.debug("GET");

        model.addAttribute("photos", new int[gallery.getPhotos().size()]);
        return "black_background";
    }

}
