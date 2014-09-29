package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Adler32;

import models.Adcategory;
import models.AddressDetails;
import models.Basicrate;
import models.City;
import models.ComposedAdSave;
import models.Newspaperdetails;
import models.Order;
import models.State;
import models.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.UtilityQuery;
import viewmodel.CCAvenueDefaultVM;
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
	    	List<Object[]> rates1 = UtilityQuery.getBasicRateByLocationAndCategory(Location.trim(),Category.trim()); 
		 
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
		// get the data for discount
		List<Object[]> rates1 = UtilityQuery.getBasicRateByNewspaperAndCategory(newspaper.trim(),Category.trim());
		List<Object[]> discountRates = UtilityQuery.getDiscountRateByNewspaperAndCategory(newspaper.trim(),Category.trim());
		
		List<DiscountRate> discRates = Lists.newArrayList();
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
			
				for(Object[] discntRate: discountRates ){
					String str; 
	            	str=discntRate[4].toString();
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
					
	             discRates.add(DiscountRate.byId(discntRate[0].toString())
	        	.withCityAndNewspaper(discntRate[1].toString(),discntRate[2].toString())
	        	.withAmountAndFreeUnit(discntRate[3].toString(),letter,number)
	        	.withOverUnit(discntRate[4].toString(), discntRate[6].toString(),discntRate[7].toString(),discntRate[8].toString(),discntRate[9].toString(),discntRate[10].toString(),discntRate[11].toString(),discntRate[12].toString(),discntRate[13].toString(),discntRate[14].toString()) );
         }
				
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rates", rates);
		map.put("discRates", discRates);
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
	
	
	
	

	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class DiscountRate {
		public String id;
		public String location; //Agra
		public String newspaper;//Time of India
        public String dTotalPrice;
        public String tBasicPrice; 
        public String tOffpercentage; 
        public String tTotleprice;
        public String dBasicPrice;
        public String dOffPrice; 
        public String extraCostperLine;
        public String border;
        public String backColor;
        public String specialDiscount;
        public String unit; 
        public String unitVal;
        public String extra;
        public String extraFortick;
        public String extraCostpersqcm;
        public String cutOfBookingDate;
      /*  public String extraForBorder;
        public String extraForBackgroud;*/
        public Boolean isSelected;
		 
        public static DiscountRate byId(String id) {
        	DiscountRate discountRate = new DiscountRate();
        	discountRate.id = id;
            return discountRate;
        }

        public DiscountRate withCityAndNewspaper(String location, String newspaper) {
            this.newspaper = newspaper;
            this.location = location;
            System.out.println("newspaper"+newspaper);
            System.out.println("location"+location);
            return this;
        }

        public DiscountRate withAmountAndFreeUnit(String dTotalPrice, String unit,String unitVal) {
        	this.dTotalPrice = dTotalPrice;
        	this.unit = unit;
            this.unitVal = unitVal;
            System.out.println("unit in discunt"+unit);
            System.out.println("dTotalPrice in discount"+dTotalPrice);
            return this;
        }

        public DiscountRate withOverUnit(String tBasicPrice, String tTotleprice,String dBasicPrice,String extraCostperLine,
        		String border,String backColor,String specialDiscount,String cutOfBookingDate,        	
        		String extraFortick,String extraCostpersqcm) {
        	this.tBasicPrice = tBasicPrice;
        	this.tTotleprice = tTotleprice;
        	this.dBasicPrice = dBasicPrice;
        	this.extraCostperLine=extraCostperLine;
        	this.border = border; 
            this.backColor = backColor;
            System.out.println("backColor"+backColor);
            this.specialDiscount = specialDiscount;
           /* this.border = border;
            System.out.println("extraForBorder:"+border);
            this.cutOfBookingDate = cutOfBookingDate;
            System.out.println("extraForBackgroud"+backColor);
            this.backColor = backColor;*/
            this.extraFortick = extraFortick;
            this.extraCostpersqcm = extraCostpersqcm;
            return this;
      }
	
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
        public int  unitVal = 1; //2
        public String extra; //15
        public String freeUnit; // 20
        public String extraFortick;
        public String extraCostpersqcm;
        public String cutOfBookingDate;
        public String extraForBorder;
        public String extraForBackgroud;
        public Boolean isSelected;
		
		
		
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

        public Rate withAmountAndFreeUnit(String amount, String unit,String  freeUnit) {
        	this.rate = amount;
        	this.unit = unit;
            this.freeUnit=freeUnit;
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
		public String id;
		public String type;
		public String description;
		public String mainCategoty;
		public String subcategory;
		public String location;
		public String newspaper;
		public float rate; //200
		public String unit; //word
		public int unitVal = 1; //2
		public int extra; //15
		public String freeUnit; // 20
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
		public String startDate;
		public float extraFortick;
		public String notickforAd;
		
		public CartItem() {};
		public CartItem(String id, String type, String location, String mainCategoty,
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
	public static class DiscountCartItem {
		public String id;
		public String type;
		public String description;
		public String mainCategoty;
		public String subcategory;
		public String location;
		public String newspaper;
		public float  dTotalPrice;
	    public String tBasicPrice; 
	    public String tOffpercentage; 
	    public String tTotleprice;
	    public String dBasicPrice;
	    public String dOffPrice; 
	    public String extraCostperLine;
	    public String border;
	    public String backColor;
	    public String specialDiscount;
	    public String unit; 
	    public float unitVal;
	    public float extra;
	    public String extraFortick;
	    public String extraCostpersqcm;
	    public String cutOfBookingDate;
	    public float extraForBorder;
	    public float extraForBackgroud;
	    public Boolean isSelected;
		
		public DiscountCartItem() {};
		public DiscountCartItem(String id, String type, String location, String mainCategoty,
				String subcategory, String newspaper, float dTotalPrice) {
			super();
			this.id = id;
			this.type = type;
			this.location = location;
			this.mainCategoty = mainCategoty;
			this.subcategory = subcategory;
			this.newspaper = newspaper;
			this.dTotalPrice = dTotalPrice;
			this.description = location + "-" + newspaper + "(" + mainCategoty + (subcategory==null ? "" : "/" + subcategory) + ")"; 
		}
	
	}
	
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class Address {
		public Long id;
		public String pinCode;
		public String fullName;
		public String shippingAddress;
		public String city;
		public String state;
		public String mobile; 
		public String userid;
		
		
		public Address() {};
		public Address(Long id, String  pinCode, String fullName, String shippingAddress,
				 String city, String state,String mobile,String userid ) {
			super();
			this.id = id;
			this.pinCode=pinCode;
			this.fullName = fullName;
			this.shippingAddress = shippingAddress;
			this.city = city;
			this.state = state;
			this.mobile = mobile;
			this.userid=userid;
		}
	
	}


	    @Transactional
	    public static Result  saveComposeyourAd() {
	  
		 JsonNode json = request().body().asJson();
	     //JsonNode nodes = json.path("data");
	     System.out.println(" json value :: "+json.toString());
	     
	     ObjectMapper objectMapper = new ObjectMapper();
	     AddressDetails addressDetails =new AddressDetails();
	     List<CartItem> cartItem ;
	     
	     String emailId;
	     if(json.has("email")) {
	      emailId= json.get("email").asText();
	     } else {
	    	 emailId = session().get("emailId"); 
	     }
	     
	     String modeOfPayment=json.get("modeOfPayment").asText();
	     String orderId = UUID.randomUUID().toString();
	     float amount = 0;
	     List<ComposedAdSave> composedAdSaves = new ArrayList<>();
         
	     try {
	    	 cartItem = objectMapper.readValue(json.get("carts").traverse(),
	    			 new com.fasterxml.jackson.core.type.TypeReference<List<CartItem>>() {});
	         
	         for(int i=0; i < cartItem.size(); i++) {
	          ComposedAdSave cds=new ComposedAdSave();
	          cds.Category=cartItem.get(i).mainCategoty;
	          cds.Subcategory=cartItem.get(i).subcategory;
	          cds.Nameofthenewspaper=cartItem.get(i).newspaper;   //location saved here
	    	  cds.City=cartItem.get(i).location;//paper name saved here
 	    	  cds.Adtext=cartItem.get(i).description;
	    	  cds.TotalCost=cartItem.get(i).fullTotal;
	    	  cds.OrderID = orderId;
	    	  cds.BorderCost=cartItem.get(i).extraForBorder;
	    	  cds.BgcolorRate=cartItem.get(i).extraForBackgroud;
	    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//save dates in DB
	    	  Calendar c = Calendar.getInstance();
	    	  cds.PublishDate="";
	    	  for( int j =0; j < cartItem.get(i).dates.length; j++){
	    		  try {
					Date dt = sdf.parse(cartItem.get(i).dates[j]);
					c.setTime(dt);
					cds.PublishDate+=c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DATE)+",";
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
	    	  }
	    	  
	    	  cds.BasicRate=cartItem.get(i).unit;
	    	  cds.numberOfWords=cartItem.get(i).totalUnit;
	    	  cds.userEmailId=emailId;
	    	  cds.paymentOption=modeOfPayment;
	    	  cds.Border=cartItem.get(i).onBorderSelected;
	    	  cds.Bgcolor=cartItem.get(i).onbgColorchange;
	    	  cds.TickRate = cartItem.get(i).extraFortick;
	    	  cds.Tick = cartItem.get(i).notickforAd;
	    	  Date date = new Date();
	    	  cds.orderDate = sdf.format(date);//current date i.e. order date saved here
	    	  
	    	  //cartItem.get(i).nobgColor=   'true' means it is not selected ;
	    	  //cartItem.get(i).notickforAd = 'true' means it is not selected ;
	    	  
	    	  if( cartItem.get(i).onBorderSelected.equals("No") && cartItem.get(i).nobgColor.equals("true")  && cartItem.get(i).notickforAd.equals("true") ) {
	    		  cds.TotalCost =(cartItem.get(i).rate + ((cartItem.get(i).extra) * (cartItem.get(i).extraUnit))) * cartItem.get(i).dates.length;
	    	    
	    	  }
	    	  else if( cartItem.get(i).onBorderSelected.equals("No") && cartItem.get(i).nobgColor.equals("true")  && cartItem.get(i).notickforAd.equals("false")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraFortick + ((cartItem.get(i).extra) * (cartItem.get(i).extraUnit)) ) * cartItem.get(i).dates.length;
	    	       
	    	  }
	    	  else if(cartItem.get(i).onBorderSelected.equals("Yes") && cartItem.get(i).nobgColor.equals("false") && cartItem.get(i).notickforAd.equals("true")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBackgroud + cartItem.get(i).extraForBorder + ((cartItem.get(i).extra)*(cartItem.get(i).extraUnit)))*cartItem.get(i).dates.length;
	    	
	    	  }
	    	  else if(cartItem.get(i).onBorderSelected.equals("Yes") && cartItem.get(i).nobgColor.equals("false") && cartItem.get(i).equals("false") ){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBackgroud + cartItem.get(i).extraForBorder + cartItem.get(i).extraFortick +((cartItem.get(i).extra)*(cartItem.get(i).extraUnit)))*cartItem.get(i).dates.length;
	    		  
	    	  }
	    	  else if(cartItem.get(i).onBorderSelected.equals("Yes") && cartItem.get(i).nobgColor.equals("true") && cartItem.get(i).notickforAd.equals("true")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBorder + ((cartItem.get(i).extra) * (cartItem.get(i).extraUnit)))*cartItem.get(i).dates.length;
	    	    
	    	  }
	    	  else if(cartItem.get(i).onBorderSelected.equals("Yes") && cartItem.get(i).nobgColor.equals("true")&& cartItem.get(i).notickforAd.equals("false")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBorder + cartItem.get(i).extraFortick+((cartItem.get(i).extra) * (cartItem.get(i).extraUnit)))*cartItem.get(i).dates.length;
	    	     
	    	  }
	    	  else if (cartItem.get(i).onBorderSelected.equals("No") && cartItem.get(i).nobgColor.equals("false") && cartItem.get(i).notickforAd.equals("true")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBackgroud+((cartItem.get(i).extra) * (cartItem.get(i).extraUnit))) * cartItem.get(i).dates.length;
	    	
	    	  }
	    	  else if (cartItem.get(i).onBorderSelected.equals("No") && cartItem.get(i).nobgColor.equals("false") &&   cartItem.get(i).notickforAd.equals("false")){
	    		  cds.TotalCost =(cartItem.get(i).rate + cartItem.get(i).extraForBackgroud + cartItem.get(i).extraFortick +((cartItem.get(i).extra) * (cartItem.get(i).extraUnit))) * cartItem.get(i).dates.length;
	    		 
	    	  }
	    	  amount = amount +  cds.TotalCost;
	    	  
	    	  composedAdSaves.add(cds);
	    	  //JPA.em().persist(cds);
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
	     
	     Order o = new Order();
	     o.orderId = orderId;
	     o.email = emailId;
	     o.total = amount;
	     o.composedAd = composedAdSaves;
	     JPA.em().persist(o);
	     
	     Address address;
	     try {
			address = objectMapper.readValue(json.get("address").traverse(),Address.class);
	    	addressDetails.pinCode=address.pinCode;
	    	addressDetails.fullName=address.fullName;
	    	addressDetails.address=address.shippingAddress;
	    //	addressDetails.nearestLandmark=address.nearestLandmark;
	    	addressDetails.city=address.city;
	    	addressDetails.state=address.state;
	    	addressDetails.mobile=address.mobile;
	    //	addressDetails.landLine=address.landline;
	    	addressDetails.userEmailid=emailId;
	    	addressDetails.orderId = orderId;
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
	     response().setCookie("orderId", orderId);
	     System.out.println("orderId " + orderId);
	     if(!modeOfPayment.equalsIgnoreCase("cod")) {
	    	return ok(routes.CCAvenueController.ccavenue(orderId.trim()).url());
	     }
		 return ok(orderId);
	 }
}
