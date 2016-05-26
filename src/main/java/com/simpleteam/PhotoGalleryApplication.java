package com.simpleteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Photo Gallery from simpleTeam.
 */
@SpringBootApplication
public class PhotoGalleryApplication {

    /**
     * Creates a new instance.
     */
    protected PhotoGalleryApplication() {
    }

    /**
     * Start here.
     * @param args not use any parameters.
     */
    public static void main(final String[] args) {
        SpringApplication.run(PhotoGalleryApplication.class, args);
    }

}
