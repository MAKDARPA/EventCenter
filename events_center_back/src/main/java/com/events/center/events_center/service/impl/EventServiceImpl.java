package com.events.center.events_center.service.impl;

import com.events.center.events_center.dto.ResponseDTO.EventResponseDTO;
import com.events.center.events_center.dto.beans.EventBean;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.exception.EventNotFoundException;
import com.events.center.events_center.repository.EventRepository;
import com.events.center.events_center.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventResponseDTO getAllEvents() {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        List<Event> events = eventRepository.findAll();
        List<EventBean> updatedEvents = new ArrayList<>();

        for (Event event1 : events) {
            EventBean eventBean = getEventBean(event1);
            if(eventBean.getStatus() == 0){
                updatedEvents.add(eventBean);
            }
        }
        eventResponseDTO.setEvents(updatedEvents);
        eventResponseDTO.setCode("200");
        eventResponseDTO.setMessage("A list of events have been retrieved");
        return eventResponseDTO;
    }

    @Override
    public EventResponseDTO getEventById(Integer id) {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        Event event1 = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Requested event not found"));
        EventBean eventBean = getEventBean(event1);

        eventResponseDTO.setEventBean(eventBean);
        eventResponseDTO.setCode("200");
        eventResponseDTO.setMessage("Successfully found an event by the given id");
        return eventResponseDTO;
    }

    @Override
    public EventResponseDTO deleteEvent(Integer id) {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Requested event not found"));
        event.setStatus(2);
        eventRepository.save(event);
        eventResponseDTO.setCode("200");
        eventResponseDTO.setMessage("Selected event has been successfully deleted");
        return eventResponseDTO;
    }

    @Override
    public void eventPersistence(EventBean eventBean) {
        Event event = new Event();
        event.setName(eventBean.getName());
        event.setPrice(eventBean.getPrice());
        event.setInfo(eventBean.getInfo());
        event.setStatus(0);
        event.setImageUrl(eventBean.getImageUrl());

        eventRepository.save(event);
    }

    @Override
    public EventResponseDTO getEventByName(String name) {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        List<EventBean> updatedEvents = new ArrayList<>();

        List<Event> eventList = eventRepository.findByName(name);
        for (Event event1 : eventList) {
            EventBean eventBean = getEventBean(event1);
            updatedEvents.add(eventBean);
        }
        eventResponseDTO.setEvents(updatedEvents);
        eventResponseDTO.setCode("200");
        eventResponseDTO.setMessage("Successfully found an event by the given name");
        return eventResponseDTO;
    }

    public EventBean getEventBean(Event event1) {
        EventBean eventBean = new EventBean(event1.getEventId(), event1.getName(), event1.getInfo(), event1.getPrice(), event1.getStatus(), event1.getImageUrl());
        return eventBean;
    }
}
