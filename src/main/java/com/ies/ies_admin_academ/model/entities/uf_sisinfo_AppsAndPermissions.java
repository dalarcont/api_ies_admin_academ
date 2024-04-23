package com.ies.ies_admin_academ.model.entities;

public class uf_sisinfo_AppsAndPermissions {

    //DB Attributes of uf_sisinfo_apps
    private String APP_CODE;
    private String APP_NAME;
    private String APP_DESCR;
    private int APP_TREE_LEVEL;
    //DB Attributes of uf_sisinfo_permisos
    private String COD_USUARIO;
    private boolean APP_PERMISSION;

    public uf_sisinfo_AppsAndPermissions() {
    }

    public uf_sisinfo_AppsAndPermissions(String APP_CODE, String APP_NAME, String APP_DESCR, int APP_TREE_LEVEL, String COD_USUARIO, boolean APP_PERMISSION) {
        this.APP_CODE = APP_CODE;
        this.APP_NAME = APP_NAME;
        this.APP_DESCR = APP_DESCR;
        this.APP_TREE_LEVEL = APP_TREE_LEVEL;
        this.COD_USUARIO = COD_USUARIO;
        this.APP_PERMISSION = APP_PERMISSION;
    }

    public String getAPP_CODE() {
        return APP_CODE;
    }

    public void setAPP_CODE(String APP_CODE) {
        this.APP_CODE = APP_CODE;
    }

    public String getAPP_NAME() {
        return APP_NAME;
    }

    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME;
    }

    public String getAPP_DESCR() {
        return APP_DESCR;
    }

    public void setAPP_DESCR(String APP_DESCR) {
        this.APP_DESCR = APP_DESCR;
    }

    public int getAPP_TREE_LEVEL() {
        return APP_TREE_LEVEL;
    }

    public void setAPP_TREE_LEVEL(int APP_TREE_LEVEL) {
        this.APP_TREE_LEVEL = APP_TREE_LEVEL;
    }

    public String getCOD_USUARIO() {
        return COD_USUARIO;
    }

    public void setCOD_USUARIO(String COD_USUARIO) {
        this.COD_USUARIO = COD_USUARIO;
    }

    public boolean getAPP_PERMISSION() {
        return APP_PERMISSION;
    }

    public void setAPP_PERMISSION(boolean APP_PERMISSION) {
        this.APP_PERMISSION = APP_PERMISSION;
    }
}
