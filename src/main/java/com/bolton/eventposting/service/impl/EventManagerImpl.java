package com.bolton.eventposting.service.impl;

import com.bolton.eventposting.enums.EventStatus;
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

@Service
public class EventManagerImpl implements EventManager {

    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public EventManagerImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Response saveEvent(EventRequest eventRequest) {
        return null;
    }
}
