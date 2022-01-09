package com.SpringWebApp.service;

import com.SpringWebApp.model.User;
import com.SpringWebApp.web.dto.RegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UService extends UserDetailsService {
    User save(RegistrationDto registrationDto);
}