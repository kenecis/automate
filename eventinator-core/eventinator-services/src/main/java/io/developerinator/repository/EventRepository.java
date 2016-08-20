package io.developerinator.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.developerinator.app.domain.Account;
import io.developerinator.app.domain.Event;
import io.developerinator.app.ref.EventSource;
@Repository
public interface EventRepository extends BaseRepository<Event, Long>, EventRepositoryCustom  {

    List<Event> findByEventSourceAndOwner(EventSource eventSource, Account account);
}