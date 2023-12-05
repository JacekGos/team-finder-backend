package com.jacekg.teamfinder.event.service;

import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.event.repository.EventRepository;
import com.sun.jdi.request.EventRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;


    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public Event createEvent(EventRequest eventRequest) {
        return null;
    }
}
