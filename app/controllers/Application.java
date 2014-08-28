package controllers;

import java.io.File;
import javax.activation.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import models.Adcategory;
import models.DisplayAdDetails;
import models.Newspaperdetails;
import models.User;
import play.Play;
import play.data.DynamicForm;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import views.html.Booknewspaperaddonlinee43a;
import views.html.about;
import views.html.affiliateduserogin;
import views.html.contact;
import views.html.disclame;
import views.html.dispad;
import views.html.howtobookanad;
import views.html.index;
import views.html.ourblog;
import views.html.ourclient;
import views.html.payment;
import views.html.pripoli;
import views.html.readenewspaper;
import views.html.register;
import views.html.tandc;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result Booknewspaperaddonlinee43a() {
    	List<String> testlists = new ArrayList<String>();
    	testlists.add("Amar Ujala");
    	testlists.add("Time of India");
    	testlists.add("Ecomonics Times");
    	return ok(Booknewspaperaddonlinee43a.render(Json.stringify(Json.toJson(testlists))));
    }
    
    public static Result AboutUs(){
    	return ok(about.render());
    }
    
    public static Result ContactUs() {
    	return ok(contact.render());
    }
    
    public static Result  OurClients() {
    	return ok(ourclient.render());
    }
    public static Result  OurBlogs() {
    	return ok(ourblog.render());
    }
    public static Result  TermsandConditions() {
    	return ok(tandc.render());
    } 
    public static Result   PrivacyPolicy() {
    	return ok(pripoli.render());
    } 
    public static Result   PaymentOptions() {
    	return ok(payment.render());
    }

    public static Result   DisClaimer() {
    	return ok(disclame.render());
    }
    public static Result   Help() {
    	return ok(howtobookanad.render());
    }
    
    @Transactional
    public static Result  DisplayAdd() {
    	
    	//get list of AdCategory 
    	List<Adcategory> listcategory = Adcategory.getAllArticles();
    	//get the list of news paper
    	List<String> listNewspaper = Newspaperdetails.getNameofallenewspaper();
    	Map<String,Object> map  = new HashMap<String,Object>();
    	map.put("categories", listcategory);
    	map.put("newspapers", listNewspaper);
    	
    	return ok(dispad.render(Json.stringify(Json.toJson(map))));
    }

    public static Result  ENewsPaper() {
    	return ok(readenewspaper.render());
    }
    public static Result  AffiliatedLogin() {
    	return ok(affiliateduserogin.render());
    }
    public static Result  RegisteredUser() {
    	return ok(register.render());
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
    //chk for the Username and pass in DB for sign in form
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
    
    	//validate user name form sign up form
    @Transactional
    public static Result  ValidateUsernameUnique() {
    	DynamicForm form = DynamicForm.form().bindFromRequest();
    	String email = form.get("txtEmail");
    	User existingUser = User.ValidateUsernameUnique(email);
	   
        if (existingUser != null) {
	    	return ok("true");
	     } 
        else{
	     
        }
             return ok("false");
      } 
    
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
       String telestd =	        form.get("telstdtxt");
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
         //save form to the DB
            JPA.em().persist(d);
            
            
            //send mail
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
    	         messageBodyPart.setText("Your Ad Display Details-  "+"\nSubcategory: "+subcategory+"\nDDL News Paper: "+ddlnewspaper+"\nReleaseDateTxt: "+releaseDatetxt+"\nBudget:"+budget+"\nAd Mattter :" +mattter+"\nYour STD Number:"+telestd+"-"+telenum+""+"Expected Size: "+expectedsizetxt+"\n"+" Your Mobile Number: "+mobilenum+"\n"+"\nSpecial Instruction:  "+specialinstruction+"\n \n \nPlease find your atatchment below");

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
 