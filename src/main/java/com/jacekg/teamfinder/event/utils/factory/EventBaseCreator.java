package com.jacekg.teamfinder.event.utils.factory;

import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.model.Venue;
import org.springframework.stereotype.Component;

@Component
public abstract class EventBaseCreator {
	public abstract Event createEvent(EventRequest event);
}
