package com.bolton.eventposting.model;

import com.bolton.eventposting.enums.EventStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;

    @Column(nullable = false)
    private String eventCode;

   @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private LocalDate eventStartDate;

    private LocalDate eventEndDate;

    @Column(nullable = false)
    private Long startTime;

    @Column(nullable = false)
    private Long endTime;

    @Column(nullable = false)
    private String addressLine1;

    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postcode;

    private String eventDescription;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contactNumber;

    @Enumerated(value = EnumType.STRING)
    private EventStatus status;

    @OneToOne
    @JoinColumn(name="userId", nullable = false)
    @JsonIgnore
    private User userId;

    public Event() {
    }

    public Event(String eventCode, String eventName, LocalDate eventStartDate, LocalDate eventEndDate, Long startTime, Long endTime, String addressLine1, String addressLine2, String city, String postcode, String eventDescription, String email, String contactNumber, EventStatus status, User userId) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postcode = postcode;
        this.eventDescription = eventDescription;
        this.email = email;
        this.contactNumber = contactNumber;
        this.status = status;
        this.userId = userId;
    }

    public Event(Long eventId, String eventCode, String eventName, LocalDate eventStartDate, LocalDate eventEndDate, Long startTime, Long endTime, String addressLine1, String addressLine2, String city, String postcode, String eventDescription, String email, String contactNumber, EventStatus status, User userId) {
        this.eventId = eventId;
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postcode = postcode;
        this.eventDescription = eventDescription;
        this.email = email;
        this.contactNumber = contactNumber;
        this.status = status;
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(LocalDate eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public LocalDate getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(LocalDate eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("eventId=").append(eventId);
        sb.append(", eventCode='").append(eventCode).append('\'');
        sb.append(", eventName='").append(eventName).append('\'');
        sb.append(", eventStartDate=").append(eventStartDate);
        sb.append(", eventEndDate=").append(eventEndDate);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", addressLine1='").append(addressLine1).append('\'');
        sb.append(", addressLine2='").append(addressLine2).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", postcode='").append(postcode).append('\'');
        sb.append(", eventDescription='").append(eventDescription).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", contactNumber='").append(contactNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
