package com.events.center.events_center.entity;

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
    @Column(name = "price")
    private Long price;
    @Column(name = "info",length = 1500)
    private String info;
    // 0=active, 1=inactive, 2=deleted
    @Column(name = "status")
    private Integer status;
    @Column(name = "imageUrl")
    private String imageUrl;

    @ManyToMany(mappedBy = "ticketsPurchased")
    private List<User> ticketsPurchasedBy;

    @ManyToMany(mappedBy = "boothRequest")
    private List<User> boothRequestBy;


    public Event(String name) {
        this.name = name;
    }
    public Event(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public Event(String name, String info, Long price, String imageUrl, Integer status) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;

    }
}

