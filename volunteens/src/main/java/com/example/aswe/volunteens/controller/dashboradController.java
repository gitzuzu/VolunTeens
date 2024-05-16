package com.example.aswe.volunteens.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.aswe.volunteens.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class dashboradController {

    @GetMapping("dashboard")
    public ModelAndView dashboard(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
         if (user != null &&"admin@gmail.com".equals(user.getEmail())) {
           
            return new ModelAndView("dashboard.html");
        }
        return new ModelAndView("redirect:/accessDenied");

    }
    
}
