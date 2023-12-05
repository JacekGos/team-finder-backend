package com.jacekg.teamfinder.event.utils.factory;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.activitytype.repository.ActivityRepository;
import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.exceptions.CreateEventException;
import com.jacekg.teamfinder.event.model.*;
import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.user.model.repository.UserRepository;
import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.exceptions.CreateVenueException;
import com.jacekg.teamfinder.venue.model.IndoorVenue;
import com.jacekg.teamfinder.venue.model.OutdoorVenue;
import com.jacekg.teamfinder.venue.model.Venue;
import com.jacekg.teamfinder.venue.repository.VenueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

//@Component
@AllArgsConstructor
@Slf4j
public class EventCreator extends EventBaseCreator {

    ActivityRepository activityRepository;
    VenueRepository venueRepository;
    UserRepository userRepository;

    @Override
    public Event createEvent(EventRequest event) {

        Optional<ActivityType> activityType = activityRepository.findByName(event.getActivityType());
        Optional<Venue> venue = venueRepository.findById(event.getVenueId());
        Optional<User> user = userRepository.findById(event.getCreatorUserId());
        if (activityType.isEmpty())
            throw new CreateEventException("No ActivityType with name: " + event.getActivityType() + " exists");
        if (venue.isEmpty())
            throw new CreateEventException("No Venue with id: " + event.getVenueId() + " exists");
        if (user.isEmpty())
            throw new CreateEventException("No User with id: " + event.getCreatorUserId() + " exists");


        log.info("createEvent: activityType: {}, venue: {}, user: {}",
                activityType.orElse(null), venue.orElse(null), user.orElse(null));

        return switch (event.getActivityType()) {
            case "FOOTBALL" -> FootballEvent.builder()
                    .name(event.getName())
                    .activityType(activityType.get())
                    .venue(venue.get())
                    .creator(user.get())
                    .price(event.getPrice())
                    .date(event.getDate())
                    .build();
            case "VOLLEYBALL" -> VolleyballEvent.builder()
                    .name(event.getName())
                    .activityType(activityType.get())
                    .venue(venue.get())
                    .creator(user.get())
                    .price(event.getPrice())
                    .date(event.getDate())
                    .build();
            case "BASKETBALL" -> BasketballEvent.builder()
                    .name(event.getName())
                    .activityType(activityType.get())
                    .venue(venue.get())
                    .creator(user.get())
                    .price(event.getPrice())
                    .date(event.getDate())
                    .build();
            case "TENNIS" -> TennisEvent.builder()
                    .name(event.getName())
                    .activityType(activityType.get())
                    .venue(venue.get())
                    .creator(user.get())
                    .price(event.getPrice())
                    .date(event.getDate())
                    .build();
            case "BICYCLE" -> BicycleEvent.builder()
                    .name(event.getName())
                    .activityType(activityType.get())
                    .venue(venue.get())
                    .creator(user.get())
                    .price(event.getPrice())
                    .date(event.getDate())
                    .build();
            default ->
                    throw new CreateEventException("No ActivityType with name: " + event.getActivityType() + " exists");
        };
    }
}
