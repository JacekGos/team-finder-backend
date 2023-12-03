package com.jacekg.teamfinder.venue.utils.factory;

import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.exceptions.CreateVenueException;
import com.jacekg.teamfinder.venue.model.IndoorVenue;
import com.jacekg.teamfinder.venue.model.OutdoorVenue;
import com.jacekg.teamfinder.venue.model.Venue;

public class VenueCreator extends VenueBaseCreator {

	@Override
	public Venue createVenue(VenueRequest venue) {
		
		Venue newVenue = null;
		
		switch (venue.getVenueTypeName()) {
		case "outdoor": 
			newVenue = OutdoorVenue.builder()
				.name(venue.getName())
				.price(venue.getPrice())
				.address(venue.getAddress())
				.build();
			break;
		case "indoor": 
			newVenue = IndoorVenue.builder()
				.name(venue.getName())
				.price(venue.getPrice())
				.address(venue.getAddress())
				.build();
			break;
		default:
			throw new CreateVenueException("No type(" + venue.getVenueTypeName() + ")" + " of Venue exists");
		}
		
		return newVenue;
	}
}
