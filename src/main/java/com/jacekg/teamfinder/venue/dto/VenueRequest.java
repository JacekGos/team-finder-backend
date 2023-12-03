package com.jacekg.teamfinder.venue.dto;

import lombok.*;

import jakarta.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VenueRequest {
	
	@NotNull(message = "required")
	@Size(min = 1, max = 50, message = "too long name")
	private String name;
	
	@NotNull(message = "required")
	@Size(min = 1, max = 200, message = "too long address")
	private String address;
	
	@NotNull(message = "required")
	@Size(min = 1, max = 200, message = "too long venue type name")
	private String venueTypeName;
	
	@NotNull(message = "required")
	@Min(value = 0, message = "min value 0")
	@Max(value = 10000, message = "max value 10000")
	private float price;
	
	@NotNull(message = "required")
	@NotEmpty(message = "activities cannot be empty")
	private List<String> activities;
	
	public void setName(String name) {
		if (name != null) {
			this.name = name.trim();
		}
	}
	
	public void setVenueTypeName(String venueTypeName) {
		if (venueTypeName != null) {
			this.venueTypeName = venueTypeName.trim();
		}
	}
}

