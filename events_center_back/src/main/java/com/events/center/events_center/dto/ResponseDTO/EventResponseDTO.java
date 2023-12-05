package com.events.center.events_center.dto.ResponseDTO;

import com.events.center.events_center.dto.beans.EventBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventResponseDTO {
    List<EventBean> events;
    EventBean eventBean;
    String code;
    String message;
}
