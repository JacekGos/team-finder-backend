package com.jacekg.teamfinder.venue.geocoding.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacekg.teamfinder.venue.exceptions.CreateVenueException;
import com.jacekg.teamfinder.venue.geocoding.model.GeocodeObject;
import com.jacekg.teamfinder.venue.geocoding.model.GeocodeResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
public class GeocodingServiceImpl implements GeocodingService {
	
	private static final Logger logger = LoggerFactory.getLogger(GeocodingServiceImpl.class);
	
	private String GEOCODING_API_KEY;
	
	private String GEOCODING_API_URL;
	
	private ObjectMapper objectMapper;
	
	@Autowired
	public GeocodingServiceImpl(
			ObjectMapper objectMapper,
			@Value("${geocoding.api.key}") String GEOCODING_API_KEY, 
			@Value("${geocoding.api.url}") String GEOCODING_API_URL) {
		
		this.objectMapper = objectMapper;
		this.GEOCODING_API_KEY = GEOCODING_API_KEY;
		this.GEOCODING_API_URL = GEOCODING_API_URL;
		
	}
	
	@Override
	public GeocodeObject findLocationByAddress(String address) throws IOException {
		
		OkHttpClient client = new OkHttpClient();

		String encodedAddress = URLEncoder.encode(address, "UTF-8");

		Request request = new Request.Builder()
				.url(GEOCODING_API_URL
					+ encodedAddress
					+ "&key=" + GEOCODING_API_KEY)
				.get().build();

		ResponseBody responseBody = client.newCall(request).execute().body();

        assert responseBody != null;
        GeocodeResult result = objectMapper.readValue(responseBody.string(), GeocodeResult.class);
		
		if (result.getResults().isEmpty() && !result.getStatus().equals("ok")) {
			throw new CreateVenueException("No location found");
		} else {
			return result.getResults().get(0);
		}
	}
}