package com.ies.ies_admin_academ.config;

public enum ErrorCodes {

    NOT_FOUND("RESOURCE NOT FOUND",404), //ROOT AND IMPORTANT CODE KEEP AS YOU FOUND
    BAD_REQUEST("BAD REQUEST",400), //ROOT AND IMPORTANT CODE KEEP AS YOU FOUND
    INTERNAL_SERVER_ERROR("INTERNAL SERVER ERROR",500), //ROOT AND IMPORTANT CODE KEEP AS YOU FOUND
    USER_VALIDATION_USER_NOEXISTS("El usuario que busca no existe.",4370001),
    USER_VALIDATION_USER_PASSWORDNOTMATCH("La contraseña no coincide.",4370002),
    USER_VALIDATION_USER_MISSMATCH("Los datos de acceso no son coincidentes o son inválidos.",4370003),
    USER_VALIDATION_DESKAPP("El usuario no pertenece al grupo permitido para usar esta aplicación.",4370005),
    USER_GETAPPPERMISSIONS_NORECORDS("El usuario no presenta registros de permisos de aplicativos del sistema de información.",4370006),
    USER_GETPROFILE_DATA_EMPTY("El usuario figura en el sistema de información pero no presenta datos asociados.",4370006),
    USER_ATTRIBUTEUPDATE_FAILS("No se pudo realizar cambio/s en los atributos del usuario.",4370007)
    ;


    //Definition of ErrorCodes
    String message;
    int code;

    ErrorCodes(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage(){return message;}
    public int getCode(){return code;}
}
