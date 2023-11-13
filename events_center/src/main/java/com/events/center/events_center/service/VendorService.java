package com.events.center.events_center.service;


import com.events.center.events_center.dto.ResponseDTO.VendorResponseDTO;
import com.events.center.events_center.entity.Vendor;

import java.util.List;

public interface VendorService {
    VendorResponseDTO submitApplication(Vendor vendor);

    public List<Vendor> getAllEventApplications();
}
