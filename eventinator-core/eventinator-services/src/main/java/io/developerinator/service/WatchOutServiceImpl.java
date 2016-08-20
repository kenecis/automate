package io.developerinator.service;


import io.developerinator.app.domain.WatchOut;
import io.developerinator.repository.WatchOutRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchOutServiceImpl implements WatchOutService{

    @Autowired
    private WatchOutRepository watchOutRepository;

    @Override
    public WatchOut save(WatchOut watchOut) {
        Validate.notNull(watchOut);
        return watchOutRepository.save(watchOut);
    }

    @Override
    public void delete(WatchOut watchOut) {
        Validate.notNull(watchOut);
        watchOutRepository.delete(watchOut);
    }

    @Override
    public WatchOut find(String id) {
        Validate.notEmpty(id);
        return watchOutRepository.findOne(id);
    }

    @Override
    public List<WatchOut> findAll() {
        return watchOutRepository.findAll();
    }
}
