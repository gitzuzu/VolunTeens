package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TempController {
    @GetMapping("aboutus")
    public ModelAndView about() {
        return new ModelAndView("about.html");
    }

    @GetMapping("opportunities")
    public ModelAndView opportunities(HttpSession session) {
        if (session.getAttribute("userId") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        return new ModelAndView("volunteer.html");
    
    }
    

    @GetMapping("donate")
    public ModelAndView donate(HttpSession session) {
        if (session.getAttribute("userId") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
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
    public ModelAndView volunteer(HttpSession session) {
        if (session.getAttribute("userId") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        return new ModelAndView("volunteer.html");
    
    }
        
    

    @GetMapping("postOpportunity")
    public ModelAndView postOpportunity(HttpSession session) {
        if (session.getAttribute("orgId") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        return new ModelAndView("postOpportunity.html");
    
    }

    @GetMapping("accessDenied")
    public ModelAndView accessDenied() {
        return new ModelAndView("404.html");
    }
    
}
