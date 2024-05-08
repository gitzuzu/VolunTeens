package com.example.aswe.volunteens.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Organization org = (Organization) session.getAttribute("org");
        model.addAttribute("user", user);
        model.addAttribute("org", org);
    }
}
