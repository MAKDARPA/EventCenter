package com.events.center.events_center.dto.RequestDTO;

import com.events.center.events_center.entity.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "classification")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "segment_name"))
    private Segment segment;
    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "genre_name"))
    private Genre genre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="eventId")
    private Event event2;
}
