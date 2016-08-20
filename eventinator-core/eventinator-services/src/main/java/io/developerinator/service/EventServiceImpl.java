package io.developerinator.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.Validate;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.developerinator.app.domain.Account;
import io.developerinator.app.domain.Event;
import io.developerinator.app.dto.EventDto;
import io.developerinator.app.dto.IteneraryDto;
import io.developerinator.app.ref.EventSource;
import io.developerinator.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private Mapper mapper;

    @Override
    public EventDto save(EventDto eventDto) {
        Validate.notNull(eventDto);

        Event event = mapper.map(eventDto, Event.class);

        return mapper.map(eventRepository.save(event), EventDto.class);
    }

    @Override
    public void delete(long id) {
        Validate.notNull(id);
        Event event = eventRepository.findOne(id);
        if(event != null){
            eventRepository.delete(event);
        }
    }

    @Override
    public EventDto find(long id) {
        Validate.notNull(id);
        return mapper.map(eventRepository.findOne(id), EventDto.class);
    }

    @Override
    public List<EventDto> findAll() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapper.map(event, EventDto.class)).collect(Collectors.<EventDto>toList());
    }

    @Override
    public List<EventDto> findAllBySource(EventSource eventSource) {

        Account account = (Account) userDetailsService.getCurrentlyLoggedInUser();

        return eventRepository.findByEventSourceAndOwner(eventSource, account).stream().map(event ->
                        mapper.map(event, EventDto.class)
        ).collect(Collectors.<EventDto> toList());
    }

    @Override
    public List<EventDto> findIteneraries(IteneraryDto itenerary) {

        Validate.notNull(itenerary);

        List<Event> events = eventRepository.findAll(itenerary);

        return events.stream().map(event -> mapper.map(event, EventDto.class)).collect(Collectors.<EventDto> toList());
    }
}
