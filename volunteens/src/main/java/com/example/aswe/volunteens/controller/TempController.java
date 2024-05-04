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

    @GetMapping("donate")
    public ModelAndView donate() {
        ModelAndView mav = new ModelAndView("donate.html");
        return mav;
    }

    @GetMapping("service")
    public ModelAndView service() {
        ModelAndView mav = new ModelAndView("service.html");
        return mav;
    }

    @GetMapping("testimonial")
    public ModelAndView testimonial() {
        ModelAndView mav = new ModelAndView("testimonial.html");
        return mav;
    }
    
    @GetMapping("contactus")
    public ModelAndView contactus() {
        ModelAndView mav = new ModelAndView("contactus.html");
        return mav;
    }

    @GetMapping("volunteer")
    public ModelAndView volunteer() {
        ModelAndView mav = new ModelAndView("volunteer.html");
        return mav;
    }
    
}
