package org.launchcode.Chapter5.Lecture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

    // Here we have a method that will render the home.html view at localhost:8080 (the root path)

    @GetMapping
    public String home() {
        return "home";
    }


}
