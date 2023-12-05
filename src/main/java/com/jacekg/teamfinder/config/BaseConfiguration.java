package com.jacekg.teamfinder.config;

import com.jacekg.teamfinder.activitytype.repository.ActivityRepository;
import com.jacekg.teamfinder.event.utils.factory.EventCreator;
import com.jacekg.teamfinder.venue.utils.factory.VenueCreator;
import org.locationtech.jts.geom.GeometryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Autowired
    ActivityRepository activityRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public GeometryFactory geometryFactory() {
        return new GeometryFactory();
    }

    @Bean
    public VenueCreator venueBaseCreator() {
        return new VenueCreator();
    }

    @Bean
    public EventCreator eventBaseCreator() {
        return new EventCreator(activityRepository);
    }
}
