package com.jacekg.teamfinder.venue.repository;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.venue.model.Venue;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface VenueRepository extends JpaRepository<Venue, Long> {
	public Optional<Venue> findByLocationAndActivitiesIn(Point location, Set<ActivityType> activityTypes);
}
