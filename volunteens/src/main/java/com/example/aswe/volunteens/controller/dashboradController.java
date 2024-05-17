package com.example.aswe.volunteens.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.UserRepositry;

import jakarta.servlet.http.HttpSession;

@Controller
public class dashboradController {

     @Autowired
    private UserRepositry UserRepositry;

    @GetMapping("dashboard")
    public ModelAndView dashboard(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
         if (user != null &&"admin@gmail.com".equals(user.getEmail())) {
           
            return new ModelAndView("dashboard.html");
        }
        return new ModelAndView("redirect:/accessDenied");

    }


    @GetMapping("/users")
    public ModelAndView showUsers(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null && "admin@gmail.com".equals(user.getEmail())) {
            List<User> users = UserRepositry.findAll();
            ModelAndView modelAndView = new ModelAndView("Userdash");
            modelAndView.addObject("users", users);
            return modelAndView;
        }
        return new ModelAndView("redirect:/accessDenied");
    }
    
}
