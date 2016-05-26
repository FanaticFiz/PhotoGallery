package com.simpleteam;

import com.simpleteam.core.PhotoGallery;
import com.simpleteam.utils.DirectoryHandler;
import com.simpleteam.utils.FileHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhotoGalleryApplication.class)
@WebAppConfiguration
public class PhotoGalleryApplicationTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    PhotoGallery photoGallery;

    @Autowired
    DirectoryHandler directoryHandler;

    @Autowired
    FileHandler fileHandler;

    @Test
    public void photoGalleryTest() throws Exception {
        photoGallery.collectAllFilesByMask("gsdfgsdfg");
    }

    @Test
    public void DirHandlerTest() throws Exception {
        assertEquals(0, directoryHandler.findFilesByMask("file", "mask").size());
    }

    @Test
    public void fileHandlerTest() throws Exception {
        assertEquals(0, fileHandler.convertToByte("file").length);
        assertEquals(0, fileHandler.convertToByte("C:\\Temp\\111111111111111\\12.png").length);
    }

    @Test
    public void mainTest() throws Exception {
        PhotoGalleryApplication application = new PhotoGalleryApplication();
        application.main(new String[] {"", ""});
    }


}
