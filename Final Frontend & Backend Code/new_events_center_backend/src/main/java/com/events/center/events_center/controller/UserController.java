package com.events.center.events_center.controller;

import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.beans.UserBean;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.entity.User;
import com.events.center.events_center.service.UserService;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add/user")
    public UserResponseDTO addUser(@RequestBody UserBean userBean){

        return userService.addUser(userBean);
    }

    @PostMapping("/signup")
    public UserResponseDTO signUp(@RequestBody UserBean userBean){

        return userService.signUp(userBean);
    }

    @PutMapping("/approve/user/{userId}")
    public UserResponseDTO approveUser(@PathVariable Integer userId) {
        return userService.approveUser(userId);
    }

    @PutMapping("/update/user/{userId}")
    public UserResponseDTO updateUser(@PathVariable Integer userId, @RequestBody UserBean updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/user/byid")
    public User getUserById(@RequestParam(name = "userId") Integer userId){
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

    @GetMapping("/get/tickets")
    public List<Event> getPurchasedTickets(@RequestParam(name="userId") Integer userId){
        return userService.getPurchasedTickets(userId);
    }

    @PostMapping("/request/booth")
    public UserResponseDTO boothRequest(@RequestParam(name="eventId") Integer eventId,@RequestParam(name="userId") Integer userId){
        return userService.boothRequest(eventId,userId);
    }

    @GetMapping("/get/booth/requests")
    public List<Event> getboothRequests(@RequestParam(name="userId") Integer userId){
        return userService.getboothRequests(userId);
    }

    @GetMapping("/findAll/pending/users")
    public List<User> findAllPendingUsers(){
        return userService.findAllPendingUsers();
    }


}
