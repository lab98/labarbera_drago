package email;

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
	

		
	public static void sendMail(String recepient, String subject , String content) throws MessagingException {
		
		Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true"); 
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.port", "587");
		 String username="hubvaccinale@gmail.com";
		 String password="ciaociao@99";
				
		 		 
		 Session session=Session.getInstance(props, new Authenticator() {
			 
			 @Override
			 protected PasswordAuthentication getPasswordAuthentication(){
				 return new PasswordAuthentication(username,password);
			 }
			 
		 });
		 
		 Message message= setMessage(session,username, recepient, subject, content);
		 
		 Transport.send(message);
		 
		 System.out.println("Email sent succesfully");
		 
	}
	
	public static Message setMessage(Session session,String sender, String recepient,String subject, String content) throws AddressException, MessagingException {
		Message message= new MimeMessage(session);
		message.setFrom(new InternetAddress(sender));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		message.setSubject(subject);
		message.setText(content);
		
		return message;
	}
	

}

