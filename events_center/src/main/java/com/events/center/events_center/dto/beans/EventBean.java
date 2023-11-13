package com.events.center.events_center.dto.beans;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class EventBean {
    private Integer eventId;
    private String name;
    private String id;
    private String info;
    private List<ClassificationBean> classificationBean;
    private EmbeddedBean embeddedBean;
    private List<ImageBean> imageBeans;
    private SalesBean salesBean;

    public EventBean(Integer eventId, String name, String id, String info, List<ClassificationBean> classificationBean, EmbeddedBean embeddedBean, List<ImageBean> imageBeans, SalesBean salesBean) {
        this.eventId = eventId;
        this.name = name;
        this.id = id;
        this.info = info;
        this.classificationBean = classificationBean;
        this.embeddedBean = embeddedBean;
        this.imageBeans = imageBeans;
        this.salesBean = salesBean;
    }

    public EventBean(Integer eventId, String name, String id, String info) {
        this.eventId = eventId;
        this.name = name;
        this.id = id;
        this.info = info;
    }
}
