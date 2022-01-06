package com.countdown.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtils 
{
	
	public static void sendEmail(String fromEmail, String toEmail,String filename)
	{

		// Recipient's email ID needs to be mentioned.
	    String to = toEmail;
	    // Sender's email ID needs to be mentioned
	    String from = fromEmail;
	  
	    // Get system properties
	    Properties properties = System.getProperties();
	    // Setup mail server
	    properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	    properties.setProperty("mail.smtp.starttls.enable","true");
	    properties.setProperty("mail.smtp.port", "587");
	    
	    //properties.put("mail.smtp.auth", "false");
	    //properties.put("mail.smtp.auth", "true");

	    properties.setProperty("mail.smtp.user", "aavinaspande");
	    properties.setProperty("mail.smtp.password", "Avishka14#");
	    properties.setProperty("mail.smtp.auth", "true"); 
	    // Get the default Session object.
	    Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() 
	    {
	        protected PasswordAuthentication getPasswordAuthentication() 
	        {
	            return new PasswordAuthentication("aavinashpande@gmail.com","Avishka14#");
	        }
	   });

	    try{
	       // Create a default MimeMessage object.
	       MimeMessage message = new MimeMessage(session);
	       // Set From: header field of the header.
	       message.setFrom(new InternetAddress(from));
	       // Set To: header field of the header.
	       message.addRecipient(Message.RecipientType.TO,
	                                new InternetAddress(to));

	       // Set Subject: header field
	       message.setSubject("CountDownTimer Test Execution Report");

	       // Create the message part 
	       BodyPart messageBodyPart = new MimeBodyPart();

	       // Fill the message
	       messageBodyPart.setText("HI All <br> Please find the attached report of Test execution.");

	       // Create a multipar message
	       Multipart multipart = new MimeMultipart();

	       // Set text message part
	       multipart.addBodyPart(messageBodyPart);

	       // Part two is attachment
	       messageBodyPart = new MimeBodyPart();
	       //String filename = "E:\\Selenium\\SeleniumResources\\SeleniumData\\Hotelapp.xlsx";
	       DataSource source = new FileDataSource(filename);
	       messageBodyPart.setDataHandler(new DataHandler(source));
	       messageBodyPart.setFileName(filename);
	       multipart.addBodyPart(messageBodyPart);

	       // Send the complete message parts
	       message.setContent(multipart );
	       Transport transport = session.getTransport("smtp");
	       transport.connect(null, "aavinashpande@gmail.com","Avishka14#");
	       // Send message
	       Transport.send(message);
	       System.out.println("Sent message successfully....");
	    }catch (MessagingException mex) {
	  	  System.out.println(mex.getMessage());
	       mex.printStackTrace();
	    }


	}

}
