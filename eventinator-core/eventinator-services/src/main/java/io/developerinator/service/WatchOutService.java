package io.developerinator.service;


import io.developerinator.app.domain.WatchOut;

import java.util.List;

public interface WatchOutService {

    WatchOut save(WatchOut watchOut);

    void delete(WatchOut watchOut);

    WatchOut find(String id);

    List<WatchOut> findAll();
}
