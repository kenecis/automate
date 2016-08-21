package io.developerinator.app.controller;

import io.developerinator.app.dto.EventDto;
import io.developerinator.app.dto.IteneraryDto;
import io.developerinator.app.ref.EventSource;
import io.developerinator.service.EventService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController implements BaseController {

    @Autowired
    private EventService eventService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public HttpEntity viewAllEvents(){
        return new ResponseEntity<List<EventDto>>(eventService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
    public HttpEntity saveEvent(@RequestBody EventDto eventDto){

        Validate.notNull(eventDto);
        return new ResponseEntity<EventDto>(eventService.save(eventDto), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public HttpEntity viewEventDetails(@PathVariable("id") long id){

        return new ResponseEntity<EventDto>(eventService.find(id), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/events", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public HttpEntity viewAllEventsBeSource(@RequestParam("source")EventSource source){

        Validate.notNull(source);
        return new ResponseEntity<List<EventDto>>(eventService.findAllBySource(source), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/iteneraries", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public HttpEntity findIteneraries(@RequestBody IteneraryDto iteneraryDto){

        Validate.notNull(iteneraryDto);
        return new ResponseEntity<List<EventDto>>(eventService.findIteneraries(iteneraryDto), HttpStatus.OK);
    }
}
