package com.simpleteam.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Simple file handler from simpleTeam.
 * The FileHandler can only convert file to byte[] array.
 *
 * @author Alexandr Bogdan, Fiz
 * @version 0.2
 */
@Component
public class FileHandler {
    /**
     * Get logger.
     */
    private Logger log = Logger.getLogger(DirectoryHandler.class);

    /**
     * Convert file to byte.
     *
     * @param path Path to the file
     * @return byte[] of file
     */
    public final byte[] convertToByte(final String path) {
        log.debug("Try convert: " + path);

        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int read;
            while ((read = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(read);
            }
        } catch (IOException e) {
            log.error("Error convert file to byte[] ", e);
        }
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.toByteArray();
        } else {
            return new byte[0];
        }
    }

    /**
     * Check file for type.
     *
     * @param file incoming file
     * @param mask something like '.png'
     * @return true if file is end like a mask
     */
    public final boolean isFileSuitable(final File file, final String mask) {
        return file.getName().toLowerCase().endsWith(mask.toLowerCase());
    }

}
