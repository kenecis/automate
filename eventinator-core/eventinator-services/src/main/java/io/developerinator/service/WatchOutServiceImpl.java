package io.developerinator.service;


import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.Validate;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.developerinator.app.domain.WatchOut;
import io.developerinator.app.dto.WatchOutDto;
import io.developerinator.repository.WatchOutRepository;

@Service
public class WatchOutServiceImpl implements WatchOutService{

    @Autowired
    private WatchOutRepository watchOutRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public WatchOutDto save(WatchOutDto watchOutDto) {
        Validate.notNull(watchOutDto);
        WatchOut watchOut = mapper.map(watchOutDto, WatchOut.class);

        return mapper.map(watchOutRepository.save(watchOut), WatchOutDto.class);
    }

    @Override
    public void delete(long id) {
        Validate.notNull(id);

        WatchOut watchOut = watchOutRepository.findOne(id);

        if(watchOut != null){
            watchOutRepository.delete(watchOut);
        }
    }

    @Override
    public WatchOutDto find(long id) {
        Validate.notNull(id);
        return mapper.map(watchOutRepository.findOne(id), WatchOutDto.class);
    }

    @Override
    public List<WatchOutDto> findAll() {
        List<WatchOut> watchOuts = watchOutRepository.findAll();
        return watchOuts.stream().map(watchOut -> mapper.map(watchOut, WatchOutDto.class)).collect(Collectors.<WatchOutDto>toList());
    }
}
