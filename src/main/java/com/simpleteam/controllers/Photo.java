/**
 * Package-info.
 */
package com.simpleteam.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Photo controller.
 * Also redirect '/' to photo...
 */
@Controller
public class Photo {

    /**
     * get logger.
     */
    private final Logger log = Logger.getLogger(Photo.class);

    /**
     * Just redirect to '/photo'.
     * @return 'photo' template
     */
    @RequestMapping("/")
    public final String home() {
        log.info("redirect to '/photo' ");

        return "redirect:/photo";
    }

    /**
     * Catches GET request to '/photo'.
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo")
    public final String photo() {
        log.info("Photo - GET");

        return "photo";
    }

    /**
     * Catches POST request to '/photo'.
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public final String photoHandler() {
        log.info("Photo - POST");

        return "photo";
    }

}
