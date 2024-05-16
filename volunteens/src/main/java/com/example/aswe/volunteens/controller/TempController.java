package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.aswe.volunteens.dto.DonationDTO;
import com.example.aswe.volunteens.dto.OpportunityDTO;
import com.example.aswe.volunteens.model.User;
import com.example.aswe.volunteens.service.DonationService;
import com.example.aswe.volunteens.service.OpportunityService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TempController {
    @Autowired
    private DonationService donationService;

    @Autowired
    private OpportunityService opportunityService;

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
        if (session.getAttribute("user") == null) {
           
            return new ModelAndView("redirect:/accessDenied");
        }
        return new ModelAndView("volunteer.html");
    
    }

    @GetMapping("postOpportunity")
    public ModelAndView postOpportunity(HttpSession session,@ModelAttribute OpportunityDTO opportunityDTO,Model model) {
        User user = (User) session.getAttribute("user");

        if (session.getAttribute("org") == null && !"admin@gmail.com".equals(user.getEmail())) {
           
            return new ModelAndView("redirect:/accessDenied");
        }

        model.addAttribute("opportunityDTO", opportunityDTO);
        return new ModelAndView("postOpportunity.html");
    
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
