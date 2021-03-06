package com.bolton.eventposting.service.impl;

import com.bolton.eventposting.enums.EventStatus;
import com.bolton.eventposting.enums.RequestStatus;
import com.bolton.eventposting.exception.SystemException;
import com.bolton.eventposting.model.Event;
import com.bolton.eventposting.model.User;
import com.bolton.eventposting.payload.EventRequest;
import com.bolton.eventposting.payload.Response;
import com.bolton.eventposting.repository.EventRepository;
import com.bolton.eventposting.repository.UserRepository;
import com.bolton.eventposting.service.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventManagerImpl implements EventManager {

    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    @Autowired
    public EventManagerImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Response saveEvent(EventRequest eventRequest) {
        Response response = new Response();
        if(eventRequest.getEventName() == null){
            throw new SystemException("1001", "Event name is required.");
        }

        if(eventRequest.getEventStartDate() == null){
            throw new SystemException("1002", "Event start date is required.");
        }

        if(eventRequest.getEventEndDate() == null){
            throw new SystemException("1003", "Event end date is required.");
        }

        if(eventRequest.getStartTime() == null){
            throw new SystemException("1004", "Event start time is required.");
        }

        if(eventRequest.getEndTime() == null){
            throw new SystemException("1005", "Event end time is required.");
        }

        if(eventRequest.getAddressLine1() == null){
            throw new SystemException("1006", "Address line 1 is required.");
        }

        if(eventRequest.getCity() == null){
            throw new SystemException("1007", "City is required.");
        }

        if(eventRequest.getPostcode() == null){
            throw new SystemException("1008", "Postcode is required.");
        }

        if(eventRequest.getEmail() == null){
            throw new SystemException("1009", "Email is required.");
        }
        try {
            User user = userRepository.getById(eventRequest.getUserId());
            Date currentDate = new Date();
            String eventCode = user.getUserId().toString()+"_"+currentDate.getTime();

            Event event = new Event(eventCode, eventRequest.getEventName(), eventRequest.getEventStartDate(),
                    eventRequest.getEventEndDate(), eventRequest.getStartTime(), eventRequest.getEndTime(),
                    eventRequest.getAddressLine1(), eventRequest.getAddressLine2(), eventRequest.getCity(),
                    eventRequest.getPostcode(),
                    eventRequest.getEventDescription(), eventRequest.getEmail(), eventRequest.getContactNumber(),
                    EventStatus.NEW, user);

            Event savedEvent = eventRepository.save(event);
            response.setObject(savedEvent);
            response.setMessage("Event has been saved successfully.");
            response.setResponseCode("1011");
            response.setStatus(RequestStatus.SUCCESS.name());

        }catch(NullPointerException ex){
            throw new SystemException("1010", "No such user is found.");
        }

        return response;
    }


    @Override
    public List<Event> getEventList(String searchQuery){

        List<Event> eventList = new ArrayList<>();
        eventList = eventRepository.getEventList(searchQuery);
        return eventList;
    }

    @Override
    public Response deleteEvent(Long eventId) {
        Response response = new Response();
        if(eventId == null){
            throw new SystemException("1012", "Event id is required.");
        }

        Event event = eventRepository.getById(eventId);
        if(event == null){
            throw new SystemException("1013", "No such event is found to delete.");
        }
        eventRepository.delete(event);
        response.setMessage("Event has been deleted successfully.");
        response.setStatus(RequestStatus.SUCCESS.name());
        return response;
    }

    @Override
    public Response updateEvent(EventRequest eventRequest) {
        Response response = new Response();
        try {
            User user = userRepository.findById(eventRequest.getUserId()).get();
            Event event = new Event(eventRequest.getEventId(),eventRequest.getEventCode(), eventRequest.getEventName(), eventRequest.getEventStartDate(),
                    eventRequest.getEventEndDate(), eventRequest.getStartTime(), eventRequest.getEndTime(),
                    eventRequest.getAddressLine1(), eventRequest.getAddressLine2(), eventRequest.getCity(),
                    eventRequest.getPostcode(),
                    eventRequest.getEventDescription(), eventRequest.getEmail(), eventRequest.getContactNumber(),
                    EventStatus.valueOf(eventRequest.getEventStatus()), user);

            eventRepository.save(event);
        }catch(SystemException ex){
            response.setMessage("Error in updating event details.");
            response.setStatus(RequestStatus.FAIL.name());
        }
        return response;
    }
}
