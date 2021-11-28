package com.bolton.eventposting.service;

import com.bolton.eventposting.model.Event;
import com.bolton.eventposting.payload.EventRequest;
import com.bolton.eventposting.payload.Response;

public interface EventManager {

    Response saveEvent(EventRequest eventRequest);
}
