package com.example.aswe.volunteens.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String orgId = (String) session.getAttribute("orgId");
        model.addAttribute("userId", userId);
        model.addAttribute("orgId", orgId);
    }
}
