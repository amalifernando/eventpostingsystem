package com.bolton.eventposting.service.impl;

import com.bolton.eventposting.enums.EventStatus;
import com.bolton.eventposting.exception.SystemException;
import com.bolton.eventposting.model.Event;
import com.bolton.eventposting.model.User;
import com.bolton.eventposting.payload.EventRequest;
import com.bolton.eventposting.payload.Response;
import com.bolton.eventposting.repository.EventRepository;
import com.bolton.eventposting.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventManagerImplTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private EventManagerImpl eventManagerImpl;

    @Test
    public void testEventCreatorIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
             EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                     "davidmith@gmail.com", "0756784344",  1L) ;
             eventManagerImpl.saveEvent(eventRequest);
         });

        assertEquals("No such user is found.", exception.getMessage());
    }

    @Test
    public void testEventNameIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest(null, LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;
            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Event name is required.", exception.getMessage());
    }

    @Test
    public void testEventStartDateIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", null, LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Event start date is required.", exception.getMessage());
    }

    @Test
    public void testEventEndDateIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), null, 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Event end date is required.", exception.getMessage());
    }

    @Test
    public void testEventStartTimeIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), null, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Event start time is required.", exception.getMessage());
    }

    @Test
    public void testEventEndTimeIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, null, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Event end time is required.", exception.getMessage());
    }

    @Test
    public void testEventAddressLine1IsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, null, "", "Bolton", "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Address line 1 is required.", exception.getMessage());
    }

    @Test
    public void testEventCityIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", null, "BL3 5HY", "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("City is required.", exception.getMessage());
    }

    @Test
    public void testEventPostCodeIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", null, "Entrance is free.",
                    "davidmith@gmail.com", "0756784344",  1L) ;

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Postcode is required.", exception.getMessage());
    }

    @Test
    public void testEventEmailIsNull(){
        Throwable exception = assertThrows(SystemException.class, () -> {
            EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                    null, "0756784344",  1L);

            eventManagerImpl.saveEvent(eventRequest);
        });

        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    public void testSaveEvent(){
        User user = new User(1L,"David", "Smith", "davidmith@gmail.com", "david@123", "0756784344");
        EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "",
                "davidmith@gmail.com", "0756784344",  1L) ;

        Event event = new Event(1L, "1_1234567", "Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"),
                32400000L, 57600000L,"9, Derby Street", "", "Bolton", "BL3 5HY","Entrance is free.","davidmith@gmail.com", "0756784344",
                EventStatus.NEW, user);

        when(userRepository.getById(eventRequest.getUserId())).thenReturn(user);
        when(eventRepository.save(Mockito.any(Event.class))).thenReturn(event);

        Response response = eventManagerImpl.saveEvent(eventRequest);

        Mockito.verify(eventRepository, Mockito.times(1)).save(ArgumentMatchers.any(Event.class));
        Assertions.assertThat(response.getObject()).isNotNull();
        assertEquals("Event has been saved successfully.", response.getMessage());
    }

    @Test
    public void testEventHasCode() throws NoSuchFieldException, IllegalAccessException {
        User user = new User(1L,"David", "Smith", "davidmith@gmail.com", "david@123", "0756784344");
        EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"), 32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                "davidmith@gmail.com", "0756784344",  1L) ;

        Event event = new Event(1L, "1_1234567", "Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"),
                32400000L, 57600000L,"9, Derby Street", "", "Bolton", "BL3 5HY","Entrance is free.","davidmith@gmail.com", "0756784344",
                EventStatus.NEW, user);

        when(userRepository.getById(eventRequest.getUserId())).thenReturn(user);
        when(eventRepository.save(Mockito.any(Event.class))).thenReturn(event);

        Response response = eventManagerImpl.saveEvent(eventRequest);

        Object eventClass = response.getObject();
        Field field = eventClass.getClass().getDeclaredField("eventCode");
        field.setAccessible(true);
        String eventCodeValue = field.get(eventClass).toString();

        Mockito.verify(eventRepository, Mockito.times(1)).save(ArgumentMatchers.any(Event.class));

        Assertions.assertThat(eventCodeValue).isNotNull();
        assertEquals("1_1234567",eventCodeValue);
    }

    @Test
    public void testEventStatusIsNew() throws NoSuchFieldException, IllegalAccessException {
        User user = new User(1L,"David", "Smith", "davidmith@gmail.com", "david@123", "0756784344");
        EventRequest eventRequest = new EventRequest("Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"),
                32400000L, 57600000L, "9, Derby Street", "", "Bolton", "BL3 5HY", "Entrance is free.",
                "davidmith@gmail.com", "0756784344",  1L) ;
        Event event = new Event(1L, "1_1234567", "Art Exhibition", LocalDate.parse("2021-12-15"), LocalDate.parse("2021-12-16"),
                32400000L, 57600000L,"9, Derby Street", "", "Bolton", "BL3 5HY","Entrance is free.","davidmith@gmail.com", "0756784344",
                EventStatus.NEW, user);

        when(userRepository.getById(eventRequest.getUserId())).thenReturn(user);
        when(eventRepository.save(Mockito.any(Event.class))).thenReturn(event);
        Response response = eventManagerImpl.saveEvent(eventRequest);

        Object eventClass = response.getObject();
        Field field = eventClass.getClass().getDeclaredField("status");
        field.setAccessible(true);
        String eventStatus = field.get(eventClass).toString();
        Assertions.assertThat(eventStatus).isNotNull();
        assertEquals(EventStatus.NEW.toString(),eventStatus);
    }
}
