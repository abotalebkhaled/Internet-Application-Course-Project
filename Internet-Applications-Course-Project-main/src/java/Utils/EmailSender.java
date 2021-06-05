package Utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender
{

    // Sender's email ID needs to be mentioned
    private static final String FROM = "mahmoudaahmedd@gmail.com";
    private static final String NAME = "Hotel Reservation System";
    private static final String PASSWORD = "01014103328m";
    
    // Mail server
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "465";
    private static final String CLASS = "javax.net.ssl.SSLSocketFactory";
    private static final String AUTH = "true";

    
    public static void send(String _to, String _subject, String _body)
    {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", EmailSender.HOST);  
        properties.put("mail.smtp.socketFactory.port", EmailSender.PORT);
        properties.put("mail.smtp.socketFactory.class", EmailSender.CLASS);
        properties.put("mail.smtp.auth", EmailSender.AUTH);
        properties.put("mail.smtp.port", EmailSender.PORT);

        // Get the default Session object.
        Session session = Session.getInstance(properties,    
          new javax.mail.Authenticator()
          {    
            protected PasswordAuthentication getPasswordAuthentication()
            {    
                return new PasswordAuthentication(EmailSender.FROM, EmailSender.PASSWORD);  
            }
          }
        );
        
        try
        {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(EmailSender.FROM, EmailSender.NAME));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(_to));

            // Set Subject: header field
            message.setSubject(_subject);

            // Send the actual HTML message, as big as you like
            message.setContent(_body, "text/html");

            // Send message
            Transport.send(message);
        }
        catch (Exception _e)
        {
            _e.printStackTrace();
        }
    }
}
