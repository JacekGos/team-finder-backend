package com.jacekg.teamfinder.venue.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "venue_event_date")
@NoArgsConstructor
@Getter
public class EventDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "venue_id")
	private Long venueId;
	
	@Column(name = "date", nullable = false)
	private Date date;

	public EventDate(Long venueId, Date date) {
		this.venueId = venueId;
		this.date = date;
	}
}	
