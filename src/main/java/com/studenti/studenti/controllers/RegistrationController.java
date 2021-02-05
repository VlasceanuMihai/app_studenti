package com.studenti.studenti.controllers;

import com.studenti.studenti.dto.UserDto;
import com.studenti.studenti.exceptions.UserAlreadyExistsException;
import com.studenti.studenti.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
//@RequestMapping("/api")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registration(@ModelAttribute("user") @Valid UserDto userDto,
                                     HttpServletRequest request, Errors errors){
        try{
            registrationService.registrationProcess(userDto);
        }catch (UserAlreadyExistsException e){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", "An account for that email already exists.");
            return modelAndView;
        }

        return new ModelAndView("successRegister", "user", userDto);
    }

    @DeleteMapping("/user/deleteAll")
    public ResponseEntity<Object> deleteAll(){
        registrationService.deleteAll();
        return ResponseEntity.ok("Ok");
    }
}
