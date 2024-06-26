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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.aswe.volunteens.dto.DonationDTO;
import com.example.aswe.volunteens.dto.OrganizationDTO;
import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.Donation;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.Testimonial;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.respository.OrganizationRepository;
import com.example.aswe.volunteens.service.DonationService;
import com.example.aswe.volunteens.service.OpportunityService;
import com.example.aswe.volunteens.service.OrganizationService;
import com.example.aswe.volunteens.service.TestimonialService;
import com.example.aswe.volunteens.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class DashboardController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TestimonialService testimonialService;

    @Autowired
    private OpportunityService opportunityService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private DonationService donationService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.getIsAdmin()) {
            model.addAttribute("adminInfo", user);

            long totalUsers = userService.getTotalUsers();
            model.addAttribute("totalUsers", totalUsers);

            List<Donation> recentDonations = donationService.findRecentDonations();
            model.addAttribute("recentDonations", recentDonations);

            return "dashboard";
        }
        return "redirect:/accessDenied";
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

    @GetMapping("/User/edit/{userId}")
    public ModelAndView editUser(Model model, @PathVariable("userId") Long userId) {
        model.addAttribute("user", userService.findUser(userId));
        return new ModelAndView("editUser.html");
    }

    @PostMapping("/User/update")
    public ModelAndView saveEditUser(@ModelAttribute UserDTO userDTO, RedirectAttributes ra) {

        userService.updateUser(userDTO);
        ra.addFlashAttribute("message", "Success! Your data is updated!");
        return new ModelAndView("redirect:/User/edit/" + userDTO.getUserId());
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

    @GetMapping("/Organization/edit/{organizationId}")
    public ModelAndView editOrganization(Model model, @PathVariable("organizationId") Long organizationId) {
        model.addAttribute("organizationDTO", organizationService.findOrganization(organizationId));
        return new ModelAndView("editorg.html");
    }

    @PostMapping("/Organization/update")
    public ModelAndView saveEditOrganization(@ModelAttribute OrganizationDTO organizationDTO, RedirectAttributes ra) {

        organizationService.updateOrganizationdash(organizationDTO);
        ra.addFlashAttribute("message", "Success! Your data is updated!");
        return new ModelAndView("redirect:/Organization/edit/" + organizationDTO.getOrganizationId());
    }

    @PostMapping("/User/toggleAdmin/{id}")
    public String toggleAdmin(@PathVariable Long id) {
        userService.toggleAdmin(id); // Implement this method in your UserService to toggle the admin status
        return "redirect:/users"; // Redirect back to the users page
    }

    @GetMapping("/Opportunity")
    public ModelAndView opportunity(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.getIsAdmin()) {

            model.addAttribute("opportunities", opportunityService.allOpportunities());
            return new ModelAndView("Opportunitydash");
        }

        return new ModelAndView("redirect:/accessDenied");
    }

    @PostMapping("/updateOpportunityStatus")
    public String updateOpportunityStatus(@RequestParam Long opportunityId, @RequestParam String newStatus) {
        opportunityService.updateOpportunityStatus(opportunityId, newStatus);
        return "redirect:/Opportunity";
    }

    @GetMapping("/reports")
    public String showReports(Model model) {
        List<Testimonial> testimonials = testimonialService.getAllTestimonials();
        model.addAttribute("testimonials", testimonials);
        return "reports";
    }

    @PostMapping("/delete-testimonial")
    public String deleteTestimonial(@RequestParam("id") Long id, Model model) {
        testimonialService.deleteTestimonialById(id);
        return "redirect:/reports";
    }

    @PostMapping("/testimonials/approve/{id}")
    public String approveTestimonial(@PathVariable Long id) {
        testimonialService.approveTestimonial(id);
        return "redirect:/reports";
    }

    @GetMapping("/Organization/delete/{organizationId}")
    public String deleteOrganization(@PathVariable Long organizationId, RedirectAttributes ra) {
        organizationService.deleteOrganization(organizationId);
        ra.addFlashAttribute("message", "Organization deleted successfully!");
        return "redirect:/organizations";
    }

 
     
    
}