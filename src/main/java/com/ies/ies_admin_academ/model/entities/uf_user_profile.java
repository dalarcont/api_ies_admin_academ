package com.ies.ies_admin_academ.model.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class uf_user_profile {

    private String fechaRegistro;
    private String idPersona;
    private String nombres;
    private String apellidos;
    private String username;
    private String genero;
    private String email_laboral;
    private String email_personal;
    private String origen_pais; private String origen_ciudad; private String reside_pais; private String reside_ciudad;
    private String escolaridad;
    private String pkeyusuario;
    private String recuperar_pregunta;
    private String recuperar_respuesta;

    public uf_user_profile() {
    }

    @JsonCreator
    public uf_user_profile(String fechaRegistro, String idPersona, String nombres, String apellidos, String username, String genero, String email_laboral, String email_personal, String origen_pais, String origen_ciudad, String reside_pais, String reside_ciudad, String escolaridad, String pkeyusuario, String recovery_quest, String recovery_ans) {
        this.fechaRegistro = fechaRegistro;
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.genero = genero;
        this.email_laboral = email_laboral;
        this.email_personal = email_personal;
        this.origen_pais = origen_pais;
        this.origen_ciudad = origen_ciudad;
        this.reside_pais = reside_pais;
        this.reside_ciudad = reside_ciudad;
        this.escolaridad = escolaridad;
        this.pkeyusuario = pkeyusuario;
        this.recuperar_pregunta = recovery_quest;
        this.recuperar_respuesta = recovery_ans;
    }

    public String getFechaRegistro() {
        DateFormat df = new SimpleDateFormat(fechaRegistro);
        return df.format(Calendar.getInstance().getTime());
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail_laboral() {
        return email_laboral;
    }

    public void setEmail_laboral(String email_laboral) {
        this.email_laboral = email_laboral;
    }

    public String getEmail_personal() {
        return email_personal;
    }

    public void setEmail_personal(String email_personal) {
        this.email_personal = email_personal;
    }

    public String getOrigen_pais() {
        return origen_pais;
    }

    public void setOrigen_pais(String origen_pais) {
        this.origen_pais = origen_pais;
    }

    public String getOrigen_ciudad() {
        return origen_ciudad;
    }

    public void setOrigen_ciudad(String origen_ciudad) {
        this.origen_ciudad = origen_ciudad;
    }

    public String getReside_pais() {
        return reside_pais;
    }

    public void setReside_pais(String reside_pais) {
        this.reside_pais = reside_pais;
    }

    public String getReside_ciudad() {
        return reside_ciudad;
    }

    public void setReside_ciudad(String reside_ciudad) {
        this.reside_ciudad = reside_ciudad;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getPkeyusuario() {
        return pkeyusuario;
    }

    public void setPkeyusuario(String pkeyusuario) {
        this.pkeyusuario = pkeyusuario;
    }

    public String getRecuperar_pregunta() {
        return recuperar_pregunta;
    }

    public void setRecuperar_pregunta(String recuperar_pregunta) {
        this.recuperar_pregunta = recuperar_pregunta;
    }

    public String getRecuperar_respuesta() {
        return recuperar_respuesta;
    }

    public void setRecuperar_respuesta(String recuperar_respuesta) {
        this.recuperar_respuesta = recuperar_respuesta;
    }
}
