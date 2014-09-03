package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
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
import models.DisplayAdDetails;
import models.User;
import play.Play;
import play.data.DynamicForm;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Booknewspaperaddonlinee43a;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result home() {
        return ok(views.html.home.render());
    }
    
  
   
    public static Result Booknewspaperaddonlinee43a() {
    	List<String> testlists = new ArrayList<String>();
    	testlists.add("Amar Ujala");
    	testlists.add("Time of India");
    	testlists.add("Ecomonics Times");
    	return ok(Booknewspaperaddonlinee43a.render(Json.stringify(Json.toJson(testlists))));
    }
    
    //save sign up form 
    @Transactional
    public static Result  SaveSignUp() {
    	DynamicForm form = DynamicForm.form().bindFromRequest();
        String name = form.get("txtUserids");
    	String email =form.get("txtEmail");
    	String mobileNumber=form.get("txtMobileno");
    	String passWord=form.get("txtpasswords");
    	
        
        User existingUser = User.findExistingUser(email);
        if(existingUser==null)
        {
        	User u=new User();
        	u.name=name;
        	u.email=email;
        	u.password=passWord;
        	u.mobileNum=mobileNumber;
        	JPA.em().persist(u);
        	return redirect("/");
       
        }
        else
        {
        	flash("emailid_error", "Email id already Exists ");
	    	return redirect("/");
        	
        }
    }
    
    // check for Auth 
    @Transactional
    public static Result  CheckSignIn() {
    	DynamicForm form = DynamicForm.form().bindFromRequest();
    	String email = form.get("txtUsername");
    	String pass =form.get("txtpwd");
	    User existingUser = User.findByCredentials(email,pass);
	    if (existingUser != null) {
	    	return redirect("/");
	    }
	    else {
	    	flash("login_error", "Please check your username and password");
	    	return redirect("/");
	    }
    }
    
    // save the ad 
    @Transactional
    public static Result  SavedispAddDetails() throws IOException {
        DynamicForm form = DynamicForm.form().bindFromRequest();
        play.mvc.Http.MultipartFormData.FilePart docFile;
        String fileName=null;
        String filenamedbpath=null;
        String subcategory  =	form.get("subCatId");
        String ddlnewspaper =	form.get("ddlnewspaper");
        String releaseDatetxt =	form.get("Datetxt");
        String expectedsizetxt=	form.get("sizetxt");
        String budget   =	    form.get("budgettxt"); 
        String mattter  =	    form.get("mattertxt");
        String specialinstruction =	form.get("instructiontxt");
        String name =	        form.get("nametxt");
        String email=	        form.get("emailtxt");
        String telestd =	    form.get("telstdtxt");
        String telenum  =     	form.get("telnotxt");
        String mobilenum=	    form.get("mobtxt");
      
        play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();
        docFile = body.getFile("fupfile");
       
        if (docFile != null) {
          fileName = docFile.getFilename();
          File file = docFile.getFile();
          final String FILE_PATH = Play.application().configuration().getString("storage.path");
          File f=new File(FILE_PATH+fileName);
          filenamedbpath = FILE_PATH+File.separator+fileName;
          Files.copy(file.toPath(),f.toPath(),java.nio.file.StandardCopyOption.REPLACE_EXISTING);
          flash("Success", "File Uploaded successfully");
        }
       
       DisplayAdDetails d=new DisplayAdDetails();
         	d.adcategory=subcategory;
         	d.newspaper=ddlnewspaper;
         	d.releasedate=releaseDatetxt;
            d.expectedsize=expectedsizetxt;
            d.budget=budget;
         	d.addmatter=mattter;
         	d.specialinstruction=specialinstruction;
         	d.name=name;
         	d.email=email;
         	d.telephonenum=telestd+""+telenum;
         	d.mobilenum=mobilenum;
            d.docfile=filenamedbpath;
            // save form to the DB
            JPA.em().persist(d);
             
             
             // send mail
            final String username = "akashshinde44comp@gmail.com";
     		final String password = "V@ishnavi14";
      
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
     			message.setFrom(new InternetAddress("akashshinde44comp@gmail.com"));
     			message.setRecipients(Message.RecipientType.TO,
     			InternetAddress.parse(email));
     			message.setSubject("Your Ad Details ");
     			//message.setText();
     			 
     			 BodyPart messageBodyPart = new MimeBodyPart();

     	         // Now set the actual message
     	         messageBodyPart.setText("Your Ad Display Details-  "+"\nSubcategory: "+subcategory+"\nDDL News Paper: "+ddlnewspaper+"\nReleaseDateTxt: "+releaseDatetxt+"\nBudget:"+budget+"\nAd Mattter :" +mattter+"\nYour STD Number:"+telestd+"-"+telenum+""+"\nExpected Size: "+expectedsizetxt+"\n"+" Your Mobile Number: "+mobilenum+"\n"+"\nSpecial Instruction:  "+specialinstruction+"\n \n \nPlease find your atatchment below");

     	         // Create a multipar message
     	         Multipart multipart = new MimeMultipart();

     	         // Set text message part
     	         multipart.addBodyPart(messageBodyPart);

     	         // Part two is attachment
     	         messageBodyPart = new MimeBodyPart();
     	         String filename = filenamedbpath;
     	         DataSource source = new FileDataSource(filename);
     	         messageBodyPart.setDataHandler(new DataHandler(source));
     	         messageBodyPart.setFileName(filename);
     	         multipart.addBodyPart(messageBodyPart);
                 // Send the complete message parts
     	         message.setContent(multipart);
     		     Transport.send(message);
          		} catch (MessagingException e) {
     			  throw new RuntimeException(e);
     		}
             
         	return redirect("/");
     }
 
}
  

