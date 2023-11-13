package com.events.center.events_center.mapper;


import com.events.center.events_center.dto.RequestDTO.Classification;
import com.events.center.events_center.dto.beans.ClassificationBean;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClassificationBeanMapper {
    List<ClassificationBean> map(List<Classification> classificationList);
}