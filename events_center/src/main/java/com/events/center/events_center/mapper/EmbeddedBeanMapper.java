package com.events.center.events_center.mapper;


import com.events.center.events_center.dto.RequestDTO._Embedded;
import com.events.center.events_center.dto.beans.EmbeddedBean;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmbeddedBeanMapper {
    EmbeddedBean map(_Embedded embedded);
}