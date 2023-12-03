package com.jacekg.teamfinder.venue.utils.factory;

import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.model.Venue;
import org.springframework.stereotype.Component;

@Component
public abstract class VenueBaseCreator {
	
	public abstract Venue createVenue(VenueRequest venue);
}
