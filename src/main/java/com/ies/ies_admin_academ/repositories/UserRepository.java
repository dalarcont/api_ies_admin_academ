package com.ies.ies_admin_academ.repositories;
/*
*
* Class to declare querys to DB
*
* */

import com.ies.ies_admin_academ.model.entities.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public List<uf_user_profile> getUserBasicData(String username){
       return daoUser.query("SELECT * FROM uf_personas WHERE USERNAME=?;",new BeanPropertyRowMapper<>(uf_user_profile.class),username);
    }

    /**
     * Perform query to get employee profile (constituted by user profile and employee data)
     * Due to business rules the retrieved data will be only referenced to the main contract of the employee
     * @param username Username of the target user
     * @return Object uf_employee_profile
     */
    public List<uf_employee_profile> getEmployeeProfile(String username){
        return daoUser.query("SELECT " +
                        "ufp.*, " +
                        "ufpl.DEPARTAMENTO, ufpl.AREA, ufpl.CARGO, ufpl.CONTRATACION, ufpl.ESTADO, ufpl.TIPOPERSONAL, ufpl.CARGOPRINCIPAL, ufpl2.DESKAPP, ufpl2.LAST_ACCESS " +
                        "FROM uf_personas AS ufp " +
                        "LEFT JOIN uf_personalinstitucional AS ufpl ON ufpl.USERNAME = ufp.USERNAME " +
                        "LEFT JOIN uf_portallaboral AS ufpl2 ON ufpl2.USERNAME = ufp.USERNAME " +
                        "WHERE ufp.USERNAME = ? AND " +
                        "ufpl.CARGOPRINCIPAL = 1;",
                        new BeanPropertyRowMapper<>(uf_employee_profile.class),username);
    }

    /**
     * Perform query to get student profile (constituted by user profile and student data)
     * Due to business rules the retrieved data will be only referenced to the general info and student access
     * @param username Username of the target user
     * @return Object uf_student_profile
     */
    public List<uf_student_profile> getStudentProfile(String username){
        return daoUser.query("SELECT " +
                        "ufp.*, " +
                        "ufeg.fechaingreso, ufeg.estadogeneral, ufeg.puntajeingreso, ufeg.ultimoprogramamatriculado, " +
                        "ufep.studentportal, ufep.last_access " +
                        "FROM uf_personas AS ufp " +
                        " LEFT JOIN uf_estudiantes_general AS ufeg ON ufeg.USERNAME = ufp.USERNAME" +
                        " LEFT JOIN uf_estudiantes_portal AS ufep ON ufep.USERNAME = ufp.USERNAME " +
                        "WHERE " +
                        "ufp.USERNAME=? AND " +
                        "ufeg.USERNAME=ufp.USERNAME AND " +
                        "ufep.USERNAME=ufp.USERNAME;",
                new BeanPropertyRowMapper<>(uf_student_profile.class),username);
    }

    /**
     * Perform query to get access validation to DESKAPP environment
     * @param username Username of the target user
     * @return boolean
     */
    public boolean deskappAccess(String username){
        return Boolean.TRUE.equals(daoUser.queryForObject("SELECT COUNT(*) FROM uf_portallaboral WHERE username = ? AND DESKAPP = 1;",
                boolean.class, username));
    }

    /**
     * Perform query to get access validation to student environment
     * @param username Username of the target user
     * @return boolean
     */
    public boolean stdAccess(String username){
        return Boolean.TRUE.equals(daoUser.queryForObject("SELECT COUNT(*) FROM uf_estudiantes_portal WHERE username = ? AND STUDENTPORTAL = 1;",
                boolean.class, username));
    }

    /**
     * Perform query operation to get a list of the applications that a user is able to use
     * @param username Username of the target user
     * @return List of uf_sisinfo_userapps objects
     */
    public List<uf_sisinfo_userapps> getAppsPermissions(String username){
        return daoUser.query(
                "SELECT null AS USERNAME, " +
                        "sia.APPCODE, " +
                        "1 AS PERMISSION, " +
                        "sia.APPNAME, " +
                        "sia.APPDESCRIPTION, " +
                        "sia.TREELEVEL " +
                        "FROM uf_sisinfo_apps sia WHERE sia.APPDESCRIPTION IN('') " +
                        "UNION SELECT " +
                        "sip.*, " +
                        "sia2.APPNAME, " +
                        "sia2.APPDESCRIPTION, " +
                        "sia2.TREELEVEL " +
                        "FROM  uf_sisinfo_permisibilidad sip, uf_sisinfo_apps sia2 " +
                        "WHERE sip.USERNAME = ? " +
                        "AND sip.PERMISSION = 1 " +
                        "AND sia2.APPCODE = sip.APPCODE;",
                new BeanPropertyRowMapper<>(uf_sisinfo_userapps.class),username);
    }


    /**
     * Perform employee's last access date update
     * @param usr Username of the target user
     * @param newDate Immediately date of performing this operation
     * @return TRUE OR FALSE
     */
    public boolean setLastAccessRecord(String usr, String newDate){
        return (daoUser.update("UPDATE uf_portallaboral SET last_access = ? WHERE username = ? ;", newDate, usr) == 1);
    }

    /**
     * Perform insert a new user profile data
     * @param userprofile User object with attributes
     * @return TRUE OR FALSE about the query execution
     */
    public boolean addUser(uf_user_profile userprofile){
        return
             daoUser.update("INSERT INTO uf_personas " +
                     "(idpersona," +
                     "nombres," +
                     "apellidos," +
                     "username," +
                     "genero," +
                     "email_personal," +
                     "email_laboral," +
                     "origen_pais," +
                     "origen_ciudad," +
                     "reside_pais," +
                     "reside_ciudad," +
                     "escolaridad," +
                     "pkeyusuario)"
                     +" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
                     userprofile.getIdPersona(),
                     userprofile.getNombres(),
                     userprofile.getApellidos(),
                     userprofile.getUsername(),
                     userprofile.getGenero(),
                     userprofile.getEmail_personal().toLowerCase(),
                     userprofile.getEmail_laboral().toLowerCase(),
                     userprofile.getOrigen_pais(),
                     userprofile.getOrigen_ciudad().toUpperCase(),
                     userprofile.getReside_pais(),
                     userprofile.getReside_ciudad().toUpperCase(),
                     userprofile.getEscolaridad(),
                     userprofile.getPkeyusuario()
             ) == 1;
    }

    /**
     * Perform update of one or more attributes of a user
     * @param usr Username of the target user
     * @return TRUE or FALSE of the query execution
     */
    public boolean updateItemUSR(uf_user_profile usr){
        /*
         * BUSINESS RULE: Strictly NO ONE can modify sign-up date. Don't add inside the query that field.
         * */
        return daoUser.update("UPDATE uf_personas " +
                        "SET IDPERSONA=?, " +
                        "NOMBRES=?, " +
                        "APELLIDOS=?, " +
                        "GENERO=?, " +
                        "EMAIL_PERSONAL=?, " +
                        "EMAIL_LABORAL=?," +
                        "ORIGEN_PAIS=?," +
                        "ORIGEN_CIUDAD=?," +
                        "RESIDE_PAIS=?," +
                        "RESIDE_CIUDAD=?," +
                        "ESCOLARIDAD=?," +
                        "PKEYUSUARIO=?," +
                        "RECUPERAR_PREGUNTA=?," +
                        "RECUPERAR_RESPUESTA=? " +
                        "WHERE USERNAME = ?;",
                usr.getIdPersona(),
                usr.getNombres(),
                usr.getApellidos(),
                usr.getGenero(),
                usr.getEmail_personal().toLowerCase(),
                usr.getEmail_laboral().toLowerCase(),
                usr.getOrigen_pais(),
                usr.getOrigen_ciudad().toUpperCase(),
                usr.getReside_pais(),
                usr.getReside_ciudad().toUpperCase(),
                usr.getEscolaridad(),
                usr.getPkeyusuario(),
                usr.getRecuperar_pregunta(),
                usr.getRecuperar_respuesta(),
                usr.getUsername())==1;
    }


    public boolean deleteUser(String usr){
        //Perform DB query
        return daoUser.update("DELETE FROM uf_personas WHERE USERNAME = ?;",usr)==1;
    }



}
