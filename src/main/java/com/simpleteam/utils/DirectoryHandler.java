package com.simpleteam.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Directory handler - utility class.
 * Can scan directory for files by specified mask.
 *
 * @version 0.1
 */
@Component
public class DirectoryHandler {
    /**
     * Get logger.
     */
    private Logger log = Logger.getLogger(DirectoryHandler.class);

    /**
     * Paths of found files.
     */
    private List<byte[]> foundFiles = new ArrayList<>();

    /**
     * Use file handler.
     */
    @Autowired
    private FileHandler fileHandler;

    /**
     * Find all files, corresponding under the mask, by specified path.
     * Convert found files to byte array.
     *
     * @param path way to directory
     * @param mask mask for files
     * @return byte[]
     */
    public final List<byte[]> findFilesByMask(final String path, final String mask) {
        log.debug("Try find files by path: " + path);

        File fileByPath = new File(path);
        File[] files = fileByPath.listFiles();

        if (files != null) {
            log.debug("Found " + files.length + " items");
            for (File file : files) {
                if (file.isFile()) {
                    log.debug("Found file: " + file.getName());
                    if (fileHandler.isFileSuitable(file, mask)) {
                        foundFiles.add(fileHandler.convertToByte(file.getPath()));
                    }
                } else {
                    log.debug(file.getName() + " is a directory");
                    findFilesByMask(file.getPath(), mask);
                }
            }
        } else {
            log.warn("Empty or wrong directory: " + path);
        }
        return foundFiles;
    }

    /**
     * Check path.
     * @param path Path as String.
     * @return true if path correct.
     */
    public final boolean isPathValid(final String path) {
        return new File(path).exists();
    }

    /**
     * Getter.
     * @return list of byte
     */
    public final List<byte[]> getFoundFiles() {
        return foundFiles;
    }

    /**
     * Setter.
     * @param files List<byte[]>
     */
    public final void setFoundFiles(final List<byte[]> files) {
        this.foundFiles = files;
    }
}
