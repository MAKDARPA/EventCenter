package com.events.center.events_center.mapper;


import com.events.center.events_center.dto.RequestDTO.Sales;
import com.events.center.events_center.dto.beans.SalesBean;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SalesBeanMapper {
    SalesBean map(Sales sales);
}