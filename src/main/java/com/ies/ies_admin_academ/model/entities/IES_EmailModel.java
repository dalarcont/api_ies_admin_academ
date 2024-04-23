package com.ies.ies_admin_academ.model.entities;

public class IES_EmailModel {
    private String senderName;
    private String senderMail;
    private String destination;
    private String subject;
    private String body;
    private boolean isHtml;

    public IES_EmailModel(String senderName, String senderMail, String destination, String subject, String body, boolean isHtml) {
        this.senderName = senderName;
        this.senderMail = senderMail;
        this.destination = destination;
        this.subject = subject;
        this.body = body;
        this.isHtml = isHtml;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }
}
