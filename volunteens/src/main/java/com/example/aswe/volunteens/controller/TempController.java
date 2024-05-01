package com.example.aswe.volunteens.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;







@RestController
public class TempController {
    @GetMapping("aboutus")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("about.html");
        return mav;
    }

    @GetMapping("opportunities")
    public ModelAndView opportunities() {
        ModelAndView mav = new ModelAndView("opportunities.html");
        return mav;
    }
    
}
