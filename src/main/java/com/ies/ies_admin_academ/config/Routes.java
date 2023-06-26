package com.ies.ies_admin_academ.config;
public class Routes {

    public enum ROOT{
        String;
        //User related apps
        public static final String USERS = "/users";
        public static final String BODY = "/{data}";
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
            //Set employee's last access date to DESKAPP
            public static final String SYSTEM_DESKAPP_RECORDACCESS = "/{data}/dsklastaccess";
            //Set student last access date
            public static final String SYSTEM_STD_RECORDACCESS = "/{data}/stdlastaccess";
            //Get validation if the user have access to DESKAPP
            public static final String DESKAPP_ACCESS = "/{data}/dskaccess";
            //Get validation if the student have access to its portal
            public static final String STUDENT_ACCESS = "/{data}/stdaccess";
            //Get list of app permissions enabled for a user
            public static final String SYSINFO_PERMISSIONS = "/{data}/sysinfopermissions";

        };

    }

}
