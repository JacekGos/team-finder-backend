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
    public Optional<Venue> findByLocationAndActivitiesIn(Point location, Set<ActivityType> activityTypes);

    //	@Query(value="SELECT v.id from venue as v inner join venue_type as vt"
//			+ " on v.venue_type_id = vt.id"
//			+ " where vt.name in :venueTypeNames and ST_DistanceSphere(location, :location) < :distance",
//			nativeQuery = true)
    @Query(value = "SELECT id from venue"
            + " where ST_DistanceSphere(location, :location) < :distance",
            nativeQuery = true)
    List<Long> getIdsWithinDistance(Point location, double distance);
}
