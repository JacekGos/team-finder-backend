package com.jacekg.teamfinder.venue.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VenueResponse {
	
private Long id;
	
	private String name;
	
	private float price;
	
	private String address;
	
	private String lat;
	
	private String lng;
	
	private List<Date> eventDates;
	
	private List<String> activities;
}
