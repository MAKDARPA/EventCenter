package com.events.center.events_center.repository;


import com.events.center.events_center.dto.RequestDTO._Embedded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface _EmbeddedRepository extends JpaRepository<_Embedded, Long> {
    //Event findByName(String eventName);
}
