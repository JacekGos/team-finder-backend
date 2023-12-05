package com.jacekg.teamfinder.venue.model;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import lombok.Builder;
import lombok.NoArgsConstructor;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Set;

@Entity
@DiscriminatorValue("indoorVenue")
@NoArgsConstructor
public class IndoorVenue extends Venue {
	
	@Builder
	public IndoorVenue(String name, float price, Set<ActivityType> activities, String address) {
		super(name, price, activities, address);
	}
}
