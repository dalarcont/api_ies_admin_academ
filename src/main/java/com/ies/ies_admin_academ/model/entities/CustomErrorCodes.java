package com.ies.ies_admin_academ.model.entities;

public class CustomErrorCodes {
    //Definition of CustomErrorCodes
    String message;
    int code;

    CustomErrorCodes(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage(){return message;}
    public int getCode(){return code;}
}
