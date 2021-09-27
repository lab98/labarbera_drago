package email;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	

		
	public static void sendMail(String recepient, String subject , String content) throws MessagingException, IOException {
		System.out.println("preparing email...");
		/* gmail     Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true"); 
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.port", "587");
		 props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		/* Properties props=new Properties();
		 props.put("mail.smtp.host", "smtp.gmail.com");
	     props.put("mail.smtp.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");*/
		 
/*
		 String username="hubvaccinale@gmail.com";
		 String password="ciaociao@99";
				*/
		 Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.libero.it"); // for gmail use smtp.gmail.com
         props.put("mail.smtp.auth", "true");
         props.put("mail.debug", "true"); 
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.port", "465");
         props.put("mail.smtp.ssl.trust", "smtp.libero.it");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.socketFactory.fallback", "false");
         
         String username="hubvaccinale@libero.it";
         String password="ciaociao@99H";
		 System.out.println("preparing session...");
		 		 
		 Session session=Session.getInstance(props, new Authenticator() {
			 
			 @Override
			 protected PasswordAuthentication getPasswordAuthentication(){
				 return new PasswordAuthentication(username,password);
			 }
			 
		 });
		 System.out.println("preparing message...");
		 MimeMessage msg=setMessage(session,username, recepient, subject, content);
		 System.out.println("sending message ...");
		 
		 System.out.println(msg.toString());
		 
		 Transport.send(msg);
		 
		 System.out.println("Email sent succesfully");
		 
	}
	
	public static MimeMessage setMessage(Session session,String sender, String recepient,String subject, String content) throws AddressException, MessagingException, IOException {
		System.out.println("setting message...");
		MimeMessage msg=new MimeMessage(session);
		System.out.println("initialized message...");
	
		msg.setFrom(new InternetAddress(sender));
		System.out.println("initialized sender...");
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		System.out.println("initialized recepient...");
		msg.setSubject(subject);
		System.out.println("initialized subject...");
		
		msg.setText(content);
		System.out.println("initialized content...");
		System.out.println("message setted");
		System.out.println(msg.getContent());
		return msg;
	}
	

}

