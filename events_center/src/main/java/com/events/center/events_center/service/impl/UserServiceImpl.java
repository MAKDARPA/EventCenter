package com.events.center.events_center.service.impl;


import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.beans.EventBean;
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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    @Override
    public List<UserBean> getAllUsers() {
        List<UserBean> userBeanList=new ArrayList<>();
        List<User> users=userRepository.findAll();
        List<EventBean> eventBeans=new ArrayList<>();

        for(User user: users){
            UserBean userBean=new UserBean(user.getUserId(),user.getUsername(),user.getPassword(),user.getRole());
            for(Event event:user.getEvent()){
                EventBean eventBean=eventService.getEventBean(event);
                eventBeans.add(eventBean);
            }
            userBean.setEventBeans(eventBeans);
            userBeanList.add(userBean);
        }
        return userBeanList;
    }

    public UserBean getUserById(Integer id) {
        User user =userRepository.findById(id.longValue()).orElseThrow(()->new UserNotFoundException("User not found, provided Id is wrong"));
        UserBean userBean=new UserBean(user.getUserId(),user.getUsername(),user.getPassword(),user.getRole());
        List<EventBean> bookedEvents = new ArrayList<>();

        List<Event> eventList=user.getEvent();
        for (Event event : eventList) {
            EventBean eventBean=eventService.getEventBean(event);
            bookedEvents.add(eventBean);
        }
        userBean.setEventBeans(bookedEvents);
        userBean.setCode("200");
        userBean.setMessage("A list of Users has been successfully retrieved");
        return userBean;
    }


    @Override
    public UserResponseDTO deleteUser(Long id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        try {
            User user =userRepository.findById(id.longValue()).orElseThrow(()->new UserNotFoundException("User not found, provided Id is wrong"));
            for(Event event:user.getEvent()){
                event.setUser(null);
                eventRepository.save(event);
            }
            userRepository.deleteById(id);
            userResponseDTO.setCode("200");
            userResponseDTO.setMessage("User with provided ID has been successfully deleted from your system");
            return userResponseDTO;
        } catch (Exception e) {
            userResponseDTO.setMessage(e.getMessage());
            userResponseDTO.setCode("400");
            return userResponseDTO;
        }
    }

    @Override
    public UserResponseDTO purchaseTicket(Integer eventId,Integer userId) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        Event event=eventRepository.findById(eventId).orElseThrow(()->new EventNotFoundException("Event not found, provided Id is wrong"));
        User user=userRepository.findById(userId.longValue()).orElseThrow(()->new UserNotFoundException("User not found, provided Id is wrong"));
        event.setUser(user);
        eventRepository.save(event);

        userResponseDTO.setCode("200");
        userResponseDTO.setMessage(user.getUsername()+" has purchased the ticket for an Event '"+event.getName()+ "' successfully");
        return userResponseDTO;
    }

}
