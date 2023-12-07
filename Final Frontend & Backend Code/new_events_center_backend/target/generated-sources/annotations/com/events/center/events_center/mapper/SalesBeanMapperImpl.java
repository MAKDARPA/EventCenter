package com.events.center.events_center.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-13T13:12:09+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class SalesBeanMapperImpl implements SalesBeanMapper {

    @Override
    public SalesBean map(Sales sales) {
        if ( sales == null ) {
            return null;
        }

        Long id = null;

        id = sales.getId();

        Public pObj = null;

        SalesBean salesBean = new SalesBean( id, pObj );

        salesBean.setPObj( sales.getPObj() );

        return salesBean;
    }
}
