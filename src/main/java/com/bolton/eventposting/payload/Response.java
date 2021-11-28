package com.bolton.eventposting.payload;

public class Response {

    private Object object;
    private String responseCode;
    private String status;
    private String message;

    public Response() {
    }

    public Response(Object object, String responseCode, String status, String message) {
        this.object = object;
        this.responseCode = responseCode;
        this.status = status;
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
