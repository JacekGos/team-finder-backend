package com.jacekg.teamfinder.event.controller;

import com.jacekg.teamfinder.event.dto.EventResponse;
import com.jacekg.teamfinder.event.dto.EventRequest;
import com.jacekg.teamfinder.event.service.EventService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

@Controller
@RequestMapping("/v1/")
@Slf4j
public class EventRestController {

    private final EventService eventService;

    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/events")
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        return status(HttpStatus.OK).body(eventService.getAllEvents());
    }

    @PostMapping("/events")
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody EventRequest eventRequest) throws Exception {
        return status(HttpStatus.OK).body(eventService.createEvent(eventRequest));
    }

    @DeleteMapping("/events/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeEvent(@PathVariable long eventId) throws Exception {
        log.info("removeEvent: eventId: {}", eventId);
        eventService.removeEvent(eventId);
    }

    @GetMapping("/events/filter")
    public ResponseEntity<List<EventResponse>> getAllEventsByFilters
            (@RequestParam Map<String, String> filterParams) throws IOException {
        log.info("getAllEventsByFilters: filters: {}", filterParams.toString());
        return status(HttpStatus.OK).body(eventService.getAllEventsByFilters(filterParams));
    }
}
