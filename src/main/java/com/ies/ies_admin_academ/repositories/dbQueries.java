package com.ies.ies_admin_academ.repositories;

/**
 * Please use Reeplace:
 * Reeplace   and    with a space
 */
public class dbQueries {

    public enum USER {
        String;

        public static final String GET_USER_BASIC_DATA_QUERY = "{CALL GET_USER_BASIC_DATA(?)};";
        public static final String GET_EMPLOYEE_PROFILE_QUERY = "{CALL GET_EMPLOYEE_PROFILE(?)};";
        public static final String GET_STUDENT_PROFILE_QUERY = "{CALL GET_STUDENT_PROFILE(?)};";
        public static final String MATCH_LOGIN_QUERY = "{CALL GET_MATCH_LOGIN(?)};";
        public static final String DESKAPP_ACCESS_QUERY = "{CALL GET_DESKAPP_ACCESS(?)};";
        public static final String STUDENT_ACCESS_QUERY = "{CALL GET_STUDENT_ACCESS(?)};";
        public static final String SISINFO_APPS_PERMISSIONS_QUERY = "{CALL GET_SISINFO_APPS_PERMISSIONS(?)};";
        public static final String UPDATE_DESKAPP_LAST_ACCESS_QUERY = "{CALL PATCH_UPDATE_DESKAPP_LAST_ACCESS(?,?)};";
        public static final String UPDATE_STUDENT_LAST_ACCESS_QUERY = "{CALL PATCH_UPDATE_STUDENT_LAST_ACCESS(?,?)};";
        public static final String INSERT_PERSONA_QUERY = "{CALL POST_INSERT_PERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?)};";
        public static final String UPDATE_ITEM_PERSONA_QUERY = "{CALL PATCH_PUT_UPDATE_PERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)};";
        public static final String DELETE_SOLO_PERSONA_QUERY = "{CALL DELETE_PERSONA(?)};";
        public static final String GET_VALIDATION_BY_ID = "{CALL GET_VALIDATION_BY_ID(?)};";
        public static final String GET_USERNAME_AVAILABLE = "{CALL GET_USERNAME_AVAILABLE(?)};";
        public static final String GET_VALIDATION_BY_EMAIL = "{CALL GET_VALIDATION_BY_EMAIL(?)};";
        public static final String ADD_EVENT_LOG_WORK = "{CALL POST_ADD_EVENT_LOG_WORK(?,?,?)};";
        public static final String ADD_EVENT_LOG_STDNT = "{CALL POST_ADD_EVENT_LOG_STDNT(?,?,?)};";

    }

    public enum GENERAL{
        String;

        public static final String GET_NAME_APP_CONVENTION_CODE_QUERY = "{CALL GET_NAME_APP_CONVENTION_CODE(?)};";
        public static final String GET_APP_STATE_QUERY = "{CALL GET_APP_STATE(?)};";

    }


}
