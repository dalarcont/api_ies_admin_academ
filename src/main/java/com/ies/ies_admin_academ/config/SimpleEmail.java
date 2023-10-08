package com.ies.ies_admin_academ.config;

import javax.mail.Session;
import java.util.Properties;

public class SimpleEmail {

    public void emailSender(String srcMail, String srcName, String rcpnt, String subjct, String body) {

        System.out.println("SimpleEmail Start");

        String smtpHostServer = "192.168.80.135";
        String emailID = rcpnt;

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        EmailUtil.sendEmail(session, srcMail, srcName, emailID,subjct, body);
    }

}
