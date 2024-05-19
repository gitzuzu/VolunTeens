package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.aswe.volunteens.dto.ApplicationDTO;
import com.example.aswe.volunteens.dto.DonationDTO;
import com.example.aswe.volunteens.dto.OpportunityDTO;
import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.model.Opportunity;
import com.example.aswe.volunteens.model.Organization;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.service.ApplicationService;
import com.example.aswe.volunteens.service.DonationService;
import com.example.aswe.volunteens.service.OpportunityService;
import com.example.aswe.volunteens.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
public class TempController {
    @Autowired
    private DonationService donationService;

    @Autowired
    private OpportunityService opportunityService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired 
    private UserService userService;

    @GetMapping("editUserProfile")
    public ModelAndView editUserProfile(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        model.addAttribute("userDTO",(User)session.getAttribute("user"));
        return new ModelAndView("editUserProfile.html");
    }

    @PostMapping("updateUser")
    public ModelAndView saveUserProfile(@ModelAttribute UserDTO userDTO,RedirectAttributes ra,HttpSession session){
        userService.updateUserProfile(userDTO,session);
        ra.addFlashAttribute("message","Success! your profile updated");
        return new ModelAndView("redirect:/editUserProfile");
    }
    
    @GetMapping("editOpportunity")
    public ModelAndView editOpportunity() {
        return new ModelAndView("editOpportunity.html");
    }
    
    @GetMapping("editProfile")
    public ModelAndView editProfile() {
        return new ModelAndView("editOrgProfile.html");
    }


    @GetMapping("aboutus")
    public ModelAndView about() {
        return new ModelAndView("about.html");
    }

    @GetMapping("opportunities")
    public ModelAndView opportunities(@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "6") int size,HttpSession session,Model model) {
        if (session.getAttribute("user") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("opportunitiesPage", opportunityService.allOpportunities(pageable));
        return new ModelAndView("opportunities.html");
    }

    @GetMapping("donate")
    public ModelAndView donate(Model model,HttpSession session) {
        if (session.getAttribute("user") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        else{
           
            DonationDTO donateDTO = new DonationDTO();
            User user = (User) session.getAttribute("user");
            
            donateDTO.setUserId(user.getFirstname());
            donateDTO.setUserEmail(user.getEmail());
            
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

    
    
    @GetMapping("contactus")
    public ModelAndView contactus() {
        return new ModelAndView("contactus.html");
    }

   
    @GetMapping("volunteer")
    public ModelAndView volunteer(HttpSession session ,@RequestParam ("opportunityId") Long opportunityId
    ,@ModelAttribute ApplicationDTO applicationDTO,Model model) {
        if (session.getAttribute("user") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        User user = (User) session.getAttribute("user");
       applicationDTO.setOpportunityId(opportunityId);
       applicationDTO.setName(user.getFirstname());
       applicationDTO.setEmail(user.getEmail());
       model.addAttribute("opportunity", opportunityService.findOpportunity(opportunityId));
       model.addAttribute("applicationDTO", applicationDTO);
        return new ModelAndView("volunteer.html");
    
    }
    @PostMapping("volunteer")
    public ModelAndView saveApplication(@Valid @ModelAttribute ApplicationDTO applicationDTO, BindingResult result, RedirectAttributes ra) throws IOException {
        System.out.println(result.getAllErrors());
    
        if (applicationDTO.getCv().isEmpty()) {
            result.addError(new FieldError("applicationDTO", "cv", "Please provide a file"));
        } else if (!applicationDTO.getCv().getContentType().equals("application/pdf")) {
            result.addError(new FieldError("applicationDTO", "cv", "Only PDF files are allowed"));
        }
    
        if (result.hasErrors()) {
            System.out.println(result.hasErrors());
            return new ModelAndView("volunteer.html");
        }
    
        applicationService.saveApplication(applicationDTO);
        ra.addFlashAttribute("message", "Success! Your application has been sent!");
        
        // Ensure the opportunityId is included in the redirect
        return new ModelAndView("redirect:/volunteer?opportunityId=" + applicationDTO.getOpportunityId());
    }

    @GetMapping("postOpportunity")
    public ModelAndView postOpportunity(HttpSession session, @ModelAttribute OpportunityDTO opportunityDTO, Model model) {
        User user = (User) session.getAttribute("user");
        Organization organization = (Organization) session.getAttribute("org");

        if (user != null && user.getIsAdmin()) {
            model.addAttribute("opportunityDTO", opportunityDTO);
            return new ModelAndView("postOpportunity.html");
        }

        if (organization != null && "approved".equalsIgnoreCase(organization.getStatus())) {
            model.addAttribute("opportunityDTO", opportunityDTO);
            return new ModelAndView("postOpportunity.html");
        }

        return new ModelAndView("redirect:/accessDenied");
    }

    @PostMapping("postOpportunity")
    public ModelAndView postedOpportunity(@Valid @ModelAttribute OpportunityDTO opportunityDTO,BindingResult bindingResult,HttpSession session,RedirectAttributes ra) {
        if(opportunityService.TitleExist(opportunityDTO.getTitle())){
            bindingResult.addError(new FieldError("opportunityDTO", "title", "Title already in use"));
        }
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.hasErrors());
            return new ModelAndView("postOpportunity.html");
        }
        opportunityService.postedOpportunity(opportunityDTO ,session);
        ra.addFlashAttribute("message","Success! your post opportunity ");
        return new ModelAndView("redirect:/postOpportunity");
    }
    

    @GetMapping("accessDenied")
    public ModelAndView accessDenied() {
        return new ModelAndView("404.html");
    }


    @GetMapping("logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("/");
    }
    
    
    
}
