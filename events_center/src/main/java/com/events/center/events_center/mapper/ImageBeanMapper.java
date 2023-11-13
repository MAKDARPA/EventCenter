package com.events.center.events_center.mapper;


import com.events.center.events_center.dto.RequestDTO.Image;
import com.events.center.events_center.dto.beans.ImageBean;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ImageBeanMapper {
    List<ImageBean> map(List<Image> imageList);
}