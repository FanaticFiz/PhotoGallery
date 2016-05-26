package com.simpleteam;

import com.simpleteam.utils.DirectoryHandler;
import com.simpleteam.utils.FileHandler;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void fileHandlerTest() {
        FileHandler fileHandler = new FileHandler();

        assertEquals(true, fileHandler != null);
        assertEquals(true, fileHandler.isFileSuitable(new File("file.png"), ".png"));
    }

    @Test
    public void dirHandlerTest() {
        DirectoryHandler dirHandler = new DirectoryHandler();
        dirHandler.setFoundFiles(new ArrayList<>());

        assertEquals(true, dirHandler != null);
        assertEquals(false, dirHandler.isPathValid("false"));
        assertEquals(0, dirHandler.getFoundFiles().size());
        assertEquals(0, dirHandler.findFilesByMask("sdfsfsf", ".png").size());
    }

}
