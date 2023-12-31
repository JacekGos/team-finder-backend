package com.jacekg.teamfinder.event.utils;

import com.jacekg.teamfinder.event.model.Event;
import com.jacekg.teamfinder.venue.service.VenueService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Slf4j
@Component
public class EventsFilterSpecification {

    private VenueService venueService;


    public Specification<Event> getEvents(Map<String, String> filterParams) {

//        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");

        return new Specification<Event>() {

            final List<Predicate> predicates = new ArrayList<>();

            @Override
            public Predicate toPredicate(@NotNull Root<Event> root, @NotNull CriteriaQuery<?> query, @NotNull CriteriaBuilder criteriaBuilder) {

                root.fetch("venue", JoinType.LEFT);
                root.fetch("activityType", JoinType.LEFT);

                log.info("filterParams: {} isEmpyty: {}", filterParams.get("location"), filterParams.get("location").isEmpty());
                if (filterParams.get("location") != null && !filterParams.get("location").trim().isEmpty() && !filterParams.get("location").isEmpty()) {

                    List<Long> venuesId = null;

                    try {
                        venuesId = venueService.getAllIdsByActivityTypeAndLocation(
                                filterParams.get("activityType"),
                                filterParams.get("location"),
                                Double.parseDouble(filterParams.get("range")) * 1000);

                    } catch (NumberFormatException | IOException e) {
                        e.printStackTrace();
                    }

                    log.info("found Venues in range: {}", venuesId);
                    predicates.add(criteriaBuilder.in(root.get("venue").get("id")).value(venuesId));

                }
                if (filterParams.get("activityType") != null && !filterParams.get("activityType").isEmpty()) {

                    predicates.add(criteriaBuilder.like(
                            root.get("activityType").get("name"),
                            filterParams.get("activityType")));

                }
                if (filterParams.get("priceMin") != null && !filterParams.get("priceMin").isEmpty()
                        && filterParams.get("priceMax") != null && !filterParams.get("priceMax").isEmpty()) {

                    int priceMin = Integer.parseInt(filterParams.get("priceMin"));
                    int priceMax = Integer.parseInt(filterParams.get("priceMax"));

                    predicates.add(criteriaBuilder.between(root.get("price"), priceMin, priceMax));

                }
                if (filterParams.get("startDate") != null && !filterParams.get("startDate").isEmpty()
                        && filterParams.get("endDate") != null && !filterParams.get("endDate").isEmpty()) {

//                    LocalDateTime startDate = LocalDateTime.ofInstant(Instant.parse(filterParams.get("startDate")), ZoneOffset.UTC);
//                    LocalDateTime endDate = LocalDateTime.ofInstant(Instant.parse(filterParams.get("endDate")), ZoneOffset.UTC);
                    LocalDateTime startDate = LocalDateTime.parse(filterParams.get("startDate"));
                    LocalDateTime endDate = LocalDateTime.parse(filterParams.get("endDate"));

                    predicates.add(criteriaBuilder.between(root.get("date"), startDate, endDate.plusDays(1)));

                }
                if (filterParams.get("playersMin") != null && !filterParams.get("playersMin").isEmpty()
                        && filterParams.get("playersMax") != null && !filterParams.get("playersMax").isEmpty()) {

                    int playersMin = Integer.parseInt(filterParams.get("playersMin"));
                    int playersMax = Integer.parseInt(filterParams.get("playersMax"));

                    predicates.add(criteriaBuilder.between(root.get("amountOfPlayers"), playersMin, playersMax));

                }
                if (filterParams.get("duration") != null && !filterParams.get("duration").isEmpty()) {

                    int duration = Integer.parseInt(filterParams.get("duration"));

                    predicates.add(criteriaBuilder.equal(root.get("duration"), duration));

                }

                query.orderBy(criteriaBuilder.desc(root.get("id")));

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }

        };

    }
}
