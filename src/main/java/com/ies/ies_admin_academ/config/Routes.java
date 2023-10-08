package com.ies.ies_admin_academ.config;
public class Routes {

    public enum ROOT{
        String;
        //User related apps
        public static final String USERS = "/users";
        public static final String BODY = "/{data}";
        //General environment
        public static final String GENERAL_ENVIRONMENT = "/general";
    }
    public enum GET{
        String;
        //Users module
        public enum USERS{
            String;
            //Get validation/existence proof of a user by its username and password
            public static final String EXISTENCEPROOF = "/{username}";
            //Get validation of SIS_INFO access for anyone
            public static final String MATCH_LOGIN = "/{data}/matchlogin";
            //Get user profile data
            public static final String GET_USER_PROFILE = "/{data}/profiledata";
            //Get employee work profile data
            public static final String GET_EMPLOYEE_PROFILE = "/{data}/employeeprofile";
            //Get student profile data
            public static final String GET_STUDENT_PROFILE = "/{data}/studentprofile";
            //Get validation if the user have access to DESKAPP
            public static final String DESKAPP_ACCESS = "/{data}/dskaccess";
            //Get validation if the student have access to its portal
            public static final String STUDENT_ACCESS = "/{data}/stdaccess";
            //Get list of app permissions enabled for a user
            public static final String SYSINFO_PERMISSIONS = "/{data}/sysinfopermissions";
            //Validation of existence of a username by its identification
            public static final String EXISTENCEPROOF_BYID = "/valbyid/{data}";
            //Validation of availability of a username
            public static final String USR_ADD_VAL_USERNAME = "/valaddusrname/{data}";
            //Validation of existence of a user by email
            public static final String USR_ADD_VAL_EMAIL = "/valaddemail/{data}";


        };

        public enum GENERAL_ENVIRONMENT{
            String;

            //Get name of a convention of something inside an app
            public static final String CONVENTION_NAME = "/convention/{data}";
            //Get status of availability of an app by its appcode
            public static final String APP_STATUS = "/appstatus/{data}";
        }

    }

    public enum PATCH{
        String;

        public enum USERS{
            String;
            //Set employee's last access date to DESKAPP
            public static final String SYSTEM_DESKAPP_RECORDACCESS = "/{data}/dsklastaccess";
            //Set student last access date
            public static final String SYSTEM_STD_RECORDACCESS = "/{data}/stdlastaccess";
        }
    }
    public enum POST{
        String;

        public enum USERS{
            String;

            //Add event log inside work environment
            public static final String ADD_EVENT_WORKLOG = "/worklog";

            //Add event log inside student environment
            public static final String ADD_EVENT_STDNTLOG = "/stdntlog";
        }
    }
}
