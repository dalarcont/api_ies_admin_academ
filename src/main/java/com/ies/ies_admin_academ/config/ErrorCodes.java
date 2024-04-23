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
    USER_SIGNUP_ATTRB_MISSMATCH("El registro de usuario no se puede aplicar porque los datos a registrar están erróneos o incompletos.",4370009),
    USER_SIGNUP_DUPLICATED("El registro de usuario no se puede aplicar porque ya existe.(Comprobación por nombre de usuario).",4370010),
    USER_SIGNUP_QUERY_ERROR("El registro de usuario no se puede aplicar debido a un error en el repositorio/base de datos.",4370011),
    USER_GETSTUDENT_PROFILEDATA_EMPTY("El usuario figura en el sistema de información pero no pertenece al grupo de estudiantes.",4370012),
    USER_STD_ACCESS("El estudiante no tiene permitido el acceso al portal estudiantil.",4370013),
    USER_ATTRIBUTEUPDATE_ILEGAL("El atributo que intenta actualizar/modificar no puede ser actualizado debido a restricciones de negocio.",4370014),
    USER_REMOTION_FAILS("El borrado de usuario no se puede realizar debido a un error en el repositorio/base de datos.",4370015),
    USER_PROFILE_UPDATE_FAILS("La actualización del perfil de usuario no se puede realizar debido a un error en el repositorio/base de datos.",4370016),
    USER_REMOTION_PREVALIDATION_CANT_EMPTY("El usuario es válido pero no cuenta con más registros en la base de datos.",4370017),
    GENERAL_CONVENTION_CODE_NOEXISTS("El código de convención que busca no existe.",4370018),
    GENERAL_CONVENTION_SRCTABLE_NOTEXISTS("El nombre de tabla origen no existe.",4370019),
    GENERAL_CONVENTION_SRCTABLE_NOTGIVEN("El nombre de tabla origen no fue ingresado.",4370020),
    GENERAL_CONVENTION_CODE_NOTGIVEN("El código de convención no fue ingresado.",4370021),
    GENERAL_APPCODE_NOTGIVEN("El código de aplicación no fue ingresado.",4370022),
    GENERAL_APPCODE_NOEXISTS("La aplicación no existe.",4370023),
    USER_EVENTLOG_WORK_FAILS("No se pudo registrar el evento del ámbito laboral debido a un error en el repositorio/base de datos.",4370024),
    USER_EVENTLOG_STDNT_FAILS("No se pudo registrar el evento del ámbito de usuarios estudiantes debido a un error en el repositorio/base de datos.",4370025),
    USER_EVENTLOG_ADD_OBJFAIL("La petición no recibió los parámetros esperados.",4370026)
    ;


    //Definition of ErrorCodes
    final String message;   //Message/description about the associated error
    final int code;         //Code of business error logic/rule/description

    //Constructor
    ErrorCodes(String message, int code){
        this.message = message;
        this.code = code;
    }

    //Getters
    public String getMessage(){return message;}
    public int getCode(){return code;}
}
