package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController annotation indicates this class is read for use by Spring MVC to handle web requests
// When invoked from a browser or by using cURL on the CLI, the index() returns pure text
// because @RestController is a combination of @Controller & @ResponseBody,
// which are two annotations that results in web requests that return data (instead of a view).
@RestController
public class HelloController {

    // @GetMapping maps the "/" endpoint to the index() method
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
