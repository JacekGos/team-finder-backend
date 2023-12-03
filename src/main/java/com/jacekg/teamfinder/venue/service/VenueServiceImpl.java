package com.jacekg.teamfinder.venue.service;

import com.jacekg.teamfinder.venue.dto.VenueRequest;
import com.jacekg.teamfinder.venue.exceptions.CreateVenueException;
import com.jacekg.teamfinder.venue.model.ActivityType;
import com.jacekg.teamfinder.venue.model.Venue;
import com.jacekg.teamfinder.venue.repository.ActivityRepository;
import com.jacekg.teamfinder.venue.repository.VenueRepository;
import com.jacekg.teamfinder.venue.utils.factory.VenueBaseCreator;
import lombok.AllArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {
	
	private VenueRepository venueRepository;
	private ActivityRepository activityRepository;
	private GeocodingService geocodingService;
	private GeometryFactory geometryFactory;
	private VenueBaseCreator venueCreator;

	@Transactional
	@Override
	public List<Venue> getAllVenues() {

		List<Venue> venues = venueRepository.findAll();
		venues.forEach(venue -> System.out.println("found venue: " +  venue.toString()));
		
		return venues;
	}
	
	@Transactional
	@Override
	public Venue createVenue(VenueRequest venueRequest) throws IOException {
		
		Venue venue = venueCreator.createVenue(venueRequest);
		venue.setActivities(getActivitiesByNames(venueRequest.getActivities()));
		venue.setLocation(getLocationByAddress(venueRequest.getAddress()));
		
		venueRepository.findByLocationAndActivitiesIn(venue.getLocation(), venue.getActivities())
			.ifPresent((foundVenue) -> {
				throw new CreateVenueException("Venue in address: " + venueRequest.getAddress() + " of activity type: " + venueRequest.getActivities() + " already exists");
			});
		
		venueRepository.save(venue);
		
		return venue;
	}
	
	private Point getLocationByAddress(String address)  {
		
		Point coordinates = null;
		
		try {
			GeocodeObject geocodeObject = geocodingService.findLocationByAddress(address);
			GeocodeLocation location = geocodeObject.getGeometry().getGeocodeLocation();
			coordinates = geometryFactory.createPoint(new Coordinate(location.getLatitude(), location.getLongitude()));
		} catch (IOException ex) {
			throw new CreateVenueException("No location found for address: " + address);
		}
		
		return coordinates;
	}
	
	private Set<ActivityType> getActivitiesByNames(List<String> names) {
		
		Optional<List<ActivityType>> foundActivites 
			= activityRepository.findByNames(names);
	
		List<ActivityType> activites = Optional.ofNullable(foundActivites)
			.get()
			.orElseThrow();
		
		if (activites.isEmpty())
			throw new CreateVenueException("No activityType for activities: " + names);
		
		return new HashSet<>(activites);
	}
}
