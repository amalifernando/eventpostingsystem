package com.bolton.eventposting.controller;

import com.bolton.eventposting.enums.RequestStatus;
import com.bolton.eventposting.exception.SystemException;
import com.bolton.eventposting.model.Event;
import com.bolton.eventposting.payload.EventRequest;
import com.bolton.eventposting.payload.Response;
import com.bolton.eventposting.service.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    private EventManager eventManager;

    @PostMapping("/add")
    public Response saveEvent(@RequestBody EventRequest eventRequest){
        Response response = new Response();
        try{
            response = eventManager.saveEvent(eventRequest);
        }catch(SystemException ex){
            response.setStatus(RequestStatus.FAIL.name());
            response.setMessage(ex.getMessage());
            response.setResponseCode(ex.getCode());
        }
        return response;
    }

    @GetMapping("/search")
    public Response getEvents(@RequestParam String searchQuery){
        Response response = new Response();
        try{
            List<Event> eventList = eventManager.getEventList(searchQuery);
            response.setObject(eventList);
            response.setStatus(RequestStatus.SUCCESS.name());
        }catch(SystemException ex){
            response.setStatus(RequestStatus.FAIL.name());
            response.setMessage(ex.getMessage());
            response.setResponseCode(ex.getCode());
        }

        return response;
    }
}
