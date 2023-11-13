package com.events.center.events_center.controller;


import com.events.center.events_center.dto.RequestDTO.LoginRequestDTO;
import com.events.center.events_center.dto.ResponseDTO.LoginResponseDTO;
import com.events.center.events_center.service.impl.AuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticatedService authenticationService;

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginRequestDTO body) {
        LoginResponseDTO loginResponseDTO = authenticationService.loginUser(body.getUsername(), body.getPassword());
        return loginResponseDTO;
    }

}
