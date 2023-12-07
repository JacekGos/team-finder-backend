package com.jacekg.teamfinder.event.repository;

import com.jacekg.teamfinder.event.model.Event;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    public List<Event> findAll(Specification<Event> spec);
}
