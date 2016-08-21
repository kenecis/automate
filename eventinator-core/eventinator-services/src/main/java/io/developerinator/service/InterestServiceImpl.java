package io.developerinator.service;

import io.developerinator.app.dto.InterestDto;
import io.developerinator.repository.InterestRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jvillanueva on 8/21/16.
 */
@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Set<InterestDto> findAll() {
        return interestRepository.findAll()
                .stream()
                .map(i -> mapper.map(i, InterestDto.class))
                .collect(Collectors.toSet());
    }
}
