package com.simpleteam.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Original controller.
 */
@Controller
public class Original {
    /**
     * Get logger.
     */
    private final Logger log = Logger.getLogger(Original.class);

    /**
     * Original.
     * @param model Map for add attributes
     * @return view
     */
    @RequestMapping("/original")
    public final String original(final Model model) {
        log.debug("GET");

        model.addAttribute("realPhotoSize", "123");
        return "original";
    }

}
