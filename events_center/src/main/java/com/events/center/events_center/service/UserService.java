package com.events.center.events_center.service;


import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.beans.UserBean;

import java.util.List;

public interface UserService {

    public List<UserBean> getAllUsers();

    public UserResponseDTO deleteUser(Long id);

    UserResponseDTO purchaseTicket(Integer eventId,Integer userId);
    public UserBean getUserById(Integer userId);
}
