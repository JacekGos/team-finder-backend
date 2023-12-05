package com.jacekg.teamfinder.venue.utils.converter;

import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.model.Venue;

public interface VenueModelConverter {
	public VenueResponse convertToResponse(Venue venue);
}
