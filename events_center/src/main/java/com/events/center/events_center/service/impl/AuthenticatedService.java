package com.events.center.events_center.service.impl;


import com.events.center.events_center.dto.ResponseDTO.LoginResponseDTO;
import com.events.center.events_center.entity.User;
import com.events.center.events_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticatedService {
    @Autowired
    private UserRepository userRepository;

    public LoginResponseDTO loginUser(String userName, String password) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        try {
            User user = userRepository.findByUsername(userName);
            if (user.getPassword().equals(password)) {
                loginResponseDTO.setRole(user.getRole());
                loginResponseDTO.setCode("200");
                loginResponseDTO.setMessage("User is Authenticated");
            }
            else{
                loginResponseDTO.setCode("404");
                loginResponseDTO.setMessage("Wrong password, please enter the right password !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            loginResponseDTO.setCode("404");
            loginResponseDTO.setMessage("User Not Found Exception");
        }
        return loginResponseDTO;
    }
}
