package com.jacekg.teamfinder.venue.service;

import com.jacekg.teamfinder.venue.model.Venue;

import java.io.IOException;
import java.util.List;

public interface VenueService {
	
	public List<Venue> getAllVenues();
	public Venue createVenue(VenueRequest venueRequest) throws IOException, Exception;
}
