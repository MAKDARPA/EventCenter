package com.events.center.events_center.dto.RequestDTO;

import com.events.center.events_center.entity.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ratio;
    private String url;
    private Integer width;
    private Integer height;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event1;
}
