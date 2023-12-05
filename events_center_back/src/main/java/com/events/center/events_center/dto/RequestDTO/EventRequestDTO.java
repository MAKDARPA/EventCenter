package com.events.center.events_center.dto.RequestDTO;

import com.events.center.events_center.dto.beans.EventBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventRequestDTO {
    EventBean eventBean;
}
