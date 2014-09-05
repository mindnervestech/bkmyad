package controllers;

import java.util.ArrayList;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Adcategory;
import models.Adsubcategory;
import models.Basicrate;
import models.City;
import models.Customstate;
import models.Discountprice;
import models.Newspaperdetails;
import models.State;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.UtilityQuery;
import viewmodel.DiscountpriceVM;
import viewmodel.NewspaperVM;
import viewmodel.Rate;
import viewmodel.ResultVM;
import viewmodel.Rate;
import views.html.Booknewspaperaddonlinee43a;
//import views.html.composeadtextclasified45e0;
//import views.html.textiframe;

import views.html.index;

import com.google.common.base.Splitter;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
    public static Result Booknewspaperaddonlinee43a() {
    	
    	List<Adcategory> listcategory = Adcategory.getAllArticles();
    	List<Newspaperdetails> listNewspaper = Newspaperdetails.getAllnewspaper();
    	List<State> liststate=State.getallstate();
    	Map<String,Object> map  = new HashMap<String,Object>();
    	map.put("categories", listcategory);
    	map.put("newspapers", listNewspaper);
    	map.put("state",liststate);
    	
    	
    	return ok(/*Booknewspaperaddonlinee43a.render(Json.stringify(Json.toJson(map)))*/);
    }
    
    @Transactional
    public static Result getBasicRates() {
    	List<Object[]> rates = UtilityQuery.getBasicRates("Agra","Amar Ujala","Computers"); 
    	
		return ok(Json.toJson(Rate.buildForBasicRate(rates)));
    }
    
    @Transactional
    public static Result getBasicRateByNewspaper() {
    	List<Object[]> rates = UtilityQuery.getBasicRateByNewspaper("Amar Ujala"); 
    	
		return ok(Json.toJson(Rate.buildForBasicRateByNewspaper(rates)));
    }
    
    @Transactional
    public static Result getDiscountedRates() {
    	List<Object[]> rates = UtilityQuery.getDiscountedRates("All UP+Uttarakhand(including Noida+Ghaziabad+Bulandshahar+Hapur+Modinagar)","Amar Ujala", "Matrimonial"); 
	 	
		return ok(Json.toJson(Rate.buildForDiscountedRate(rates)));
    }
  
   /* public static Result index() {
        return ok(index.render("Your new application is ready."));
    }*/
    
    public static Result home() {
        return ok(views.html.home.render());
    }
    
    @Transactional
    public static Result getBasicRateByLocation() {
    	List<Object[]> rates = UtilityQuery.getBasicRateByLocation("Agra"); 
	 	
		return ok(Json.toJson(Rate.buildForBasicRateByLocation(rates)));
    }
    
    @Transactional
    public static Result getBasicRateByCategory() {
    	List<Object[]> rates = UtilityQuery.getBasicRateByCategory("Computers"); 
	 	
		return ok(Json.toJson(Rate.buildForgetBasicRateByCategory(rates)));
    }
    
    @Transactional
    public static Result getBasicRateByNewspaperAndCategory() {
    	List<Object[]> rates = UtilityQuery.getBasicRateByNewspaperAndCategory("Amar Ujala","Computers"); 
	 	
		return ok(Json.toJson(Rate.buildForgetBasicRateByNewspaperAndCategory(rates)));
    }
    
    
    @Transactional
    public static Result getBasicRateByLocationAndCategory() {
    	List<Object[]> rates = UtilityQuery.getBasicRateByLocationAndCategory("Agra","Computers"); 
	 	
		return ok(Json.toJson(Rate.buildForgetBasicRateByLocationAndCategory(rates)));
    }
    
    @Transactional
    public static Result Textiframe() {
    	List<Adcategory> listcategory = Adcategory.getAllArticles();
    	List<Newspaperdetails> listNewspaper = Newspaperdetails.getAllnewspaper();
    	List<State> liststate=State.getallstate();
    	Map<String,Object> map  = new HashMap<String,Object>();
    	map.put("categories", listcategory);
    	map.put("newspapers", listNewspaper);
    	map.put("state",liststate);
    	return ok(/*textiframe.render(Json.stringify(Json.toJson(map)))*/);
    }
    
    /*@Transactional
    public static Result composeadtextclasified45e0(){
    	Form<ComposeTextRequestHolder> form = DynamicForm.form(ComposeTextRequestHolder.class).bindFromRequest();
    	ComposeTextRequestHolder ComposeTextResultHolder = form.get();
    	ComposeTextResposeHolder composeTextResposeHolder = new ComposeTextResposeHolder();
    	composeTextResposeHolder.mainCategory=ComposeTextResultHolder.mainCategory;
    	composeTextResposeHolder.subCategory =ComposeTextResultHolder.subCategory;
    	composeTextResposeHolder.adType =ComposeTextResultHolder.adsBy;
    	composeTextResposeHolder.selectedNewspaper =ComposeTextResultHolder.selectedNewspaper.split(",");
    	composeTextResposeHolder.basicRates =ComposeTextResultHolder.basicRates;
    	composeTextResposeHolder.selectedCity =ComposeTextResultHolder.selectedCity.split(",");
    	composeTextResposeHolder.basicRates2 =ComposeTextResultHolder.basicRate2;
    	composeTextResposeHolder.discountedRates=ComposeTextResultHolder.discountedRates;
    	
    	
    	List<NewspaperVM> list=new ArrayList<NewspaperVM>();
    	if(composeTextResposeHolder.basicRates!=null && !composeTextResposeHolder.basicRates.isEmpty())
    	{

    		list = BasicDatanewspaperwise(composeTextResposeHolder.mainCategory,composeTextResposeHolder.basicRates);
        	Map<String,Object>  resutlMap = new HashMap<>();
        	resutlMap.put("composeTextResposeHolder", composeTextResposeHolder);
        	resutlMap.put("basicdata", list);
        	return ok(composeadtextclasified45e0.render(Json.stringify(Json.toJson(resutlMap))));
       
    	}
    	else
    	{
    		list = BasicDatacitywise(composeTextResposeHolder.mainCategory,composeTextResposeHolder.selectedCity,composeTextResposeHolder.basicRates2);
        	Map<String,Object>  resutlMap = new HashMap<>();
        	resutlMap.put("composeTextResposeHolder", composeTextResposeHolder);
        	resutlMap.put("basicdata", list);
        	return ok(composeadtextclasified45e0.render(Json.stringify(Json.toJson(resutlMap))));
    	   		
    	}
        	
    }*/
    
    public static class ComposeTextResposeHolder {
    	public String mainCategory;
    	public String subCategory;
    	public String adType;
    	public String[] selectedNewspaper;
    	public String[] selectedCity;
    	public List<String> basicRates;
    	public List<String> basicRates2;
    	public List<String> discountedRates;
    	List<ResultVM> rates;
    	
    }
    
    public static class ComposeTextRequestHolder {
    	public String textClassifiedAddRdbtn;
    	public List<String> basicRates2;
    	public String getTextClassifiedAddRdbtn() {
			return textClassifiedAddRdbtn;
		}
		public void setTextClassifiedAddRdbtn(String textClassifiedAddRdbtn) {
			this.textClassifiedAddRdbtn = textClassifiedAddRdbtn;
		}
		public String getMainCategory() {
			return mainCategory;
		}
		public void setMainCategory(String mainCategory) {
			this.mainCategory = mainCategory;
		}
		public String getSubCategory() {
			return subCategory;
		}
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}
		public String getMatrimonialCastSelection() {
			return matrimonialCastSelection;
		}
		public void setMatrimonialCastSelection(String matrimonialCastSelection) {
			this.matrimonialCastSelection = matrimonialCastSelection;
		}
		public String getMatrimonialAge() {
			return matrimonialAge;
		}
		public void setMatrimonialAge(String matrimonialAge) {
			this.matrimonialAge = matrimonialAge;
		}
		public String getTargetBy() {
			return targetBy;
		}
		public void setTargetBy(String targetBy) {
			this.targetBy = targetBy;
		}
		public String getAdsBy() {
			return adsBy;
		}
		public void setAdsBy(String adsBy) {
			this.adsBy = adsBy;
		}
		public String getSelectedNewspaper() {
			return selectedNewspaper;
		}
		public void setSelectedNewspaper(String selectedNewspaper) {
			this.selectedNewspaper = selectedNewspaper;
		}
		public String getSelectedState() {
			return selectedState;
		}
		public void setSelectedState(String selectedState) {
			this.selectedState = selectedState;
		}
		public String getSelectedCity() {
			return selectedCity;
		}
		public void setSelectedCity(String selectedCity) {
			this.selectedCity = selectedCity;
		}
		public List<String> getBasicRates() {
			return basicRates;
		}
		public void setBasicRates(List<String> basicRates) {
			this.basicRates = basicRates;
		}
		public List<String> getBasicRates2() {
			return basicRates2;
		}
		public void setBasicRates2(List<String> basicRates2) {
			this.basicRates2 = basicRates2;
		}
		public List<String> discountedRates() {
			return discountedRates;
		}
		public void discountedRates(List<String> discountedRates) {
			this.discountedRates = discountedRates;
		}
		
		public String mainCategory;
    	public String subCategory;
    	public String matrimonialCastSelection;
    	public String matrimonialAge;
    	public String targetBy;
    	public String adsBy;
    	public String selectedNewspaper;
    	public String selectedState;
    	public String selectedCity;
    	public List<String> basicRates;
    	public List<String> basicRate2;
    	public List<String> discountedRates;
    	
    }
       
    @Transactional
	public static Result getstate()
	{
		List<State> liststate=State.getallstate();
		return ok(Booknewspaperaddonlinee43a.render(Json.stringify(Json.toJson(liststate))));
	}
    
       
    @Transactional
	public static Result discountednewspaper(String cname,String city){
	 	
	 	List<Object[]> getDiscount = Discountprice.getdiscountednewspaperwise(cname, city);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : getDiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	} 	
		return ok(Json.toJson(list));
	}
    
    @Transactional
	public static Result discountedcity(String cname,String city,String nname){
	 	
	 	List<Object[]> getDiscount = Discountprice.getdiscountedcity(cname, city,nname);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : getDiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	} 	
		return ok(Json.toJson(list));
	}
    
    
    
    @Transactional
	private static List<NewspaperVM> BasicDatanewspaperwise(String cname,List<String> city){
	 	
	 	List<Object[]> getbasicdata = Basicrate.getbasicdatanewspaperwise(cname, city);
	 	List<NewspaperVM> list = new ArrayList<>();
	 	for(Object[] newspaperVM : getbasicdata){
	 		NewspaperVM vm = new NewspaperVM(newspaperVM);
	 		list.add(vm);
	 	}
	 	
		return list;
	}
    
     
    

    @Transactional
    public static Result getbeforebookingdate(String nname){
    	List<Newspaperdetails> listnewspaper = Newspaperdetails.getbeforebookingdate(nname);
    	Map<String, String> description = new HashMap<>();
    	for(Newspaperdetails newspaperdetails : listnewspaper){
    		description.put("Beforebookingdate", newspaperdetails.Beforebookingdate);
    	}
    	return ok(Json.toJson(description));
    }
    
    
    @Transactional
	private static List<NewspaperVM> BasicDatacitywise(String cname,String[] city,List<String> newspaper){
	 	
	 	List<Object[]> getbasicdatacitywise = Basicrate.getbasicdatacitywise(cname,city, newspaper);
	 	List<NewspaperVM> list = new ArrayList<>();
	 	for(Object[] newspaperVM : getbasicdatacitywise){
	 		NewspaperVM vm = new NewspaperVM(newspaperVM);
	 		list.add(vm);
	 	}
	 	
		return list;
	}
    
    @Transactional
    public static Result getadscategory(){
    	
    	List<Adcategory> listcategory = Adcategory.getAllArticles();
    	return ok(Booknewspaperaddonlinee43a.render(Json.stringify(Json.toJson(listcategory))));
    }
    
    @Transactional
    public static Result getSubCategoty(String cname){
    	List<Adsubcategory> listnewspaper = Adsubcategory.getSubcategotBy(cname);
    	
    	if(!listnewspaper.isEmpty()) {
    		Iterable<String> subCats = Splitter.on(",").split(listnewspaper.get(0).Sucategory);
    		return ok(Json.toJson(subCats));
    	}
    	return ok();
    }
    
    /*@Transactional
    public static Result getcity(String statename){
    	List<City> listallcity = City.getallcity(statename);
    	    	
    	if(!listallcity .isEmpty()) {
    		Iterable<String> subCats = Splitter.on(",").split(listallcity.get(0).Cityname);
    		return ok(Json.toJson(subCats));
    	}
    	return ok();
    	
    	getDiscountByStateCityAndCategory(state,city,category);
    }*/
    

	@Transactional
	public static Result getallcityName(String cname,String nname){
	 	
	 	List<Object[]> listcity = Basicrate.getallcity(cname, nname);
	 	List<ResultVM> list = new ArrayList<>();
	 	for(Object[] resultVM : listcity){
	 		ResultVM vm = new ResultVM(resultVM);
	 		list.add(vm);
	 	} 	
	 	
	 	List<Object[]> listdiscount = Discountprice.getfewdiscount(nname, cname);
	 	List<DiscountpriceVM> list1 = new ArrayList<>();
	 	for(Object[] discountpriceVM : listdiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list1.add(vm);
	 	}
	 	
		

    	Map<String,Object>  resutlMap = new HashMap<>();
    	resutlMap.put("basicRate", list);
    	resutlMap.put("discountedRate", list1);
	return ok(Json.toJson(resutlMap));
	 	
		
	}
		
	@Transactional
	public static Result getcitywisenews(String cname,String city){
	 	
	 	List<Object[]> listnewspaper = Basicrate.getnewspaper(cname, city);
	 	List<NewspaperVM> list = new ArrayList<>();
	 	for(Object[] newspaperVM : listnewspaper){
	 		NewspaperVM vm = new NewspaperVM(newspaperVM);
	 		list.add(vm);
	 	}
	 	
		return ok(Json.toJson(list));
	}

	
	@Transactional
	public static Result getDiscountByStateCityAndCategory(String state,String city, String category){
		
		List<Customstate> listcstate = Customstate.getcstate(state, city);
		Customstate cstate;
		
		List<DiscountpriceVM> list2=new ArrayList<DiscountpriceVM>();
				
			cstate =listcstate.isEmpty()?null:listcstate.get(0);
			if(state.equalsIgnoreCase("Uttar Pradesh")) {
		    	if(cstate == null ) {
		    		list2 = getyesUPnull(category,city);
		    	} else {
		    		list2 = getnoUPnotnull(category, city,state, cstate.CState);
		    	}
	    	} else {
	    		if(cstate == null ) {
	    			list2 = getnoUPnull(category, city, state);
	    		} else {
	    			list2 = getnoUPnotnull(category, city, state, cstate.CState);
	    		}
	    	}
	   	
		

		 	List<Object[]> listnewspaper = Basicrate.getnewspaper(category, city);
		 	List<NewspaperVM> list = new ArrayList<>();
		 	for(Object[] newspaperVM : listnewspaper){
		 		NewspaperVM vm = new NewspaperVM(newspaperVM);
		 		list.add(vm);
		 	}
		 	
	   
	    	Map<String,Object>  resutlMap = new HashMap<>();
	    	resutlMap.put("basicRate", list);
	    	resutlMap.put("discountedRate", list2);
    	return ok(Json.toJson(resutlMap));
    	
	}
	
	
	@Transactional
	public static Result getdiscount(String nname,String cname){
	 	
	 	List<Object[]> listdiscount = Discountprice.getfewdiscount(nname, cname);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : listdiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	}
	 	
		return ok(Json.toJson(list));
	}
	
	
	private static List<DiscountpriceVM> getyesUPnull(String cname,String city){
	 	
	 	List<Object[]> listdiscount = Discountprice.getyesUPNull(cname, city);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : listdiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	}
	 	
		return list;
	}

	private static List<DiscountpriceVM> getyesUPnotnull(String cname,String city, String state){
	 	List<Object[]> listdiscount = Discountprice.getyesUPnotNull(cname, city ,state);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : listdiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	}
		return list;
	}
		
	private static List<DiscountpriceVM> getnoUPnull(String cname,String city,String state){
	 	
	 	List<Object[]> listdiscount = Discountprice.getnoUPNull(cname, city, state);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : listdiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	}
		return list;
	}
		
	private static List<DiscountpriceVM> getnoUPnotnull(String cname,String city,String dstate,String cstate){
	 	
	 	List<Object[]> listdiscount = Discountprice.getnoUPnotNull(cname, city, dstate, cstate);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : listdiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	}
		return list;
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
  

