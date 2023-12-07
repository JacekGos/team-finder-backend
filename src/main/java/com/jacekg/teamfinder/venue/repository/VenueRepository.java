package com.jacekg.teamfinder.venue.repository;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.venue.model.Venue;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Optional<Venue> findByLocationAndActivitiesIn(Point location, Set<ActivityType> activityTypes);

    @Query(value = "SELECT id FROM venue"
            + " WHERE ST_DistanceSphere(location, :location) < :distance",
            nativeQuery = true)
    List<Long> getIdsWithinDistance(Point location, double distance);
}
