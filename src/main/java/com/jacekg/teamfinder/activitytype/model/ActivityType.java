package com.jacekg.teamfinder.activitytype.model;

import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.venue.model.Venue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity_type")
public class ActivityType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY,
			mappedBy = "activityType",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Event> games;
	
	@ManyToMany(mappedBy = "activities")
	private Set<Venue> venues = new HashSet<>();

	@Override
	public String toString() {
		return name;
	}
	
	public void addVenue(Venue venue) {
		this.venues.add(venue);
	}
	
	public String getName() {
		System.out.println("activity name: " + this.name);
		return this.name;
	}
}
