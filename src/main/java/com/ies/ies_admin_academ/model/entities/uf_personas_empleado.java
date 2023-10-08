package com.ies.ies_admin_academ.model.entities;

import java.io.Serializable;

/*
* Model/Entity used for validate an existence of a user by its username and password
* ONLY WORKS FOR DESKTOP APP ENVIRONMENT AND VALIDATION OF ADMIN PEOPLE ROLE
* */
public class uf_personas_empleado extends uf_personas implements Serializable {

    private String COD_UNIDAD;
    private String COD_AREA;
    private String COD_CARGO;
    private String COD_TIPO_PERSONAL;
    private String ESTADO_DISCIPLINARIO;
    private String MCA_VACACIONES;
    private boolean MCA_CARGO_PRINCIPAL;
    private boolean PERMISO_ACCESO;
    private String FEC_ULTIMO_ACCESO;

    //Custom properties created by the original properties with its codes given
    private String NOM_UNIDAD;
    private String NOM_AREA;
    private String NOM_CARGO;
    private String NOM_CARGO_NIVEL;
    private String NOM_TIPO_PERSONAL;
    private String NOM_ESTADO_DISCIPLINARIO;
    private String NOM_MCA_VACACIONES;


    public uf_personas_empleado(){
        super();
    }

    public uf_personas_empleado(int PRSN_REG, String PRSN_FEC_REG, String PRSN_ID, String PRSN_NOM, String PRSN_APE, String PRSN_USUARIO, String PRSN_GEN, String PRSN_EMAIL_PERSONAL, String PRSN_EMAIL_LABORAL, String PRSN_ORIGEN_PAIS, String PRSN_ORIGEN_CIUDAD, String PRSN_RESIDE_PAIS, String PRSN_RESIDE_CIUDAD, String PRSN_ESCOLARIDAD, String PRSN_PKEY, String PRSN_RECOVERY_QUEST, String PRSN_RECOVERY_ANS, String PRSN_GEN_NOM, String PRSN_ORIGEN_PAIS_NOM, String PRSN_ORIGEN_RESIDE_NOM, String PRSN_ESCOLARIDAD_NOM, String COD_UNIDAD, String COD_AREA, String COD_CARGO, String COD_TIPO_PERSONAL, String ESTADO_DISCIPLINARIO, String MCA_VACACIONES, boolean MCA_CARGO_PRINCIPAL, boolean PERMISO_ACCESO, String FEC_ULTIMO_ACCESO, String NOM_UNIDAD, String NOM_AREA, String NOM_CARGO, String NOM_CARGO_NIVEL, String NOM_TIPO_PERSONAL, String NOM_ESTADO_DISCIPLINARIO, String NOM_MCA_VACACIONES) {
        super(PRSN_REG, PRSN_FEC_REG, PRSN_ID, PRSN_NOM, PRSN_APE, PRSN_USUARIO, PRSN_GEN, PRSN_EMAIL_PERSONAL, PRSN_EMAIL_LABORAL, PRSN_ORIGEN_PAIS, PRSN_ORIGEN_CIUDAD, PRSN_RESIDE_PAIS, PRSN_RESIDE_CIUDAD, PRSN_ESCOLARIDAD, PRSN_PKEY, PRSN_RECOVERY_QUEST, PRSN_RECOVERY_ANS, PRSN_GEN_NOM, PRSN_ORIGEN_PAIS_NOM, PRSN_ORIGEN_RESIDE_NOM, PRSN_ESCOLARIDAD_NOM);
        this.COD_UNIDAD = COD_UNIDAD;
        this.COD_AREA = COD_AREA;
        this.COD_CARGO = COD_CARGO;
        this.COD_TIPO_PERSONAL = COD_TIPO_PERSONAL;
        this.ESTADO_DISCIPLINARIO = ESTADO_DISCIPLINARIO;
        this.MCA_VACACIONES = MCA_VACACIONES;
        this.MCA_CARGO_PRINCIPAL = MCA_CARGO_PRINCIPAL;
        this.PERMISO_ACCESO = PERMISO_ACCESO;
        this.FEC_ULTIMO_ACCESO = FEC_ULTIMO_ACCESO;
        this.NOM_UNIDAD = NOM_UNIDAD;
        this.NOM_AREA = NOM_AREA;
        this.NOM_CARGO = NOM_CARGO;
        this.NOM_CARGO_NIVEL = NOM_CARGO_NIVEL;
        this.NOM_TIPO_PERSONAL = NOM_TIPO_PERSONAL;
        this.NOM_ESTADO_DISCIPLINARIO = NOM_ESTADO_DISCIPLINARIO;
        this.NOM_MCA_VACACIONES = NOM_MCA_VACACIONES;
    }

    public String getCOD_UNIDAD() {
        return COD_UNIDAD;
    }

    public void setCOD_UNIDAD(String COD_UNIDAD) {
        this.COD_UNIDAD = COD_UNIDAD;
    }

    public String getCOD_AREA() {
        return COD_AREA;
    }

    public void setCOD_AREA(String COD_AREA) {
        this.COD_AREA = COD_AREA;
    }

    public String getCOD_CARGO() {
        return COD_CARGO;
    }

    public void setCOD_CARGO(String COD_CARGO) {
        this.COD_CARGO = COD_CARGO;
    }

    public String getCOD_TIPO_PERSONAL() {
        return COD_TIPO_PERSONAL;
    }

    public void setCOD_TIPO_PERSONAL(String COD_TIPO_PERSONAL) {
        this.COD_TIPO_PERSONAL = COD_TIPO_PERSONAL;
    }

    public String getESTADO_DISCIPLINARIO() {
        return ESTADO_DISCIPLINARIO;
    }

    public void setESTADO_DISCIPLINARIO(String ESTADO_DISCIPLINARIO) {
        this.ESTADO_DISCIPLINARIO = ESTADO_DISCIPLINARIO;
    }

    public String getMCA_VACACIONES() {
        return MCA_VACACIONES;
    }

    public void setMCA_VACACIONES(String MCA_VACACIONES) {
        this.MCA_VACACIONES = MCA_VACACIONES;
    }

    public boolean isMCA_CARGO_PRINCIPAL() {
        return MCA_CARGO_PRINCIPAL;
    }

    public void setMCA_CARGO_PRINCIPAL(boolean MCA_CARGO_PRINCIPAL) {
        this.MCA_CARGO_PRINCIPAL = MCA_CARGO_PRINCIPAL;
    }

    public boolean isPERMISO_ACCESO() {
        return PERMISO_ACCESO;
    }

    public void setPERMISO_ACCESO(boolean PERMISO_ACCESO) {
        this.PERMISO_ACCESO = PERMISO_ACCESO;
    }

    public String getFEC_ULTIMO_ACCESO() {
        return FEC_ULTIMO_ACCESO;
    }

    public void setFEC_ULTIMO_ACCESO(String FEC_ULTIMO_ACCESO) {
        this.FEC_ULTIMO_ACCESO = FEC_ULTIMO_ACCESO;
    }

    public String getNOM_UNIDAD() {
        return NOM_UNIDAD;
    }

    public void setNOM_UNIDAD(String NOM_UNIDAD) {
        this.NOM_UNIDAD = NOM_UNIDAD;
    }

    public String getNOM_AREA() {
        return NOM_AREA;
    }

    public void setNOM_AREA(String NOM_AREA) {
        this.NOM_AREA = NOM_AREA;
    }

    public String getNOM_CARGO() {
        return NOM_CARGO;
    }

    public void setNOM_CARGO(String NOM_CARGO) {
        this.NOM_CARGO = NOM_CARGO;
    }

    public String getNOM_CARGO_NIVEL() {
        return NOM_CARGO_NIVEL;
    }

    public void setNOM_CARGO_NIVEL(String NOM_CARGO_NIVEL) {
        this.NOM_CARGO_NIVEL = NOM_CARGO_NIVEL;
    }

    public String getNOM_TIPO_PERSONAL() {
        return NOM_TIPO_PERSONAL;
    }

    public void setNOM_TIPO_PERSONAL(String NOM_TIPO_PERSONAL) {
        this.NOM_TIPO_PERSONAL = NOM_TIPO_PERSONAL;
    }

    public String getNOM_ESTADO_DISCIPLINARIO() {
        return NOM_ESTADO_DISCIPLINARIO;
    }

    public void setNOM_ESTADO_DISCIPLINARIO(String NOM_ESTADO_DISCIPLINARIO) {
        this.NOM_ESTADO_DISCIPLINARIO = NOM_ESTADO_DISCIPLINARIO;
    }

    public String getNOM_MCA_VACACIONES() {
        return NOM_MCA_VACACIONES;
    }

    public void setNOM_MCA_VACACIONES(String NOM_MCA_VACACIONES) {
        this.NOM_MCA_VACACIONES = NOM_MCA_VACACIONES;
    }
}
