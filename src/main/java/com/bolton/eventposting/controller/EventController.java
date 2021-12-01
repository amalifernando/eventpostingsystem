package com.bolton.eventposting.controller;

import com.bolton.eventposting.enums.RequestStatus;
import com.bolton.eventposting.exception.SystemException;
import com.bolton.eventposting.payload.EventRequest;
import com.bolton.eventposting.payload.Response;
import com.bolton.eventposting.service.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
