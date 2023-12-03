package com.jacekg.teamfinder.venue.geocoding.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeLocation {
	
	@JsonProperty("lat")
	private double latitude;
	
	@JsonProperty("lng")
	private double longitude;
}