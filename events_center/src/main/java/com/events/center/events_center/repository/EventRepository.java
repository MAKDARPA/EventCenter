package com.events.center.events_center.repository;


import com.events.center.events_center.entity.Event;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

//    @Query("select e from Event e where e.name LIKE %?1% OR e.name LIKE ?1% OR e.name LIKE %?1")
    @Query("select e from Event e where lower(e.name) LIKE lower(concat('%', ?1, '%'))")
    List<Event> findByName(String eventName);

}
