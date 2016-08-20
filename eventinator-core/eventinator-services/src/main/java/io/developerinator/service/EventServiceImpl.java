package io.developerinator.service;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import io.developerinator.app.domain.Event;
import io.developerinator.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        Validate.notNull(event);
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        Validate.notNull(event);
        eventRepository.delete(event);
    }

    @Override
    public Event find(String id) {
        Validate.notEmpty(id);
        return eventRepository.findOne(id);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
