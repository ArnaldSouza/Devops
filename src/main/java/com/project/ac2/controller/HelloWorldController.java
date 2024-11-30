package com.project.ac2.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.project.ac2", "com.project.ac2.controller"})
@RestController
@RequestMapping("/test")
public class HelloWorldController {
	
	@GetMapping("/example")
    public String example() {
        return "Arnald Victor";
    }
}
