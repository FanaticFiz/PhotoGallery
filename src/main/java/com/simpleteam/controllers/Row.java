package com.simpleteam.controllers;

import com.simpleteam.core.PhotoGallery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Photo by a line controller.
 */
@Controller
public class Row {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(Row.class);

    /**
     * Padding between photos.
     */
    private final int padding = 20;

    /**
     * Use PhotoGallery class.
     */
    @Autowired
    private PhotoGallery gallery;

    /**
     * Catch length.
     * @param model Map for add attributes
     * @param rowCount Line must be certain length
     * @return view
     */
    @RequestMapping("/photo/row/{count}")
    public final String rowGet(final Model model, @PathVariable("count") final Integer rowCount) {
        log.debug("Row count: " + rowCount);

        model.addAttribute("size", (gallery.getScreenWidth() - rowCount * padding) / rowCount)
             .addAttribute("photos", new int[gallery.getPhotos().size()]);
        return "row";
    }

}
