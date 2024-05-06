package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TempController {
    @GetMapping("aboutus")
    public ModelAndView about() {
        return new ModelAndView("about.html");
    }

    @GetMapping("opportunities")
    public ModelAndView opportunities() {
        return new ModelAndView("opportunities.html");
    }

    @GetMapping("donate")
    public ModelAndView donate() {
        return new ModelAndView("donate.html");
    }

    @GetMapping("service")
    public ModelAndView service() {
        return new ModelAndView("service.html");
    }

    @GetMapping("testimonial")
    public ModelAndView testimonial() {
        return new ModelAndView("testimonial.html");
    }
    
    @GetMapping("contactus")
    public ModelAndView contactus() {
        return new ModelAndView("contactus.html");
    }

    @GetMapping("volunteer")
    public ModelAndView volunteer() {
        return new ModelAndView("volunteer.html");
    }

    @GetMapping("postOpportunity")
    public ModelAndView postOpportunity() {
        return new ModelAndView("postOpportunity.html");
    }
}
