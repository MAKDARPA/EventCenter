package com.events.center.events_center.dto.RequestDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="venue")
public class Venues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venueId", nullable = false)
    private Long venueId;
    private String name;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "city_name"))
    private City city;
    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "state_name"))
    private State state;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id")
    private _Embedded embedded;
}
