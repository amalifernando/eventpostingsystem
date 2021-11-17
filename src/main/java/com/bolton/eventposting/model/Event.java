package com.bolton.eventposting.model;

import com.bolton.eventposting.enums.EventStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private String eventCode;
    private String eventName;
    private Date eventStartDate;
    private Date eventEndDate;
    private Long startTime;
    private Long endTime;
    private String addressLine1;
    private String city;
    private String postcode;
    private String eventDescription;
    private String email;
    private String contactNumber;

    @Enumerated(value = EnumType.STRING)
    private EventStatus status;

    @OneToOne
    @JoinColumn(name="userId", nullable = false)
    private User userId;

    public Event() {
    }

    public Event(String eventCode, String eventName, Date eventStartDate, Date eventEndDate, Long startTime, Long endTime, String addressLine1, String city, String postcode, String eventDescription, String email, String contactNumber, EventStatus status, User userId) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.addressLine1 = addressLine1;
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

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
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
        sb.append(", city='").append(city).append('\'');
        sb.append(", postcode='").append(postcode).append('\'');
        sb.append(", eventDescription='").append(eventDescription).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", contactNumber='").append(contactNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
