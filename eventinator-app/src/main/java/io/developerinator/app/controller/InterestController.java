package io.developerinator.app.controller;

import io.developerinator.app.dto.InterestDto;
import io.developerinator.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by jvillanueva on 8/21/16.
 */
@RestController
@RequestMapping("/api/interests")
public class InterestController {

    @Autowired
    private InterestService interestService;

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Set<InterestDto>> findAll(){
        return new ResponseEntity<>(interestService.findAll(), HttpStatus.OK);
    }
}
