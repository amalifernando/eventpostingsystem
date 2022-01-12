package com.bolton.eventposting.repository;

import com.bolton.eventposting.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    @Query("select event from Event event where lower(event.eventName) like lower(concat('%',:searchQuery,'%')) " +
            " OR lower(event.city) like lower(concat('%',:searchQuery,'%'))")
    List<Event> getEventList(@Param("searchQuery")String searchQuery);
}
