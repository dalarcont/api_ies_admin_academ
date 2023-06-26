package com.ies.ies_admin_academ.model.entities;

import java.io.Serializable;

public class uf_student_profile extends uf_user_profile implements Serializable {

    private String fechaIngreso;
    private String estadoGeneral;
    private int puntajeIngreso;
    private String ultimoProgramaMatriculado;
    private boolean portalAccess;
    private String lastAccess;

    public uf_student_profile(){super();}

    public uf_student_profile(String fechaRegistro, String idPersona, String nombres, String apellidos, String username, String genero, String email_laboral, String email_personal, String origen_pais, String origen_ciudad, String reside_pais, String reside_ciudad, String escolaridad, String pkeyusuario, String recovery_quest, String recovery_ans, String fechaIngreso, String estadoGeneral, int puntajeIngreso, String ultimoProgramaMatriculado, boolean portalAccess, String lastAccess) {
        super(fechaRegistro, idPersona, nombres, apellidos, username, genero, email_laboral, email_personal, origen_pais, origen_ciudad, reside_pais, reside_ciudad, escolaridad, pkeyusuario, recovery_quest, recovery_ans);
        this.fechaIngreso = fechaIngreso;
        this.estadoGeneral = estadoGeneral;
        this.puntajeIngreso = puntajeIngreso;
        this.ultimoProgramaMatriculado = ultimoProgramaMatriculado;
        this.portalAccess = portalAccess;
        this.lastAccess = lastAccess;
    }

    public boolean isPortalAccess() {
        return portalAccess;
    }

    public void setPortalAccess(boolean portalAccess) {
        this.portalAccess = portalAccess;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(String estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public int getPuntajeIngreso() {
        return puntajeIngreso;
    }

    public void setPuntajeIngreso(int puntajeIngreso) {
        this.puntajeIngreso = puntajeIngreso;
    }

    public String getUltimoProgramaMatriculado() {
        return ultimoProgramaMatriculado;
    }

    public void setUltimoProgramaMatriculado(String ultimoProgramaMatriculado) {
        this.ultimoProgramaMatriculado = ultimoProgramaMatriculado;
    }

}
