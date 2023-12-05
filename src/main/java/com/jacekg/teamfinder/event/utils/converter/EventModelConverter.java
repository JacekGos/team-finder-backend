package com.jacekg.teamfinder.event.utils.converter;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.model.Event;

public interface EventModelConverter {
	public EventResponse convertToResponse(Event event);
}
