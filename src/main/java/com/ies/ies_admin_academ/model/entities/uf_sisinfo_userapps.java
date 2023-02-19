package com.ies.ies_admin_academ.model.entities;

public class uf_sisinfo_userapps {

    private String user;
    private String appcode;
    private boolean permission;
    private String appname;
    private String appdescr;
    private int treelevel;

    public uf_sisinfo_userapps() {
    }

    public uf_sisinfo_userapps(String user, String appcode, boolean permission, String appname, String appdescr, int treelevel) {
        this.user = user;
        this.appcode = appcode;
        this.permission = permission;
        this.appname = appname;
        this.appdescr = appdescr;
        this.treelevel = treelevel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppdescr() {
        return appdescr;
    }

    public void setAppdescr(String appdescr) {
        this.appdescr = appdescr;
    }

    public int getTreelevel() {
        return treelevel;
    }

    public void setTreelevel(int treelevel) {
        this.treelevel = treelevel;
    }
}
