package com.ies.ies_admin_academ.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.ies_admin_academ.config.ErrorCodes;
import com.ies.ies_admin_academ.exceptions.BusinessException;
import com.ies.ies_admin_academ.model.entities.uf_appstates;
import com.ies.ies_admin_academ.model.entities.uf_registro_ejecutivo;
import com.ies.ies_admin_academ.repositories.GeneralRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
    Logger eventLogger = LogManager.getLogger(GeneralService.class);
    private final GeneralRepository generalRepository;
    private final ObjectMapper objMapper;

    public GeneralService(GeneralRepository generalRepository, ObjectMapper objMapper) {
        this.generalRepository = generalRepository;
        this.objMapper = objMapper;
    }

    /**
     * The different tables present at DDBB has its codes to refer to something
     * This endpoint performs let you know the mean of that code
     * @param codConv Code convention needed to know
     * @param srcTable Name of table where is present
     * @return String name of convention
     */
    public String getConventionName(String codConv,String srcTable){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----GET CONVENTION NAME\t-----@{}\t@{}", codConv,srcTable);
        String r = null;
        //Check for source table parameter isn't empty
        if(!srcTable.isEmpty()){
            //Source table was specified
            //Validate convention code is given
            if(!codConv.isEmpty()){
                String tmp = generalRepository.getConventionName(codConv,srcTable);
                if(!tmp.contains("NULL")){
                    //There is a result
                    r = tmp;
                }else if(tmp.contains("NULL_TABLE")){
                    //Given source table doesn't exits
                    throw new BusinessException(ErrorCodes.GENERAL_CONVENTION_SRCTABLE_NOTEXISTS);
                }else{
                    //Given convention code doesn't exists
                    throw new BusinessException(ErrorCodes.GENERAL_CONVENTION_CODE_NOEXISTS);
                }
            }else{
                //Convention code not given
                throw new BusinessException(ErrorCodes.GENERAL_CONVENTION_CODE_NOTGIVEN);
            }
        }else{
            //Source table wasn't given or is incorrect
            throw new BusinessException(ErrorCodes.GENERAL_CONVENTION_SRCTABLE_NOTGIVEN);
        }

        return r;
    }

    public uf_appstates getAppStatus(String appcode){
        eventLogger.log(org.apache.logging.log4j.Level.INFO, "-API\t--SERVICE\t---GET\t----GET APP STATUS OBJECT\t-----@{}", appcode);
        uf_appstates rs = null;
        if(!appcode.isEmpty()){
            //App code was given
            rs = generalRepository.getAppStatus(appcode);
            if(rs == null){
                //Object return null from repository, so the appcode was given but is incorrect or doesn't exists
                throw new BusinessException(ErrorCodes.GENERAL_APPCODE_NOEXISTS);
            }
        }else{
            //App code was not given
            throw new BusinessException(ErrorCodes.GENERAL_APPCODE_NOTGIVEN);
        }
        return rs;
    }

}
