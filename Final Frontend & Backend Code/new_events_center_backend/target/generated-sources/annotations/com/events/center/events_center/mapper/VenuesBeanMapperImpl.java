package com.events.center.events_center.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-13T13:12:09+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class VenuesBeanMapperImpl implements VenuesBeanMapper {

    @Override
    public List<VenuesBean> map(List<Venues> imageList) {
        if ( imageList == null ) {
            return null;
        }

        List<VenuesBean> list = new ArrayList<VenuesBean>( imageList.size() );
        for ( Venues venues : imageList ) {
            list.add( venuesToVenuesBean( venues ) );
        }

        return list;
    }

    protected VenuesBean venuesToVenuesBean(Venues venues) {
        if ( venues == null ) {
            return null;
        }

        Long venueId = null;
        String name = null;
        State state = null;
        City city = null;

        venueId = venues.getVenueId();
        name = venues.getName();
        state = venues.getState();
        city = venues.getCity();

        VenuesBean venuesBean = new VenuesBean( venueId, name, state, city );

        return venuesBean;
    }
}
