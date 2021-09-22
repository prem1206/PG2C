package com.barclays.acc.service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class MailServiceImpl
{
 public static void sendMail(String toemail, String subject, String body) {

    Properties prop = new Properties();
    prop.put("mail.smtp.auth", true);
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", "smtp.mailtrap.io");
    prop.put("mail.smtp.port", "2525");
    prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
    Session session = Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("b1bf9319153b57", "e96090a6463228");
        }
    });

    try
    {
    	Message message = new MimeMessage(session);
    	message.setFrom(new InternetAddress("support@pg2c.com"));
    	message.setRecipients(
    	  Message.RecipientType.TO, InternetAddress.parse(toemail));
    	message.setSubject(subject);

    	String msg = body;

    	MimeBodyPart mimeBodyPart = new MimeBodyPart();
    	mimeBodyPart.setContent(msg, "text/html");

    	Multipart multipart = new MimeMultipart();
    	multipart.addBodyPart(mimeBodyPart);

    	message.setContent(multipart);

    	Transport.send(message);
    	System.out.println("Mail sent successfully");
    }
    catch (MessagingException mex)
    {
        mex.printStackTrace();
    }
 }

}