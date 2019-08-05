package com.thoughmechanix.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/hello")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/{firstname}/{lastname}", method = RequestMethod.GET)
    public String hello(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {
        return String.format("{\"message\":\"hello %s %s\"}", firstname, lastname);
    }

}
