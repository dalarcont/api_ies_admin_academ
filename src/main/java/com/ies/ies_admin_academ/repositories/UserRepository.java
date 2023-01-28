package com.ies.ies_admin_academ.repositories;
/*
*
* Class to declare querys to DB
*
* */

import com.ies.ies_admin_academ.model.entities.*;
import com.ies.ies_admin_academ.model.mappers.UserValidationDESKAPP_Mapper;
import com.ies.ies_admin_academ.model.mappers.uf_sisinfo_permisibilidad_Mapper;
import com.ies.ies_admin_academ.model.mappers.userProfile_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Desktop app environment user validation mapper

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate dao_template;

    //SINGULAR SERVICE FOR USER VALIDATION BY ITS USERNAME
    public List<uf_portallaboral> validateUsername(String username){
        return dao_template.query(
                "SELECT * FROM uf_portallaboral WHERE NICKNAME_USUARIO = ?", new UserValidationDESKAPP_Mapper(), username
        );
    }

    //SINGULAR SERVICE FOR USER VALIDATION BY MATCH WITH ITS USERNAME AND PASSWORD
    public List<uf_portallaboral> validateUsernameByMatch(String username, String password){
        return dao_template.query(
                "SELECT * FROM uf_portallaboral WHERE nickname_usuario = ? AND pkeyusuario = ?", new UserValidationDESKAPP_Mapper(), username, password
        );
    }

    //SINGULAR SERVICE FOR VALIDATE DESKAPP ACCESS
    public List<uf_portallaboral> validateDeskappAccess(String username, String password){
        return dao_template.query(
                "SELECT * FROM uf_portallaboral WHERE nickname_usuario = ? AND pkeyusuario = ?", new UserValidationDESKAPP_Mapper(), username, password
        );
    }

    //SINGULAR SERVICE TO GET ROWS FROM DB THAT CONTAINS APP PERMISSIONS ON SYSINFO
    public List<uf_sisinfo_permisibilidad> getApps_permissions(String username){
        return dao_template.query(
                "SELECT * FROM uf_sisinfo_permisibilidad WHERE nickname = ?", new uf_sisinfo_permisibilidad_Mapper(), username
        );
    }

    //SINGULAR SERVICE TO GET USER'S PROFILE FOR DESKAPP
    public List<uf_userprofile> getUserProfile(String username, String password){
        return dao_template.query("SELECT \n" +
                "ufp.*,\n" +
                "ufpl.PKEYUSUARIO, ufpl.RECUPERAR_PREGUNTA, ufpl.RECUPERAR_RESPUESTA,\n" +
                "ufcc.NIVEL AS NIVELCARGO, ufcc.NOMBRE AS NOMBREDELCARGO,\n" +
                "ufui1.NOMBREUNIDAD,\n" +
                "ufpl.LAST_ACCESS AS ULTIMOINGRESO\n" +
                "FROM \n" +
                "\tuf_personas AS ufp\n" +
                "    LEFT JOIN uf_portallaboral AS ufpl ON ufp.USERNAME = ufpl.NICKNAME_USUARIO\n" +
                "    LEFT JOIN uf_personalinstitucional AS ufpi ON ufp.USERNAME = ufpi.NICKNAME\n" +
                "    LEFT JOIN uf_codigoscargos AS ufcc ON ufpi.CARGO = ufcc.CODIGO\n" +
                "    LEFT JOIN uf_unidades_institucionales ufui1 ON ufpi.DEPARTAMENTO = ufui1.CODIGOUNIDAD\n" +
                "WHERE ufpl.NICKNAME_USUARIO = ? AND ufpl.PKEYUSUARIO = ?\n" +
                "ORDER BY ufpi.TIPOPERSONAL ASC LIMIT 1;", new userProfile_Mapper(), username, password);
    }

    //SINGULAR SERVICE TO UPDATE USER'S LAST ACCESS DATE
    public boolean setLastAccessRecord(String usr, String pwd, String newDate){
        boolean r = false;
        if(
                dao_template.update("UPDATE uf_portallaboral SET last_access = ? WHERE nickname_usuario = ? AND pkeyusuario = ?;", newDate, usr, pwd)
                ==
                1
        ){
            //Successful update of field
            r = true;
        }else{
            r = false;
        }

        return r;
    }



}
