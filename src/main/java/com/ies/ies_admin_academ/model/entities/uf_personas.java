package com.ies.ies_admin_academ.model.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class uf_personas {

    //Properties as DDBB properties
    private int PRSN_REG;
    private String PRSN_FEC_REG;
    private String PRSN_ID;
    private String PRSN_NOM;
    private String PRSN_APE;
    private String PRSN_USUARIO;
    private String PRSN_GEN;
    private String PRSN_EMAIL_PERSONAL;
    private String PRSN_EMAIL_LABORAL;
    private String PRSN_ORIGEN_PAIS;
    private String PRSN_ORIGEN_CIUDAD;
    private String PRSN_RESIDE_PAIS;
    private String PRSN_RESIDE_CIUDAD;
    private String PRSN_ESCOLARIDAD;
    private String PRSN_PKEY;
    private String PRSN_RECOVERY_QUEST;
    private String PRSN_RECOVERY_ANS;

    //Custom properties created by the original properties with its codes given
    private String PRSN_GEN_NOM;
    private String PRSN_ORIGEN_PAIS_NOM;
    private String PRSN_ORIGEN_RESIDE_NOM;
    private String PRSN_ESCOLARIDAD_NOM;

    public uf_personas() {
    }

    @JsonCreator
    //@JsonPropertyOrder(value = {"PRSN_REG","PRSN_FEC_REG","PRSN_ID","PRSN_NOM","PRSN_APE","PRSN_USUARIO","PRSN_GEN","PRSN_EMAIL_PERSONAL","PRSN_EMAIL_LABORAL","PRSN_ORIGEN_PAIS","PRSN_ORIGEN_CIUDAD","PRSN_RESIDE_PAIS","PRSN_RESIDE_CIUDAD","PRSN_ESCOLARIDAD","PRSN_PKEY","PRSN_RECOVERY_QUEST","PRSN_RECOVERY_ANS"})
    public uf_personas(int PRSN_REG, String PRSN_FEC_REG, String PRSN_ID, String PRSN_NOM, String PRSN_APE, String PRSN_USUARIO, String PRSN_GEN, String PRSN_EMAIL_PERSONAL, String PRSN_EMAIL_LABORAL, String PRSN_ORIGEN_PAIS, String PRSN_ORIGEN_CIUDAD, String PRSN_RESIDE_PAIS, String PRSN_RESIDE_CIUDAD, String PRSN_ESCOLARIDAD, String PRSN_PKEY, String PRSN_RECOVERY_QUEST, String PRSN_RECOVERY_ANS, String PRSN_GEN_NOM, String PRSN_ORIGEN_PAIS_NOM, String PRSN_ORIGEN_RESIDE_NOM, String PRSN_ESCOLARIDAD_NOM) {
        this.PRSN_REG = PRSN_REG;
        this.PRSN_FEC_REG = PRSN_FEC_REG;
        this.PRSN_ID = PRSN_ID;
        this.PRSN_NOM = PRSN_NOM;
        this.PRSN_APE = PRSN_APE;
        this.PRSN_USUARIO = PRSN_USUARIO;
        this.PRSN_GEN = PRSN_GEN;
        this.PRSN_EMAIL_PERSONAL = PRSN_EMAIL_PERSONAL;
        this.PRSN_EMAIL_LABORAL = PRSN_EMAIL_LABORAL;
        this.PRSN_ORIGEN_PAIS = PRSN_ORIGEN_PAIS;
        this.PRSN_ORIGEN_CIUDAD = PRSN_ORIGEN_CIUDAD;
        this.PRSN_RESIDE_PAIS = PRSN_RESIDE_PAIS;
        this.PRSN_RESIDE_CIUDAD = PRSN_RESIDE_CIUDAD;
        this.PRSN_ESCOLARIDAD = PRSN_ESCOLARIDAD;
        this.PRSN_PKEY = PRSN_PKEY;
        this.PRSN_RECOVERY_QUEST = PRSN_RECOVERY_QUEST;
        this.PRSN_RECOVERY_ANS = PRSN_RECOVERY_ANS;
        this.PRSN_GEN_NOM = PRSN_GEN_NOM;
        this.PRSN_ORIGEN_PAIS_NOM = PRSN_ORIGEN_PAIS_NOM;
        this.PRSN_ORIGEN_RESIDE_NOM = PRSN_ORIGEN_RESIDE_NOM;
        this.PRSN_ESCOLARIDAD_NOM = PRSN_ESCOLARIDAD_NOM;
    }

    public int getPRSN_REG() {
        return PRSN_REG;
    }

    public void setPRSN_REG(int PRSN_REG) {
        this.PRSN_REG = PRSN_REG;
    }

    public String getPRSN_FEC_REG() {
        return PRSN_FEC_REG;
    }

    public void setPRSN_FEC_REG(String PRSN_FEC_REG) {
        this.PRSN_FEC_REG = PRSN_FEC_REG;
    }

    public String getPRSN_ID() {
        return PRSN_ID;
    }

    public void setPRSN_ID(String PRSN_ID) {
        this.PRSN_ID = PRSN_ID;
    }

    public String getPRSN_NOM() {
        return PRSN_NOM;
    }

    public void setPRSN_NOM(String PRSN_NOM) {
        this.PRSN_NOM = PRSN_NOM;
    }

    public String getPRSN_APE() {
        return PRSN_APE;
    }

    public void setPRSN_APE(String PRSN_APE) {
        this.PRSN_APE = PRSN_APE;
    }

    public String getPRSN_USUARIO() {
        return PRSN_USUARIO;
    }

    public void setPRSN_USUARIO(String PRSN_USUARIO) {
        this.PRSN_USUARIO = PRSN_USUARIO;
    }

    public String getPRSN_GEN() {
        return PRSN_GEN;
    }

    public void setPRSN_GEN(String PRSN_GEN) {
        this.PRSN_GEN = PRSN_GEN;
    }

    public String getPRSN_EMAIL_PERSONAL() {
        return PRSN_EMAIL_PERSONAL;
    }

    public void setPRSN_EMAIL_PERSONAL(String PRSN_EMAIL_PERSONAL) {
        this.PRSN_EMAIL_PERSONAL = PRSN_EMAIL_PERSONAL;
    }

    public String getPRSN_EMAIL_LABORAL() {
        return PRSN_EMAIL_LABORAL;
    }

    public void setPRSN_EMAIL_LABORAL(String PRSN_EMAIL_LABORAL) {
        this.PRSN_EMAIL_LABORAL = PRSN_EMAIL_LABORAL;
    }

    public String getPRSN_ORIGEN_PAIS() {
        return PRSN_ORIGEN_PAIS;
    }

    public void setPRSN_ORIGEN_PAIS(String PRSN_ORIGEN_PAIS) {
        this.PRSN_ORIGEN_PAIS = PRSN_ORIGEN_PAIS;
    }

    public String getPRSN_ORIGEN_CIUDAD() {
        return PRSN_ORIGEN_CIUDAD;
    }

    public void setPRSN_ORIGEN_CIUDAD(String PRSN_ORIGEN_CIUDAD) {
        this.PRSN_ORIGEN_CIUDAD = PRSN_ORIGEN_CIUDAD;
    }

    public String getPRSN_RESIDE_PAIS() {
        return PRSN_RESIDE_PAIS;
    }

    public void setPRSN_RESIDE_PAIS(String PRSN_RESIDE_PAIS) {
        this.PRSN_RESIDE_PAIS = PRSN_RESIDE_PAIS;
    }

    public String getPRSN_RESIDE_CIUDAD() {
        return PRSN_RESIDE_CIUDAD;
    }

    public void setPRSN_RESIDE_CIUDAD(String PRSN_RESIDE_CIUDAD) {
        this.PRSN_RESIDE_CIUDAD = PRSN_RESIDE_CIUDAD;
    }

    public String getPRSN_ESCOLARIDAD() {
        return PRSN_ESCOLARIDAD;
    }

    public void setPRSN_ESCOLARIDAD(String PRSN_ESCOLARIDAD) {
        this.PRSN_ESCOLARIDAD = PRSN_ESCOLARIDAD;
    }

    public String getPRSN_PKEY() {
        return PRSN_PKEY;
    }

    public void setPRSN_PKEY(String PRSN_PKEY) {
        this.PRSN_PKEY = PRSN_PKEY;
    }

    public String getPRSN_RECOVERY_QUEST() {
        return PRSN_RECOVERY_QUEST;
    }

    public void setPRSN_RECOVERY_QUEST(String PRSN_RECOVERY_QUEST) {
        this.PRSN_RECOVERY_QUEST = PRSN_RECOVERY_QUEST;
    }

    public String getPRSN_RECOVERY_ANS() {
        return PRSN_RECOVERY_ANS;
    }

    public void setPRSN_RECOVERY_ANS(String PRSN_RECOVERY_ANS) {
        this.PRSN_RECOVERY_ANS = PRSN_RECOVERY_ANS;
    }

    public String getPRSN_GEN_NOM() {
        return PRSN_GEN_NOM;
    }

    public void setPRSN_GEN_NOM(String PRSN_GEN_NOM) {
        this.PRSN_GEN_NOM = PRSN_GEN_NOM;
    }

    public String getPRSN_ORIGEN_PAIS_NOM() {
        return PRSN_ORIGEN_PAIS_NOM;
    }

    public void setPRSN_ORIGEN_PAIS_NOM(String PRSN_ORIGEN_PAIS_NOM) {
        this.PRSN_ORIGEN_PAIS_NOM = PRSN_ORIGEN_PAIS_NOM;
    }

    public String getPRSN_ORIGEN_RESIDE_NOM() {
        return PRSN_ORIGEN_RESIDE_NOM;
    }

    public void setPRSN_ORIGEN_RESIDE_NOM(String PRSN_ORIGEN_RESIDE_NOM) {
        this.PRSN_ORIGEN_RESIDE_NOM = PRSN_ORIGEN_RESIDE_NOM;
    }

    public String getPRSN_ESCOLARIDAD_NOM() {
        return PRSN_ESCOLARIDAD_NOM;
    }

    public void setPRSN_ESCOLARIDAD_NOM(String PRSN_ESCOLARIDAD_NOM) {
        this.PRSN_ESCOLARIDAD_NOM = PRSN_ESCOLARIDAD_NOM;
    }
}
