package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.collect.Lists;

public class SideBarController extends Controller {
	
	public static Result index() {
		/*
		
		
		
		
		*/
		return ok(views.html.sidebar.render(Json.stringify(Json.toJson(sideBarFixture()))));
		
	}
	
	
	private static Map<String,Object>  sideBarFixture() {
		List<String> newspapers = Lists.newArrayList("Times Of India", "Hindustan", "Hindustan Times", "Danik Jagran", "Amar Ujala","Other");
		List<String> locations = Lists.newArrayList("Delhi","Mumbai","Chandighar","Lucknow","Other");
		List<CartItem> cartItems = Lists.newArrayList(new CartItem(1,"Text Classified Ad","Agra","Matrimonial",null,"Times Of India",1000.00f),
				new CartItem(2,"Text Classified Ad","Chandighar","Announcement",null,"Hindustan Times",800.00f),
				new CartItem(3,"Text Classified Ad","Delhi","Computers","Software","Danik Jagran",500.00f));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("newspapers", newspapers);
		map.put("locations", locations);
		map.put("cartItems", cartItems);
		return map;
	}
	
	public static class CartItem {
		public int id;
		public String type;
		public String description;
		public String location;
		public String category;
		public String subcategory;
		public String newspaper;
		public float amount;
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
}
