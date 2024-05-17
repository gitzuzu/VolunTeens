package com.example.aswe.volunteens.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.OrganizationRepository;
import com.example.aswe.volunteens.respository.UserRepositry;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/dashboard")
public class dashboradController {
    @Autowired
    private OrganizationRepository organizationRepository;

     @Autowired
    private UserRepositry UserRepositry;

    @GetMapping("")
    public ModelAndView dashboard(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
         if (user != null ){
             if("admin@gmail.com".equals(user.getEmail())) 
                 return new ModelAndView("dashboard.html");
        }
        return new ModelAndView("redirect:/accessDenied");

    }


    @GetMapping("/users")
    public ModelAndView showUsers(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user != null){
            if( "admin@gmail.com".equals(user.getEmail())) {
                List<User> users = UserRepositry.findAll();
                ModelAndView modelAndView = new ModelAndView("Userdash");
                modelAndView.addObject("users", users);
                return modelAndView;
            }
        }
        return new ModelAndView("redirect:/accessDenied");
    }

    @GetMapping("/organizations")
    public ModelAndView getorganizations(HttpSession session, Model model){ {
        User user = (User) session.getAttribute("user");
        if (user != null ){
            if("admin@gmail.com".equals(user.getEmail())) 
             { 
                List<Organization> organizations = organizationRepository.findAll();
                model.addAttribute("organizations", organizations);
                return new ModelAndView("/organizations");
            }
       }
       return new ModelAndView("redirect:/accessDenied");
       
    } }
    
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long organizationId, @RequestParam String newStatus) {
        Organization optionalOrganization = organizationRepository.findById(organizationId).get();
        if (optionalOrganization != null) {
            optionalOrganization.setStatus(newStatus);
            organizationRepository.save(optionalOrganization);
            return "redirect:/dashboard/organizations";
        } else {
            // Handle the case where the organization is not found
            return "redirect:/dashboard/organizations?error=OrganizationNotFound";
        }
    }

    
}
