package com.events.center.events_center.repository;


import com.events.center.events_center.dto.RequestDTO.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales, Long> {
    // Event findByName(String eventName);
}
