package com.jacekg.teamfinder.venue.utils.converter;

import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.model.Venue;

public interface ModelConverter {
	public VenueResponse convertToResponse(Venue venue);
}
