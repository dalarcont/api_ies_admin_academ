package com.ies.ies_admin_academ.model.entities;

public class uf_appstates {

    private String APP_CODE;
    private String APP_STATE;
    private String APP_ST_MSG;
    //
    private String APP_STATE_NOM;

    public uf_appstates() {
    }

    public uf_appstates(String APP_CODE, String APP_STATE, String APP_ST_MSG, String APP_STATE_NOM) {
        this.APP_CODE = APP_CODE;
        this.APP_STATE = APP_STATE;
        this.APP_ST_MSG = APP_ST_MSG;
        this.APP_STATE_NOM = APP_STATE_NOM;
    }

    public String getAPP_CODE() {
        return APP_CODE;
    }

    public void setAPP_CODE(String APP_CODE) {
        this.APP_CODE = APP_CODE;
    }

    public String getAPP_STATE() {
        return APP_STATE;
    }

    public void setAPP_STATE(String APP_STATE) {
        this.APP_STATE = APP_STATE;
    }

    public String getAPP_ST_MSG() {
        return APP_ST_MSG;
    }

    public void setAPP_ST_MSG(String APP_ST_MSG) {
        this.APP_ST_MSG = APP_ST_MSG;
    }

    public String getAPP_STATE_NOM() {
        return APP_STATE_NOM;
    }

    public void setAPP_STATE_NOM(String APP_STATE_NOM) {
        this.APP_STATE_NOM = APP_STATE_NOM;
    }
}
