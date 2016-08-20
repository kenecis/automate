package io.developerinator.repository;


import io.developerinator.app.domain.Event;
import io.developerinator.app.dto.IteneraryDto;

import java.util.List;

public interface EventRepositoryCustom {

    List<Event> findAll(IteneraryDto iteneraryDto);
}
