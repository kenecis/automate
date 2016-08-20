package io.developerinator.service;


import io.developerinator.app.domain.Event;

import java.util.List;

public interface EventService {

    Event save(Event event);

    void delete(Event event);

    Event find(String id);

    List<Event> findAll();
}
