package com.example.aswe.volunteens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.OrganizationRepository;
import com.example.aswe.volunteens.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class DashboardController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserService userService;

    @GetMapping("dashboard")
    public ModelAndView dashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.getIsAdmin()) {
            return new ModelAndView("dashboard.html");
        }
        return new ModelAndView("redirect:/accessDenied");
    }

    @GetMapping("/users")
    public ModelAndView showUsers(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.getIsAdmin()) {
            ModelAndView modelAndView = new ModelAndView("Userdash");
            modelAndView.addObject("users", userService.findAllUsers());
            return modelAndView;
        }
        return new ModelAndView("redirect:/accessDenied");
    }

    @GetMapping("/User/AddUser")
    public ModelAndView showAddUserForm() {
        ModelAndView modelAndView = new ModelAndView("addUser");
        modelAndView.addObject("userDTO", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/User/AddUser")
    public ModelAndView addUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("addUser");
        
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        
        if (userService.EmailExist(userDTO.getEmail())) {
            bindingResult.addError(new FieldError("userDTO", "email", "Email already exists"));
            return modelAndView;
        }

        if (!userDTO.getPassword().equals(userDTO.getCpassword())) {
            bindingResult.addError(new FieldError("userDTO", "cpassword", "Passwords do not match"));
            return modelAndView;
        }

        userService.saveUser(userDTO);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/User/delete/{userId}")
    public ModelAndView deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ModelAndView("redirect:/users");
    }
    @GetMapping("/organizations")
    public ModelAndView getorganizations(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.getIsAdmin()) {
            List<Organization> organizations = organizationRepository.findAll();
            model.addAttribute("organizations", organizations);
            return new ModelAndView("orgdash");
        }
        return new ModelAndView("redirect:/accessDenied");
    }
    
    
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long organizationId, @RequestParam String newStatus) {
        Organization organization = organizationRepository.findById(organizationId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid organization Id:" + organizationId));
        organization.setStatus(newStatus);
        organizationRepository.save(organization);
        return "redirect:/organizations"; 
    }
    

    @PostMapping("/User/toggleAdmin/{id}")
    public String toggleAdmin(@PathVariable Long id) {
        userService.toggleAdmin(id); // Implement this method in your UserService to toggle the admin status
        return "redirect:/users"; // Redirect back to the users page
    }
}
