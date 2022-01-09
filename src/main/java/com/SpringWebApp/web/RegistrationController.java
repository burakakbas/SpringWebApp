package com.SpringWebApp.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.SpringWebApp.model.User;
import com.SpringWebApp.service.UService;
import com.SpringWebApp.web.dto.RegistrationDto;
import org.springframework.stereotype.Controller;

import java.sql.SQLIntegrityConstraintViolationException;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UService uService;

    public RegistrationController(UService uService) {
        super();
        this.uService = uService;
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") RegistrationDto registrationDto) {
        try{
            User user = uService.save(registrationDto) ;
        }
        catch (Exception e) {
            return "redirect:/registration?failed";
        }

        return "redirect:/registration?success";
    }

    @ModelAttribute("user")
    public RegistrationDto RegistrationDto() {
        return new RegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }
}