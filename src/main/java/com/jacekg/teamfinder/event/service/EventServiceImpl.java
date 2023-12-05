package com.jacekg.teamfinder.event.service;

import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.repository.EventRepository;
import com.jacekg.teamfinder.event.utils.factory.EventBaseCreator;
import com.jacekg.teamfinder.user.model.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private final EventBaseCreator eventCreator;


    @Transactional
    @Override
    public List<Event> getAllEvents() {

        List<Event> events = eventRepository.findAll();
        events.forEach(event -> System.out.println("found event: " + event.toString()));

        return events;
    }

    @Transactional
    @Override
    public Event createEvent(EventRequest eventRequest) {
        Event event = eventCreator.createEvent(eventRequest);
        log.info("Created event: {}", event);
        //TODO get user by id
//        event.addCreator(creator);
//        event.addUser(creator);
//        event.setVenue(venue);
//        event.setActivityType(activityType);
//        eventRepository.save(event);

        return event;
    }
}
