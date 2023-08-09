package com.thevarungupta.springbootsampleapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String index(){
        return "Hello from spring boot inside a container";
    }
}
