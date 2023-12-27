package com.jacekg.teamfinder.venue;

import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.venue.model.IndoorVenue;
import com.jacekg.teamfinder.venue.model.Venue;
import com.jacekg.teamfinder.venue.repository.VenueRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AllArgsConstructor
public class VenueRepositoryTest {

    private VenueRepository venueRepository;
    private GeometryFactory geometryFactory;
    private Venue venue;
    private Set<ActivityType> acitivitiesTypes = new HashSet<>();

    @BeforeEach
    void setUp() throws Exception {
        venue = IndoorVenue.builder()
                .name("test-venue")
                .address("Warszawa, aleja Solidarności")
                .price(10)
                .build();

        Point location = geometryFactory.createPoint(new Coordinate(52.24678842149118, 21.014623478817406));
        venue.setLocation(location);

        acitivitiesTypes.add()
    }

    @Test
    void testFindByLocationAndActivitiesIn() {
        Point location = geometryFactory.createPoint(new Coordinate(52.24678842149118, 21.014623478817406));
        venueRepository.save(venue);

        Venue foundVenue = venueRepository.findByLocationAndActivitiesIn()

    }

}
