package com.jacekg.teamfinder.venue.controller;

import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.dto.VenueResponse;
import com.jacekg.teamfinder.venue.service.VenueService;
import com.jacekg.teamfinder.venue.utils.converter.ModelConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/v1/")
public class VenueRestController {
	
	VenueService venueService;
//	ModelConverter modelConverter;

	public VenueRestController(VenueService venueService, ModelConverter modelConverter) {
		this.venueService = venueService;
//		this.modelConverter = modelConverter;
	}
	
	@GetMapping("/venues")
	public ResponseEntity<List<VenueResponse>> getAllVenues() {
		return status(HttpStatus.OK).body(venueService.getAllVenues());
//		return status(HttpStatus.OK).body(venueService.getAllVenues().stream().map(venue -> modelConverter.convertToResponse(venue)).collect(Collectors.toList()));
	}
	
	@PostMapping("/venues")
	public ResponseEntity<VenueResponse> createVenue(@Valid @RequestBody VenueRequest venueRequest) throws Exception {
		return status(HttpStatus.CREATED).body(venueService.createVenue(venueRequest));
//		return status(HttpStatus.CREATED).body(modelConverter.convertToResponse(venueService.createVenue(venueRequest)));
	}
	
}
