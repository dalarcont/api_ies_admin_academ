package com.ies.ies_admin_academ.config;

public class Routes {

    //Root of API path
    public static final String IES_PATH = "/ies";



    //Root of API path for User related apps
    public static final String IES_USERS = "/users";
        //Get validation/existence proof of a user by its username and password
        public static final String IES_USERS_EXISTENCEPROOF = "/{username}";
        //Get validation of SIS_INFO access for that user
        public static final String IES_USERS_PWD_VALIDATION = "/{data}/match";
        //Get validation if the user have access to DESKAPP
        public static final String IES_USERS_DESKAPP_ACCESS = "/{data}/sysinfoaccess";
        //Get list of app permissions enabled for an user
        public static final String IES_USERS_SYSINFO_PERMISSIONS = "/{data}/sysinfopermissions";
        //Get user personal and work profile data
        public static final String IES_USERS_GETPROFILE = "/{data}/profiledata";
        //Set user's last access to DESKAPP
        public static final String IES_USERS_DESKAPP_RECORDACCESS = "/{data}/recordaccess";




}
