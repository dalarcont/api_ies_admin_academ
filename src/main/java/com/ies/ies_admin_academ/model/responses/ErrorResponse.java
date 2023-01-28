package com.ies.ies_admin_academ.model.responses;

public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse(){}

    public ErrorResponse(int Code, String Message){
        this.code = Code;
        this.message = Message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
