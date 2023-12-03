package com.jacekg.teamfinder.venue.repository;

import com.jacekg.teamfinder.venue.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<ActivityType, Long> {
	public Optional<ActivityType> findByName(String name);
	@Query("FROM ActivityType WHERE name IN :names")
	public Optional<List<ActivityType>> findByNames(@Param("names") List<String> names);
}
