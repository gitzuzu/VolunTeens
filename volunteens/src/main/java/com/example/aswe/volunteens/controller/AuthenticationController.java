package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.aswe.volunteens.dto.AuthDTO;
import com.example.aswe.volunteens.dto.OrganizationDTO;
import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.service.AuthService;
import com.example.aswe.volunteens.service.OrganizationService;
import com.example.aswe.volunteens.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/")

public class AuthenticationController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private AuthService authService;
    @GetMapping("")
    public ModelAndView home(Model model,HttpSession session) {
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }

     
    @GetMapping("signup")
    public ModelAndView signup(@ModelAttribute UserDTO userDTO,Model model) {
        ModelAndView mav = new ModelAndView("signup.html");
        model.addAttribute("userDTO", userDTO);
        return mav;
    }

     @GetMapping("register")
    public ModelAndView signup(@ModelAttribute OrganizationDTO OrganizationDTO,Model model) {
        ModelAndView mav = new ModelAndView("organzationSignup.html");
        model.addAttribute("organizationDTO", OrganizationDTO);
        return mav;
    }

    @PostMapping("signup")
    public ModelAndView save (@Valid @ModelAttribute UserDTO userDTO,BindingResult bindingResult,RedirectAttributes ra){
        //check if the user exists
        if(userService.EmailExist(userDTO.getEmail())){
            bindingResult.addError(new FieldError("userDTO", "email", "Email address already in use"));
        }
        //check if the passwords match 
        if(userDTO.getPassword()!= null && userDTO.getCpassword()!=null){
            if(!userDTO.getPassword().equals(userDTO.getCpassword())){
                bindingResult.addError(new FieldError("userDTO", "cpassword", "Password must match"));
            }
        }
       if(bindingResult.hasErrors()){
        System.out.println(bindingResult.hasErrors());
        return new ModelAndView("signup.html");
       }
       ra.addFlashAttribute("message","Success! your register");
       this.userService.saveUser(userDTO);
       return new ModelAndView("redirect:/login");
    }
    @PostMapping("register")
    public ModelAndView save (@Valid @ModelAttribute OrganizationDTO OrganizationDTO,BindingResult bindingResult,RedirectAttributes ra){
        //check if the user exists
        if(organizationService.EmailExist(OrganizationDTO.getEmail())){
            bindingResult.addError(new FieldError("OrganizationDTO", "email", "Email address already in use"));
        }
        //check if the passwords match 
        if(OrganizationDTO.getPassword()!= null && OrganizationDTO.getCpassword()!=null){
            if(!OrganizationDTO.getPassword().equals(OrganizationDTO.getCpassword())){
                bindingResult.addError(new FieldError("OrganizationDTO", "cpassword", "Password must match"));
            }
        }
       if(bindingResult.hasErrors()){
        System.out.println(bindingResult.hasErrors());
        return new ModelAndView("organzationSignup.html");
       }
       ra.addFlashAttribute("message","Success! your register");
       this.organizationService.saveOrganization(OrganizationDTO);
       return new ModelAndView("redirect:/login");
    }

     @GetMapping("login")
    public ModelAndView login(@ModelAttribute AuthDTO AuthDTO,Model model) {
        ModelAndView mav = new ModelAndView("login.html");
        model.addAttribute("authDTO", AuthDTO);
        return mav;
    }

    @PostMapping("login")
    public ModelAndView getUser(@Valid @ModelAttribute AuthDTO AuthDTO, BindingResult bindingResult,HttpSession session) {
      
        if( bindingResult.hasFieldErrors("email")||bindingResult.hasFieldErrors("password")) {
            System.out.println(bindingResult.hasErrors());
            return new ModelAndView("login.html");
        }
        if(!this.authService.getUser(AuthDTO.getEmail(), AuthDTO.getPassword(),session)){
            System.out.println(bindingResult.hasErrors());
            bindingResult.addError(new FieldError("authDTO", "password", "Password incorrector Incoreect emaill"));
            return new ModelAndView("login.html");
        }
        return new ModelAndView("redirect:/");
    }
    

    

    
}
