package io.developerinator.app.controller;


import io.developerinator.app.dto.EventDto;
import io.developerinator.app.dto.WatchOutDto;
import io.developerinator.service.WatchOutService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "watchout")
public class WatchOutController implements BaseController{

    @Autowired
    private WatchOutService watchOutService;

    @ResponseBody
    @RequestMapping(name = "/save", method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
    public HttpEntity save(@RequestBody WatchOutDto watchOutDto){

        Validate.notNull(watchOutDto);

        return new ResponseEntity<WatchOutDto>(watchOutService.save(watchOutDto), HttpStatus.OK);
    }


}
