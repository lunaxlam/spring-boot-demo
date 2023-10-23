package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication annotation adds:
// - @Configuration: Tags this class as a source of bean definitions for the application context
// - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and other various property settings
//      i.e. if 'spring-webmvc' is on the classpath, then this annotation will flag the application as a web application
//          and activates key behaviors, such as setting up 'DispatcherServlet'
// - @ComponentScan: Tells Spring to look for other components, configurations, and services in the 'com/example' package,
//      letting it find the Controllers
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Spring Boot's SpringApplication.run() is used to launch an application.
        // There are no XML lines or web.xml file required when using Spring Boot (no need to configure any plumnbing or infrastructure).
        SpringApplication.run(Application.class, args);
    }

    // CommandLineRunner() will run on start-up
    // def: Retrieves, sorts, and prints out all the beans created by our application,
    // as well as all beans automatically added by Spring Boot
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
