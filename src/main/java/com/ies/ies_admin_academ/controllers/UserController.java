package com.ies.ies_admin_academ.controllers;
/*
*
* Define here the method will be used when client request the API resource
*
* */

import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.uf_sisinfo_permisibilidad;
import com.ies.ies_admin_academ.model.entities.uf_userprofile;
import com.ies.ies_admin_academ.services.UserServiceGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Routes.IES_USERS)
public class UserController {

    String[] dataDecoder(String cad){
        //Decode data
        String[] d  = cad.split("!");
        byte[] bA = Base64.getDecoder().decode(d[0]);
        byte[] bB = Base64.getDecoder().decode(d[1]);
        return new String[] {new String(bA), new String(bB)};
    }
    @Autowired
    private UserServiceGeneral userServiceGeneral;

    @GetMapping(Routes.IES_USERS_EXISTENCEPROOF)
    public boolean user_validate_existence(
            @PathVariable("username") String username){
            return userServiceGeneral.validateUsername(username);
    }

    @GetMapping(Routes.IES_USERS_PWD_VALIDATION)
    public boolean user_validate_pwd(
            @PathVariable("data") String data){
            //Decode user and password
            String[] param = dataDecoder(data);
            //Perform service operation
            return userServiceGeneral.validateAccess(param[0],param[1]);
    }

    @GetMapping(Routes.IES_USERS_DESKAPP_ACCESS)
    public boolean user_validate_deskapp(
            @PathVariable("data") String data){
            //Decode user and password
            String[] param = dataDecoder(data);
            //Perform service operation
            return userServiceGeneral.validateDeskappAccess(param[0],param[1]);
    }

    @GetMapping(Routes.IES_USERS_SYSINFO_PERMISSIONS)
    public List<uf_sisinfo_permisibilidad> user_getapps_permissions(
            @PathVariable("data") String data){
            //Decode user and password
            String[] param = dataDecoder(data);
            //Perform service operation
            return userServiceGeneral.user_getapps_permissions(param[0]);
    }

    @GetMapping(Routes.IES_USERS_GETPROFILE)
    public List<uf_userprofile> user_getProfileData(
            @PathVariable("data") String data){
            //Decode user and password
            String[] param = dataDecoder(data);
            //Perform service operation
            return userServiceGeneral.getUserProfileData(param[0],param[1]);
    }

    @GetMapping(Routes.IES_USERS_DESKAPP_RECORDACCESS)
    public boolean user_newAccessRecord(
            @PathVariable("data") String data){
            //Decode user and password
            String[] param = dataDecoder(data);
            //new date data
            String newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            //Perform service operation
            return userServiceGeneral.setUserLastAccessDeskapp(param[0], param[1], newDate);
    }



}
