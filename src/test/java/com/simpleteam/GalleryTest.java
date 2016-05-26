package com.simpleteam;

import com.simpleteam.core.PhotoGallery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GalleryTest {
    private PhotoGallery photoGallery;

    @Before
    public void before() {
        photoGallery = new PhotoGallery();
    }

    @Test
    public void testForGettersSetters() {

        assertEquals(".png", photoGallery.getMask());
        assertEquals(0, photoGallery.getPhotos().size());
        assertEquals(0, photoGallery.getScreenWidth());

        photoGallery.setMask(".txt");
        photoGallery.setScreenWidth(1000);

        assertEquals(".txt", photoGallery.getMask());
        assertEquals(1000, photoGallery.getScreenWidth());
    }
}
