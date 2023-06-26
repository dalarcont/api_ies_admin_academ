package com.ies.ies_admin_academ.model.entities;

public class uf_sisinfo_userapps {

    private String username;
    private String appcode;
    private boolean permission;
    private String appname;
    private String appdescription;
    private int treelevel;

    public uf_sisinfo_userapps() {
    }

    public uf_sisinfo_userapps(String user, String appcode, boolean permission, String appname, String appdescr, int treelevel) {
        this.username = user;
        this.appcode = appcode;
        this.permission = permission;
        this.appname = appname;
        this.appdescription = appdescr;
        this.treelevel = treelevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAppdescription() {
        return appdescription;
    }

    public void setAppdescription(String appdescription) {
        this.appdescription = appdescription;
    }

    public int getTreelevel() {
        return treelevel;
    }

    public void setTreelevel(int treelevel) {
        this.treelevel = treelevel;
    }
}
