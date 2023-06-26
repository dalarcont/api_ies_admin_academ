package com.ies.ies_admin_academ.services;
/*
*
* Class to define service return values after retrieve data
*
* */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.ies.ies_admin_academ.config.ErrorCodes;
import com.ies.ies_admin_academ.exceptions.BusinessException;
import com.ies.ies_admin_academ.model.entities.*;
import com.ies.ies_admin_academ.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

@Service
public class UserServiceGeneral {

    Logger eventLogger = LogManager.getLogger(UserServiceGeneral.class);
    private final UserRepository userRepository;

    private final ObjectMapper objMapper;
    public UserServiceGeneral(UserRepository userRepository, ObjectMapper objMapper) {
        this.userRepository = userRepository;
        this.objMapper = objMapper;
    }

    /**
     * Validates if a user exists using its username, it doesn't matter the user role.
     * Provide validation to logins, existence before user addition or user actions related.
     * @param username -> Username target
     * @return FALSE => Means that username doesn't exist so can add the user
     */
    public boolean validateUser(String username){
        //This service doesn't have a log record because it's the root of all services, so It's useful to keep logging a record
        return (!userRepository.getUserBasicData(username).isEmpty());
    }

    /**
     * @param username Username target
     * @return uf_user_profile Object
     */
    public List<uf_user_profile> getUserProfileData(String username){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER PROFILE DATA\t-----@{}", username);

        List<uf_user_profile> resultTemp;

        if(validateUser(username)){
            //User exists
            //Get data
            resultTemp = userRepository.getUserBasicData(username);
            if(resultTemp.size()==0){
                //User exists but query doesn't get related data.
                throw new BusinessException(ErrorCodes.USER_GETPROFILE_DATA_EMPTY);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
        return resultTemp;
    }

    /**
     * Perform business logic to get the employee profile
     * @param username Username target
     * @return uf_employee_profile Object
     */
    public List<uf_employee_profile> getEmployeeProfile(String username){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----EMPLOYEE PROFILE DATA\t-----@{}", username);
        List<uf_employee_profile> resultTemp;

        if(validateUser(username)){
            //User exists
            //Get data
            resultTemp = userRepository.getEmployeeProfile(username);
            if(resultTemp.size()==0){
                //User exists but query doesn't get related data.
                throw new BusinessException(ErrorCodes.USER_GETPROFILE_DATA_EMPTY);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
        return resultTemp;
    }

    /**
     * Perform business logic to get the student profile
     * @param username Username target
     * @return uf_employee_profile Object
     */
    public List<uf_student_profile> getStudentProfile(String username){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----STUDENT PROFILE DATA\t-----@{}", username);
        List<uf_student_profile> resultTemp;

        if(validateUser(username)){
            //User exists, but we don't know which category/group
            //Get data
            resultTemp = userRepository.getStudentProfile(username);
            if(resultTemp.size()==0){
                //User exists but query doesn't get related data as student.
                throw new BusinessException(ErrorCodes.USER_GETSTUDENT_PROFILEDATA_EMPTY);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
        return resultTemp;
    }

    /**
     * Service to validate the match between username and password to give access to an EMPLOYEE
     * @param usr Username target
     * @param pwd Password associated to username target
     * @return TRUE OR FALSE
     */
    public boolean validateLogin(String usr, String pwd){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----LOGIN ACCESS VALIDATION BY MATCH\t-----@{}", usr);

        if(validateUser(usr)){
            String pwdEncrypted = getUserProfileData(usr).get(0).getPkeyusuario();
            if(new BCryptPasswordEncoder().matches(pwd,pwdEncrypted)){
                return true;
            }else{
                throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_MISSMATCH);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
    }

    /**
     * Service to validate a student have access to system-info
     * @param usr Username target
     * @return TRUE OR FALSE
     */
    public boolean validateDeskappAccess(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER DESKAPP ACCESS VALIDATION\t-----@{}", usr);

        if(validateUser(usr)){
            if(userRepository.deskappAccess(usr)){
                return true;
            }else{
                throw new BusinessException(ErrorCodes.USER_VALIDATION_DESKAPP);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
    }

    /**
     * Service to validate a student have access to system-info
     * @param usr Username target
     * @return TRUE OR FALSE
     */
    public boolean validateStudentAccess(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER STUDENT ACCESS VALIDATION\t-----@{}", usr);

        if(validateUser(usr)){
            if(userRepository.stdAccess(usr)){
                return true;
            }else{
                throw new BusinessException(ErrorCodes.USER_VALIDATION_DESKAPP);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
    }

    /**
     * Service to get and let system know apps that the user can afford
     * @param usr Username target
     * @return List<uf_sisinfo_userapps> to let system the apps list available for a user
     */
    public List<uf_sisinfo_userapps> userGetAppsPermissions(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER APPS AND PERMISSIONS\t-----@{}", usr);
        List<uf_sisinfo_userapps> resultObj;
        if(validateUser(usr)){
            //User exists
             resultObj = userRepository.getAppsPermissions(usr);
            //Count how many apps were assigned
            if(resultObj.stream().filter(app -> usr.equals(app.getUsername())).count() == 0){
                //User doesn't have any app assigned
                throw new BusinessException(ErrorCodes.USER_GETAPPPERMISSIONS_NORECORDS);
            }
        }else{
            //User can't be validated
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }

        return resultObj;
    }

    /**
     * Service to set new date to provide system information when was the last access of a user
     * @param usr Username target
     * @param newDate New date format YYYY-MM-DD HH:mm:ss
     * @return TRUE OR FALSE
     */
    public boolean setUserLastAccessDeskapp(String usr, String newDate){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----UPDATE USER LAST ACCESS DATE\t-----@{}\t{}", usr,newDate);
        boolean resultTemp;

        if(validateUser(usr)){
            //User exists
            resultTemp = userRepository.setLastAccessRecord(usr,newDate);
            if(!resultTemp){
                //Update field was not applied
                throw new BusinessException(ErrorCodes.USER_ATTRIBUTEUPDATE_FAILS);
            }else {
                return true;
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
    }


    /**
     * Service to perform user addition to the system-info as a common user.
     * @param userdata uf_user_profile Object with target user data
     * @return uf_user_profile Object
     */
    public uf_user_profile addUser(uf_user_profile userdata){
        eventLogger.log(org.apache.logging.log4j.Level.INFO,
                "-API\t--SERVICE\t---POST\t----ADD USER\t-----@{}\t{}\t{}",
                userdata.getIdPersona(),userdata.getApellidos(),userdata.getNombres());
        //Perform password encryption
        /*
        *   DUE TO BUSINESS RULE, NO ONE, INCLUDED STAFF, CAN ASSIGN THE PASSWORD.
        *   FOR THE USER ADDITION PROCEDURE THE DEFAULT PASSWORD WILL BE USERNAME ASSIGNED + ID NUMBER OR IDENTIFICATION + CLOSES WITH '#'.
        * */
        userdata.setPkeyusuario(new BCryptPasswordEncoder().encode(userdata.getUsername()+userdata.getIdPersona()+"#"));
        //Perform operations
        if(!validateUser(userdata.getUsername())){
            //Can add the user
            if(userRepository.addUser(userdata)){
               userdata = userRepository.getUserBasicData(userdata.getUsername()).get(0);
            }else{
                //There's something bad occurs with DDBB operation
                throw new BusinessException(ErrorCodes.USER_SIGNUP_QUERY_ERROR);
            }
        }else{
            //Can't add user: duplicated username it means the user already exists
            throw new BusinessException(ErrorCodes.USER_SIGNUP_DUPLICATED);
        }
        return userdata;
    }


    /**
     * Service to perform partially attribute updates
     * @param usr Username target
     * @param jsonPatch JSON incoming data patched as object
     * @return uf_user_profile Object
     * @throws JsonPatchException Patching JSON Node exception
     * @throws JsonProcessingException JSON conversion
     */
    public uf_user_profile patchUser(String usr, JsonPatch jsonPatch) throws JsonPatchException, JsonProcessingException {
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---PATCH\t----USER PROFILE DATA\t-----@{}", usr);
        //If the target user, proceed with updates
        if(validateUser(usr)){
            uf_user_profile target = userRepository.getUserBasicData(usr).get(0);
            // Path jsonPatch object to class
            objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            JsonNode patched = jsonPatch.apply(objMapper.convertValue(target,JsonNode.class));
            uf_user_profile newUser = objMapper.treeToValue(patched, uf_user_profile.class);
            /*
             * BUSINESS RULE: Validate if inside the JsonPatch request exists a password update, it can be known if exists a field named 'pkeyusuario'.
             * If exists then encode the new password.
             * This is necessary to prevent take the encoded user's password at the moment and encode it again (encoding something that is already encoded)
             * making login and validation access failures
             * */
            /*
             *   DUE TO BUSINESS RULE, NO ONE, INCLUDED STAFF, CAN ASSIGN THE PASSWORD.
             *   FOR THE USER ADDITION PROCEDURE THE DEFAULT PASSWORD WILL BE USERNAME ASSIGNED + ID NUMBER OR IDENTIFICATION + CLOSES WITH '#'.
             *   ANYTHING THAT COMES INTO THE PKEYUSUARIO ATTRIBUTE WILL BE OVERWRITTEN.
             * */
            newUser.setPkeyusuario(new BCryptPasswordEncoder().encode(newUser.getPkeyusuario()));
            //Perform update
            if(userRepository.updateItemUSR(newUser)){
                //Return new user profile data
                return userRepository.getUserBasicData(usr).get(0);
            }else{
                //There's something bad occurs when the repository tries to update the data on disk.
                throw new BusinessException(ErrorCodes.USER_ATTRIBUTEUPDATE_FAILS);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }

    }

    /**
     * Service for update entire resource of uf_user_profile object
     * @param usr Username target
     * @param userdata uf_user_profile Object with new values
     * @return uf_user_profile Object
     */
    public uf_user_profile putUser(String usr, uf_user_profile userdata){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---PUT\t----PUT USER PROFILE DATA\t-----@{}", usr);
        /*
         *   KNOWING THE PRACTICES OF 'PUT' METHOD WHERE IF THE REQUEST TRIES TO UPDATE SOME RESOURCE THAT DOESN'T EXIST, THEN IT ADDS THE RESOURCE.
         *   THIS PROCEDURE WILL BE BASED ON A BUSINESS RULE DISTANT FROM THE COMMON OR KNOWN PRACTICES.
         *   SO IF THE REQUEST TRIES TO UPDATE SOMETHING THAT DOESN'T, THEN THE PROCEDURE THROWS AN EXCEPTION, OTHERWISE
         *   PERFORM USE OF RESOURCE 'UPDATE' SERVICE PROVIDED BY THE REPOSITORY.
         * */

        /*
         * BUSINESS RULE: Validate if inside the JsonPatch request exists a password update, it can be known if exists a field named 'pkeyusuario'.
         * If exists then encode the new password.
         * This is necessary to prevent take the encoded user's password at the moment and encode it again (encoding something that is already encoded)
         * making login and validation access failures
         * */
        //Perform operations
        if(validateUser(usr)){
            //Perform update
            /*
             *   DUE TO BUSINESS RULE, NO ONE, INCLUDED STAFF, CAN ASSIGN THE PASSWORD.
             *   FOR THE USER ADDITION PROCEDURE THE DEFAULT PASSWORD WILL BE USERNAME ASSIGNED + ID NUMBER OR IDENTIFICATION + CLOSES WITH '#'.
             *   ANYTHING THAT COMES INTO THE PKEYUSUARIO ATTRIBUTE WILL BE OVERWRITTEN.
             * */
             userdata.setPkeyusuario(new BCryptPasswordEncoder().encode(userdata.getUsername()+userdata.getIdPersona()+"#"));

            //Perform validations
            if(userRepository.updateItemUSR(userdata)){
                userdata = userRepository.getUserBasicData(userdata.getUsername()).get(0);
            }else{
                //There's something bad occurs with DDBB operation
                throw new BusinessException(ErrorCodes.USER_SIGNUP_QUERY_ERROR);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
        return userdata;
    }


    /**
     * Service for remove a user from system database
     * @param usr Username target
     * @return TRUE OR FALSE
     */
    public boolean deleteUser(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---DELETE\t----DELETE USER PROFILE DATA\t-----@{}", usr);
        if(validateUser(usr)){
            //User to be deleted exists!
            if(userRepository.deleteUser(usr)){
                //User was deleted
                return true;
            }else{
                //There's something bad occurs with DDBB operation
                throw new BusinessException(ErrorCodes.USER_REMOTION_FAILS);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
    }
}
