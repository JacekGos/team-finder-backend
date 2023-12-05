package com.jacekg.teamfinder.event.service;

import com.jacekg.teamfinder.event.model.Event;
import com.sun.jdi.request.EventRequest;

import java.util.List;

public interface EventService {

    public List<Event> getAllEvents();

    public Event createEvent(EventRequest eventRequest);
}
