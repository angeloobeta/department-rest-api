package com.example.departmentrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomePage {
    @GetMapping("/")
    public String indexPage(){
        return "Server is up & running";
    }
}
