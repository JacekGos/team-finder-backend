package com.jacekg.teamfinder.event.utils.converter;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.model.Venue;

public interface ModelConverter {
	public EventResponse convertToResponse(Event event);
}
