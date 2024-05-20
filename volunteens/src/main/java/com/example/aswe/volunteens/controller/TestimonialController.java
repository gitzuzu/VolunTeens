package com.example.aswe.volunteens.controller;

import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.Testimonial;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @GetMapping("/testimonial")
    public ModelAndView showTestimonials(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Organization organization = (Organization) session.getAttribute("org");
        
        if (user == null && organization == null) {

            return new ModelAndView("redirect:/accessDenied");
        }
        else{
            ModelAndView modelAndView = new ModelAndView("testimonial");
            modelAndView.addObject("testimonials", testimonialService.getAllTestimonials());
            return modelAndView;
        }
       
    }

    @GetMapping("/testimonial/new")
    public ModelAndView showTestimonialForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Organization organization = (Organization) session.getAttribute("org");
        
        if (user == null && organization == null) {

            return new ModelAndView("redirect:/accessDenied");
        }
        else{
            ModelAndView modelAndView = new ModelAndView("Testimonialform");
            modelAndView.addObject("testimonial", new Testimonial());
            return modelAndView;
        
        }

    }

    @PostMapping("/testimonial")
    public ModelAndView submitTestimonial(@Valid @ModelAttribute Testimonial testimonial, BindingResult result , HttpSession session) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Testimonialform");
            return modelAndView;
        }
        testimonialService.saveTestimonial(testimonial , session);
        return new ModelAndView("redirect:/testimonial");
    }

}
