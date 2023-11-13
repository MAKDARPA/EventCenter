package com.events.center.events_center.repository;


import com.events.center.events_center.dto.RequestDTO.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    //Event findByName(String eventName);
}
