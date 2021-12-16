package com.bolton.eventposting.repository;

import com.bolton.eventposting.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    @Query("select event from Event  event where event.eventName like '%searchQuery%'" +
            "OR event.city like '%searchQuery%'")
    List<Event> getEventList(String searchQuery);
}
