package com.ies.ies_admin_academ.model.entities;

import java.io.Serializable;

public class user_loginvalidation implements Serializable {
    private String usr;
    private String pkey;

    public user_loginvalidation(){}

    public user_loginvalidation(String usr, String pkey) {
        this.usr = usr;
        this.pkey = pkey;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }
}
