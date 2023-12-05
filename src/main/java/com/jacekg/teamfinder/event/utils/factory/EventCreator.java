package com.jacekg.teamfinder.event.utils.factory;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.activitytype.repository.ActivityRepository;
import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.exceptions.CreateEventException;
import com.jacekg.teamfinder.event.model.*;
import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.exceptions.CreateVenueException;
import com.jacekg.teamfinder.venue.model.IndoorVenue;
import com.jacekg.teamfinder.venue.model.OutdoorVenue;
import com.jacekg.teamfinder.venue.model.Venue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

//@Component
@AllArgsConstructor
public class EventCreator extends EventBaseCreator {

    ActivityRepository activityRepository;

    @Override
    public Event createEvent(EventRequest event) {

        Optional<ActivityType> activityType = activityRepository.findByName(event.getName());

        Event newEvent = null;

        switch (event.getActivityType()) {
            case "football":
                newEvent = FootballEvent.builder()
                        .name(event.getName())
                        .price(event.getPrice())
                        .date(event.getDate())
                        .activityType(activityType.orElse(null))
                        .build();
                break;
            case "volleyball":
                newEvent = VolleyballEvent.builder()
                        .name(event.getName())
                        .price(event.getPrice())
                        .date(event.getDate())
                        .activityType(activityType.orElse(null))
                        .build();
                break;
            case "basketball":
                newEvent = BasketballEvent.builder()
                        .name(event.getName())
                        .price(event.getPrice())
                        .date(event.getDate())
                        .activityType(activityType.orElse(null))
                        .build();
                break;
            case "tennis":
                newEvent = TennisEvent.builder()
                        .name(event.getName())
                        .price(event.getPrice())
                        .date(event.getDate())
                        .activityType(activityType.orElse(null))
                        .build();
                break;
            case "bicycle":
                newEvent = BicycleEvent.builder()
                        .name(event.getName())
                        .price(event.getPrice())
                        .date(event.getDate())
                        .activityType(activityType.orElse(null))
                        .build();
                break;
            default:
                throw new CreateEventException("No type(" + event.getActivityType() + ")" + " of Event exists");
        }

        return newEvent;
    }
}
