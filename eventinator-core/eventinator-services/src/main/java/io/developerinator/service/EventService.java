package io.developerinator.service;


import java.util.List;

import io.developerinator.app.dto.EventDto;
import io.developerinator.app.dto.IteneraryDto;
import io.developerinator.app.ref.EventSource;

public interface EventService {

    EventDto save(EventDto eventDto);

    void delete(long id);

    EventDto find(long id);

    List<EventDto> findAll();

    List<EventDto> findAllBySource(EventSource eventSource);

    List<EventDto> findIteneraries(IteneraryDto itenerary);
}
