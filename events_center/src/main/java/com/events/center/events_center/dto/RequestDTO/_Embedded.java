package com.events.center.events_center.dto.RequestDTO;

import com.events.center.events_center.entity.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="_embedded")
public class _Embedded {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "embedded",cascade = CascadeType.REMOVE)
    private List<Venues> venues;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="eventId")
    private Event event3;

    public _Embedded(List<Venues> venues){
        this.venues=venues;
    }
}
