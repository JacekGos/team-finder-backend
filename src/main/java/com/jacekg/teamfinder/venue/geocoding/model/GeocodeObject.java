package com.jacekg.teamfinder.venue.geocoding.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeObject {
	
	@JsonProperty("place_id")
	String placeId;
	
	@JsonProperty("formatted_address")
	String formattedAddress;
	
	GeocodeGeometry geometry;
}
