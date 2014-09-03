package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import models.ComposedAdSave;


import play.data.DynamicForm;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

public class MakeBookingController extends Controller {
	
	public static Result index() {
		/*
		
		
		
		
		*/
		return ok(views.html.makeBooking.render(Json.stringify(Json.toJson(makeBookingBarFixture()))));
		
	}
	
	public static Result getRatesByNewspaper() {
		List<Rate> rates = Lists.newArrayList(
				Rate
				.byId(1)
				.withCityAndNewspaper("Times Of India", "Delhi")
				.withAmountAndFreeUnit(200f, 20).withOverUnit(25, 2, "Word"),
				Rate
				.byId(1)
				.withCityAndNewspaper("Times Of India", "Mumbai")
				.withAmountAndFreeUnit(200f, 20).withOverUnit(15, 2, "Line"),
				Rate
				.byId(1)
				.withCityAndNewspaper("Times Of India", "Chandighar")
				.withAmountAndFreeUnit(200f, 20).withOverUnit(20, 2, "Word"),
				Rate
				.byId(1)
				.withCityAndNewspaper("Times Of India", "Lucknow")
				.withAmountAndFreeUnit(200f, 20).withOverUnit(15, 1, "Line"));
				
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rates", rates);
		return ok(Json.toJson(map));
	}
	
	
	private static Map<String,Object>  makeBookingBarFixture() {
		List<String> newspapers = Lists.newArrayList("Times Of India", "Hindustan", "Hindustan Times", "Danik Jagran", "Amar Ujala","Other");
		List<String> locations = Lists.newArrayList("Delhi","Mumbai","Chandighar","Lucknow","Other");
		List<String> categories = Lists.newArrayList("Announcement","Matrimonial","Computers","Education","Others");
		
		
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
		public int id;
		public String location;
		public String newspaper;
		public float rate; //200
		public String unit; //word
		public int unitVal; //2
		public int extra; //15
		public int freeUnit; // 20
		public DateConfig dateConfig;
		public ExtraConfig extraConfig;
		
		public static Rate byId(int id) {
			Rate rate = new Rate();
			rate.id = id;
			return rate;
		}
		
		public Rate withCityAndNewspaper(String location, String newspaper) {
			this.newspaper = newspaper;
			this.location = location;
			return this;
		}
		
		public Rate withAmountAndFreeUnit(float amount, int freeUnit) {
			this.freeUnit = freeUnit;
			this.rate = amount;
			return this;
		}
		
		public Rate withOverUnit(int extra, int unitVal,String unit) {
			this.unitVal = unitVal;
			this.unit = unit;
			this.extra = extra;
			return this;
		}
		
		
		public Rate withDateConfig(DateConfig dateConfig) {
			this.dateConfig = dateConfig;
			return this;
		}
		
		public Rate withExtraConfig(ExtraConfig extraConfig) {
			this.extraConfig = extraConfig;
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
