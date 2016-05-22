package com.simpleteam.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Photo by size mask.
 */
@Controller
public class PhoboBySizeMask {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(PhoboBySizeMask.class);

    /**
     * Catch size mask of photo.
     * @param model Map for add attributes
     * @param sizeMask mask for photo size
     * @return view
     */
    @RequestMapping("/photo/wh/{sizeMask}")
    public final String row(final Model model, @PathVariable("sizeMask") final String sizeMask) {
        log.info("GET");

        model.addAttribute("sizeMask", sizeMask);
        return "photoBySizeMask";
    }

}
