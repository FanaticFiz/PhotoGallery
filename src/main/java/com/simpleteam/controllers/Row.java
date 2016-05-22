package com.simpleteam.controllers;

import org.apache.log4j.Logger;
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
     * Catch length.
     * @param model Map for add attributes
     * @param rowCount Line must be certain length
     * @return view
     */
    @RequestMapping("/photo/row/{count}")
    public final String rowGet(final Model model, @PathVariable("count") final Integer rowCount) {
        log.info("GET");

        model.addAttribute("rowCount", rowCount);
        return "row";
    }

}
