package com.events.center.events_center.controller;

import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.beans.UserBean;
import com.events.center.events_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/all")
    public List<UserBean> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/user/byid")
    public UserBean getUserById(@RequestParam(name = "userId") Integer userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public UserResponseDTO deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

    @PostMapping("/buy/ticket")
    public UserResponseDTO purchaseTicket(@RequestParam(name="eventId") Integer eventId,@RequestParam(name="userId") Integer userId){
        return userService.purchaseTicket(eventId,userId);
    }
}
