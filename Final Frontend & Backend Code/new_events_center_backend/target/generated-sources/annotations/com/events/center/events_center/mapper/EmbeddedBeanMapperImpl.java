package com.events.center.events_center.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-13T13:12:09+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class EmbeddedBeanMapperImpl implements EmbeddedBeanMapper {

    @Override
    public EmbeddedBean map(_Embedded embedded) {
        if ( embedded == null ) {
            return null;
        }

        EmbeddedBean embeddedBean = new EmbeddedBean();

        embeddedBean.setId( embedded.getId() );

        return embeddedBean;
    }
}
