package com.ies.ies_admin_academ.repositories;
/*
*
* Class to declare querys to DB
*
* */

import com.ies.ies_admin_academ.model.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate daoUser;

    public UserRepository(JdbcTemplate daoUser) {
        this.daoUser = daoUser;
    }

    /**
     * Perform query operation to get user's basic data
     * Due to business rules where set that the users are identified as unique with its username and not with id
     * Related to provide validations and data usage
     * @param username Username of the target user
     * @return Object uf_user_profile
     */
    public List<uf_personas> getUserBasicData(String username){
        return daoUser.query(dbQueries.USER.GET_USER_BASIC_DATA_QUERY,new BeanPropertyRowMapper<>(uf_personas.class),username);
    }

    /**
     * Perform query to get employee profile (constituted by user profile and employee data)
     * Due to business rules the retrieved data will be only referenced to the main contract of the employee
     * @param username Username of the target user
     * @return Object uf_employee_profile
     */
    public List<uf_personas_empleado> getEmployeeProfile(String username){
        return daoUser.query(dbQueries.USER.GET_EMPLOYEE_PROFILE_QUERY,
                        new BeanPropertyRowMapper<>(uf_personas_empleado.class),username);
    }

    /**
     * Perform query to get student profile (constituted by user profile and student data)
     * Due to business rules the retrieved data will be only referenced to the general info and student access
     * @param username Username of the target user
     * @return Object uf_student_profile
     */
    public List<uf_personas_estudiante> getStudentProfile(String username){
        return daoUser.query(dbQueries.USER.GET_STUDENT_PROFILE_QUERY,
                new BeanPropertyRowMapper<>(uf_personas_estudiante.class),username);
    }

    /**
     * Perform query to get user credentials match to login
     * @param username Username of the target user
     * @param pwd Password of the target user
     * @return boolean
     */
    public boolean matchLogin(String username, String pwd){
        String gotDdbbPkey = daoUser.queryForObject(dbQueries.USER.MATCH_LOGIN_QUERY,
                String.class,
                username);
        return Boolean.TRUE.equals(new BCryptPasswordEncoder().matches(pwd,gotDdbbPkey));
    }

    /**
     * Perform query to get access validation to DESKAPP environment
     * @param username Username of the target user
     * @return boolean
     */
    public boolean deskappAccess(String username){
        return Boolean.TRUE.equals(daoUser.queryForObject(dbQueries.USER.DESKAPP_ACCESS_QUERY,
                boolean.class,
                username));
    }

    /**
     * Perform query to get access validation to student environment
     * @param username Username of the target user
     * @return boolean
     */
    public boolean stdAccess(String username){
        return Boolean.TRUE.equals(daoUser.queryForObject(dbQueries.USER.STUDENT_ACCESS_QUERY,
                boolean.class,
                username));
    }

    /**
     * Perform query operation to get a list of the applications that a user is able to use
     * @param username Username of the target user.
     * @return List of uf_sisinfo_userapps object
     */
    public List<uf_sisinfo_AppsAndPermissions> getAppsPermissions(String username){
        return daoUser.query(
                dbQueries.USER.SISINFO_APPS_PERMISSIONS_QUERY,
                new BeanPropertyRowMapper<>(uf_sisinfo_AppsAndPermissions.class),
                username);
    }

    /**
     * Checks TRUE/FALSE if there is a user related to an ID
     * @param id Identification to check
     * @return TRUE / FALSE
     */
    public boolean getValidationById(String id){
        return Boolean.TRUE.equals(daoUser.queryForObject(dbQueries.USER.GET_VALIDATION_BY_ID,boolean.class,id));
    }

    /**
     * Checks TRUE/FALSE for a username availability
     * @param usr Username to check
     * @return TRUE / FALSE
     */
    public boolean getAvailableUsername(String usr){
        return Boolean.TRUE.equals(daoUser.queryForObject(dbQueries.USER.GET_USERNAME_AVAILABLE,boolean.class,usr));
    }

    /**
     * Checks TRUE/FALSE if there is a user related to an email address
     * @param email Email to check
     * @return TRUE / FALSE
     */
    public boolean getValidationByEmail(String email){
        return Boolean.TRUE.equals(daoUser.queryForObject(dbQueries.USER.GET_VALIDATION_BY_EMAIL,boolean.class,email));
    }

    /**
     * Perform employee's last access date update
     * @param usr Username of the target user
     * @param newDate Immediately date of performing this operation
     * @return TRUE OR FALSE
     */
    public boolean setLastAccessRecord(String usr, String newDate){
        return (daoUser.update(dbQueries.USER.UPDATE_DESKAPP_LAST_ACCESS_QUERY, newDate, usr) == 1);
    }

    /**
     * Perform insertion of a work event log
     * @param workEventLog Object with data to insert
     * @return
     */
    public boolean addExecutiveLog(uf_registro_ejecutivo workEventLog){
        return daoUser.update(dbQueries.USER.ADD_EVENT_LOG_WORK,
                workEventLog.getCOD_EMPLEADO(),
                workEventLog.getREG_APPSET(),
                workEventLog.getREG_ACTION_DESCR()) == 1;
    }

    /**
     * Perform insert a new user profile data
     * @param userprofile User object with attributes
     * @return TRUE OR FALSE about the query execution
     */
    public boolean addUser(uf_personas userprofile){
        return
             daoUser.update(dbQueries.USER.INSERT_PERSONA_QUERY,
                     userprofile.getPRSN_ID(),
                     userprofile.getPRSN_NOM(),
                     userprofile.getPRSN_APE(),
                     userprofile.getPRSN_USUARIO(),
                     userprofile.getPRSN_GEN(),
                     userprofile.getPRSN_EMAIL_PERSONAL().toLowerCase(),
                     userprofile.getPRSN_EMAIL_LABORAL().toLowerCase(),
                     userprofile.getPRSN_ORIGEN_PAIS(),
                     userprofile.getPRSN_ORIGEN_CIUDAD().toUpperCase(),
                     userprofile.getPRSN_RESIDE_PAIS(),
                     userprofile.getPRSN_RESIDE_CIUDAD().toUpperCase(),
                     userprofile.getPRSN_ESCOLARIDAD(),
                     userprofile.getPRSN_PKEY()
             ) == 1;
    }

    /**
     * Perform update of one or more attributes of a user
     * @param usr Username of the target user
     * @return TRUE or FALSE of the query execution
     */
    public boolean updateItemUSR(uf_personas usr){
        /*
         * BUSINESS RULE: Strictly NO ONE can modify sign-up date. Don't add inside the query that field.
         * */
        return daoUser.update(dbQueries.USER.UPDATE_ITEM_PERSONA_QUERY,
                usr.getPRSN_ID(),
                usr.getPRSN_NOM(),
                usr.getPRSN_APE(),
                usr.getPRSN_GEN(),
                usr.getPRSN_EMAIL_PERSONAL().toLowerCase(),
                usr.getPRSN_EMAIL_LABORAL().toLowerCase(),
                usr.getPRSN_ORIGEN_PAIS(),
                usr.getPRSN_ORIGEN_CIUDAD().toUpperCase(),
                usr.getPRSN_RESIDE_PAIS(),
                usr.getPRSN_RESIDE_CIUDAD().toUpperCase(),
                usr.getPRSN_ESCOLARIDAD(),
                usr.getPRSN_PKEY(),
                usr.getPRSN_RECOVERY_QUEST(),
                usr.getPRSN_RECOVERY_ANS(),
                usr.getPRSN_USUARIO())==1;

    }

    /**
     * Perform delete user profile
     * @param usr User target
     * @return TRUE or FALSE
     */
    public boolean deleteUser(String usr){
        //Perform DB query
        return daoUser.update(dbQueries.USER.DELETE_SOLO_PERSONA_QUERY,usr)==1;
    }
}
