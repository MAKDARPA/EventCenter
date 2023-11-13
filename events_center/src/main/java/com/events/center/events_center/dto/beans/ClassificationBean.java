package com.events.center.events_center.dto.beans;

import com.events.center.events_center.dto.RequestDTO.Genre;
import com.events.center.events_center.dto.RequestDTO.Segment;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificationBean {
    private Integer id;
    private Segment segment;
    private Genre genre;
}
