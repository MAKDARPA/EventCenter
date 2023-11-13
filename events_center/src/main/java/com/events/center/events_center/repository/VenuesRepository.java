package com.events.center.events_center.repository;


import com.events.center.events_center.dto.RequestDTO.Venues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenuesRepository extends JpaRepository<Venues, Long> {
    //Event findByName(String eventName);
}
