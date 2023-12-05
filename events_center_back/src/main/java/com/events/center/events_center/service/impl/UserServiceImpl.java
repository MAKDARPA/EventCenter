package com.events.center.events_center.service.impl;


import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.beans.UserBean;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.entity.User;
import com.events.center.events_center.exception.EventNotFoundException;
import com.events.center.events_center.exception.UserNotFoundException;
import com.events.center.events_center.repository.EventRepository;
import com.events.center.events_center.repository.UserRepository;
import com.events.center.events_center.service.EventService;
import com.events.center.events_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;


    @Override
    public UserResponseDTO addUser(UserBean userBean) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        User user = new User();
        user.setUserName(userBean.getUserName());
        user.setEmail(userBean.getEmail());
        user.setPassword(userBean.getPassword());
        user.setRole(userBean.getRole());
        user.setStatus(1);

        userRepository.save(user);

        userResponseDTO.setUser(user);
        userResponseDTO.setCode("200");
        userResponseDTO.setMessage("User Added");

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO signUp(UserBean userBean) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        User user = new User();
        user.setUserName(userBean.getUserName());
        user.setEmail(userBean.getEmail());
        user.setPassword(userBean.getPassword());
        user.setRole("USER");
        user.setStatus(1);

        userRepository.save(user);

        userResponseDTO.setUser(user);
        userResponseDTO.setCode("200");
        userResponseDTO.setMessage("User Added");

        return userResponseDTO;
    }

    @Override
    public List<User> findAllPendingUsers() {
        List<User> users = userRepository.findAllUsersWithStatusOne();
        return users;
    }

    @Override
    public UserResponseDTO approveUser(Integer userId) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        User user = getUserById(userId);
        user.setStatus(0);
        userRepository.save(user);
        userResponseDTO.setCode("200");
        userResponseDTO.setMessage("User Approved");
        return userResponseDTO;
    }


    @Override
    public UserResponseDTO updateUser(Integer userId, UserBean userBean) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        // Retrieve the existing user from the database
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(userBean.getUserId()));

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Update user properties with new values
            user.setUserName(userBean.getUserName());
            user.setEmail(userBean.getEmail());
            user.setPassword(userBean.getPassword());
            user.setRole(userBean.getRole());

            // Save the updated user
            userRepository.save(user);

            userResponseDTO.setUser(user);
            userResponseDTO.setCode("200");
            userResponseDTO.setMessage("User Updated");
        } else {
            userResponseDTO.setCode("404");
            userResponseDTO.setMessage("User not found");
        }

        return userResponseDTO;
    }

    @Override
    public List<Event> getPurchasedTickets(Integer userId) {
        List<Event> events = eventRepository.findEventsByUserId(userId);
        return events;
    }



    @Override
    public List<User> getAllUsers() {
        List<User> users=userRepository.findAllUsersWithStatusZeroOrOne();
        return users;

    }

    public User getUserById(Integer id) {
        User user =userRepository.findById(id.longValue()).orElseThrow(()->new UserNotFoundException("User not found, provided Id is wrong"));
        return user;
    }




    @Override
    public UserResponseDTO deleteUser(Long id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        User user =userRepository.findById(id.longValue()).orElseThrow(()->new UserNotFoundException("User not found, provided Id is wrong"));
        if(user != null) {
            user.setStatus(2);
            userRepository.save(user);
            userResponseDTO.setCode("200");
            userResponseDTO.setMessage("User with provided ID has been successfully deleted");
        }else {
            userResponseDTO.setCode("400");
            userResponseDTO.setMessage("User with provided ID not found");
        }
        return userResponseDTO;

    }

    @Override
    public UserResponseDTO purchaseTicket(Integer eventId, Integer userId) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found, provided Id is wrong"));
        User user = userRepository.findById(userId.longValue())
                .orElseThrow(() -> new UserNotFoundException("User not found, provided Id is wrong"));

        user.getTicketsPurchased().add(event);

        userRepository.save(user);

        userResponseDTO.setCode("200");
        userResponseDTO.setMessage(user.getUserName() + " has purchased the ticket for an Event '" + event.getName() + "' successfully");
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO boothRequest(Integer eventId, Integer userId) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found, provided Id is wrong"));
        User user = userRepository.findById(userId.longValue())
                .orElseThrow(() -> new UserNotFoundException("User not found, provided Id is wrong"));

        user.getBoothRequest().add(event);

        userRepository.save(user);

        userResponseDTO.setCode("200");
        userResponseDTO.setMessage(user.getUserName() + " has requested booth for Event '" + event.getName() + "' successfully");
        return userResponseDTO;
    }

    @Override
    public List<Event> getboothRequests(Integer userId) {
        List<Event> events = eventRepository.findBoothRequestEventsByUserId(userId);
        return events;
    }


//    @Override
//    public UserResponseDTO purchaseTicket(Integer eventId,Integer userId) {
//        UserResponseDTO userResponseDTO = new UserResponseDTO();
//
//        Event event = eventRepository.findById(eventId).orElseThrow(()->new EventNotFoundException("Event not found, provided Id is wrong"));
//        User user = userRepository.findById(userId.longValue()).orElseThrow(()->new UserNotFoundException("User not found, provided Id is wrong"));
//
//        List<Event> events = new ArrayList<>();
//        events.add(event);
//
////        user.setTicketsPurchased(events);
//        user.getTicketsPurchased().add((Event) events);
//        userRepository.save(user);
//
//        userResponseDTO.setCode("200");
//        userResponseDTO.setMessage(user.getUserName()+" has purchased the ticket for an Event '"+event.getName()+ "' successfully");
//        return userResponseDTO;
//    }

}
