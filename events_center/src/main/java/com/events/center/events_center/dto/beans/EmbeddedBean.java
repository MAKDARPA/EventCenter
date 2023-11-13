package com.events.center.events_center.dto.beans;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedBean {
    private Long id;
    private List<VenuesBean> venuesBeans;
}
