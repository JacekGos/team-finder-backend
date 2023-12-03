package com.jacekg.teamfinder.venue.geocoding.service;

import com.jacekg.teamfinder.venue.geocoding.model.GeocodeObject;

import java.io.IOException;


public interface GeocodingService {
	public GeocodeObject findLocationByAddress(String address) throws IOException;
}