package com.lcwd;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "preparing to send message....." );
        
        String message = "Hello, Dear this is message for security check.";
        String subject = "CodersArea : Confirmation";
        String to = "ak5338837@gmail.com";
        String from = "aksoft51@gmail.com";
        
   //     sendEmail(message,subject,to,from);
        sendAttach(message,subject,to,from);
    }
      
    //this is reponsible to send the message with attachment
    private static void sendAttach(String message, String subject, String to, String from) {
		
    	//variable for gmail
		
    			String host= "smtp.gmail.com";
    			
    			//get the system properties
    			Properties properties = System.getProperties();
    		    	System.out.println("PROPERTIES"+properties);
    		    	
    		    	//setting important info to properties object
    		    	
    		    	
    		    	//host set
    		    	properties.put("mail.smtp.host", host);
    		    	properties.put("mail.smtp.port","465" );
    		    	properties.put("mail.smtp.ssl.enable", "true");
    		    	properties.put("mail.smtp.auth", "true");
    		    	
    		    	
    		    	//step1 : to get the session object
    		    	Session session = Session.getInstance(properties,new Authenticator() {
    		    		@Override
    		    		protected PasswordAuthentication getPasswordAuthentication() {
    		    			return new PasswordAuthentication("aksoft51@gmail.com","pvbgxbcnndxiilrs");
    		    		}
    		    	});
    		    	
    		    	session.setDebug(true);
    		    	
    		    	//step 2 : compose the message[text,multi media]
    		    	
    		    	MimeMessage m = new MimeMessage(session);
    		    	
    		    	try {
    		    		//from email
    		    		m.setFrom(from);
    		    		
    		    	
    		    	//adding recipient to message
    		    		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    		    	
    		    	//adding subject to message
    		    	m.setSubject(subject);
    		    	
    		    	
    		    	//attachment..
    		    	
    		    	//file path
    		    	
    		    	String path = "C:\\Users\\dell\\OneDrive\\Desktop\\Anuj_Resume.pdf";
    		    	
    		    	MimeMultipart mimeMultipart = new MimeMultipart();
    		    	//text
    		    	//file
    		    	
    		    	MimeBodyPart textMime = new MimeBodyPart();
    		    	
    		    	MimeBodyPart fileMime = new MimeBodyPart();
    		    	
    		    	try {
    		    		
    		    		textMime.setText(message);
    		    		
    		    		File file = new File(path);
    		    		fileMime.attachFile(file);
    		    		
    		    		
    		    		mimeMultipart.addBodyPart(textMime);
    		    		mimeMultipart.addBodyPart(fileMime);
    		    	}
    		    	  catch (Exception e) {
    		    		
    		    		e.printStackTrace();
    		    	}
    		    	
    		    	m.setContent(mimeMultipart);
    		    	
    		    	//send
    		    	//step 3 : send the message using transport class
    		    	Transport.send(m);
    		    	
    		    	
    		    	
    		    	}catch (Exception e) {
    		    		
    		    		e.printStackTrace();
    		    	}
    		    	
    		    	
    		    
    		    	
    		    	
    		    	
    		    	
    		    	
    		    	System.out.println("sent success.............");
    		    	
	}

	//this is responsible to send email...
	private static void sendEmail(String message, String subject, String to, String from) {
		
		//variable for gmail
		
		String host= "smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
	    	System.out.println("PROPERTIES"+properties);
	    	
	    	//setting important info to properties object
	    	
	    	
	    	//host set
	    	properties.put("mail.smtp.host", host);
	    	properties.put("mail.smtp.port","465" );
	    	properties.put("mail.smtp.ssl.enable", "true");
	    	properties.put("mail.smtp.auth", "true");
	    	
	    	
	    	//step1 : to get the session object
	    	Session session = Session.getInstance(properties,new Authenticator() {
	    		@Override
	    		protected PasswordAuthentication getPasswordAuthentication() {
	    			return new PasswordAuthentication("aksoft51@gmail.com","pvbgxbcnndxiilrs");
	    		}
	    	});
	    	
	    	session.setDebug(true);
	    	
	    	//step 2 : compose the message[text,multi media]
	    	
	    	MimeMessage m = new MimeMessage(session);
	    	
	    	try {
	    		//from email
	    		m.setFrom(from);
	    		
	    	
	    	//adding recipient to message
	    		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	
	    	//adding subject to message
	    	m.setSubject(subject);
	    	
	    	
	    	//adding text to message
	    	m.setText(message);
	    	
	    	//send
	    	//step 3 : send the message using transport class
	    	Transport.send(m);
	    	
	    	
	    	System.out.println("sent success.............");
	    	
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	}
}
