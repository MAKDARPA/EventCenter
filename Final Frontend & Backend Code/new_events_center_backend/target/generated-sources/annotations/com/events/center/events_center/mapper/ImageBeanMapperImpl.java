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
public class ImageBeanMapperImpl implements ImageBeanMapper {

    @Override
    public List<ImageBean> map(List<Image> imageList) {
        if ( imageList == null ) {
            return null;
        }

        List<ImageBean> list = new ArrayList<ImageBean>( imageList.size() );
        for ( Image image : imageList ) {
            list.add( imageToImageBean( image ) );
        }

        return list;
    }

    protected ImageBean imageToImageBean(Image image) {
        if ( image == null ) {
            return null;
        }

        Integer id = null;
        String ratio = null;
        String url = null;
        Integer width = null;
        Integer height = null;

        id = image.getId();
        ratio = image.getRatio();
        url = image.getUrl();
        width = image.getWidth();
        height = image.getHeight();

        ImageBean imageBean = new ImageBean( id, ratio, url, width, height );

        return imageBean;
    }
}
