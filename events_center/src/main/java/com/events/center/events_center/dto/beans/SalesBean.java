package com.events.center.events_center.dto.beans;

import com.events.center.events_center.dto.RequestDTO.Public;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalesBean {
    private Long id;
    private Public pObj;
}
