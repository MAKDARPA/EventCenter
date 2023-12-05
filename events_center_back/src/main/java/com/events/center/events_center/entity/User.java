package com.events.center.events_center.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    // 0=active, 1=inactive, 2=deleted
    @Column(name = "status")
    private Integer status;

//    @OneToMany(mappedBy ="user",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
//    private List<Event> event;

    @ManyToMany
    @JoinTable(
            name = "tickets",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "eventId"))
    @JsonIgnore
    private List<Event> ticketsPurchased;

    @ManyToMany
    @JoinTable(
            name = "boothRequests",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "eventId"))
    @JsonIgnore
    private List<Event> boothRequest;

    public User(String userName, String email, String password, String role, Integer status) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}

