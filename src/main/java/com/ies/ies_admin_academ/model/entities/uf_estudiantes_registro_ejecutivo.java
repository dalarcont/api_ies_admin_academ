package com.ies.ies_admin_academ.model.entities;

public class uf_estudiantes_registro_ejecutivo {

    private int REG_NUM ;
    private String COD_ESTUDIANTE;
    private String FEC_REG;
    private String REG_APPSET;
    private String REG_ACTION_DESCR;

    public uf_estudiantes_registro_ejecutivo() {
    }

    public uf_estudiantes_registro_ejecutivo(int REG_NUM, String COD_ESTUDIANTE, String FEC_REG, String REG_APPSET, String REG_ACTION_DESCR) {
        this.REG_NUM = REG_NUM;
        this.COD_ESTUDIANTE = COD_ESTUDIANTE;
        this.FEC_REG = FEC_REG;
        this.REG_APPSET = REG_APPSET;
        this.REG_ACTION_DESCR = REG_ACTION_DESCR;
    }

    public int getREG_NUM() {
        return REG_NUM;
    }

    public void setREG_NUM(int REG_NUM) {
        this.REG_NUM = REG_NUM;
    }

    public String getCOD_ESTUDIANTE() {
        return COD_ESTUDIANTE;
    }

    public void setCOD_ESTUDIANTE(String COD_ESTUDIANTE) {
        this.COD_ESTUDIANTE = COD_ESTUDIANTE;
    }

    public String getFEC_REG() {
        return FEC_REG;
    }

    public void setFEC_REG(String FEC_REG) {
        this.FEC_REG = FEC_REG;
    }

    public String getREG_APPSET() {
        return REG_APPSET;
    }

    public void setREG_APPSET(String REG_APPSET) {
        this.REG_APPSET = REG_APPSET;
    }

    public String getREG_ACTION_DESCR() {
        return REG_ACTION_DESCR;
    }

    public void setREG_ACTION_DESCR(String REG_ACTION_DESCR) {
        this.REG_ACTION_DESCR = REG_ACTION_DESCR;
    }
}
