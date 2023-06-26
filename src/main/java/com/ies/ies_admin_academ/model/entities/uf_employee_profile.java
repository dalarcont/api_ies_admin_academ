package com.ies.ies_admin_academ.model.entities;

import java.io.Serializable;

/*
* Model/Entity used for validate an existence of a user by its username and password
* ONLY WORKS FOR DESKTOP APP ENVIRONMENT AND VALIDATION OF ADMIN PEOPLE ROLE
* */
public class uf_employee_profile extends uf_user_profile implements Serializable {

    private int deskapp;
    private String lastAccess;
    private String departamento;
    private String area;
    private String cargo;
    private String contratacion;
    private String estado; //It means the employee's contractual status
    private String tipopersonal;

    public uf_employee_profile(){
        super();
    }

    public uf_employee_profile(String fechaRegistro, String idPersona, String nombres, String apellidos, String username, String genero, String email_laboral, String email_personal, String origen_pais, String origen_ciudad, String reside_pais, String reside_ciudad, String escolaridad, String pkeyusuario, String recovery_quest, String recovery_ans, int deskapp_access, String lastAccess, String departamento, String area, String cargo, String contratacion, String estado, String tipopersonal) {
        super(fechaRegistro, idPersona, nombres, apellidos, username, genero, email_laboral, email_personal, origen_pais, origen_ciudad, reside_pais, reside_ciudad, escolaridad, pkeyusuario, recovery_quest, recovery_ans);
        this.deskapp = deskapp_access;
        this.lastAccess = lastAccess;
        this.departamento = departamento;
        this.area = area;
        this.cargo = cargo;
        this.contratacion = contratacion;
        this.estado = estado;
        this.tipopersonal = tipopersonal;
    }

    public int getDeskapp() {
        return deskapp;
    }

    public void setDeskapp(int deskapp) {
        this.deskapp = deskapp;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContratacion() {
        return contratacion;
    }

    public void setContratacion(String contratacion) {
        this.contratacion = contratacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipopersonal() {
        return tipopersonal;
    }

    public void setTipopersonal(String tipopersonal) {
        this.tipopersonal = tipopersonal;
    }
}
