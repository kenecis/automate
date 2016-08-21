package io.developerinator.service;

import io.developerinator.app.dto.InterestDto;

import java.util.Set;

/**
 * Created by jvillanueva on 8/21/16.
 */
public interface InterestService {

    Set<InterestDto> findAll();
}
