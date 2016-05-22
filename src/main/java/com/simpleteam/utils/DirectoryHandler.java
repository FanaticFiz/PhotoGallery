package com.simpleteam.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Directory handler utility class.
 * Take 'path' as string, scan it for *.png files.
 *
 * @author Fiz
 * @version 0.1
 */
@Component
public class DirectoryHandler {
    /**
     * Get logger.
     */
    private Logger log = Logger.getLogger(DirectoryHandler.class);

    /**
     * Contain all found file paths.
     */
    private List<String> foundPaths;

    /**
     * Instance.
     */
    public DirectoryHandler() {
        this.foundPaths = new ArrayList<>();
    }

    /**
     * Find all files, corresponding under the mask, by specified path.
     * Return an array of found ways.
     *
     * @param path way to directory
     * @param mask mask for files
     * @return an array of file paths.
     */
    public final List<String> findAllFilesByMask(final String path, final String mask) {
        log.debug("Try find files by path: " + path);

        File fileByPath = new File(path);
        File[] files = fileByPath.listFiles();

        if (files != null) {
            log.debug("Found " + files.length + " items");
            for (File file : files) {
                if (file.isFile()) {
                    log.debug("Found file: " + file.getName());
                    if (isFileSuitable(file, mask)) {
                        foundPaths.add(path + File.separator + file.getName());
                    }
                } else {
                    log.debug(file.getName() + " is a directory");
                    findAllFilesByMask(path + File.separator + file.getName(), mask);
                }
            }
        } else {
            log.warn("Empty or wrong directory: " + path);
        }
        return foundPaths;
    }

    /**
     * Check file for type.
     *
     * @param file incoming file
     * @param mask something like '.png'
     * @return true if file is end like a mask
     */
    private boolean isFileSuitable(final File file, final String mask) {
        return file.getName().toLowerCase().endsWith(mask.toLowerCase());
    }
}
