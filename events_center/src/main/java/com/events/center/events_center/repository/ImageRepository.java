package com.events.center.events_center.repository;


import com.events.center.events_center.dto.RequestDTO.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    //Event findByName(String eventName);
}
