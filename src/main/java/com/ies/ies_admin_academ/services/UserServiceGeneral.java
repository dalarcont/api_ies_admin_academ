package com.ies.ies_admin_academ.services;
/*
*
* Class to define service return values after retrieve data
*
* */
import com.ies.ies_admin_academ.config.ErrorCodes;
import com.ies.ies_admin_academ.exceptions.BusinessException;
import com.ies.ies_admin_academ.model.entities.uf_portallaboral;
import com.ies.ies_admin_academ.model.entities.uf_sisinfo_userapps;
import com.ies.ies_admin_academ.model.entities.uf_userprofile;
import com.ies.ies_admin_academ.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceGeneral {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validates if a user exists using only the username
     * @param username
     * @return TRUE OR FALSE
     */
    public boolean validateUsername(String username){
        List<uf_portallaboral> resultTemp = userRepository.validateUsername(username);
        boolean r = false;

        if(resultTemp.size()>0){
            if(resultTemp.get(0).getUsername().equals(username)) {
                r = true;
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }
        return r;
    }

    /**
     * Find the match between username and password to give access
     * @param usr
     * @param pwd
     * @return TRUE OR FALSE
     */
    public boolean validateAccess(String usr, String pwd){
        List<uf_portallaboral> resultTemp = userRepository.validateUsernameByMatch(usr,pwd);
        boolean r = false;

        if(resultTemp.size()>0){
            if(
                    resultTemp.get(0).getUsername().equals(usr)
                    &&
                    resultTemp.get(0).getPassword().equals(pwd)
            ) {
                r = true;
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_MISSMATCH);
        }
        return r;
    }

    /**
     * Let know deskapp if an user haves access
     * @param usr
     * @param pwd
     * @return TRUE OR FALSE
     */
    public boolean validateDeskappAccess(String usr, String pwd){
        List<uf_portallaboral> resultTemp = userRepository.validateDeskappAccess(usr,pwd);
        boolean r = false;

        if(resultTemp.size()>0){
            if(
                    resultTemp.get(0).isDeskapp_access() == 1
                    &&
                    (
                        resultTemp.get(0).getUsername().equals(usr) && resultTemp.get(0).getPassword().equals(pwd)
                    )
            ) {
                r = true;
            }else{
                throw new BusinessException(ErrorCodes.USER_VALIDATION_DESKAPP);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_MISSMATCH);
        }
        return r;
    }

    /**
     * @param usr
     * @return Object to give app permissions of an user
     */
    public List<uf_sisinfo_userapps> user_getapps_permissions(String usr){
        List<uf_sisinfo_userapps> resultTemp = userRepository.getApps_permissions(usr);

        if(validateUsername(usr)){
            //User exists
            if(resultTemp.size()==0){
                throw new BusinessException(ErrorCodes.USER_GETAPPPERMISSIONS_NORECORDS);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }

        return resultTemp;
    }

    public List<uf_userprofile> getUserProfileData(String usr, String pwd){
        List<uf_userprofile> resultTemp = userRepository.getUserProfile(usr,pwd);

        if(validateUsername(usr)){
            //User exists
            if(resultTemp.size()==0){
                throw new BusinessException(ErrorCodes.USER_GETPROFILE_DATA_EMPTY);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }

        return resultTemp;
    }

    public boolean setUserLastAccessDeskapp(String usr, String pwd, String newDate){
        boolean resultTemp = userRepository.setLastAccessRecord(usr,pwd,newDate);

        if(validateUsername(usr)){
            //User exists
            if(!resultTemp){
                //Update field was not applied
                throw new BusinessException(ErrorCodes.USER_ATTRIBUTEUPDATE_FAILS);
            }
        }else{
            throw new BusinessException(ErrorCodes.USER_VALIDATION_USER_NOEXISTS);
        }

        return resultTemp;
    }
}
