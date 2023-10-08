package com.ies.ies_admin_academ.repositories;

/**
 * Please use Reeplace:
 * Reeplace   and    with a space
 */
public class dbQueries {

    public enum USER {
        String;

        public static final String GET_USER_BASIC_DATA_QUERY = "SELECT * FROM uf_personas ufp WHERE ufp.PRSN_USUARIO = ?;";
        //public static final String GET_EMPLOYEE_PROFILE_QUERY = "{CALL EMPLOYEE_PROFILE(?)};"; // -> DB STORED PROCEDURE TESTING

        public static final String GET_EMPLOYEE_PROFILE_QUERY = new StringBuilder()
                .append("SELECT ufp.*, ")
                .append("       ufpl.COD_UNIDAD, ")
                .append("       ufpl.COD_AREA, ")
                .append("       ufpl.COD_CARGO, ")
                .append("       ufpl.ESTADO_DISCIPLINARIO, ")
                .append("       ufpl.COD_TIPO_PERSONAL, ")
                .append("       ufpl.MCA_CARGO_PRINCIPAL, ")
                .append("       ufpl2.PERMISO_ACCESO, ")
                .append("       ufpl2.FEC_ULTIMO_ACCESO, ")
                .append("       (SELECT ufca.DETALLE FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN = 'uf_personas' AND ufca.COD_CONV=ufp.PRSN_GEN) PRSN_GEN_NOM, ")
                .append("       (SELECT ufcc.DETALLE FROM uf_country_codes ufcc WHERE ufcc.COUNTRY = ufp.PRSN_ORIGEN_PAIS AND ufcc.LANG = 'ES') PRSN_ORIGEN_PAIS_NOM, ")
                .append("       (SELECT ufcc.DETALLE FROM uf_country_codes ufcc WHERE ufcc.COUNTRY = ufp.PRSN_RESIDE_PAIS AND ufcc.LANG = 'ES') PRSN_ORIGEN_RESIDE_NOM, ")
                .append("       (SELECT ufca.DETALLE FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN = 'uf_personas' AND ufca.COD_CONV=ufp.PRSN_ESCOLARIDAD) PRSN_ESCOLARIDAD_NOM, ")
                .append("       (SELECT uui.UNIDAD_NOMBRE FROM uf_unidades_institucionales uui WHERE uui.COD_UNIDAD = ufpl.COD_UNIDAD) NOM_UNIDAD, ")
                .append("       (SELECT uui2.UNIDAD_NOMBRE FROM uf_unidades_institucionales uui2 WHERE uui2.COD_UNIDAD = ufpl.COD_AREA) NOM_AREA, ")
                .append("       (SELECT ufcc2.CARGO_NOMBRE FROM uf_codigos_cargos ufcc2 WHERE ufcc2.COD_CARGO = ufpl.COD_CARGO) NOM_CARGO, ")
                .append("       (SELECT ufcc2.NIVEL_CARGO FROM uf_codigos_cargos ufcc2 WHERE ufcc2.COD_CARGO = ufpl.COD_CARGO) NOM_CARGO_NIVEL, ")
                .append("       (SELECT ufca.DETALLE FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN = 'uf_personal_institucional' AND ufca.COD_CONV=ufpl.COD_TIPO_PERSONAL) NOM_TIPO_PERSONAL, ")
                .append("       (SELECT ufca.DETALLE FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN = 'uf_personal_institucional' AND ufca.COD_CONV=ufpl.ESTADO_DISCIPLINARIO) NOM_ESTADO_DISCIPLINARIO, ")
                .append("       (SELECT ufca.DETALLE FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN = 'uf_personal_institucional' AND ufca.COD_CONV=ufpl.MCA_VACACIONES) NOM_MCA_VACACIONES ")
                .append("FROM ")
                .append("    uf_personas AS ufp ")
                .append("        LEFT JOIN uf_personal_institucional AS ufpl ON ufpl.COD_USUARIO  = ufp.PRSN_USUARIO ")
                .append("        LEFT JOIN uf_portal_laboral AS ufpl2 ON ufpl2.COD_USUARIO  = ufp.PRSN_USUARIO ")
                .append("WHERE ")
                .append("        ufp.PRSN_USUARIO  = ? AND ")
                .append("        ufpl.MCA_CARGO_PRINCIPAL  = 1;")
                .toString();
        public static final String GET_STUDENT_PROFILE_QUERY = new StringBuilder()
                .append("SELECT ")
                .append("ufp.*, ")
                .append("ufeg.FEC_PRIMER_MATRICULA, ufeg.FEC_ULTIMA_MATRICULA, ufeg.COD_ULTIMO_PROGRAMA_MATRICULADO, ufeg.ESTADO_DISCIPLINARIO, ufeg.ESTADO_ACADEMICO_GENERAL, ")
                .append("ufep.PERMISO_ACCESO, ufep.FEC_ULTIMO_ACCESO  ")
                .append("FROM ")
                .append("uf_personas AS ufp ")
                .append("LEFT JOIN uf_estudiantes_general AS ufeg ON ufeg.COD_ESTUDIANTE  = ufp.PRSN_USUARIO  ")
                .append("LEFT JOIN uf_estudiantes_portal AS ufep ON ufep.COD_ESTUDIANTE  = ufp.PRSN_USUARIO  ")
                .append("WHERE ")
                .append("ufp.PRSN_USUARIO = ? AND ")
                .append("ufeg.COD_ESTUDIANTE = ufp.PRSN_USUARIO  AND  ")
                .append("ufep.COD_ESTUDIANTE = ufp.PRSN_USUARIO ; ")
                .toString();
        public static final String MATCH_LOGIN_QUERY = "SELECT ufp.PRSN_PKEY FROM uf_personas ufp WHERE ufp.PRSN_USUARIO = ?;";
        public static final String DESKAPP_ACCESS_QUERY = "SELECT COUNT(*) FROM uf_portal_laboral upl WHERE upl.COD_USUARIO  = ? AND upl.PERMISO_ACCESO  = 1;";
        public static final String STUDENT_ACCESS_QUERY = "SELECT COUNT(*) FROM uf_estudiantes_portal ufep WHERE ufep.COD_ESTUDIANTE = ? AND ufep.PERMISO_ACCESO  = 1;";
        public static final String SISINFO_APPS_PERMISSIONS_QUERY = new StringBuilder()
                .append("SELECT  ")
                .append("null AS COD_USUARIO, sia.APP_CODE, 1 AS PERMISSION, sia.APP_NAME, sia.APP_DESCR, sia.APP_TREE_LEVEL  ")
                .append("FROM ")
                .append("uf_sisinfo_apps sia WHERE sia.APP_DESCR IN('') ")
                .append("UNION ")
                .append("SELECT  ")
                .append("sip.COD_USUARIO, sia2.APP_CODE, sip.PERMISSION , sia2.APP_NAME, sia2.APP_DESCR, sia2.APP_TREE_LEVEL  ")
                .append("FROM  ")
                .append("uf_sisinfo_permisos sip, uf_sisinfo_apps sia2 ")
                .append("WHERE  ")
                .append("sip.COD_USUARIO    = ?  ")
                .append("AND sip.PERMISSION  = 1  ")
                .append("AND sia2.APP_CODE    = sip.APP_CODE ; ")
                .toString();
        public static final String UPDATE_DESKAPP_LAST_ACCESS_QUERY = "UPDATE uf_portal_laboral ufpl SET ufpl.FEC_ULTIMO_ACCESO = ? WHERE ufpl.COD_USUARIO = ?;";
        public static final String INSERT_PERSONA_QUERY = new StringBuilder()
                .append("INSERT INTO uf_personas ")
                .append("(PRSN_ID,  ")
                .append("PRSN_NOM,  ")
                .append("PRSN_APE,  ")
                .append("PRSN_USUARIO,  ")
                .append("PRSN_GEN,  ")
                .append("PRSN_EMAIL_PERSONAL,  ")
                .append("PRSN_EMAIL_LABORAL,  ")
                .append("PRSN_ORIGEN_PAIS,  ")
                .append("PRSN_ORIGEN_CIUDAD,  ")
                .append("PRSN_RESIDE_PAIS,  ")
                .append("PRSN_RESIDE_CIUDAD,  ")
                .append("PRSN_ESCOLARIDAD,  ")
                .append("PRSN_PKEY) ")
                .append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ")
                .toString();
        public static final String UPDATE_ITEM_PERSONA_QUERY = new StringBuilder()
                .append("UPDATE uf_personas  ")
                .append("SET PRSN_ID=?,  ")
                .append("PRSN_NOM=?,  ")
                .append("PRSN_APE=?,  ")
                .append("PRSN_GEN=?,  ")
                .append("PRSN_EMAIL_PERSONAL=?,  ")
                .append("PRSN_EMAIL_LABORAL=?, ")
                .append("PRSN_ORIGEN_PAIS=?, ")
                .append("PRSN_ORIGEN_CIUDAD=?, ")
                .append("PRSN_RESIDE_PAIS=?, ")
                .append("PRSN_RESIDE_CIUDAD=?, ")
                .append("PRSN_ESCOLARIDAD=?, ")
                .append("PRSN_PKEY=?, ")
                .append("PRSN_RECOVERY_QUEST=?, ")
                .append("PRSN_RECOVERY_ANS=?  ")
                .append("WHERE PRSN_USUARIO = ?; ")
                .toString();
        public static final String DELETE_SOLO_PERSONA_QUERY = "DELETE FROM uf_personas WHERE PRSN_USUARIO = ?;";

        public static final String GET_VALIDATION_BY_ID = new StringBuilder()
                .append("SELECT ")
                .append("  CASE WHEN EXISTS  (")
                .append("  SELECT * FROM uf_personas ufp WHERE ufp.PRSN_ID = ? )")
                .append("  THEN 'TRUE'")
                .append("  ELSE 'FALSE'")
                .append("  END")
                .toString();

        public static final String GET_USERNAME_AVAILABLE = new StringBuilder()
                .append("SELECT ")
                .append("  CASE WHEN EXISTS  (")
                .append("  SELECT * FROM uf_personas ufp WHERE ufp.PRSN_USUARIO = ? )")
                .append("  THEN 'TRUE'")
                .append("  ELSE 'FALSE'")
                .append("  END")
                .toString();

        public static final String GET_VALIDATION_BY_EMAIL = new StringBuilder()
                .append("SELECT ")
                .append("CASE WHEN EXISTS (")
                .append("SELECT * FROM uf_personas ufp WHERE ufp.PRSN_EMAIL_PERSONAL = ? )")
                .append("    THEN 'TRUE'")
                .append("    ELSE 'FALSE'")
                .append("END")
                .toString();

        public static final String ADD_EVENT_LOG_WORK = "INSERT INTO uf_registro_ejecutivo (COD_EMPLEADO,REG_APPSET,REG_ACTION_DESCR) VALUES (?,?,?);";

        public static final String ADD_EVENT_LOG_STDNT = "INSERT INTO uf_estudiantes_registro_ejecutivo (COD_ESTUDIANTE,REG_APPSET,REG_ACTION_DESCR) VALUES (?,?,?);";


    }

    public enum GENERAL{
        String;

        public static final String GET_NAME_APP_CONVENTION_CODE_QUERY = new StringBuilder()
                .append("SELECT CASE ")
                .append(" WHEN NOT EXISTS(SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_NAME = ?) THEN \"NULL_TABLE\" ")
                .append(" ELSE (SELECT IFNULL((SELECT ufca.DETALLE  FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN = ? AND ufca.COD_CONV = ?),\"NULL\")) ")
                .append("END AS DETALLE FROM DUAL;")
                .toString();

        public static final String GET_APP_STATE_QUERY = "SELECT ufas.*, (SELECT ufca.DETALLE FROM uf_convenciones_apps ufca WHERE ufca.TABLA_ORIGEN='uf_appstates' AND ufca.COD_CONV = ufas.APP_STATE) APP_STATE_NOM FROM uf_appstates ufas WHERE ufas.APP_CODE = ?;";

    }


}
