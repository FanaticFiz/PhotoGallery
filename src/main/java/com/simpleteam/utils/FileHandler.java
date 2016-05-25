package com.simpleteam.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Simple file handler from simpleTeam.
 * The FileHandler can only convert file to byte[] array.
 *
 * @version 0.1
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
        return byteArrayOutputStream.toByteArray();
    }
}
