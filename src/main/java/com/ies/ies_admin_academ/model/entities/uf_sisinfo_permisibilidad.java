package com.ies.ies_admin_academ.model.entities;

public class uf_sisinfo_permisibilidad {

    private String username;
    private String app_name;
    private boolean permission;

    public uf_sisinfo_permisibilidad() {
    }

    public uf_sisinfo_permisibilidad(String username, String app_name, boolean permission) {
        this.username = username;
        this.app_name = app_name;
        this.permission = permission;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
