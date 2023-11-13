package com.events.center.events_center.dto.beans;

import com.events.center.events_center.dto.RequestDTO.City;
import com.events.center.events_center.dto.RequestDTO.State;
import lombok.*;

@Data
@AllArgsConstructor
public class VenuesBean {
    private Long venueId;
    private String name;
    private State state;
    private City city;

}
