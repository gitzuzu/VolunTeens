package com.example.aswe.volunteens.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboradController {

    @GetMapping("dashboard")
    public String dashboard(){
        return "dashboard";

    }
    
}
