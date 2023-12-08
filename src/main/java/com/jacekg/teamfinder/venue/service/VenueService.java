package com.jacekg.teamfinder.venue.service;

import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.model.Venue;

import java.io.IOException;
import java.util.List;

public interface VenueService {
	
	public List<VenueResponse> getAllVenues();
	public VenueResponse createVenue(VenueRequest venueRequest) throws IOException, Exception;
	public List<Long> getAllIdsByActivityTypeAndLocation(String activityType, String address, Double range) throws IOException;
}
