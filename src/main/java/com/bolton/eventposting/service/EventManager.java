package com.bolton.eventposting.service;

import com.bolton.eventposting.model.Event;
import com.bolton.eventposting.payload.EventRequest;
import com.bolton.eventposting.payload.Response;

import java.util.List;

public interface EventManager {

    Response saveEvent(EventRequest eventRequest);

    List<Event> getEventList(String searchQuery);
}
