package com.jacekg.teamfinder.event.controller;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import static org.springframework.http.ResponseEntity.status;

@Controller
@RequestMapping("/v1/")
public class EventRestController {

    private final EventService eventService;

    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        return status(HttpStatus.OK).body(eventService.getAllEvents());
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponse> createVenue(@Valid @RequestBody EventRequest eventRequest) throws Exception {
        return status(HttpStatus.OK).body(eventService.createEvent(eventRequest));
    }
}
