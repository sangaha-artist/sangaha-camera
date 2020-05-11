package com.sangaha.sangahacamera.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/web")
@RestController
@Slf4j
public class WebRestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!!";
    }
}
