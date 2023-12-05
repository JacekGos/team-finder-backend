package com.jacekg.teamfinder.event.model;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.venue.model.Venue;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("bicycleEvent")
@AllArgsConstructor
public class BicycleEvent extends Event {

    @Builder
    public BicycleEvent(String name, ActivityType activityType, LocalDateTime date, float price, Venue venue, User creator) {
        super(name, activityType, venue, date, price);
    }
}