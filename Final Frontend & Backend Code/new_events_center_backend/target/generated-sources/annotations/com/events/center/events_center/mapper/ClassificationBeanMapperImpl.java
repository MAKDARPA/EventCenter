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
public class ClassificationBeanMapperImpl implements ClassificationBeanMapper {

    @Override
    public List<ClassificationBean> map(List<Classification> classificationList) {
        if ( classificationList == null ) {
            return null;
        }

        List<ClassificationBean> list = new ArrayList<ClassificationBean>( classificationList.size() );
        for ( Classification classification : classificationList ) {
            list.add( classificationToClassificationBean( classification ) );
        }

        return list;
    }

    protected ClassificationBean classificationToClassificationBean(Classification classification) {
        if ( classification == null ) {
            return null;
        }

        ClassificationBean classificationBean = new ClassificationBean();

        classificationBean.setId( classification.getId() );
        classificationBean.setSegment( classification.getSegment() );
        classificationBean.setGenre( classification.getGenre() );

        return classificationBean;
    }
}
