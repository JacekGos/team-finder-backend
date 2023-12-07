package com.jacekg.teamfinder.event.service;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.event.dto.EventRequest;

import java.util.List;
import java.util.Map;

public interface EventService {

    public List<EventResponse> getAllEvents();

    public List<EventResponse> getAllEventsByFilters(Map<String, String> filterParams);

    public EventResponse createEvent(EventRequest eventRequest);

    void removeEvent(long eventId);
}
