package com.jacekg.teamfinder.venue.controller;

import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.service.VenueService;
import com.jacekg.teamfinder.venue.utils.converter.VenueModelConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/v1/")
public class VenueRestController {
	
	VenueService venueService;

	public VenueRestController(VenueService venueService, VenueModelConverter modelConverter) {
		this.venueService = venueService;
	}
	
	@GetMapping("/venues")
	public ResponseEntity<List<VenueResponse>> getAllVenues() {
		return status(HttpStatus.OK).body(venueService.getAllVenues());
	}
	
	@PostMapping("/venues")
	public ResponseEntity<VenueResponse> createVenue(@Valid @RequestBody VenueRequest venueRequest) throws Exception {
		return status(HttpStatus.CREATED).body(venueService.createVenue(venueRequest));
	}
}
