package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import models.Adcategory;
import models.Basicrate;
import models.City;
import models.Newspaperdetails;
import models.State;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.UtilityQuery;
import viewmodel.NewspaperVM;
import viewmodel.Rate;

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
        //public String freeUnit; // 20
       
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
		public String location;
		public String category;
		public String subcategory;
		public String newspaper;
		public float rate; //200
		public String unit; //word
		public int unitVal; //2
		public int extra; //15
		public int freeUnit; // 20
		public float amount;
		
		public CartItem() {};
		public CartItem(int id, String type, String location, String category,
				String subcategory, String newspaper, float amount) {
			super();
			this.id = id;
			this.type = type;
			this.location = location;
			this.category = category;
			this.subcategory = subcategory;
			this.newspaper = newspaper;
			this.amount = amount;
			this.description = location + "-" + newspaper + "(" + category + (subcategory==null ? "" : "/" + subcategory) + ")"; 
		}
	
	}

	    @Transactional
	    public static Result  saveComposeyourAd() {
	  
		 JsonNode json = request().body().asJson();
	     //JsonNode nodes = json.path("data");
	     System.out.println(" json value :: "+json.toString());
	     
	     ObjectMapper objectMapper = new ObjectMapper();
	     List<CartItem> cartItem ;
	     try {
	    	 cartItem = objectMapper.readValue(json.traverse(),new com.fasterxml.jackson.core.type.TypeReference<List<CartItem>>() {});
		
	        List<ComposedAdSave> orderListComposeAd=new ArrayList<ComposedAdSave>();
	        String orderId = UUID.randomUUID().toString();
	        for(int i=0; i<cartItem.size();i++) {
	    	  
	        	ComposedAdSave cds=new ComposedAdSave();
	          
	    	   cds.City=cartItem.get(i).newspaper;
	    	   cds.Adtext=cartItem.get(i).description;
	    	   cds.Nameofthenewspaper=cartItem.get(i).location;
	    	   cds.OrderID = orderId;
	    	 
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
