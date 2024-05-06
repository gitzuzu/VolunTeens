package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.aswe.volunteens.dto.DonationDTO;
import com.example.aswe.volunteens.service.DonationService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TempController {
    @Autowired
    private DonationService donationService;

    @GetMapping("aboutus")
    public ModelAndView about() {
        return new ModelAndView("about.html");
    }

    @GetMapping("opportunities")
    public ModelAndView opportunities(HttpSession session) {
        if (session.getAttribute("userId") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        return new ModelAndView("opportunities.html");
    }
    

    @GetMapping("donate")
    public ModelAndView donate(Model model,HttpSession session) {
        if (session.getAttribute("userId") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        else{
            model.addAttribute("userEmail", session.getAttribute("userEmail"));
            DonationDTO donateDTO = new DonationDTO();
            String userId = (String) session.getAttribute("userId");
            String userEmail = (String) session.getAttribute("userEmail");

            
            donateDTO.setUserId(userId);
            donateDTO.setUserEmail(userEmail);
            
            model.addAttribute("donateDTO", donateDTO);
            return new ModelAndView("donate.html");
        }
        
    }
    @PostMapping("donate")
    public String saveDonation(@ModelAttribute DonationDTO donateDTO, HttpSession session) {


        donationService.saveDonation(donateDTO);
        return "success";
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
