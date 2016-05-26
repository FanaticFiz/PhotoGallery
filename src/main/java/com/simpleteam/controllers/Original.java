package com.simpleteam.controllers;

import com.simpleteam.core.PhotoGallery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Original controller.
 *
 * @author Fiz
 * @version 0.1
 */
@Controller
public class Original {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(Original.class);

    /**
     * Use PhotoGallery class.
     */
    @Autowired
    private PhotoGallery gallery;

    /**
     * Original.
     * @param model Map for add attributes
     * @return view
     */
    @RequestMapping("/photo/original")
    public final String original(final Model model) {
        log.debug("GET");

        model.addAttribute("photos", new int[gallery.getPhotos().size()]);
        return "original";
    }

}
