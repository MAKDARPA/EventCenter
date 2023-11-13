package com.events.center.events_center.mapper;


import com.events.center.events_center.dto.RequestDTO.Venues;
import com.events.center.events_center.dto.beans.VenuesBean;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface VenuesBeanMapper {
    List<VenuesBean> map(List<Venues> imageList);
}