package com.events.center.events_center.controller;

import com.events.center.events_center.dto.RequestDTO.Embeded1;
import com.events.center.events_center.dto.ResponseDTO.EventResponseDTO;
import com.events.center.events_center.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/save/all")
    public void saveAllEvents() {
        eventService.eventPersistence();
    }

    @GetMapping("/get/all/events")
    public EventResponseDTO getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/get/event/byid/{eventId}")
    public EventResponseDTO getEventById(@PathVariable Integer eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/get/event/byname")
    public EventResponseDTO getEventByName(@RequestParam(name="name") String name) {
        return eventService.getEventByName(name);
    }

    @DeleteMapping("/delete/{eventId}")
    public EventResponseDTO deleteEvent(@PathVariable Integer eventId) {
        return eventService.deleteEvent(eventId);
    }
}
