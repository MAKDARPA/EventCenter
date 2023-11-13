package com.events.center.events_center.dto.beans;

import lombok.*;

@Data
@AllArgsConstructor
public class ImageBean {
    private Integer id;

    private String ratio;
    private String url;
    private Integer width;
    private Integer height;
}
