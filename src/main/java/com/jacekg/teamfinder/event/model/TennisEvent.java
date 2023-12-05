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
@DiscriminatorValue("tennisEvent")
@AllArgsConstructor
public class TennisEvent extends Event {

    @Builder
    public TennisEvent(String name, ActivityType activityType, Venue venue, User creator, LocalDateTime date, float price) {
        super(name, activityType, venue, creator, date, price);
    }
}