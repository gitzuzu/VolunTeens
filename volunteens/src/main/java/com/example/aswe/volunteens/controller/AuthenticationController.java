package com.example.aswe.volunteens.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.aswe.volunteens.dto.UserDTO;
import com.example.aswe.volunteens.service.UserService;

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
    
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }

       @Autowired
    private UserService userService;
    @GetMapping("signup")
    public ModelAndView signup(@ModelAttribute UserDTO userDTO,Model model) {
        ModelAndView mav = new ModelAndView("signup.html");
        model.addAttribute("userDTO", userDTO);
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

    @GetMapping("login")
    public ModelAndView login(@ModelAttribute UserDTO userDTO,Model model) {
        ModelAndView mav = new ModelAndView("login.html");
        mav.addObject("userDTO", new UserDTO());
        return mav;
    }

    @PostMapping("login")
    public ModelAndView getUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
      
        if( bindingResult.hasFieldErrors("email")||bindingResult.hasFieldErrors("password")) {
            System.out.println(bindingResult.hasErrors());
            return new ModelAndView("login.html");
        }
        if(!this.userService.getUser(userDTO.getEmail(), userDTO.getPassword())){
            System.out.println(bindingResult.hasErrors());
            bindingResult.addError(new FieldError("userDTO", "password", "Password incorrect"));
            return new ModelAndView("login.html");
        }
        return new ModelAndView("redirect:/");
    }
    
}
