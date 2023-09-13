package com.example.sprintboot_test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplicationController {
    Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @GetMapping("/confirm")
    public Object handleApplication() {
        return null;
    }
}
