package com.ies.ies_admin_academ.config;

import com.ies.ies_admin_academ.model.entities.IES_EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Properties;
@Configuration
@PropertySource("classpath:application.properties")
public class EmailUtil {
    @Autowired
    private Environment env;
    private static Environment environment;

    @PostConstruct
    public void init() {
        //
        environment = env;
    }

    /**
     * Utility method to send simple HTML email
     * @param emailModel Object with email attributes
     */
    public void sendEmail(IES_EmailModel emailModel){

        //Session data
        Properties props = System.getProperties();
        System.out.println(environment.getProperty("mail.smtp.host").toString());
        props.put("mail.smtp.host",environment.getProperty("mail.smtp.host"));
        Session session = Session.getInstance(props,null);
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(emailModel.getSenderMail(),emailModel.getSenderName()));

            msg.setReplyTo(InternetAddress.parse("noreply@unifalsa.com", false));

            msg.setSubject(emailModel.getSubject(), "UTF-8");

            msg.setText(emailModel.getBody(), "UTF-8","html");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailModel.getDestination(), false));
            Transport.send(msg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

