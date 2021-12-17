package com.bolton.eventposting.payload;

import java.time.LocalDate;

public class EventRequest {

    private Long eventId;
    private String eventCode;
    private String eventName;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;
    private Long startTime;
    private Long endTime;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
    private String eventDescription;
    private String email;
    private String contactNumber;
    private Long userId;

    public EventRequest(String eventName, LocalDate eventStartDate, LocalDate eventEndDate, Long startTime, Long endTime, String addressLine1, String addressLine2, String city, String postcode, String eventDescription, String email, String contactNumber, Long userId) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
