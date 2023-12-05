package com.jacekg.teamfinder.event.service;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.event.dto.EventRequest;

import java.util.List;

public interface EventService {

    public List<EventResponse> getAllEvents();

    public EventResponse createEvent(EventRequest eventRequest);

    void removeEvent(long eventId);
}
