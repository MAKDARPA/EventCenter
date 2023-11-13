package com.events.center.events_center.controller;

import com.events.center.events_center.dto.ResponseDTO.UserResponseDTO;
import com.events.center.events_center.dto.ResponseDTO.VendorResponseDTO;
import com.events.center.events_center.dto.beans.UserBean;
import com.events.center.events_center.entity.Vendor;
import com.events.center.events_center.service.UserService;
import com.events.center.events_center.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/submit/stall/application")
    public VendorResponseDTO eventFormApply(@RequestBody Vendor vendor){
        return vendorService.submitApplication(vendor);
    }

    @GetMapping("/get/all/event/applications")
    public List<Vendor> getAllEventApplications(){
        return vendorService.getAllEventApplications();
    }
}
