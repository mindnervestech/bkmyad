package controllers;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import models.City;
import models.Discountprice;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Splitter;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.DiscountVM;
import views.html.adpackage;


public class AddPackageController  extends Controller{

	 public static Result index() {
	        return ok(adpackage.render());
	    } 
	
	 @Transactional
	    public static Result getAllCityOfState(){
	    	List<String> listcity = City.getAllCityName(); 
	    	List<Map> list = new ArrayList<>();
	    	if(!listcity.isEmpty()) {
	    		for(String string: listcity){
	    			Iterable<String> subCats = Splitter.on(",").split(string);
		    		for(String city : subCats){
		    			
		    			Map<String,String> map = new HashMap<String, String>();
		    			map.put("cityname", city);
		    			list.add(map);
		    		}
	    		}
	    		
	    		return ok(Json.toJson(list));
	    	}
	    	return ok();
	    }
	 
	 @Transactional
		public static Result saveNewpackageRate() {
			JsonNode json = request().body().asJson();
			DynamicForm form = DynamicForm.form().bindFromRequest();
			Discountprice discountprice = new Discountprice();
			discountprice.Tbasicprice ="0";
			discountprice.Toffpercentage= "0";
			discountprice.Ttotalprice="0";
			discountprice.Doffprice="0";
			discountprice.Dbasicprice="0";
			discountprice.LastDate="0";
			discountprice.Tickper="0";
			discountprice.Nameofthenewspaper=form.get("Nameofthenewspaper");
			discountprice.Dtotalprice=form.get("Textaddrate");
			discountprice.Exstracostperline=form.get("Exstracostperline");
			//check for the borderRs
			if(form.get("borderRs")==null){
				discountprice.Border = "0";
			}else{
				discountprice.Border=form.get("borderRs");
			}
			
			//check for boderPer
			if(form.get("borderPercentage") == null){
				discountprice.Extraborderper="0";
				
			}else{
				discountprice.Extraborderper=form.get("borderPercentage");
			}
			
			//check for the BackColor
			if(form.get("bgRs") == null){
				discountprice.Backcolor = "0";
				
			}else{
				discountprice.Backcolor=form.get("bgRs");
			}
			
			//check for the extrabgper
			if(form.get("bgPercentage") == null){
				
				discountprice.Extrabgper = "0";
			}else{
				discountprice.Extrabgper = form.get("bgPercentage");
			}
			
			discountprice.SpecialDiscount=form.get("SpecialDiscount");
			
			//check for tick
			if(form.get("tickRs") == null){
				
				discountprice.Tick = "0";
			}else{
				discountprice.Tick=form.get("tickRs");
			}
			//check for the TickPer
			if(form.get("tickPercentage") == null){
				discountprice.Tickper = "0";
			}else{
				discountprice.Tickper= form.get("tickPercentage");
			}
			
			discountprice.Category=form.get("Category");
			discountprice.ExtracostperSqcm=form.get("ExtracostperSqcm");
			
			JsonNode arrNode = json.get("City");
			String cities = null;
			if (arrNode.isArray()) {
				
			    for (final JsonNode objNode : arrNode) {
			    	if(cities == null){
			    		cities = objNode.asText();
			    	} else {
			    		cities = cities +","+objNode.asText();
			    	}
			    }
			}
		
			discountprice.Cities = cities;
			discountprice.Edition=form.get("packageName");
			discountprice.save();
			return ok();
		}
	 
	    @Transactional
		public static Result getDiscountRate(String City,int currentPage) {
			long totalPages = Discountprice.getAllAnnouncementsTotal(City, 8);
			List<Discountprice> allBasicRate = Discountprice.getAllAnnouncements(City, currentPage, 8, totalPages);
			List<DiscountVM> listOfBasicrate = new ArrayList<>();
			
			for (Discountprice basicrateVM: allBasicRate) {
				DiscountVM vm = new DiscountVM (basicrateVM);
				listOfBasicrate.add(vm);
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalPages", totalPages);
			map.put("currentPage", currentPage);
			map.put("results", listOfBasicrate);
			return ok(Json.toJson(map));
		}
	    
	    
	    @Transactional
		public static Result updateDiscountRate() {
	    	JsonNode json = request().body().asJson();
	    	
			DynamicForm form = DynamicForm.form().bindFromRequest();
			Discountprice discountprice = Discountprice.findById(form.get("Did"));
			discountprice.Tbasicprice ="0";
			discountprice.Toffpercentage= "0";
			discountprice.Ttotalprice="0";
			discountprice.Doffprice="0";
			discountprice.Dbasicprice="0";
			discountprice.LastDate="0";
			discountprice.Tickper="0";
			discountprice.Nameofthenewspaper=form.get("Nameofthenewspaper");
			discountprice.Dtotalprice=json.get("Dtotalprice").asText();
			discountprice.Exstracostperline=form.get("Exstracostperline");
			String Edition = json.get("Edition").asText();
			discountprice.Edition = Edition;
			discountprice.Category=form.get("Category");
			discountprice.SpecialDiscount=form.get("SpecialDiscount");
			
			//check the borderRs for null
			if(form.get("Border") == null){
				
				discountprice.Border = "0";
			}else{
				discountprice.Border=form.get("Border");
			}
			//Check the BorderPer null form UI
			if(form.get("Extraborderper") == null){
				
				discountprice.Extraborderper  = "0";
			}else{
				discountprice.Extraborderper = form.get("Extraborderper");
				
			}
			// check for the BackGround Color Null value 
			if(form.get("Backcolor") == null){
				discountprice.Backcolor = "0";
			}else{
				discountprice.Backcolor=form.get("Backcolor");
			}
			
			//Check for the BackGround Percentage 
			if(form.get("Extrabgper") == null){
				discountprice.Extrabgper= "0";
				
			}else{
				discountprice.Extrabgper = form.get("Extrabgper");
			}
			
			//check for the tick Rs
             if(form.get("Tick") == null){
            	 discountprice.Tick = "0";
             }else{
            	 discountprice.Tick=form.get("Tick");
             }
			
			//check for the Tick Percenatge
             if(form.get("Tickper") == null){
            	 discountprice.Tickper = "0";
             }else{
            	 discountprice.Tickper = form.get("Tickper");
             }
			
			
			JsonNode arrNode = json.get("Cities");
			String cities = null;
			if (arrNode.isArray()) {
				
			    for (final JsonNode objNode : arrNode) {
			    	if(cities == null){
			    		cities = objNode.asText();
			    	} else {
			    		cities = cities +","+objNode.asText();
			    	}
			    }
			
			}
			discountprice.Cities = cities;
		
			discountprice.ExtracostperSqcm=form.get("ExtracostperSqcm");
			discountprice.merge();
			return ok();
		}
	    
	    @Transactional
		public static Result deleteDiscountRate(String id) {
	    	Discountprice discountprice =  Discountprice.findById(id);
	    	discountprice.delete();
			return ok();
		}
		
	    
}