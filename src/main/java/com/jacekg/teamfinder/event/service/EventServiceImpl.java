package com.jacekg.teamfinder.event.service;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.exceptions.CreateEventException;
import com.jacekg.teamfinder.event.exceptions.RemoveEventException;
import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.repository.EventRepository;
import com.jacekg.teamfinder.event.utils.converter.EventModelConverter;
import com.jacekg.teamfinder.event.utils.factory.EventBaseCreator;
import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.model.Venue;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private final EventBaseCreator eventCreator;
    private EventModelConverter modelConverter;

    @Transactional
    @Override
    public List<EventResponse> getAllEvents() {

        List<Event> events = eventRepository.findAll();
        events.forEach(event -> log.info("found event: {}", event));

        return events.stream().map(venue -> modelConverter.convertToResponse(venue)).collect(Collectors.toList());//        return events;
    }

    @Transactional
    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        Event event = eventCreator.createEvent(eventRequest);
        log.info("Created event to save: {}", event);
        eventRepository.save(event);

        return modelConverter.convertToResponse(event);
    }

    @Transactional
    @Override
    public void removeEvent(long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isEmpty())
            throw new RemoveEventException("No Event with id: " + eventId + " exists");

        eventRepository.delete(event.get());
    }
}
