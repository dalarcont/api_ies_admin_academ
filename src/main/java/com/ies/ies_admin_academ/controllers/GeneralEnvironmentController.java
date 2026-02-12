package com.ies.ies_admin_academ.controllers;

import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.uf_appstates;
import com.ies.ies_admin_academ.services.GeneralService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.ROOT.GENERAL_ENVIRONMENT)
public class GeneralEnvironmentController {
    private final GeneralService generalService;
    public GeneralEnvironmentController(GeneralService generalService){this.generalService = generalService;}

    //TOOLS
    public String[] dataDecoder(String cad){
        //Constant
        String[] white = new String[]{"",""};
        String[] r = new String[0];
        final String EOS = "_eos_"; //EOS = End of String
        final String SOS = "_sos_"; //SOS = Start of String
        final String TBL_IDNTFR = "uf_";
        //Add this for string validations
        cad += EOS;

        if(cad.toLowerCase().contains(TBL_IDNTFR)){
            //Source table identifier mention
            if(cad.toLowerCase().split(TBL_IDNTFR)[1].equals(EOS)){
                //No table name given
                r = white;
            }else{
                //Table name was given after identifier then check conv code
                //if(cad.toLowerCase().split(TBL_IDNTFR)[0].isEmpty()){
                if((SOS+cad.toLowerCase().split(TBL_IDNTFR)[0])==SOS){
                    //No convention code given
                    r = white;
                }else{
                    //Convention code given can proceed
                    r = new String[]{cad.toLowerCase().split(TBL_IDNTFR)[0],TBL_IDNTFR+cad.toLowerCase().split(TBL_IDNTFR)[1].replace(EOS,"")};
                }
            }
        }else{
            //No source table identifier given can't proceed
            r = white;
        }

        return r;
    }

    //ENDPOINTS
    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// GET ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */
    @GetMapping(Routes.GET.GENERAL_ENVIRONMENT.CONVENTION_NAME)
    public String getConventionName(
            @PathVariable("data") String data){
        //Get name of convention
        //return generalService.getConventionName(dataDecoder(data)[0],dataDecoder(data)[1]);
        return generalService.getConventionName(data);
    }

    @GetMapping(Routes.GET.GENERAL_ENVIRONMENT.APP_STATUS)
    public uf_appstates getAppStatus(
            @PathVariable("data") String data){
        //Get app status object
        return generalService.getAppStatus(data.replace('!','/'));
    }


    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// POST ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */


    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// PATCH //////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */


    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// PUT ////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */


    /* /////////////////////////////////////////////////////////////////////////////////////////////////
    /// DELETE /////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////// */

}
