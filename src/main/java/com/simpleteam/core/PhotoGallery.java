package com.simpleteam.core;

import com.simpleteam.utils.DirectoryHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple Gallery from simpleTeam.
 * Contain photos as list of byte array.
 * By default the Gallery class is use ".png" mask.
 *
 * @version 0.1
 */
@Component
public class PhotoGallery {
    /**
     * Get logger.
     */
    private Logger log = Logger.getLogger(PhotoGallery.class);

    /**
     * Mask for files.
     */
    private String mask = ".png";

    /**
     * Screen width.
     * Use in row controller.
     */
    private Integer screenWidth;

    /**
     * Contain all found photos in byte.
     */
    private List<byte[]> photos = new ArrayList<>();

    /**
     * Use Directory handler.
     */
    @Autowired
    private DirectoryHandler dirHandler;

    /**
     * Collect files by path.
     *
     * @param dirPath Path to directory
     */
    public final void collectAllFilesByMask(final String dirPath) {
        log.debug("Collect files in: " + dirPath + " By mask: " + mask);

        dirHandler.setFoundFiles(new ArrayList<byte[]>());
        photos = dirHandler.findFilesByMask(dirPath, mask);

    }

    /**
     * Getter for found photo.
     * @return List<byte[]>
     */
    public final List<byte[]> getPhotos() {
        return photos;
    }

    /**
     * Getter for mask.
     * @return mask
     */
    public final String getMask() {
        return mask;
    }

    /**
     * Set mask for file. Example: ".png"
     * @param maskForFile String
     */
    public final void setMask(final String maskForFile) {
        this.mask = maskForFile;
    }

    /**
     * Getter.
     * @return int
     */
    public final Integer getScreenWidth() {
        return screenWidth;
    }

    /**
     * Setter.
     * @param width set screen width
     */
    public final void setScreenWidth(final Integer width) {
        screenWidth = width;
    }
}
