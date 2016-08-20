package io.developerinator.service;


import io.developerinator.app.domain.WatchOut;

import java.util.List;

public interface WatchOutService {

    WatchOut save(WatchOut watchOut);

    void delete(WatchOut watchOut);

    WatchOut find(long id);

    List<WatchOut> findAll();
}
