package com.example.aswe.volunteens.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;







@RestController
public class TempController {
    @GetMapping("aboutus")
    public ModelAndView about(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String orgId = (String) session.getAttribute("orgId");
        ModelAndView mav = new ModelAndView("about.html");
        model.addAttribute("userId", userId);
        model.addAttribute("orgId", orgId);
        return mav;
    }

    @GetMapping("opportunities")
    public ModelAndView opportunities(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        ModelAndView mav = new ModelAndView("opportunities.html");
        model.addAttribute("userId", userId);
        return mav;
    }

    @GetMapping("donate")
    public ModelAndView donate(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        ModelAndView mav = new ModelAndView("donate.html");
        model.addAttribute("userId", userId);
        return mav;
    }

    @GetMapping("service")
    public ModelAndView service(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String orgId = (String) session.getAttribute("orgId");
        ModelAndView mav = new ModelAndView("service.html");
        model.addAttribute("userId", userId);
        model.addAttribute("orgId", orgId);
        return mav;
    }

    @GetMapping("testimonial")
    public ModelAndView testimonial(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String orgId = (String) session.getAttribute("orgId");
        ModelAndView mav = new ModelAndView("testimonial.html");
        model.addAttribute("userId", userId);
        model.addAttribute("orgId", orgId);
        return mav;
    }
    
    @GetMapping("contactus")
    public ModelAndView contactus(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String orgId = (String) session.getAttribute("orgId");
        ModelAndView mav = new ModelAndView("contactus.html");
        model.addAttribute("userId", userId);
        model.addAttribute("orgId", orgId);
        return mav;
    }

    @GetMapping("volunteer")
    public ModelAndView volunteer(Model model,HttpSession session) {
        String userId = (String) session.getAttribute("userId"); 
        ModelAndView mav = new ModelAndView("volunteer.html");
        model.addAttribute("userId", userId);
        return mav;
    }

    @GetMapping("postOpportunity")
    public ModelAndView postOpportunity(Model model,HttpSession session) {
        String orgId = (String) session.getAttribute("orgId");
        ModelAndView mav = new ModelAndView("postOpportunity.html");
        model.addAttribute("orgId", orgId);
        return mav;
    }
    
}
