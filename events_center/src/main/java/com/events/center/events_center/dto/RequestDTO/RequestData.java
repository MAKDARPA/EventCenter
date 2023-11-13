package com.events.center.events_center.dto.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Getter
@Setter
public class RequestData {
    private HashMap<String, Embeded1[]> map;
}
