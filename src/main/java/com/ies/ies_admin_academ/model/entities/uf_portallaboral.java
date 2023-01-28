package com.ies.ies_admin_academ.model.entities;

import java.io.Serializable;

/*
* Model/Entity used for validate an existence of an user by its username and password
* ONLY WORKS FOR DESKTOP APP ENVIRONMENT AND VALIDATION OF ADMIN PEOPLE ROLE
* */
public class uf_portallaboral implements Serializable {

    private String username;
    private String password;
    private String recovery_quest;
    private String recovery_ans;
    private int deskapp_access;

    public uf_portallaboral() {}

    public uf_portallaboral(String username, String password, String recovery_quest, String recovery_ans, int deskapp_access){
        this.username = username;
        this.password = password;
        this.recovery_quest = recovery_quest;
        this.recovery_ans = recovery_ans;
        this.deskapp_access = deskapp_access;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecovery_quest() {
        return recovery_quest;
    }

    public void setRecovery_quest(String recovery_quest) {
        this.recovery_quest = recovery_quest;
    }

    public String getRecovery_ans() {
        return recovery_ans;
    }

    public void setRecovery_ans(String recovery_ans) {
        this.recovery_ans = recovery_ans;
    }

    public int isDeskapp_access() {
        return deskapp_access;
    }

    public void setDeskapp_access(int deskapp_access) {
        this.deskapp_access = deskapp_access;
    }
}
