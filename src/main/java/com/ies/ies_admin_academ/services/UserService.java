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
import com.ies.ies_admin_academ.config.EmailUtil;
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
public class UserService {

    Logger eventLogger = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final ObjectMapper objMapper;
    public UserService(UserRepository userRepository, ObjectMapper objMapper) {
        this.userRepository = userRepository;
        this.objMapper = objMapper;
    }


    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// GET ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    /**
     * Validates if a user exists using its username, it doesn't matter the user role.
     * Provide validation to logins, existence before user addition or user actions related.
     * @param username -> Username target
     * @return TRUE or FALSE
     */
    public boolean userExistenceValidation(String username){
        //This service doesn't have a log record because it's the root of all services, so It's useful to keep logging a record
        return (userRepository.validateUsername(username));
    }

    /**
     * @param username Username target
     * @return uf_user_profile Object
     */
    public List<uf_personas> userGetProfileData(String username){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER PROFILE DATA\t-----@{}", username);

        List<uf_personas> resultTemp;

        if(userExistenceValidation(username)){
            //User exists
            //Get data
            resultTemp = userRepository.getUserProfile(username);
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
    public List<uf_personas_empleado> userGetEmployeeProfile(String username){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----EMPLOYEE PROFILE DATA\t-----@{}", username);
        List<uf_personas_empleado> resultTemp;

        if(userExistenceValidation(username)){
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
    public List<uf_personas_estudiante> userGetStudentProfile(String username){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----STUDENT PROFILE DATA\t-----@{}", username);
        List<uf_personas_estudiante> resultTemp;

        if(userExistenceValidation(username)){
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
     * Service to validate the match between username and password to give access to system doesn't matter what environment
     * @param usr Username target
     * @param pwd Password associated to username target
     * @return TRUE OR FALSE
     */
    public boolean matchLogin(String usr, String pwd){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----LOGIN ACCESS VALIDATION BY MATCH\t-----@{}", usr);

        if(userExistenceValidation(usr)){
            if(userRepository.matchLogin(usr,pwd)){
                //Match!
                return true;
            }else{
                //Doesn't match
                throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_MISSMATCH);
            }
        }else{
            //User doesn't exists
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }

    }

    /**
     * Service to validate an employee have access to system-info
     * @param usr Username target
     * @return TRUE OR FALSE
     */
    public boolean validateDeskappAccess(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER DESKAPP ACCESS VALIDATION\t-----@{}", usr);

        if(userExistenceValidation(usr)){
            if(userRepository.validateDeskappAccess(usr)){
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

        if(userExistenceValidation(usr)){
            if(userRepository.validateStudentAccess(usr)){
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
    public List<uf_sisinfo_AppsAndPermissions> userGetAppsAndPermissions(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----USER APPS AND PERMISSIONS\t-----@{}", usr);
        List<uf_sisinfo_AppsAndPermissions> resultObj;
        if(userExistenceValidation(usr)){
            //User exists
            resultObj = userRepository.userGetAppsAndPermissions(usr);
            //Count how many apps were assigned
            if(resultObj.stream().noneMatch(app -> usr.equals(app.getCOD_USUARIO()))){
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
     * Checks TRUE/FALSE if there is a user related to an ID
     * @param id Identification to check
     * @return TRUE / FALSE
     */
    public boolean validateUserById(String id){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----VALIDATE EXISTENCE BY ID\t-----@{}", id);
        return userRepository.validateUserById(id);
    }

    /**
     * Checks TRUE/FALSE if there is a user related to an email address
     * @param email Email to check
     * @return TRUE / FALSE
     */
    public boolean validateSignupEmail(String email){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----VALIDATE EXISTENCE BY EMAIL\t-----@{}", email);
        return userRepository.validateSignupEmail(email);
    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// POST ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    /**
     * Service to perform user addition to the system-info as a common user.
     * @param userdata uf_user_profile Object with target user data
     * @return uf_user_profile Object
     */
    public uf_personas addUser(uf_personas userdata){
        eventLogger.log(org.apache.logging.log4j.Level.INFO,
                "-API\t--SERVICE\t---POST\t----ADD USER\t-----@{}\t{}\t{}",
                userdata.getPRSN_USUARIO().toLowerCase(),userdata.getPRSN_APE(),userdata.getPRSN_NOM());
        //Perform password encryption
        /*
         *   DUE TO BUSINESS RULE, NO ONE, INCLUDED STAFF, CAN ASSIGN THE PASSWORD.
         *   FOR THE USER ADDITION PROCEDURE THE DEFAULT PASSWORD WILL BE USERNAME ASSIGNED + ID NUMBER OR IDENTIFICATION + CLOSES WITH '#'.
         * */
        userdata.setPRSN_PKEY(new BCryptPasswordEncoder().encode(userdata.getPRSN_USUARIO()+userdata.getPRSN_ID()+"#"));
        //Perform operations
        if(!userExistenceValidation(userdata.getPRSN_USUARIO())){
            //Can add the user
            //Apply rules to strings
            userdata.setPRSN_GEN(userdata.getPRSN_GEN().toUpperCase());
            userdata.setPRSN_ESCOLARIDAD(userdata.getPRSN_ESCOLARIDAD().toUpperCase());
            userdata.setPRSN_ORIGEN_PAIS(userdata.getPRSN_ORIGEN_PAIS().toUpperCase());
            userdata.setPRSN_ORIGEN_CIUDAD(userdata.getPRSN_ORIGEN_CIUDAD().toUpperCase());
            userdata.setPRSN_RESIDE_PAIS(userdata.getPRSN_RESIDE_PAIS().toUpperCase());
            userdata.setPRSN_RESIDE_CIUDAD(userdata.getPRSN_RESIDE_CIUDAD().toUpperCase());
            userdata.setPRSN_USUARIO(userdata.getPRSN_USUARIO().toLowerCase());
            if(userRepository.addUser(userdata)){
                userdata = userRepository.getUserProfile(userdata.getPRSN_USUARIO()).get(0);
                //Email sending
                IES_EmailModel emailModel = new IES_EmailModel(
                        IES_CONSTANTS.EMAIL_NAMES.INFO_REGISTRO,
                        IES_CONSTANTS.EMAIL_ADDRESS.NOREPLY,
                        userdata.getPRSN_EMAIL_PERSONAL(),
                        "Registro de usuario",
                        IES_EmailTemplates.IES_WELCOME_NEW_USER(
                                new String[]{
                                    "Registro de usuario",
                                        userdata.getPRSN_ID(),
                                        userdata.getPRSN_USUARIO(),
                                        new StringBuilder()
                                                .append(userdata.getPRSN_NOM())
                                                .append(" ")
                                                .append(userdata.getPRSN_APE())
                                                .toString()
                                }
                        ),
                        true
                        );
                new EmailUtil().sendEmail(emailModel);
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
     * Service to perform addition of a log that describes employee activities inside Deskapp
     * @param reg Object with data to add
     * @return TRUE/FALSE
     */
    public boolean addEmployeeActivityLog(uf_registro_ejecutivo reg){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----ADD WORKLOG EVENT INSIDE DESKAPP\t-----@{}\t{}", reg.getCOD_EMPLEADO(),reg.getREG_APPSET());
        if(reg.getCOD_EMPLEADO() != null){
            if(userRepository.addEmployeeActivityLog(reg)){
                return true;
            }else{
                throw new BusinessException(ErrorCodes.USER_EVENTLOG_WORK_FAILS);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_EVENTLOG_ADD_OBJFAIL);
        }

    }

    /**
     * Service to perform addition of a log that describes student activities inside educational platform
     * @param reg Object with data to add
     * @return TRUE/FALSE
     */
    public boolean addStudentActivityLog(uf_estudiantes_registro_ejecutivo reg){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----ADD LOG EVENT INSIDE STUDENT ENV\t-----@{}\t{}", reg.getCOD_ESTUDIANTE(),reg.getREG_APPSET());
        if(reg.getCOD_ESTUDIANTE() != null){
            if(userRepository.addStudentActivityLog(reg)){
                return true;
            }else{
                throw new BusinessException(ErrorCodes.USER_EVENTLOG_STDNT_FAILS);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_EVENTLOG_ADD_OBJFAIL);
        }

    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// PATCH //////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    /**
     * Service to perform partially attribute updates
     * @param usr Username target
     * @param jsonPatch JSON incoming data patched as object
     * @return uf_user_profile Object
     * @throws JsonPatchException Patching JSON Node exception
     * @throws JsonProcessingException JSON conversion
     */
    public uf_personas patchUser(String usr, JsonPatch jsonPatch) throws JsonPatchException, JsonProcessingException {
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---PATCH\t----USER PROFILE DATA\t-----@{}", usr);
        //If the target user, proceed with updates
        if(userExistenceValidation(usr)){
            uf_personas target = userRepository.getUserProfile(usr).get(0);
            // Path jsonPatch object to class
            objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //Include non null and null values
            JsonNode patched = jsonPatch.apply(objMapper.convertValue(target,JsonNode.class)); //Patch json to JsonNodeObject
            uf_personas newUser = objMapper.treeToValue(patched, uf_personas.class); //Patch jsonnodeobject to class
            //Perform validation on PKEYUSUARIO (password), to prevent re-encryption of existent password
            if(jsonPatch.toString().toUpperCase().contains("PRSN_PKEY")){
                //Need password change
                newUser.setPRSN_PKEY(new BCryptPasswordEncoder().encode(newUser.getPRSN_PKEY()));
            }
            //Perform update
            if(userRepository.generalUpdateUserProfile(newUser)){
                //Return new user profile data
                return userRepository.getUserProfile(usr).get(0);
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
     * Service to set new date to provide system information when was the last access of a user
     * @param usr Username target
     * @param newDate New date format YYYY-MM-DD HH:mm:ss
     * @return TRUE OR FALSE
     */
    public boolean patchUserDeskappLastAccessDate(String usr, String newDate){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----UPDATE USER LAST ACCESS DATE ON DESKAPP\t-----@{}\t{}", usr,newDate);
        boolean resultTemp;

        if(userExistenceValidation(usr)){
            //User exists
            resultTemp = userRepository.patchUserDeskappLastAccessDate(usr,newDate);
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
     * Service to set new date to provide system information when was the last access of a student
     * @param usr Username target
     * @param newDate New date format YYYY-MM-DD HH:mm:ss
     * @return TRUE OR FALSE
     */
    public boolean patchStudentLastAccessDate(String usr, String newDate){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----UPDATE STUDENT LAST ACCESS DATE\t-----@{}\t{}", usr,newDate);
        boolean resultTemp;

        if(userExistenceValidation(usr)){
            //User exists
            resultTemp = userRepository.patchStudentLastAccessDate(usr,newDate);
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

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// PUT ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    /**
     * Service for update entire resource of uf_user_profile object
     * @param usr Username target
     * @param userdata uf_user_profile Object with new values
     * @return uf_user_profile Object
     */
    public uf_personas putUserProfile(String usr, uf_personas userdata){
        uf_personas newProfile = null;
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---PUT\t----PUT USER PROFILE DATA\t-----@{}", usr);
        //Perform operations
        if(userExistenceValidation(usr)){
            //Perform update of password
            if(userdata.getPRSN_PKEY().isEmpty() || userdata.getPRSN_PKEY().isBlank()){
                //Set default password by business rule
                userdata.setPRSN_PKEY(new BCryptPasswordEncoder().encode(userdata.getPRSN_USUARIO()+userdata.getPRSN_ID()+"#"));
            }else{
                //It comes with a custom password value
                userdata.setPRSN_PKEY(new BCryptPasswordEncoder().encode(userdata.getPRSN_PKEY()));
            }

            //Perform validations
            if(userRepository.generalUpdateUserProfile(userdata)){
                newProfile = userRepository.getUserProfile(userdata.getPRSN_USUARIO()).get(0);
            }else{
                //There's something bad occurs with DDBB operation
                throw new BusinessException(ErrorCodes.USER_SIGNUP_QUERY_ERROR);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
        return newProfile;
    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// DELETE /////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    /**
     * Service for remove a user from system database
     * @param usr Username target
     * @return TRUE OR FALSE
     */
    public boolean deleteUser(String usr){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---DELETE\t----DELETE USER PROFILE DATA\t-----@{}", usr);
        if(userExistenceValidation(usr)){
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
