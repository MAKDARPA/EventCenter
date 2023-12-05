package com.events.center.events_center.service;


import com.events.center.events_center.dto.ResponseDTO.EventResponseDTO;
import com.events.center.events_center.dto.beans.EventBean;
import com.events.center.events_center.entity.Event;


public interface EventService {

    public EventResponseDTO getAllEvents();
    public EventResponseDTO getEventById(Integer id);

    public EventResponseDTO deleteEvent(Integer id);

    public void eventPersistence(EventBean eventBean);


    EventResponseDTO getEventByName(String name);
    public EventBean getEventBean(Event event1);
}
