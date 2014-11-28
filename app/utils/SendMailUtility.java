package utils;

import java.text.Format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

import play.mvc.Result;
import viewmodel.ComposedAdSaveVMInvoice;

import controllers.MyAccountController;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


 
public class SendMailUtility {
	
	
	public void sendMailAboutOrder(String orderId,String email,String  cc_orderNo){
		
		final String username = "support@arihantbooking.com";
		final String password = "Adschela@123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
	try {
	     	//send a  order order confirmation  mail to Admin,registered(currently order placed user)  user.
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Rajan_Jain"));
			MyAccountController mc=new MyAccountController();
			Result ordedrdata= mc.getInvoiceOrderDetails(orderId);
			

			if(cc_orderNo != null){
			    //Add multiple recipients. including Admin
				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("rajanjain8aug@gmail.com"));
				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(email));
				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("support@arihantbooking.com"));
				//set msg text body
				 message.setSubject( "Your Ad Order Details");
				 BodyPart messageBodyPart = new MimeBodyPart();
				 // Now set the actual message
				 Date todaysDate = new Date();
				 Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String dateToSend = formatter.format(todaysDate);
	             //set the msg body text.	 
				 messageBodyPart.setText("Your Order placed successfully\n Order id is: "+orderId+"\nDate of Order is: "+dateToSend+"\nEmail Id is : "+email);
		         // Create a multipart message
		         Multipart multipart = new MimeMultipart();
		         // Set text message part
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart);
			     Transport.send(message);
			
			}else{
				
				//send a  order cancled mail to Admin user.
			
				//add receipts (Admin mail id )
				 message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("rajanjain8aug@gmail.com"));
				 message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("support@arihantbooking.com"));
				 message.setSubject( "Redarding order placed by some user.");
				 BodyPart messageBodyPart = new MimeBodyPart();
				 // Now set the actual message
				 Date todaysDate = new Date();
				 Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String dateToSend = formatter.format(todaysDate);
	             //set the msg body text.	 
				 messageBodyPart.setText("Some user placed the order but he cancled it  .\n Below are the Order Details \n Order id is: "+orderId+"\nEmail id is : "+email+"\nDate of Order is: "+dateToSend);
		         // Create a multipart message
		         Multipart multipart = new MimeMultipart();
		         // Set text message part
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart);
		         //send a  order cancled mail to Admin user. 
			     Transport.send(message);
			}
			
  		} catch (Exception e) {
  			e.printStackTrace();
			  throw new RuntimeException(e);
		}
	}
	
	
	  //send a  order confirmation mail to register user. 
	  public void  sendMail(String OrderID, String email, String cc_orderNo){
	  // OrderID = "1048001412";
	   String declaimer= "This is a computer generated Invoice and does not require any authorised signatory.\n If you have any problem with your order, please call us at or send us a message at \n support@arihantbooking.com.";
	 //  String total = String.valueOf(TotalCost );
	   final String username = "support@arihantbooking.com";
		final String password = "Adschela@123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
	try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("RajanJain"));
			//Add multiple recipients.
			//message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(email));
			if(cc_orderNo != null){
			 //Add multiple recipients. including Admin
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("rajanjain8aug@gmail.com"));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(email));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("support@arihantbooking.com"));
			MyAccountController mc=new MyAccountController();
			List<ComposedAdSaveVMInvoice> ordedrdata= mc.getInvoiceOrderDetailsEmail(OrderID);
			/*System.out.println("ordedrdata size: "+ordedrdata.size());
			for (int i = 0; i < ordedrdata.size(); i++) {
				System.out.println("border Cost: in email"+ordedrdata.get(i).BorderCost);
			}
			*/
			final String text = getEmailTemplate("views.html.orderdetails",ordedrdata);
		     message.setSubject( "Your Ad Order Details");
			 BodyPart messageBodyPart = new MimeBodyPart();
	         // Now set the actual message
			 messageBodyPart.setContent(text, "text/html");
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();
	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);
	         message.setContent(multipart);
		     Transport.send(message);
		     } else{
		    	 message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("rajanjain8aug@gmail.com"));
				 message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("support@arihantbooking.com"));
				 message.setSubject( "Redarding order placed by some user.");
				 BodyPart messageBodyPart = new MimeBodyPart();
				 // Now set the actual message
				 Date todaysDate = new Date();
				 Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String dateToSend = formatter.format(todaysDate);
	             //set the msg body text.	 
				 messageBodyPart.setText("Some user placed the order but he cancled it  .\n Below are the Order Details \n Order id is: "+OrderID+"\nEmail id is : "+email+"\nDate of Order is: "+dateToSend);
		         // Create a multipart message
		         Multipart multipart = new MimeMultipart();
		         // Set text message part
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart);
		         //send a  order cancled mail to Admin user. 
			     Transport.send(message);
  		}
	}catch (Exception e) {
  			e.printStackTrace();
			  throw new RuntimeException(e);
		}

	}
	
	protected String getEmailTemplate(final String template, List<ComposedAdSaveVMInvoice> ordedrdata) {
		Class<?> cls = null;
		String ret = null;                                                                                                                                                                                                                         
		try {
			cls = Class.forName(template);
		} catch (ClassNotFoundException e) {
			/*Logger.warn("Template: '"
					+ template
					+ "' was not found! Trying to use English fallback template instead.");*/
		}
		if (cls == null) {
			try {
				cls = Class.forName(template);
			} catch (ClassNotFoundException e) {
				/*Logger.error("Fallback template: '" + template 
						+ "' was not found either!");*/
			}
		}
		if (cls != null) {
			Method htmlRender = null;
			try {
				htmlRender = cls.getMethod("render",List.class);
				ret = htmlRender.invoke(null,ordedrdata)
						.toString();

			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}


	public void sendMailAboutGuestUser(String tempuserName,
			String tempuserMobnumber) {
		// TODO Auto-generated method stub
		
		final String username = "support@arihantbooking.com";
		final String password = "Adschela@123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
	try {
	     	//send a   mail to support regrading the temporly visitor user.
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("Rajan_Jain"));
			  	message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("support@arihantbooking.com"));
				//set msg text body
				 message.setSubject( "Captured information about guest user");
				 BodyPart messageBodyPart = new MimeBodyPart();
	             //set the msg body text.	 
				 messageBodyPart.setText("\n Name is: "+tempuserName+"\n\nMobile Number : "+tempuserMobnumber);
		         // Create a multipart message
		         Multipart multipart = new MimeMultipart();
		         // Set text message part
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart);
			     Transport.send(message);
	}catch (Exception e) {
			e.printStackTrace();
		  throw new RuntimeException(e);
	}
	}


	public void sendMailAboutClassifiedAd(String tempuserName,
			String tempuserMobnumber, String tempuserNote) {
		// TODO Auto-generated method stub
		System.out.println("in send mail class ");
		final String username = "support@arihantbooking.com";
		final String password = "Adschela@123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	try {
	     	//send a   mail to support regrading the temporly visitor user.
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("Rajan_Jain"));
			  	message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("support@arihantbooking.com"));
				//set msg text body
				 message.setSubject( "Classified ad Display ad ");
				 BodyPart messageBodyPart = new MimeBodyPart();
	             //set the msg body text.	 
				 messageBodyPart.setText("\n Name is: "+tempuserName+"\n\nMobile Number : "+tempuserMobnumber+"\n\nNote Given is: "+tempuserNote);
		         // Create a multipart message
		         Multipart multipart = new MimeMultipart();
		         // Set text message part
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart);
			     Transport.send(message);
	}catch (Exception e) {
			e.printStackTrace();
		  throw new RuntimeException(e);
	}
		
	}
	}