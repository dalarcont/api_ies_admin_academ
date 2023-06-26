package com.ies.ies_admin_academ.exceptions;


import com.ies.ies_admin_academ.config.ErrorCodes;

/*
* File for handle exceptions related to IES Admin Academ business logic
* */
public class BusinessException extends RuntimeException{

    private ErrorCodes code;

    public BusinessException(String message){super(message);}

    public BusinessException(ErrorCodes code){
        super(code.getMessage());
        this.code = code;
    }

    public int getCode(){
        return code.getCode();
    }
}
