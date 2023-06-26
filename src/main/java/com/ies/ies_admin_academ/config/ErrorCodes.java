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
    USER_GETPROFILE_DATA_EMPTY("El usuario figura en el sistema de información pero no presenta datos asociados.",4370007),
    USER_ATTRIBUTEUPDATE_FAILS("No se pudo realizar cambio/s en los atributos del usuario.",4370008),
    USER_SIGNUP_ATTRB_MISSMATCH("El registro de usuario no se puede aplicar porque los datos a registrar están erróneos o incompletos.",437000),
    USER_SIGNUP_DUPLICATED("El registro de usuario no se puede aplicar porque ya existe.(Comprobación por nombre de usuario).",4370010),
    USER_SIGNUP_QUERY_ERROR("El registro de usuario no se puede aplicar debido a un error en el repositorio/base de datos.",4370011),
    USER_GETSTUDENT_PROFILEDATA_EMPTY("El usuario figura en el sistema de información pero no pertenece al grupo de estudiantes.",4370012),
    USER_STD_ACCESS("El estudiante no tiene permitido el acceso al portal estudiantil.",4370013),
    USER_ATTRIBUTEUPDATE_ILEGAL("El atributo que intenta actualizar/modificar no puede ser actualizado debido a restricciones de negocio.",4370014),
    USER_REMOTION_FAILS("El borrado de usuario no se puede realizar debido a un error en el repositorio/base de datos",4370015)
    ;


    //Definition of ErrorCodes
    final String message;
    final int code;

    ErrorCodes(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage(){return message;}
    public int getCode(){return code;}
}
