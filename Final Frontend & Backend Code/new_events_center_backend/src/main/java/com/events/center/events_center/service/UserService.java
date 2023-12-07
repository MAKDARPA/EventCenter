package com.events.center.events_center.service;


import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.beans.UserBean;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public UserResponseDTO deleteUser(Long id);

    UserResponseDTO purchaseTicket(Integer eventId,Integer userId);
    public User getUserById(Integer userId);

    UserResponseDTO addUser(UserBean userBean);

    UserResponseDTO updateUser(Integer userId, UserBean userBean);

    List<Event> getPurchasedTickets(Integer userId);

    UserResponseDTO boothRequest(Integer eventId, Integer userId);

    List<Event> getboothRequests(Integer userId);

    UserResponseDTO signUp(UserBean userBean);

    List<User> findAllPendingUsers();

    UserResponseDTO approveUser(Integer userId);
}
