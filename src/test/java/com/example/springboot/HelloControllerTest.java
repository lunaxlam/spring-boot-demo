package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// @SpringBootTest & @AutoConfigureMockMvc enables to inject a MockMvc instance.
// @SpringBootTest asks for the whole application context to be created so we can locate the main method.
// Instead of @SpringBootTest, we could also use @WebMvcTest, which would create only the web layers of the context.
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    // MockMvc comes from Spring Test -
    // through a set of convenient builder classes, we can send HTTP requests into the DispatcherServlet
    // and make assertions about the result.
    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

}