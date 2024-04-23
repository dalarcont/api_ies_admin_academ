package com.ies.ies_admin_academ.controllers;
/*
*
* Define here the method will be used when client request the API resource
*
* */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.*;
import com.ies.ies_admin_academ.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(Routes.ROOT.USERS)
public class UserController {

    private final UserService userServiceGeneral;
    public UserController(UserService userServiceGeneral) {
        this.userServiceGeneral = userServiceGeneral;
    }

    //TOOLS
    /**
     * Receives encoded credentials of a user from the frontEnd and convert to use it as normal string content.
     * @param cad   Encoded credentials as one single string
     * @return String[] with decoded credentials 0 = username ; 1 = password
     */
    public String[] dataDecoder(String cad){
        //Decode data
        String[] d  = cad.split("!");
        String a = new String(Base64.getDecoder().decode(d[0]));
        String b = new String(Base64.getDecoder().decode(d[1]));
        return new String[] {a,b};
    }

    //FINAL ENDPOINTS
    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// GET ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    @GetMapping(Routes.GET.USERS.EXISTENCEPROOF)
    public boolean userExistenceValidation(
            @PathVariable("username") String username){
            return userServiceGeneral.userExistenceValidation(username);
    }

    @GetMapping(Routes.GET.USERS.GET_USER_PROFILE)
    public uf_personas userGetProfileData(
    //public List<uf_user_profile> userGetProfileData(
            @PathVariable("data") String data){
        //Perform endpoint consumption
        return userServiceGeneral.userGetProfileData(data).get(0);
    }

    @GetMapping(Routes.GET.USERS.GET_EMPLOYEE_PROFILE)
    public uf_personas_empleado userGetEmployeeProfile(
    //public List<uf_employee_profile> userGetEmployeeData(
            @PathVariable("data") String data){
        //Perform endpoint consumption
        return userServiceGeneral.userGetEmployeeProfile(data).get(0);
    }

    @GetMapping(Routes.GET.USERS.GET_STUDENT_PROFILE)
    public uf_personas_estudiante userGetStudentProfile(
            @PathVariable("data") String data){
        //Perform endpoint consumption
        return userServiceGeneral.userGetStudentProfile(data).get(0);
    }

    @GetMapping(Routes.GET.USERS.MATCH_LOGIN)
    public boolean matchLogin(
            @PathVariable("data") String data){
            //Perform endpoint consumption
            return userServiceGeneral.matchLogin(dataDecoder(data)[0],dataDecoder(data)[1]);

    }

    @GetMapping(Routes.GET.USERS.DESKAPP_ACCESS)
    public boolean validateDeskappAccess(
            @PathVariable("data") String data){
            //Perform endpoint consumption
        return userServiceGeneral.validateDeskappAccess(data);
    }

    @GetMapping(Routes.GET.USERS.STUDENT_ACCESS)
    public boolean validateStudentAccess(
            @PathVariable("data") String data){
        //Perform endpoint consumption
        return userServiceGeneral.validateStudentAccess(data);
    }

    @GetMapping(Routes.GET.USERS.SYSINFO_PERMISSIONS)
    public List<uf_sisinfo_AppsAndPermissions> userGetAppsAndPermissions(
            @PathVariable("data") String data){
            //Perform endpoint consumption
            return userServiceGeneral.userGetAppsAndPermissions(dataDecoder(data)[0]);
    }

    @GetMapping(Routes.GET.USERS.EXISTENCEPROOF_BYID)
    public boolean validateUserById(
            @PathVariable("data") String data) {
        //Perform endpoint consumption
        return userServiceGeneral.validateUserById(data);
    }

    @GetMapping(Routes.GET.USERS.USR_ADD_VAL_EMAIL)
    public boolean validateSignupEmail(
            @PathVariable("data") String data){
        //Perform endpoint consumption
        return userServiceGeneral.validateSignupEmail(data);
    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// POST ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    @PostMapping
    public uf_personas addUser(@RequestBody uf_personas userdata){
        //Perform endpoint consumption
        return userServiceGeneral.addUser(userdata);
    }

    @PostMapping(Routes.POST.USERS.ADD_EVENT_WORKLOG)
    public boolean addEmployeeActivityLog(@RequestBody uf_registro_ejecutivo data){
        //Perform endpoint consumption
        return userServiceGeneral.addEmployeeActivityLog(data);
    }

    @PostMapping(Routes.POST.USERS.ADD_EVENT_STDNTLOG)
    public boolean addStudentActivityLog(@RequestBody uf_estudiantes_registro_ejecutivo data){
        //Perform endpoint consumption
        return userServiceGeneral.addStudentActivityLog(data);
    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// PATCH //////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    @PatchMapping(Routes.ROOT.BODY)
    public uf_personas patchUser(
            @PathVariable String data,
            @RequestBody JsonPatch jsonPatch) throws JsonPatchException, JsonProcessingException {
        //Decode user and password
        return userServiceGeneral.patchUser(data,jsonPatch);

    }

    @PatchMapping(Routes.PATCH.USERS.SYSTEM_DESKAPP_RECORDACCESS)
    public boolean patchUserDeskappLastAccessDate(
            @PathVariable("data") String data){
        //new date data
        String newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        //Perform endpoint consumption
        return userServiceGeneral.patchUserDeskappLastAccessDate(dataDecoder(data)[0], newDate);
    }

    @PatchMapping(Routes.PATCH.USERS.SYSTEM_STD_RECORDACCESS)
    public boolean patchStudentLastAccessDate(
            @PathVariable("data") String data){
        //new date data
        String newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        //Perform endpoint consumption
        return userServiceGeneral.patchStudentLastAccessDate(dataDecoder(data)[0], newDate);
    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// PUT ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    @PutMapping(Routes.ROOT.BODY)
    public uf_personas putUserProfile(
            @PathVariable String data,
            @RequestBody uf_personas userdata){
        //Perform endpoint consumption
        return userServiceGeneral.putUserProfile(data,userdata);
    }

    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// DELETE /////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    @DeleteMapping(Routes.ROOT.BODY)
    public boolean deleteUser(@PathVariable String data){
        //Perform endpoint consumption
        return userServiceGeneral.deleteUser(data);
    }


}
