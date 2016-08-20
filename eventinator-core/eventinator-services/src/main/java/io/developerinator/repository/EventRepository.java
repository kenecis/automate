package io.developerinator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.developerinator.app.domain.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{
}
