package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import models.Adcategory;
import models.AddressDetails;
import models.Basicrate;
import models.City;
import models.ComposedAdSave;
import models.Newspaperdetails;
import models.State;
import models.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.UtilityQuery;
import viewmodel.NewspaperVM;
import viewmodel.Rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class MakeBookingController extends Controller {
	@Transactional
	public static Result index() {
		/*
		
		
		
		
		*/
		return ok(views.html.makeBooking.render(Json.stringify(Json.toJson(makeBookingBarFixture()))));
		
	}
	
		
	@Transactional
    public static Result getcity(String statename){
    	List<String> listallcity = City.getallcity(statename);
    	    	
    	if(!listallcity .isEmpty()) {
    		Iterable<String> subCats = Splitter.on(",").split(listallcity.get(0));
    		return ok(Json.toJson(subCats));
    	}
    	return ok();
     }
	@Transactional
	public static Result checkUserNameandPassword(String Username,String Password){
		
		 User existingUser = User.findByCredentials(Username,Password);
		   System.out.println("existingUser:: "+existingUser);
		 if (existingUser != null) {
		    	return ok("false");
		    }
		    else {
		    	flash("login_error", "Please check your username and password");
		    	return ok("true");
		    }
		 
		
		
		
		
	}
	 @Transactional
	    public static Result getBasicRateByLocationAndCategory(String Location,String Category) {
	    	List<Object[]> rates1 = UtilityQuery.getBasicRateByLocationAndCategory(Location,Category); 
		 	System.out.println("----------"+Location+"---------"+Category+"----");
	    	List<Rate> rates = Lists.newArrayList();
            
			for(Object[] rs :rates1) {
        		
        		String str; 
            	str=rs[4].toString();
           	 String number = "";
                String letter = "";
            
                for (int i = 0; i < str.length(); i++) {
                       char a = str.charAt(i);
                       if (Character.isDigit(a)) {
                             number = number + a;

                       } else if (Character.isAlphabetic(a)) {
                             letter = letter + a;

               }
                }
                            		
                rates.add(Rate.byId(rs[0].toString())
        				.withCityAndNewspaper(rs[1].toString(),rs[2].toString())
        				.withAmountAndFreeUnit(rs[3].toString(),letter,number)
        				.withOverUnit(rs[5].toString(), rs[6].toString(),rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()) );
        		
        		        		
        	}
		
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("rates", rates);
	System.out.println(Json.toJson(map));
	return ok(Json.toJson(map));

	    }
	
	
	@Transactional
	public static Result getRatesByNewspaper(String newspaper,String Category) {
		
		
		List<Object[]> rates1 = UtilityQuery.getBasicRateByNewspaperAndCategory(newspaper,Category);
	 	
		List<Rate> rates = Lists.newArrayList();
                  
				for(Object[] rs :rates1) {
	        		
	        		String str; 
	            	str=rs[4].toString();
	           	 String number = "";
	                String letter = "";
	            
	                for (int i = 0; i < str.length(); i++) {
	                       char a = str.charAt(i);
	                       if (Character.isDigit(a)) {
	                             number = number + a;

	                       } else if (Character.isAlphabetic(a)) {
	                             letter = letter + a;

	               }
	                }
	                            		
	                rates.add(Rate.byId(rs[0].toString())
	        				.withCityAndNewspaper(rs[1].toString(),rs[2].toString())
	        				.withAmountAndFreeUnit(rs[3].toString(),letter,number)
	        				.withOverUnit(rs[5].toString(), rs[6].toString(),rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()) );
	        		
	        		        		
	        	}
			
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rates", rates);
		return ok(Json.toJson(map));
	}
	
	
	private static Map<String,Object>  makeBookingBarFixture() {
		List<Newspaperdetails> newspapers = Newspaperdetails.getAllnewspaper();
		List<State> locations=State.getallstate();
		List<Adcategory> categories = Adcategory.getAllArticles();
				
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("newspapers", newspapers);
		map.put("locations", locations);
		map.put("categories", categories);
		map.put("categories", categories);
		return map;
	}
	
	// 200 for first 20 words, 15 / 2 words 
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class Rate {
		
		/*public DateConfig dateConfig;
		public ExtraConfig extraConfig;*/
		
		public String id;
        public String location; //Agra
        public String newspaper; //Time of India
        public String rate; //200
       // public String disRate; // This is for discounted Value
        public String unit; //word
        public String unitVal; //2
        public String extra; //15
        public int freeUnit=25; // 20
       
        public String extraFortick;
        public String extraCostpersqcm;
        public String cutOfBookingDate;
        public String extraForBorder;
        public String extraForBackgroud;
		
		
		
        public static Rate byId(String id) {
            Rate rate = new Rate();
            rate.id = id;
            return rate;
}

public Rate withCityAndNewspaper(String location, String newspaper) {
            this.newspaper = newspaper;
            this.location = location;
            return this;
}

public Rate withAmountAndFreeUnit(String amount, String unit,String unitVal) {
            this.unit = unit;
            this.unitVal=unitVal;
            this.rate = amount;
            return this;
}

public Rate withOverUnit(String extra,String cutOfBookingDate,String extraForBorder,String extraForBackgroud, String 

extraFortick,String extraCostpersqcm) {
            this.extra = extra;
            this.cutOfBookingDate=cutOfBookingDate;
            this.extraForBorder=extraForBorder;
            this.extraForBackgroud=extraForBackgroud;
            this.extraFortick=extraFortick;
            this.extraCostpersqcm=extraCostpersqcm;
            return this;
}

		
		
		/*public Rate withDateConfig(DateConfig dateConfig) {
			this.dateConfig = dateConfig;
			return this;
		}
		
		public Rate withExtraConfig(ExtraConfig extraConfig) {
			this.extraConfig = extraConfig;
			return this;
		}*/
		
	}
	
	
	
	public class ExtraConfig {
		public float rate;
		public String rateOf;
	}
	
	public class DateConfig {
		public int preBookingCutOffDays;
		public int maxAllowedDays;
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class CartItem {
		public int id;
		public String type;
		public String description;
		public String mainCategoty;
		public String subcategory;
		public String location;
		public String newspaper;
		public float rate; //200
		public String unit; //word
		public int unitVal; //2
		public int extra; //15
		public int freeUnit; // 20
		public float amount;
		public String onbgColorchange;
		public String onBorderSelected;
		public float extraForBorder;
		public float extraForBackgroud;
		public int totalUnit;//number of words
		public float fullTotal; 
		public String userid;
		public String  [] dates = {};
		public float extraUnit;
		public String nobgColor;
		
		public CartItem() {};
		public CartItem(int id, String type, String location, String mainCategoty,
				String subcategory, String newspaper, float amount) {
			super();
			this.id = id;
			this.type = type;
			this.location = location;
			this.mainCategoty = mainCategoty;
			this.subcategory = subcategory;
			this.newspaper = newspaper;
			this.amount = amount;
			this.description = location + "-" + newspaper + "(" + mainCategoty + (subcategory==null ? "" : "/" + subcategory) + ")"; 
		}
	
	}

	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class Address {
		public Long id;
		public String pinCode;
		public String fullName;
		public String shippingAddress;
		public String nearestLandmark;
		public String city;
		public String state;
		public String mobile; 
		public String landline; 
		public String userid;
		
		
		public Address() {};
		public Address(Long id, String  pinCode, String fullName, String shippingAddress,
				String nearestLandmark, String city, String state,String mobile,String landline,String userid ) {
			super();
			this.id = id;
			this.pinCode=pinCode;
			this.fullName = fullName;
			this.shippingAddress = shippingAddress;
			this.nearestLandmark = nearestLandmark;
			this.city = city;
			this.state = state;
			this.mobile = mobile;
			this.landline=landline;
			this.userid=userid;
		}
	
	}


	    @Transactional
	    public static Result  saveComposeyourAd() {
	  
		 JsonNode json = request().body().asJson();
	     //JsonNode nodes = json.path("data");
	     System.out.println(" json value :: "+json.toString());
	     
	     ObjectMapper objectMapper = new ObjectMapper();
	     List<CartItem> cartItem ;
	     Address address;
	     String emailId= json.get("email").asText();
	     String modeOfPayment=json.get("modeOfPayment").asText();
	     try {
			address = objectMapper.readValue(json.get("address").traverse(),Address.class);
			
			AddressDetails addressDetails =new AddressDetails();
	    	addressDetails.pinCode=address.pinCode;
	    	System.out.println("addressDetails.pinCode:"+addressDetails.pinCode);
	    	addressDetails.fullName=address.fullName;
	    	addressDetails.address=address.shippingAddress;
	    	addressDetails.nearestLandmark=address.nearestLandmark;
	    	addressDetails.city=address.city;
	    	addressDetails.state=address.state;
	    	addressDetails.mobile=address.mobile;
	    	addressDetails.landLine=address.landline;
	    	addressDetails.userEmailid=emailId;
	    	JPA.em().persist(addressDetails);
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		
    	
	     try {
	    	 cartItem = objectMapper.readValue(json.get("carts").traverse(),new com.fasterxml.jackson.core.type.TypeReference<List<CartItem>>() {});
	         List<ComposedAdSave> orderListComposeAd=new ArrayList<ComposedAdSave>();
	         String orderId = UUID.randomUUID().toString();
	         for(int i=0; i<cartItem.size();i++) {
	          ComposedAdSave cds=new ComposedAdSave();
	          cds.Category=cartItem.get(i).mainCategoty;
	          cds.Subcategory=cartItem.get(i).subcategory;
	          cds.Nameofthenewspaper=cartItem.get(i).newspaper;   //location saved here
	    	  cds.City=cartItem.get(i).location;//paper name saved here
 	    	  cds.Adtext=cartItem.get(i).description;
	    	  cds.OrderID = orderId;
	    	  cds.BorderCost=cartItem.get(i).extraForBorder;
	    	  cds.BgcolorRate=cartItem.get(i).extraForBackgroud;
	    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//save dates in DB 
	    	  for(int j =0; j<cartItem.get(i).dates.length; j++){
	    		  try {
					Date dt = sdf.parse(cartItem.get(i).dates[j]);
                    cds.PublishDate+=cartItem.get(i).dates[j]+",";
					System.out.println("dates : "+dt);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  }
	    	  
	    	  cds.BasicRate=cartItem.get(i).unit;
	    	  cds.numberOfWords=cartItem.get(i).totalUnit;
	    	  cds.userEmailId=emailId;
	    	  cds.paymentOption=modeOfPayment;
	    	  cds.Border=cartItem.get(i).onBorderSelected;
	    	  cds.Bgcolor=cartItem.get(i).nobgColor;
	    	  
	    	  //cartItem.get(i).nobgColor=   'true' means it is not selected ;
	    	  if( cartItem.get(i).onBorderSelected.equals("No")&&cartItem.get(i).nobgColor.equals("true")) {
	    		  cds.TotalCost =(cartItem.get(i).rate + ((cartItem.get(i).extra) * (cartItem.get(i).extraUnit))) * cartItem.get(i).dates.length;
	    		System.out.println("Both NOT selected ");
	    	  }
	    	  else if(cartItem.get(i).onBorderSelected.equals("Yes")&&cartItem.get(i).nobgColor.equals("false")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBackgroud + cartItem.get(i).extraForBorder + ((cartItem.get(i).extra)*(cartItem.get(i).extraUnit)))*cartItem.get(i).dates.length;
	    		  System.out.println("Both selected ");
	    	  }
	    	  else if(cartItem.get(i).onBorderSelected.equals("Yes")&&cartItem.get(i).nobgColor.equals("true")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBorder + ((cartItem.get(i).extra) * (cartItem.get(i).extraUnit)))*cartItem.get(i).dates.length;
	    		  System.out.println("Yes border selected ");
	    	  }else if (cartItem.get(i).onBorderSelected.equals("No")&&cartItem.get(i).nobgColor.equals("false")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBackgroud+((cartItem.get(i).extra) * (cartItem.get(i).extraUnit))) * cartItem.get(i).dates.length;
	    		  System.out.println("NO border selected ");
	    	  }
	    		 System.out.println("Full total to save into Db:"+cds.TotalCost);
	    	  JPA.em().persist(cds);
	    	   }
	     } catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("In makebooking"+nodes);
		/* System.out.println("\n sub"+subcategory);*/
		 return ok("");
	 }
	    
	
}
