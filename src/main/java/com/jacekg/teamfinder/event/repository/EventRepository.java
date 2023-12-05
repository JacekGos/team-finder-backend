package com.jacekg.teamfinder.event.repository;

import com.jacekg.teamfinder.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
