package com.jacekg.teamfinder.event.model;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.venue.model.Venue;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("basketballEvent")
@AllArgsConstructor
public class BasketballEvent extends Event {

    @Builder
    public BasketballEvent(String name, ActivityType activityType, Venue venue, User creator, LocalDateTime date, float price) {
        super(name, activityType, venue, creator, date, price);
    }
}