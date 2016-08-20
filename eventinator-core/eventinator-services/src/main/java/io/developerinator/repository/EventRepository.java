package io.developerinator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.developerinator.app.domain.Event;

public interface EventRepository extends JpaRepository<Event, String>{
}
