package com.events.center.events_center.dto.ResponseDTO;

import com.events.center.events_center.dto.beans.EventBean;
import com.events.center.events_center.entity.Event;
import com.events.center.events_center.entity.User;
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
public class UserResponseDTO {
    List<User> users;
    User user;
    List<Event> events;
    String code;
    String message;
}
