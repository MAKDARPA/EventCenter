package com.events.center.events_center.service.impl;


import com.events.center.events_center.dto.ResponseDTO.VendorResponseDTO;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.entity.User;
import com.events.center.events_center.entity.Vendor;
import com.events.center.events_center.repository.EventRepository;
import com.events.center.events_center.repository.VendorRepository;
import com.events.center.events_center.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private EventRepository eventRepository;


    @Override
    public VendorResponseDTO submitApplication(Vendor vendor) {
        VendorResponseDTO vendorResponseDTO=new VendorResponseDTO();
        Vendor vendor1 = vendorRepository.save(vendor);
        vendorResponseDTO.setVendor(vendor1);
        vendorResponseDTO.setMessage("Form has been submitted successfully");
        vendorResponseDTO.setCode("200");
        return vendorResponseDTO;
    }

    @Override
    public List<Vendor> getAllEventApplications() {
        List<Vendor> vendorList=vendorRepository.findAll();
        List<Vendor> vendorForms=new ArrayList<>();
        for(Vendor vendor:vendorList){
            Optional<Event> optionalEvent= eventRepository.findById(vendor.getEventId());
            if(optionalEvent.isPresent()){
                Event event=optionalEvent.get();
                vendor.setEventName(event.getName());
                vendorForms.add(vendor);
            }
        }
        return vendorForms;
    }
}
