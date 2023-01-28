package com.ies.ies_admin_academ.model.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class uf_userprofile {

    private String fechaRegistro;
    private String idPersona;
    private String nombres;
    private String apellidos;
    private String username;
    private String genero;
    private String emailLaboral;
    private String origenPais; private String origenCiudad; private String residePais; private String resideCiudad;
    private String escolaridad;
    private String pkeyUsuario;
    private String recuperarPregunta;
    private String recuperarRespuesta;
    private String nivelCargo;
    private String nombreCargo;
    private String nombreUnidad;
    private String ultimoAcceso;

    public uf_userprofile() {
    }

    public uf_userprofile(String fechaRegistro, String idPersona, String nombres, String apellidos, String username, String genero, String emailLaboral, String origenPais, String origenCiudad, String residePais, String resideCiudad, String escolaridad, String pkeyUsuario, String recuperarPregunta, String recuperarRespuesta, String nivelCargo, String nombreCargo, String nombreUnidad, String ultimoAcceso) {
        this.fechaRegistro = fechaRegistro;
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.genero = genero;
        this.emailLaboral = emailLaboral;
        this.origenPais = origenPais;
        this.origenCiudad = origenCiudad;
        this.residePais = residePais;
        this.resideCiudad = resideCiudad;
        this.escolaridad = escolaridad;
        this.pkeyUsuario = pkeyUsuario;
        this.recuperarPregunta = recuperarPregunta;
        this.recuperarRespuesta = recuperarRespuesta;
        this.nivelCargo = nivelCargo;
        this.nombreCargo = nombreCargo;
        this.nombreUnidad = nombreUnidad;
        this.ultimoAcceso = ultimoAcceso;
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

    public String getEmailLaboral() {
        return emailLaboral;
    }

    public void setEmailLaboral(String emailLaboral) {
        this.emailLaboral = emailLaboral;
    }

    public String getOrigenPais() {
        return origenPais;
    }

    public void setOrigenPais(String origenPais) {
        this.origenPais = origenPais;
    }

    public String getOrigenCiudad() {
        return origenCiudad;
    }

    public void setOrigenCiudad(String origenCiudad) {
        this.origenCiudad = origenCiudad;
    }

    public String getResidePais() {
        return residePais;
    }

    public void setResidePais(String residePais) {
        this.residePais = residePais;
    }

    public String getResideCiudad() {
        return resideCiudad;
    }

    public void setResideCiudad(String resideCiudad) {
        this.resideCiudad = resideCiudad;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getPkeyUsuario() {
        return pkeyUsuario;
    }

    public String getRecuperarPregunta() {
        return recuperarPregunta;
    }

    public String getRecuperarRespuesta() {
        return recuperarRespuesta;
    }

    public void setPkeyUsuario(String pkeyUsuario) {
        this.pkeyUsuario = pkeyUsuario;
    }

    public void setRecuperarPregunta(String recuperarPregunta) {
        this.recuperarPregunta = recuperarPregunta;
    }

    public void setRecuperarRespuesta(String recuperarRespuesta) {
        this.recuperarRespuesta = recuperarRespuesta;
    }

    public String getUltimoAcceso() {
        DateFormat df = new SimpleDateFormat(ultimoAcceso);
        return df.format(Calendar.getInstance().getTime());
    }

    public void setUltimoAcceso(String ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
}
