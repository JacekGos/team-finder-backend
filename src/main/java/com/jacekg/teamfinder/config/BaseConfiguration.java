package com.jacekg.teamfinder.config;

import com.jacekg.teamfinder.activitytype.repository.ActivityRepository;
import com.jacekg.teamfinder.event.utils.factory.EventCreator;
import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.user.model.repository.UserRepository;
import com.jacekg.teamfinder.venue.repository.VenueRepository;
import com.jacekg.teamfinder.venue.utils.factory.VenueCreator;
import lombok.AllArgsConstructor;
import org.locationtech.jts.geom.GeometryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BaseConfiguration {

    ActivityRepository activityRepository;
    VenueRepository venueRepository;
    UserRepository userRepository;

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
        return new EventCreator(activityRepository, venueRepository, userRepository);
    }
}
