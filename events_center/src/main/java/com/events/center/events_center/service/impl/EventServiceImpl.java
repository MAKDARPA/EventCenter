package com.events.center.events_center.service.impl;

import com.events.center.events_center.dto.RequestDTO.*;
import com.events.center.events_center.dto.ResponseDTO.EventResponseDTO;
import com.events.center.events_center.dto.beans.*;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.exception.EventNotFoundException;
import com.events.center.events_center.mapper.*;
import com.events.center.events_center.repository.*;
import com.events.center.events_center.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private VenuesRepository venuesRepository;
    @Autowired
    private _EmbeddedRepository embeddedRepository;
    @Autowired
    private ImageBeanMapper imageBeanMapper;
    @Autowired
    private ClassificationBeanMapper classificationBeanMapper;
    @Autowired
    private EmbeddedBeanMapper embeddedBeanMapper;
    @Autowired
    private SalesBeanMapper salesBeanMapper;
    @Autowired
    private VenuesBeanMapper venuesBeanMapper;


    @Override
    public EventResponseDTO getAllEvents() {
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        List<Event> events = eventRepository.findAll();
        List<EventBean> updatedEvents = new ArrayList<>();

        for (Event event1 : events) {
            EventBean eventBean = getEventBean(event1);
            updatedEvents.add(eventBean);
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
        eventRepository.deleteById(id);
        eventResponseDTO.setCode("200");
        eventResponseDTO.setMessage("Selected event has been successfully deleted");
        return eventResponseDTO;
    }

    @Override
    public void eventPersistence() {

        String apiUrl = "https://app.ticketmaster.com/discovery/v2/events.json";
        String url = apiUrl + "?apikey=" + "otvhy0gAJaOtEDJ6z93ssMEtx9GPTGxn" + "&size=2";
        Random random = new Random();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Embeded1> response = restTemplate.getForEntity(url, Embeded1.class);
        Embeded1 embeded11 = response.getBody();

        for (Map.Entry<String, Event[]> entry : embeded11.get_embedded().entrySet()) {
            Event[] eventList = entry.getValue();
            for (Event event : eventList) {
                List<Classification> clasificationSet = new ArrayList<>();
                List<Venues> venueSet = new ArrayList<>();
                List<Image> imageSet = new ArrayList<>();
                Integer random_number = random.nextInt(110) + 25;
                String price=random_number.toString();
                Event savedEvent = eventRepository.save(new Event(event.getName(), event.getId(), event.getInfo(),price));

                for (Image image : event.getImages()) {
                    image.setEvent1(savedEvent);
                    Image image1 = imageRepository.save(image);
                    imageSet.add(image1);
                }
                event.getSales().setEvent4(savedEvent);
                Sales sale = saleRepository.save(event.getSales());
                for (Classification classification : event.getClassifications()) {
                    classification.setEvent2(savedEvent);
                    Classification classification1 = classificationRepository.save(classification);
                    clasificationSet.add(classification1);
                }
                _Embedded embedded = embeddedRepository.save(new _Embedded());
                for (Venues venues : event.get_embedded().getVenues()) {
                    venues.setEmbedded(embedded);
                    Venues venues1 = venuesRepository.save(venues);
                    venueSet.add(venues1);
                }
                embedded.setVenues(venueSet);
                embedded.setEvent3(savedEvent);
                embeddedRepository.save(embedded);

                savedEvent.set_embedded(embedded);
                savedEvent.setClassifications(clasificationSet);
                savedEvent.setImages(imageSet);
                savedEvent.setSales(sale);
                eventRepository.save(savedEvent);
            }
        }
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
        EventBean eventBean = new EventBean(event1.getEventId(), event1.getName(), event1.getId(), event1.getInfo());

        List<ImageBean> imageBeans = imageBeanMapper.map(event1.getImages());
        List<ClassificationBean> classificationBeans = classificationBeanMapper.map(event1.getClassifications());
        SalesBean salesBean = salesBeanMapper.map(event1.getSales());

        List<VenuesBean> venuesBeans = venuesBeanMapper.map(event1.get_embedded().getVenues());
        EmbeddedBean embeddedBean = embeddedBeanMapper.map(event1.get_embedded());
        embeddedBean.setVenuesBeans(venuesBeans);

        eventBean.setClassificationBean(classificationBeans);
        eventBean.setImageBeans(imageBeans);
        eventBean.setSalesBean(salesBean);
        eventBean.setEmbeddedBean(embeddedBean);
        return eventBean;
    }
}
