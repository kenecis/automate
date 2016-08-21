package io.developerinator.service;


import io.developerinator.app.domain.WatchOut;
import io.developerinator.app.dto.WatchOutDto;

import java.util.List;

public interface WatchOutService {

    WatchOutDto save(WatchOutDto watchOut);

    void delete(long id);

    WatchOutDto find(long id);

    List<WatchOutDto> findAll();
}
