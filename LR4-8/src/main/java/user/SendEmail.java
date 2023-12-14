package user;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void sendMessage(String error) throws Exception {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.3");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kartoshka8800@gmail.com", "ztuj xacq fvkx yieh");
            }
        };

        Session session = Session.getInstance(properties, auth);

        MimeMessage message = new MimeMessage(session);

        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");

        message.setFrom(new InternetAddress("kartoshka8800@gmail.com"));
        message.setReplyTo(InternetAddress.parse("kartoshka8800@gmail.com", false));
        message.setSubject("The critical error occurred", "UTF-8");
        message.setText(error, "UTF-8");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("kartoshka8800@gmail.com"));

        Transport.send(message);
        System.out.println("Message was sent successfully...");
    }
}