package com.bolton.eventposting.exception;

public class SystemException extends RuntimeException{

    private String status;
    private String code;
    private String message;
    private String messageDescription;

    public SystemException() {
    }

    public SystemException(String code, String message, String messageDescription) {
        this.code = code;
        this.message = message;
        this.messageDescription = messageDescription;
    }

    public SystemException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }
}
