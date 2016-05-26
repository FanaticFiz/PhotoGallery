package com.simpleteam;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhotoGalleryApplication.class)
@WebAppConfiguration
public class ControllersTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void photoGet() throws Exception {
        this.mockMvc
                .perform(get("/photo")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("photo"));
    }

    @Test
    public void photoByIdGet() throws Exception {
        this.mockMvc
                .perform(get("/photo/{id}", 0)
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @Test
    public void photoPostBedRequestTest() throws Exception {
        this.mockMvc
                .perform(post("/photo")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void photoPostRedirectTest() throws Exception {
        this.mockMvc
                .perform(post("/photo")
                        .param("photoDir", "photoDir")
                        .param("screenWidth", "1000"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/photo"));
    }

    @Test
    public void photoRedirect() throws Exception {
        this.mockMvc
                .perform(get("/")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/photo"));
    }

    @Test
    public void bySizeGet() throws Exception {
        this.mockMvc
                .perform(get("/photo/wh/{sizeMask}", "200x200")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("photoBySizeMask"));
    }

    @Test
    public void byRowGet() throws Exception {
        this.mockMvc
                .perform(get("/photo/row/{count}", "10")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("row"));
    }

    @Test
    public void originalGet() throws Exception {
        this.mockMvc
                .perform(get("/photo/original")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("original"));
    }

    @Test
    public void blackBackgroundGet() throws Exception {
        this.mockMvc
                .perform(get("/photo/blackbackground")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("black_background"));
    }

}
