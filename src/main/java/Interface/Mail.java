/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author charleswong
 */
public class Mail {
    
    public static void main(String[] args) {
        
        String to = "junjungoodboy@gmail.com"; 
        String from = "charleswongxox@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
           
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("charleswongxox@gmail.com", "12345abcde@");

            }

        });
        
        session.setDebug(true);
        
        try {
            
            MimeMessage message = new MimeMessage(session);

            
            message.setFrom(new InternetAddress(from));

            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Sent From Java");

            // Now set the actual message
            message.setText("Hi I am Charles. For my Computer Science IA, "
                    + "being able to send mail will give me a lor of points, "
                    + "therefore, I am implementing the mail system. "
                    +"So you can tell me if you recive this. "
                    + "P.S. i have already tried, but just to let you know :p");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
