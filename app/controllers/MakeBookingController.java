package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
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

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FilenameUtils;

import models.Adcategory;
import models.AddressDetails;
import models.Basicrate;
import models.City;
import models.ComposedAdSave;
import models.Newspaperdetails;
import models.Order;
import models.State;
import models.User;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData.FilePart;
import scala.Array;
import scala.util.parsing.json.JSONObject;
import utils.SendMailUtility;
import utils.UtilityQuery;
import viewmodel.CCAvenueDefaultVM;
import viewmodel.NewspaperVM;
import viewmodel.Rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
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
			 //
			session().clear();
			String name=existingUser.name;
    		session().put("emailId",Username );
    		session().put("userName",name);
		    return ok(existingUser.name+"");
		}
		else {
		flash("login_error", "Please check your username and password");
		 return ok("true");
	   }
	 }
	    @Transactional
	    public static Result getBasicRateByLocationAndCategory(String Location,String Category , String selectYourAd) {
	    	if("textClasified".equals(selectYourAd)){
	    		System.out.println("in text");
	    	List<Object[]> rates1 = UtilityQuery.getBasicRateByLocationAndCategory(Location.trim(),Category.trim()); 
	    	List<Object[]> discountRates = UtilityQuery.getDiscountRateByLocationAndCategory(Location.trim(),Category.trim());
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
        				.withOverUnit(rs[5].toString(), rs[6].toString(),rs[7].toString(),rs[8].toString(),rs[9].toString(),
        						rs[11].toString(),rs[12].toString(),rs[13].toString(),
        						rs[10].toString(),rs[14].toString(),Integer.parseInt(rs[15].toString())));
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
        	.withOverUnit(discntRate[5].toString(), discntRate[6].toString(),discntRate[7].toString(),discntRate[8].toString(),discntRate[9].toString(),discntRate[10].toString(),discntRate[11].toString(),discntRate[12].toString(),discntRate[13].toString(),discntRate[14].toString(),Integer.parseInt(discntRate[15].toString())) );
     }
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("rates", rates);
		    map.put("discRates", discRates);
			System.out.println(Json.toJson(map));
			return ok(Json.toJson(map));
	   }else  if ("displayClassified".equals(selectYourAd)){System.out.println("inn classified");
	    		List<Object[]> rates1 = UtilityQuery.getBasicRateByLocationAndCategoryForDisplay(Location.trim(),Category.trim()); 
		    	List<Object[]> discountRates = UtilityQuery.getDiscountRateByLocationAndCategoryForDisplay(Location.trim(),Category.trim());
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
	        				.withOverUnit(rs[5].toString(), rs[6].toString(),rs[7].toString(),rs[8].toString(),rs[9].toString(),
	        						rs[11].toString(),rs[12].toString(),rs[13].toString(),
	        						rs[10].toString(),rs[14].toString(),Integer.parseInt(rs[15].toString())) );
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
	        	.withOverUnit(discntRate[5].toString(), discntRate[6].toString(),discntRate[7].toString(),discntRate[8].toString(),discntRate[9].toString(),discntRate[10].toString(),discntRate[11].toString(),discntRate[12].toString(),discntRate[13].toString(),discntRate[14].toString(),Integer.parseInt(discntRate[15].toString())) );
	     }
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rates", rates);
	    map.put("discRates", discRates);
		System.out.println(Json.toJson(map));
		return ok(Json.toJson(map));
	    		
	    	}
         return null;
	    }
	    
	    
	   @Transactional
	    public static Result getOrderDetailsByOrderId (String orderIdPer) {
	    	List<Object[]> orde = UtilityQuery.getDetailsByOrderId(orderIdPer); 
	    	System.out.println("orderList"+orde.toString());
	    	List<OrderList> orderListuser = Lists.newArrayList();
	    	for(Object[] ol :orde) {
	    	String str =ol[10].toString();
           	String dates[] = str.split(",");   
	    
                orderListuser.add(OrderList.byId(ol[24].toString())
                		       .cancelOrderDetails(ol[1].toString(), ol[2].toString(),ol[3].toString(),ol[4].toString(),ol[5].toString(),ol[6].toString(),ol[7].toString(),ol[8].toString(),ol[9].toString(),dates,ol[11].toString(),ol[12].toString(),ol[13].toString(),ol[14].toString(),ol[15].toString(),ol[16].toString(),(float) ol[17],(float) ol[18], (float) ol[19], (int) ol[20],(float) ol[21],Boolean.parseBoolean(ol[22].toString()),Boolean.parseBoolean(ol[23].toString()), ol[25].toString(),ol[26].toString(), ol[27].toString(),ol[28].toString(),(int) ol[29],ol[30].toString(),ol[31].toString(),ol[32].toString(),ol[33].toString(),ol[34].toString(),ol[35].toString(),ol[36].toString(),ol[37].toString(),ol[38].toString(),ol[39].toString(),ol[40].toString(),ol[41].toString(),ol[42].toString(),ol[43].toString(),ol[44].toString(),ol[45].toString()));
        	}
	    	Map<String,Object> map = new HashMap<String, Object>();
			map.put("orderListuser",orderListuser);
			return ok(Json.toJson(map));
	    }
	    
	@Transactional
	public static Result getRatesByNewspaper(String newspaper,String Category,String selectYourAd) {
		// get the data for discount
		//System.out.println("selectYourAd:"+selectYourAd);
		String selectYourAd1 = selectYourAd.trim();
       	if("textClasified".equals(selectYourAd1) ){
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
	        				.withOverUnit(rs[5].toString(), rs[6].toString(),rs[7].toString(),
	        						rs[8].toString(),rs[9].toString(),rs[11].toString(),rs[12].toString(),rs[13].toString(),rs[10].toString(),rs[14].toString(),Integer.parseInt(rs[15].toString())) );
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
	        	.withOverUnit(discntRate[5].toString(), discntRate[6].toString(),discntRate[7].toString(),discntRate[8].toString(),discntRate[9].toString(),discntRate[10].toString(),discntRate[11].toString(),discntRate[12].toString(),discntRate[13].toString(),discntRate[14].toString(),Integer.parseInt(discntRate[15].toString())) );
         }
				
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rates", rates);
		map.put("discRates", discRates);
		return ok(Json.toJson(map));
       	}else if ("displayClassified".equals(selectYourAd.trim())){
       		System.out.println("displayClassified:"+selectYourAd);
       		List<Object[]> rates1 = UtilityQuery.getBasicRateByNewspaperAndCategoryForDisplay(newspaper.trim(),Category.trim());
    		List<Object[]> discountRates = UtilityQuery.getDiscountRateByNewspaperAndCategoryForDisplay(newspaper.trim(),Category.trim());
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
    	        				.withOverUnit(rs[5].toString(), rs[6].toString(),rs[7].toString(),
    	        						rs[8].toString(),rs[9].toString(),rs[11].toString(),rs[12].toString(),rs[13].toString(),rs[10].toString(),rs[14].toString(),Integer.parseInt(rs[15].toString())) );
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
    	        	.withOverUnit(discntRate[5].toString(), discntRate[6].toString(),discntRate[7].toString(),discntRate[8].toString(),discntRate[9].toString(),discntRate[10].toString(),discntRate[11].toString(),discntRate[12].toString(),discntRate[13].toString(),discntRate[14].toString(),Integer.parseInt(discntRate[15].toString())) );
             }
    				
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("rates", rates);
    		map.put("discRates", discRates);
    		return ok(Json.toJson(map));	
       	}
       	return null; 
	}
	 // check for order Status when page is refreshed.
    @Transactional
    public static Result checkforOrderStatus(String orderIdStatus) {
    System.out.println("orderIdStatus num"+orderIdStatus);
    Order orderStatus = Order.getOrderStatus(orderIdStatus);
    System.out.println("orderStatus:::"+orderStatus);
    
    	if((orderStatus) == null){   
    		return ok("false");	
    	}else{
    		return ok("true");
    	}
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
	public static class OrderList {
		public String id;
		
		public String OrderId;
		public String newspaper;
		public String description;
		public String bgcolor;
		//public String border;
		public String mainCategoty;
		public String subcategory;
		public String location;
		//public String newspaper;
		public String unit;
		public String onbgColorchange;
		public String onBorderSelected;
		public String extraForBorder;
		public String extraForBackgroud;
		public String totalUnit;//number of words
		public String  fullTotal; 
		//public String userid;
	    public String  [] dates;
		public String datesSelected;
		//public float extraUnit;
		//public String nobgColor;
		public String adbookedDate;
		public String extraFortick;
		public boolean notickforAd;
		public float extra;
		public String freeunit;
		public float totalExtraCost;
		public float totalUnitCost;
		public int noOfImpression;
		public float rate;
		public boolean bgColorSelect;
		public String extraForBorderInPer;
	    public String extraForBackgroudInPer;
	    public String extraFortickInPer;
	    public int numberOfWords;
	   
	    public String  descriptionFooter;
	    public String  descriptionHeader;
	    public String  descriptionBody;
	    public String footerColor;
	    public String  bodyColor;
	    public String headerColor;
	    public String adType;
	    public String  colorAd;
	    public String  imageAd;
	    public String  adSizeSelect;
	   // public float extraCost;
	    public String adSelectedType;
	    //for disp user defined ad
	    public String otherWidth;
	    public String height;
	    public String originalFileName;
	    public String freewords;
	    public String extraCostpersqcm;
	    
	    public static OrderList byId(String id) {
			 OrderList orderList = new OrderList();
			 orderList.id = id;
	         return orderList;
	        }
		   public  OrderList cancelOrderDetails(String OrderId,String newspaper,String  location ,String description, String extraFortick , String onbgColorchange ,String extraForBackgroud,
				   String onBorderSelected , String extraForBorder , String []  dates,String unit , String  fullTotal,  String mainCategoty ,  String totalUnit , String adbookedDate,
				   String freeunit, float extra, float totalExtraCost ,float totalUnitCost, int noOfImpression, float rate, boolean bgColorSelect ,boolean notickforAd ,String extraForBorderInPer,String extraForBackgroudInPer,String  extraFortickInPer, String subcategory, int  numberOfWords
    			  ,String descriptionFooter,String descriptionHeader, String descriptionBody,String footerColor,String bodyColor,String headerColor,String adType,String colorAd,String imageAd,String adSizeSelect, String adSelectedType,String otherWidth,String height, String originalFileName,String freewords,String extraCostpersqcm){
			   
			   this.OrderId=OrderId;
			   this.newspaper=newspaper;
			   this.location=location;
			   this.description=description;
			   this.extraFortick = extraFortick;
			   this.onbgColorchange = onbgColorchange;
			   this.extraForBackgroud=extraForBackgroud;
			   this.onBorderSelected =  onBorderSelected;
			   this.extraForBorder = extraForBorder;
			   this.dates = dates;
			   this.unit=unit;
			   this.mainCategoty = mainCategoty;
			   this.fullTotal=fullTotal;
			   this.extraForBorder=extraForBorder;
			   this.totalUnit=totalUnit;
			   this.adbookedDate = adbookedDate;
			   this.extra = extra;
			   this.freeunit = freeunit;
			   this.totalExtraCost = totalExtraCost;
			   this.totalUnitCost = totalUnitCost;
			   this.noOfImpression = noOfImpression;
			   this.rate = rate;
			   this.bgColorSelect = bgColorSelect;
			   this.notickforAd = notickforAd;
			   this.extraForBorderInPer = extraForBorderInPer;
			   this.extraForBackgroudInPer = extraForBackgroudInPer;
			   this.extraFortickInPer = extraFortickInPer;
			   this.subcategory = subcategory;
			   this.numberOfWords = numberOfWords;
			   this.descriptionFooter = descriptionFooter;
			   this.descriptionHeader = descriptionHeader;
			   this.descriptionBody = descriptionBody;
			   this.footerColor = footerColor;
			   this.bodyColor = bodyColor;
			   this.headerColor = headerColor;
			   this.adType = adType;
			   this.colorAd = colorAd;
			   this.imageAd = imageAd;
			   this.adSizeSelect = adSizeSelect;
			   this.adSelectedType = adSelectedType;
			   this.otherWidth = otherWidth;
			   this.height = height;
			   this.originalFileName =originalFileName; 
			   this.freewords = freewords;
			   this.extraCostpersqcm = extraCostpersqcm;
			   return this;
		   }
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
        public int unitVal= 1;
        public String extra;
        public String extraFortick;
        public String extraCostpersqcm;
        public String cutOfBookingDate;
        public String freeUnit;
        public String extraForBorderInPer;
        public String extraForBackgroudInPer;
        public String extraFortickInPer;
        public Boolean isSelected;
        public String  packageSelected = "P";
        public int numberOfWords;
        public String freewords;
        public int Allow;
        public static DiscountRate byId(String id) {
        	DiscountRate discountRate = new DiscountRate();
        	discountRate.id = id;
            return discountRate;
        }

        public DiscountRate withCityAndNewspaper(String location, String newspaper) {
            this.newspaper = newspaper;
            this.location = location;
            return this;
        }

        public DiscountRate withAmountAndFreeUnit(String dTotalPrice, String unit,String freeUnit) {
        	this.dTotalPrice = dTotalPrice;
        	this.unit = unit;
            this.freeUnit = freeUnit;
           
            return this;
        }

        public DiscountRate withOverUnit(String extraCostperLine,
        		String border,String backColor,String specialDiscount,     	
        		String extraFortick,String extraCostpersqcm,String extraForBackgroudInPer,
        		String extraForBorderInPer,String extraFortickInPer,String freewords,int Allow) {
        	
        	
        	this.extraCostperLine=extraCostperLine;//extra for line
        	this.border = border; //border selected or not 
            this.backColor = backColor;//bgColor Selected or not
            this.specialDiscount = specialDiscount;
            this.extraFortick = extraFortick;
            this.extraCostpersqcm = extraCostpersqcm;
            this.extraForBackgroudInPer=extraForBackgroudInPer;
            this.extraForBorderInPer=extraForBorderInPer;
            this.extraFortickInPer=extraFortickInPer;
            this.freewords = freewords;
            this.Allow = Allow;
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
        public String extraForBorderInPer;
        public String extraForBackgroudInPer;
        public String extraFortickInPer;
        public Boolean isSelected;
        public String  packageSelected = "B";
	    public String subcategory;	
	    public String freewords;
	    public int Allow;
	    
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

        public Rate withOverUnit(String extra,String cutOfBookingDate,
        		String extraForBorder,String extraForBackgroud, String	extraFortick,
        		String extraForBorderInPer,String extraForBackgroudInPer, String extraFortickInPer,
        		String extraCostpersqcm,String freewords,int Allow) {
            this.extra = extra;
            this.cutOfBookingDate=cutOfBookingDate;
            this.extraForBorder=extraForBorder;
            this.extraForBackgroud=extraForBackgroud;
            this.extraFortick=extraFortick;
            this.extraForBorderInPer=extraForBorderInPer;
            this.extraForBackgroudInPer=extraForBackgroudInPer;
            this.extraFortickInPer=extraFortickInPer;
            this.extraCostpersqcm=extraCostpersqcm;
            this.freewords = freewords;
            this.Allow = Allow;
         
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
		public float fullTotal=0; 
		public String userid;
		public String  [] dates = {};
		public float extraUnit;
		public String nobgColor;
		public String startDate;
		public float extraFortick;
		public String notickforAd;
		public float totalExtraCost;
		public float totalUnitCost;
		public int noOfImpression;
		public boolean bgColorSelect;
		public String extraForBorderInPer;
	    public String extraForBackgroudInPer;
	    public String extraFortickInPer;
	    public String  packageSelected;
	    public String bodyColor;
	    public String headerColor;
	    public String footerColor;
	    public String descriptionFooter;
	    public String descriptionHeader;
	    public String descriptionBody;
	    public String adSelectedType;
	    public String   colorAd;
	    public String BWAd;
	    public String imageAd;
	    public String adSizeSelect;
	    public float extraCost;
	    public String extraCostpersqcm;
	   
	    //for dispplay user defined ad.
	    public int otherWidth;
	    public int height;
	    public String freewords;
		/*//to store the image path 
	    public String originalFileName;
	    */
	    //public float FinalTotal = 0;
		
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
	   // public String extraFortick;
	    public String extraCostpersqcm;
	    public String cutOfBookingDate;
	    //public float extraForBorder;
	   // public float extraForBackgroud;
	    public String extraForBordeper;
        public String extraForBackgroudper;
        public  String tickPer;
	    public Boolean isSelected;
	    public int numberOfWords;
		
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
        String  emailId = session().get("emailId"); 
        public static void createDir(String rootDir) {
	        File file3 = new File(rootDir);
	        if (!file3.exists()) {
	                file3.mkdirs();
	        }
		}	
        final static String rootDir = Play.application().configuration().getString("adimage.storage.path");
  	  static {
        createRootDir();
  }

  public static void createRootDir() {
        File file = new File(rootDir);
        if (!file.exists()) {
                file.mkdir();
        }
  }
  
 /* @Transactional
  public static class DisplayCartItem {
    	 public List<CartItemDisp> carts =  new ArrayList<>() ;
         public Address address;
    	 public String email;
    	 public String modeOfPayment;
    	 public String adSelectedType; 
    	}
      */
        @Transactional
	    public static Result  saveComposeyourAd() throws JsonProcessingException, IOException {
        	  DynamicForm form = DynamicForm.form().bindFromRequest();
 		     System.out.println("carts value :"+form.get("carts"));
 		     
 		    ObjectMapper mapper = new ObjectMapper();
		     //JSONObject json = (JSONObject) JSONSerializer.toJSON(data);        
		     JsonNode jsonAddress =  mapper.readTree(form.get("address"));
		     JsonNode jsonEmail = Json.toJson(form.get("email"));
		     JsonNode jsonAdSelect = Json.toJson(form.get("adSelectedType"));
		     JsonNode jsonmodeOfPayment = Json.toJson(form.get("modeOfPayment"));
		     
		     JsonNode carts = mapper.readTree(form.get("carts"));
 		     
        	ObjectMapper objectMapper = new ObjectMapper();
	     AddressDetails addressDetails =new AddressDetails();
	     List<CartItem> cartItem ;
	     String emailId;
	     if(jsonEmail.asText() != null) {
	    	 emailId= jsonEmail.asText();
	    	 //System.out.println("json1.getFile"+json1.getFile("email").toString());
	     } else {
	    	 emailId = session().get("emailId"); 
	     }
	     String modeOfPayment=jsonmodeOfPayment.asText();
	     String orderId = UUID.randomUUID().toString();
	    
	     long order =  orderId.hashCode();
	     //orderId = orderId.substring(orderId.lastIndexOf("-") + 1);
         order = Math.abs(order);//convert to positive if hashcode is obtained  negitive.
	     orderId = Long.toString(order);//convert order id to String. 
	    // System.out.println("orderId::"+orderId);
	    
	     float amount = 0;
	     List<ComposedAdSave> composedAdSaves = new ArrayList<>();
	     /*cartItem = objectMapper.readValue(json.get("carts").traverse(),
				 new com.fasterxml.jackson.core.type.TypeReference<CartItem>() {});
		*/ 
		 cartItem = mapper.convertValue(carts, mapper.getTypeFactory().constructCollectionType(List.class, CartItem.class));
		 
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
		  cds.Extrabgper = cartItem.get(i).extraForBackgroudInPer;
		  cds.Extraborderper =cartItem.get(i).extraForBorderInPer;
		  cds.Tickper = cartItem.get(i).extraFortickInPer;
		 // System.out.println("cartItem.get(i).extraFortickInPer"+cartItem.get(i).extraFortickInPer);
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//save dates in DB
		  Calendar c = Calendar.getInstance();
		  cds.PublishDate="";
		 for( int j =0; j < cartItem.get(i).dates.length; j++){
			  try {
				Date dt = sdf.parse(cartItem.get(i).dates[j]);
				c.setTime(dt);
				cds.PublishDate+=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+",";
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  }
		  cds.BasicRate=cartItem.get(i).unit;
		  cds.numberOfWords=cartItem.get(i).totalUnit;
		  cds.userEmailId=emailId;
		  cds.paymentOption=modeOfPayment;
		  cds.Border=cartItem.get(i).onBorderSelected;
		 //to handle  null values
		  if(cartItem.get(i).onbgColorchange == null){
			  cds.Bgcolor= "true";
		  }else{
			  cds.Bgcolor=cartItem.get(i).onbgColorchange;
		  }
		 
		  if(cartItem.get(i).notickforAd == null){
			  cds.Tick = "true";
		  }else{
			  cds.Tick = cartItem.get(i).notickforAd;
		  }
		  
		  cds.TickRate = cartItem.get(i).extraFortick;
		  cds.extra =  cartItem.get(i).extra;
		  cds.freeunit = cartItem.get(i).freeUnit;
		  cds.totalExtraCost = cartItem.get(i).totalExtraCost;
		  cds.totalUnitCost = cartItem.get(i).totalUnitCost;
		  cds.noOfImpression = cartItem.get(i).noOfImpression;
		  cds.rate = cartItem.get(i).rate;
		  cds.bgColorSelect = cartItem.get(i).nobgColor;
		  cds.adbookedId = cartItem.get(i).id;
		  cds.packageType = cartItem.get(i).packageSelected;
		  cds.headerColor = cartItem.get(i).headerColor;
		  cds.bodyColor = cartItem.get(i).bodyColor;
		  cds.footerColor  = cartItem.get(i).footerColor;
		  cds.footerDescption = cartItem.get(i).descriptionFooter;
		  cds.headerDescption = cartItem.get(i).descriptionHeader;
		  cds.bodyDescription = cartItem.get(i).descriptionBody;
		  cds.colorAd = cartItem.get(i).colorAd;
		  cds.BWAd = cartItem.get(i).BWAd;
		  cds.imageAd = cartItem.get(i).imageAd;
		  cds. adSizeSelect = cartItem.get(i).adSizeSelect;
		  cds.freewords = cartItem.get(i).freewords;
				  
		 // cds.widthSelected = cartItem.get(i).
		     
		  //ad type save here
		  cds.adSelectedType =  jsonAdSelect.asText();
		  System.out.println("ad type"+cds.adSelectedType);
		  cds.extraCost = cartItem.get(i).extraCost;
		  Date date = new Date();
		  cds.orderDate = sdf.format(date);//current date i.e. order placed date saved here
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
		  System.out.println("amount :"+amount);
		  composedAdSaves.add(cds);
	
		   }
	     
	     Order o = new Order();
	     o.orderId = orderId;
	     o.email = emailId;
	     o.total = amount;
	     o.orderDate = new Date();
	     o.composedAd = composedAdSaves;
	     JPA.em().persist(o);
	     
	     Address address;
	     try {
			//address = objectMapper.readValue(json.get("address").traverse(),Address.class);
	    	 address = objectMapper.readValue(jsonAddress.traverse(),Address.class);
	    	 addressDetails.pinCode=address.pinCode;
	    	addressDetails.fullName=address.fullName;
	    	addressDetails.address=address.shippingAddress;
	    	addressDetails.city=address.city;
	    	addressDetails.state=address.state;
	    	addressDetails.mobile=address.mobile;
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
	     if(!modeOfPayment.equalsIgnoreCase("cod")) {
			//return ok(routes.CCAvenueController.ccavenue(orderId.trim()).url());
	    	return redirect(routes.CCAvenueController.ccavenue(orderId.trim()));
	     }
		 return ok(orderId);
	 }
    public class CountryInfoResponse {
        	   @JsonProperty("carts")
        	   private List<CartItem> cartItems; 
        	   //getter - setter
     }
        
        @Transactional
	    public static Result  saveUserDisplayComposeyourAd() throws JsonProcessingException, IOException {
        	  DynamicForm form = DynamicForm.form().bindFromRequest();
        	  FilePart picture =  request().body().asMultipartFormData().getFile("file");
	 		 createDir(rootDir);
	 		 String originalFileName = null;
	 		 String fileName = picture.getFilename();
	 		 ObjectMapper objectMapper = new ObjectMapper();
		     AddressDetails addressDetails =new AddressDetails();
		     //List<CartItem> cartItem;
		     String emailId;
		     System.out.println(form.get("carts"));
		     JsonNode json = Json.toJson(form.get("carts"));
		     ObjectMapper mapper = new ObjectMapper();
		     JsonNode jsonAddress =  mapper.readTree(form.get("address"));
		     JsonNode jsonEmail = Json.toJson(form.get("email"));
		     JsonNode jsonAdSelect = Json.toJson(form.get("adSelectedType"));
		     JsonNode jsonmodeOfPayment = Json.toJson(form.get("modeOfPayment"));
		     JsonNode actualObj = mapper.readTree(form.get("carts"));
		     if(jsonEmail != null) {
		    	 emailId= jsonEmail.asText();
		    	 //System.out.println("json1.getFile"+json1.getFile("email").toString());
		     } else {
		    	 emailId = session().get("emailId"); 
		     }
		     String modeOfPayment=jsonmodeOfPayment.asText();
		     String orderId = UUID.randomUUID().toString();
		     long order =  orderId.hashCode();
		     //orderId = orderId.substring(orderId.lastIndexOf("-") + 1);
	         order = Math.abs(order);//convert to positive if hashcode is obtained  negitive.
		     orderId = Long.toString(order);//convert order id to String. 
		     float amount = 0;
		     List<ComposedAdSave> composedAdSaves = new ArrayList<>();
		     List<CartItem> cartItem = mapper.convertValue(actualObj, mapper.getTypeFactory().constructCollectionType(List.class, CartItem.class));
			 for(int i=0; i < cartItem.size(); i++) {
				 if(FilenameUtils.getExtension(fileName).equals("jpg")){
			 		 String ThumbnailImage = rootDir + File.separator +orderId+"."+FilenameUtils.getExtension(fileName);
			         originalFileName = rootDir + File.separator +orderId+"."+FilenameUtils.getExtension(fileName);
			          File src = picture.getFile();
			          OutputStream out = null;
			          BufferedImage image = null;
			          File f = new File(ThumbnailImage);
			          System.out.println(originalFileName);
			          try {
			                         BufferedImage originalImage = ImageIO.read(src);
			                         Thumbnails.of(originalImage)
			                             .size(220, 220)
			                             .toFile(f);
			                             File _f = new File(originalFileName);
			                             Thumbnails.of(originalImage).scale(1.0).
			                             toFile(_f);
			          } catch (FileNotFoundException e) {
			                  e.printStackTrace();
			          } catch (IOException e) {
			                  e.printStackTrace();
			          } finally {
			                  try {
			                          if(out != null) out.close();
			                  } catch (IOException e) {
			                          e.printStackTrace();
			                  }
			          }
			  		File filepath = new File(originalFileName);
//			  		System.out.println("filepath:"+filepath);
			  		
			 	}else{
			 		System.out.println("in else");
			 		String fileNameDoc = null;
			 		String filenamedbpath = null;
			 		
			 		play.mvc.Http.MultipartFormData.FilePart docFile;
			 		play.mvc.Http.MultipartFormData body = request().body()
			 				.asMultipartFormData();
			 		docFile = body.getFile("file");

			 		if (docFile != null) {
			 			fileNameDoc = docFile.getFilename();
			 			File file = docFile.getFile();
			 			final String FILE_PATH = Play.application().configuration()
			 					.getString("storage.path");
			 			File f = new File(FILE_PATH + fileNameDoc);
			 			filenamedbpath = FILE_PATH + File.separator + fileNameDoc;
			 			try {
							Files.copy(file.toPath(), f.toPath(),
									java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			 			flash("Success", "File Uploaded successfully");
			 	}
			 	}
				 
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
			  cds.Extrabgper = cartItem.get(i).extraForBackgroudInPer;
			  cds.Extraborderper =cartItem.get(i).extraForBorderInPer;
			  cds.Tickper = cartItem.get(i).extraFortickInPer;
			 // System.out.println("cartItem.get(i).extraFortickInPer"+cartItem.get(i).extraFortickInPer);
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//save dates in DB
			  Calendar c = Calendar.getInstance();
			  cds.PublishDate="";
			 for( int j =0; j < cartItem.get(i).dates.length; j++){
				  try {
					Date dt = sdf.parse(cartItem.get(i).dates[j]);
					c.setTime(dt);
					cds.PublishDate+=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+",";
				} catch (ParseException e) {
					e.printStackTrace();
				}
			  }
			  cds.BasicRate=cartItem.get(i).unit;
			  cds.numberOfWords=cartItem.get(i).totalUnit;
			  cds.userEmailId=emailId;
			  cds.paymentOption=modeOfPayment;
			  cds.Border=cartItem.get(i).onBorderSelected;
			 //to handle  null values
			  if(cartItem.get(i).onbgColorchange == null){
				  cds.Bgcolor= "true";
			  }else{
				  cds.Bgcolor=cartItem.get(i).onbgColorchange;
			  }
			 
			  if(cartItem.get(i).notickforAd == null){
				  cds.Tick = "true";
			  }else{
				  cds.Tick = cartItem.get(i).notickforAd;
			  }
			  cds.TickRate = cartItem.get(i).extraFortick;
			  cds.extra =  cartItem.get(i).extra;
			  cds.freeunit = cartItem.get(i).freeUnit;
			  cds.totalExtraCost = cartItem.get(i).totalExtraCost;
			  cds.totalUnitCost = cartItem.get(i).totalUnitCost;
			  cds.noOfImpression = cartItem.get(i).noOfImpression;
			  cds.rate = cartItem.get(i).rate;
			  cds.bgColorSelect = cartItem.get(i).nobgColor;
			  cds.adbookedId = cartItem.get(i).id;
			  cds.packageType = cartItem.get(i).packageSelected;

			  cds.headerColor = cartItem.get(i).headerColor;
			  cds.bodyColor = cartItem.get(i).bodyColor;
			  cds.footerColor  = cartItem.get(i).footerColor;
			  
			  cds.footerDescption = cartItem.get(i).descriptionFooter;
			  cds.headerDescption = cartItem.get(i).descriptionHeader;
			  cds.bodyDescription = cartItem.get(i).descriptionBody;
			  
			  cds.colorAd = cartItem.get(i).colorAd;
			  cds.BWAd = cartItem.get(i).BWAd;
			  cds.imageAd = cartItem.get(i).imageAd;
			  cds. adSizeSelect = cartItem.get(i).adSizeSelect;
			  //ad type save here
			  cds.adSelectedType =  jsonAdSelect.asText();
			  System.out.println("ad type"+cds.adSelectedType);
			  cds.extraCost = cartItem.get(i).extraCost;
	  	      //for user defined ad (disply classified ad)
	  	      cds.otherWidth = Integer.toString(cartItem.get(i).otherWidth);
	  	      cds.height = Integer.toString(cartItem.get(i).height);
	  	      cds.originalFileName = originalFileName;
	  	      cds.freewords = cartItem.get(i).freewords;
			  Date date = new Date();
			  cds.orderDate = sdf.format(date);//current date i.e. order placed date saved here
			  System.out.println("width"+cartItem.get(i).otherWidth);
			  System.out.println("height"+cartItem.get(i).height);
			  
			  cds.extraCostpersqcm = cartItem.get(i).extraCostpersqcm;
			  System.out.println(" cds.extraCostpersqcm"+ cds.extraCostpersqcm);
			  if(cartItem.get(i).height > 5){
				  int extraHeight =  (cartItem.get(i).height - 5); 
				  System.out.println("in if");
				  cds.TotalCost = (cartItem.get(i).rate + (Integer.parseInt(cartItem.get(i).extraCostpersqcm)) * (extraHeight)) * (cartItem.get(i).dates.length);
			  }else{
				  cds.TotalCost = (cartItem.get(i).rate  * (cartItem.get(i).dates.length));
			  }
			  amount = amount +  cds.TotalCost;
			  System.out.println("amount :"+amount);
			  composedAdSaves.add(cds);
			 }
		     Order o = new Order();
		     o.orderId = orderId;
		     o.email = emailId;
		     o.total = amount;
		     o.orderDate = new Date();
		     o.composedAd = composedAdSaves;
		     JPA.em().persist(o);
		     Address address;
		     try {
				address = objectMapper.readValue(jsonAddress.traverse(),Address.class);
		    	addressDetails.pinCode=address.pinCode;
		    	addressDetails.fullName=address.fullName;
		    	addressDetails.address=address.shippingAddress;
		    	addressDetails.city=address.city;
		    	addressDetails.state=address.state;
		    	addressDetails.mobile=address.mobile;
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
		     if(!modeOfPayment.equalsIgnoreCase("cod")) {
				//return ok(routes.CCAvenueController.ccavenue(orderId.trim()).url());
		    	return redirect(routes.CCAvenueController.ccavenue(orderId.trim()));
		     }
			 return ok(orderId);
		 
	 }
        @Transactional
	    public static Result  saveDisplayColorComposeyourAd() throws JsonProcessingException, IOException {
        	 DynamicForm form = DynamicForm.form().bindFromRequest();
 		   
 		     String originalFileName = null;
	 		 String fileName = null;
 		     ObjectMapper mapper = new ObjectMapper();
		     //JSONObject json = (JSONObject) JSONSerializer.toJSON(data);        
		     JsonNode jsonAddress =  mapper.readTree(form.get("address"));
		     JsonNode jsonEmail = Json.toJson(form.get("email"));
		     JsonNode jsonAdSelect = Json.toJson(form.get("adSelectedType"));
		     JsonNode jsonmodeOfPayment = Json.toJson(form.get("modeOfPayment"));
		     JsonNode actualObj = mapper.readTree(form.get("carts"));
		     ObjectMapper objectMapper = new ObjectMapper();
    	     AddressDetails addressDetails =new AddressDetails();
    	     List<CartItem> cartItem ;
	     String emailId;
	     if(jsonEmail.asText() != null) {
	    	 emailId= jsonEmail.asText();
	    	 //System.out.println("json1.getFile"+json1.getFile("email").toString());
	     } else {
	    	 emailId = session().get("emailId"); 
	     }
	     String modeOfPayment=jsonmodeOfPayment.asText();
	     String orderId = UUID.randomUUID().toString();
	     long order =  orderId.hashCode();
	     //orderId = orderId.substring(orderId.lastIndexOf("-") + 1);
         order = Math.abs(order);//convert to positive if hashcode is obtained  negitive.
	     orderId = Long.toString(order);//convert order id to String. 
	     float amount = 0;
	     List<ComposedAdSave> composedAdSaves = new ArrayList<>();
	     /*cartItem = objectMapper.readValue(json.get("carts").traverse(),
				 new com.fasterxml.jackson.core.type.TypeReference<CartItem>() {});
		*/ 
		 cartItem = mapper.convertValue(actualObj, mapper.getTypeFactory().constructCollectionType(List.class, CartItem.class));
		 for(int i=0; i < cartItem.size(); i++) {
			
			 FilePart picture =  request().body().asMultipartFormData().getFile("file");
			 fileName = picture.getFilename();
			 if(FilenameUtils.getExtension(fileName).equals("jpg")){
				 
				 String ThumbnailImage = rootDir + File.separator +orderId+"."+FilenameUtils.getExtension(fileName);
		          originalFileName = rootDir + File.separator +orderId+"."+FilenameUtils.getExtension(fileName);
		          File src = picture.getFile();
		          OutputStream out = null;
		          BufferedImage image = null;
		          File f = new File(ThumbnailImage);
		          System.out.println(originalFileName);
		          try {
		                         BufferedImage originalImage = ImageIO.read(src);
		                         Thumbnails.of(originalImage)
		                             .size(220, 220)
		                             .toFile(f);
		                             File _f = new File(originalFileName);
		                             Thumbnails.of(originalImage).scale(1.0).
		                             toFile(_f);
		          } catch (FileNotFoundException e) {
		                  e.printStackTrace();
		          } catch (IOException e) {
		                  e.printStackTrace();
		          } finally {
		                  try {
		                          if(out != null) out.close();
		                  } catch (IOException e) {
		                          e.printStackTrace();
		                  }
		          }
		  		File filepath = new File(originalFileName);
		  		System.out.println("filepath:"+filepath);
		  		
		 	}else{
		 		System.out.println("in else");
		 		String fileNameDoc = null;
		 		String filenamedbpath = null;
		 		
		 		play.mvc.Http.MultipartFormData.FilePart docFile;
		 		play.mvc.Http.MultipartFormData body = request().body()
		 				.asMultipartFormData();
		 		docFile = body.getFile("file");

		 		if (docFile != null) {
		 			fileNameDoc = docFile.getFilename();
		 			File file = docFile.getFile();
		 			final String FILE_PATH = Play.application().configuration()
		 					.getString("storage.path");
		 			File f = new File(FILE_PATH + fileNameDoc);
		 			filenamedbpath = FILE_PATH + File.separator + fileNameDoc;
		 			try {
						Files.copy(file.toPath(), f.toPath(),
								java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			flash("Success", "File Uploaded successfully");
		 	}
		 	}
			 
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
		  cds.Extrabgper = cartItem.get(i).extraForBackgroudInPer;
		  cds.Extraborderper =cartItem.get(i).extraForBorderInPer;
		  cds.Tickper = cartItem.get(i).extraFortickInPer;
		 // System.out.println("cartItem.get(i).extraFortickInPer"+cartItem.get(i).extraFortickInPer);
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//save dates in DB
		  Calendar c = Calendar.getInstance();
		  cds.PublishDate="";
		 for( int j =0; j < cartItem.get(i).dates.length; j++){
			  try {
				Date dt = sdf.parse(cartItem.get(i).dates[j]);
				c.setTime(dt);
				cds.PublishDate+=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+",";
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  }
		  cds.BasicRate=cartItem.get(i).unit;
		  cds.numberOfWords=cartItem.get(i).totalUnit;
		  cds.userEmailId=emailId;
		  cds.paymentOption=modeOfPayment;
		  cds.Border=cartItem.get(i).onBorderSelected;
		 //to handle  null values
		  if(cartItem.get(i).onbgColorchange == null){
			  cds.Bgcolor= "true";
		  }else{
			  cds.Bgcolor=cartItem.get(i).onbgColorchange;
		  }
		  if(cartItem.get(i).notickforAd == null){
			  cds.Tick = "true";
		  }else{
			  cds.Tick = cartItem.get(i).notickforAd;
		  }
		  cds.TickRate = cartItem.get(i).extraFortick;
		  cds.extra =  cartItem.get(i).extra;
		  cds.freeunit = cartItem.get(i).freeUnit;
		  cds.totalExtraCost = cartItem.get(i).totalExtraCost;
		  cds.totalUnitCost = cartItem.get(i).totalUnitCost;
		  cds.noOfImpression = cartItem.get(i).noOfImpression;
		  cds.rate = cartItem.get(i).rate;
		  cds.bgColorSelect = cartItem.get(i).nobgColor;
		  cds.adbookedId = cartItem.get(i).id;
		  cds.packageType = cartItem.get(i).packageSelected;
		  cds.headerColor = cartItem.get(i).headerColor;
		  cds.bodyColor = cartItem.get(i).bodyColor;
		  cds.footerColor  = cartItem.get(i).footerColor;
		  cds.footerDescption = cartItem.get(i).descriptionFooter;
		  cds.headerDescption = cartItem.get(i).descriptionHeader;
		  cds.bodyDescription = cartItem.get(i).descriptionBody;
		  cds.colorAd = cartItem.get(i).colorAd;
		  cds.BWAd = cartItem.get(i).BWAd;
		  cds.imageAd = cartItem.get(i).imageAd;
		  cds. adSizeSelect = cartItem.get(i).adSizeSelect;
		  cds.originalFileName = originalFileName;
		  cds.freewords = cartItem.get(i).freewords;
		  //ad type save here
		  cds.adSelectedType =  jsonAdSelect.asText();
		  System.out.println("ad type"+cds.adSelectedType);
		  cds.extraCost = cartItem.get(i).extraCost;
		  cds.otherWidth = Integer.toString(cartItem.get(i).otherWidth);
  	      cds.height = Integer.toString(cartItem.get(i).height);
  	      cds.extraCostpersqcm = cartItem.get(i).extraCostpersqcm;
		  if(cartItem.get(i).height > 5){
			  int extraHeight =  (cartItem.get(i).height - 5); 
			  cds.TotalCost = (cartItem.get(i).rate + ((Integer.parseInt(cartItem.get(i).extraCostpersqcm)) * (extraHeight + 1))) * (cartItem.get(i).dates.length);
		  }else{
			  cds.TotalCost = (cartItem.get(i).rate  * (cartItem.get(i).dates.length));
		  }
		  Date date = new Date();
		  cds.orderDate = sdf.format(date);//current date i.e. order placed date saved here
		/*  cds.TotalCost = (cartItem.get(i).rate *(((cartItem.get(i).otherWidth))) * (((cartItem.get(i).height))) * (cartItem.get(i).dates.length));
	*/	  amount = amount +  cds.TotalCost;
		  System.out.println("amount :"+amount);
		  composedAdSaves.add(cds);
		  //JPA.em().persist(cds);
		   }
	     
	     Order o = new Order();
	     o.orderId = orderId;
	     o.email = emailId;
	     o.total = amount;
	     o.orderDate = new Date();
	     o.composedAd = composedAdSaves;
	     JPA.em().persist(o);
	     
	     Address address;
	     try {
			//address = objectMapper.readValue(json.get("address").traverse(),Address.class);
	    	 address = objectMapper.readValue(jsonAddress.traverse(),Address.class);
	    	 addressDetails.pinCode=address.pinCode;
	    	addressDetails.fullName=address.fullName;
	    	addressDetails.address=address.shippingAddress;
	    	addressDetails.city=address.city;
	    	addressDetails.state=address.state;
	    	addressDetails.mobile=address.mobile;
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
	     if(!modeOfPayment.equalsIgnoreCase("cod")) {
			//return ok(routes.CCAvenueController.ccavenue(orderId.trim()).url());
	    	return redirect(routes.CCAvenueController.ccavenue(orderId.trim()));
	     }
		 return ok(orderId);
	 }
        
        @Transactional
	    public static Result  saveDisplayHTMLAd() throws JsonProcessingException, IOException {
        	  DynamicForm form = DynamicForm.form().bindFromRequest();
 		     System.out.println(form.get("carts"));
 		     
 		    ObjectMapper mapper = new ObjectMapper();
		     //JSONObject json = (JSONObject) JSONSerializer.toJSON(data);        
		     JsonNode jsonAddress =  mapper.readTree(form.get("address"));
		     JsonNode jsonEmail = Json.toJson(form.get("email"));
		     JsonNode jsonAdSelect = Json.toJson(form.get("adSelectedType"));
		     JsonNode jsonmodeOfPayment = Json.toJson(form.get("modeOfPayment"));
		     
		     JsonNode actualObj = mapper.readTree(form.get("carts"));
 		     
        	ObjectMapper objectMapper = new ObjectMapper();
	     AddressDetails addressDetails =new AddressDetails();
	     List<CartItem> cartItem ;
	     String emailId;
	     if(jsonEmail.asText() != null) {
	    	 emailId= jsonEmail.asText();
	    	 //System.out.println("json1.getFile"+json1.getFile("email").toString());
	     } else {
	    	 emailId = session().get("emailId"); 
	     }
	     String modeOfPayment=jsonmodeOfPayment.asText();
	     String orderId = UUID.randomUUID().toString();
	    
	     long order =  orderId.hashCode();
         order = Math.abs(order);//convert to positive if hashcode is obtained  negitive.
	     orderId = Long.toString(order);//convert order id to String. 
	     float amount = 0;
	     List<ComposedAdSave> composedAdSaves = new ArrayList<>();
	     /*cartItem = objectMapper.readValue(json.get("carts").traverse(),
				 new com.fasterxml.jackson.core.type.TypeReference<CartItem>() {});
		*/ 
		 cartItem = mapper.convertValue(actualObj, mapper.getTypeFactory().constructCollectionType(List.class, CartItem.class));
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
		  cds.Extrabgper = cartItem.get(i).extraForBackgroudInPer;
		  cds.Extraborderper =cartItem.get(i).extraForBorderInPer;
		  cds.Tickper = cartItem.get(i).extraFortickInPer;
		 // System.out.println("cartItem.get(i).extraFortickInPer"+cartItem.get(i).extraFortickInPer);
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//save dates in DB
		  Calendar c = Calendar.getInstance();
		  cds.PublishDate="";
		 for( int j =0; j < cartItem.get(i).dates.length; j++){
			  try {
				Date dt = sdf.parse(cartItem.get(i).dates[j]);
				c.setTime(dt);
				cds.PublishDate+=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE)+",";
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  }
		  cds.BasicRate=cartItem.get(i).unit;
		  cds.numberOfWords=cartItem.get(i).totalUnit;
		  cds.userEmailId=emailId;
		  cds.paymentOption=modeOfPayment;
		  cds.Border=cartItem.get(i).onBorderSelected;
		 //to handle  null values
		  if(cartItem.get(i).onbgColorchange == null){
			  cds.Bgcolor= "true";
		  }else{
			  cds.Bgcolor=cartItem.get(i).onbgColorchange;
		  }
		 
		  if(cartItem.get(i).notickforAd == null){
			  cds.Tick = "true";
		  }else{
			  cds.Tick = cartItem.get(i).notickforAd;
		  }
		  
		  cds.TickRate = cartItem.get(i).extraFortick;
		  cds.extra =  cartItem.get(i).extra;
		  cds.freeunit = cartItem.get(i).freeUnit;
		  cds.totalExtraCost = cartItem.get(i).totalExtraCost;
		  cds.totalUnitCost = cartItem.get(i).totalUnitCost;
		  cds.noOfImpression = cartItem.get(i).noOfImpression;
		  cds.rate = cartItem.get(i).rate;
		  cds.bgColorSelect = cartItem.get(i).nobgColor;
		  cds.adbookedId = cartItem.get(i).id;
		  cds.packageType = cartItem.get(i).packageSelected;
		  cds.headerColor = cartItem.get(i).headerColor;
		  cds.bodyColor = cartItem.get(i).bodyColor;
		  cds.footerColor  = cartItem.get(i).footerColor;
		  cds.footerDescption = cartItem.get(i).descriptionFooter;
		  cds.headerDescption = cartItem.get(i).descriptionHeader;
		  cds.bodyDescription = cartItem.get(i).descriptionBody;
		  cds.colorAd = cartItem.get(i).colorAd;
		  cds.BWAd = cartItem.get(i).BWAd;
		  cds.imageAd = cartItem.get(i).imageAd;
		  cds. adSizeSelect = cartItem.get(i).adSizeSelect;
		  cds.freewords = cartItem.get(i).freewords;
		  cds.otherWidth = Integer.toString(cartItem.get(i).otherWidth);
  	      cds.height = Integer.toString(cartItem.get(i).height);
		 // cds.widthSelected = cartItem.get(i).
		  //ad type save here
		  cds.adSelectedType =  jsonAdSelect.asText();
		  System.out.println("ad type"+cds.adSelectedType);
		  cds.extraCost = cartItem.get(i).extraCost;
		  Date date = new Date();
		  cds.orderDate = sdf.format(date);//current date i.e. order placed date saved here
		  /*cds.TotalCost = (cartItem.get(i).rate *(((cartItem.get(i).otherWidth))) * (((cartItem.get(i).height))) * (cartItem.get(i).dates.length));*/  
		  cds.extraCostpersqcm = cartItem.get(i).extraCostpersqcm;
		  if(cartItem.get(i).height > 5){
			  int extraHeight =  (cartItem.get(i).height - 5); 
			  cds.TotalCost = (cartItem.get(i).rate + ((Integer.parseInt(cartItem.get(i).extraCostpersqcm)) * (extraHeight  + 1))) * (cartItem.get(i).dates.length);
		  }else{
			  cds.TotalCost = (cartItem.get(i).rate  * (cartItem.get(i).dates.length));
		  }
		  amount = amount +  cds.TotalCost;
		  System.out.println("amount :"+amount);
		  composedAdSaves.add(cds);
		   }
	     Order o = new Order();
	     o.orderId = orderId;
	     o.email = emailId;
	     o.total = amount;
	     o.orderDate = new Date();
	     o.composedAd = composedAdSaves;
	     JPA.em().persist(o);
	     Address address;
	     try {
			//address = objectMapper.readValue(json.get("address").traverse(),Address.class);
	    	 address = objectMapper.readValue(jsonAddress.traverse(),Address.class);
	    	 addressDetails.pinCode=address.pinCode;
	    	addressDetails.fullName=address.fullName;
	    	addressDetails.address=address.shippingAddress;
	    	addressDetails.city=address.city;
	    	addressDetails.state=address.state;
	    	addressDetails.mobile=address.mobile;
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
	     if(!modeOfPayment.equalsIgnoreCase("cod")) {
			//return ok(routes.CCAvenueController.ccavenue(orderId.trim()).url());
	    	return redirect(routes.CCAvenueController.ccavenue(orderId.trim()));
	     }
		 return ok(orderId);
	 }
}
