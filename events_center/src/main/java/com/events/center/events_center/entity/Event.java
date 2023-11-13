package com.events.center.events_center.entity;

import com.events.center.events_center.dto.RequestDTO.Classification;
import com.events.center.events_center.dto.RequestDTO.Image;
import com.events.center.events_center.dto.RequestDTO.Sales;
import com.events.center.events_center.dto.RequestDTO._Embedded;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId", nullable = false)
    private Integer eventId;

    @Column(name = "name")
    private String name;
    @Column(name = "id")
    private String id;
    @Column(name = "price")
    private String price;
    @Column(name = "info",length = 1500)
    private String info;

    @OneToMany(mappedBy = "event1", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Image> images;

    @OneToOne(mappedBy = "event4", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Sales sales;

    @OneToMany(mappedBy = "event2", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Classification> classifications;

    @OneToOne(mappedBy = "event3", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private _Embedded _embedded;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    public Event(String name, String id, List<Image> images, Sales sales, List<Classification> classifications, _Embedded _embedded) {
        this.name = name;
        this.id = id;
//        this.info = info;
        this.images = images;
        this.sales = sales;
        this.classifications = classifications;
        this._embedded = _embedded;
    }
    public Event(String name, String id,String info) {
        this.name = name;
        this.id = id;
        this.info = info;
    }

    public Event(String name, String id, String info, String price) {
        this.name = name;
        this.id = id;
        this.info = info;
        this.price = price;
    }
}

