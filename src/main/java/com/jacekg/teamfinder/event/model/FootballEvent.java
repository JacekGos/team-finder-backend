package com.jacekg.teamfinder.event.model;

import java.time.LocalDateTime;

import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.venue.model.ActivityType;
import com.jacekg.teamfinder.venue.model.Venue;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@DiscriminatorValue("footballEvent")
//@NoArgsConstructor
@AllArgsConstructor
public class FootballEvent extends Event {

    @Builder
    public FootballEvent(String name, ActivityType activityType, LocalDateTime date, float price, Venue venue, User creator) {
        super(name, activityType, date, price, venue, creator);
    }
}