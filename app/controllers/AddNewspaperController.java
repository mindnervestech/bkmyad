package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Adcategory;
import models.City;
import models.Newspaperdetails;
import models.State;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.NewspaperdetailsVM;
import viewmodel.SelectionVM;
import views.html.addnewspap;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Splitter;

public class AddNewspaperController extends Controller{

	 public static Result index() {
	        return ok(addnewspap.render());
	    } 
	@Transactional
	public static Result getNewpaper(String Nameofthenewspaper,int currentPage) {
		long totalPages = Newspaperdetails.getAllnewpaperTotal(Nameofthenewspaper, 8);
		
		List<Newspaperdetails> allnewspaper = Newspaperdetails.getAllNewspaper(Nameofthenewspaper, currentPage, 8, totalPages);
		List<NewspaperdetailsVM> listOfNewpaper = new ArrayList<>();
		
			
		for (Newspaperdetails newspaperdetailsVM: allnewspaper) {
			NewspaperdetailsVM vm = new NewspaperdetailsVM(newspaperdetailsVM);
			listOfNewpaper.add(vm);
		}
		if(currentPage>totalPages && totalPages!=0) {
			currentPage--;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPages", totalPages);
		map.put("currentPage", currentPage);
		map.put("results", listOfNewpaper);
		return ok(Json.toJson(map));
	}
	
	@Transactional
	public static Result saveNewpaper() {
		JsonNode json = request().body().asJson();
		DynamicForm form = DynamicForm.form().bindFromRequest();
		Json.fromJson(json, Newspaperdetails.class);
		Newspaperdetails newspaperdetails = Json.fromJson(json, Newspaperdetails.class);
				
		newspaperdetails.save();
		return ok();
	}
	
	@Transactional
	public static Result deleteNewpaper(String id) {
		
		Newspaperdetails newspaperdetails =  Newspaperdetails.findById(id);
	
		newspaperdetails.delete();
		return ok();
	}
	
	
	
	@Transactional
	public static Result updateNewpaper() {
	
		JsonNode json = request().body().asJson();
		DynamicForm form = DynamicForm.form().bindFromRequest();
		Json.fromJson(json, Newspaperdetails.class);
		Newspaperdetails newspaperdetailsFromFE = Json.fromJson(json, Newspaperdetails.class);
		
		Newspaperdetails newspaperdetails = Newspaperdetails.findById(form.get("NewsId"));
        	
		newspaperdetails.Nameofthenewspaper=newspaperdetailsFromFE.Nameofthenewspaper;
		newspaperdetails.LogoFileExtention=newspaperdetailsFromFE.LogoFileExtention;
		newspaperdetails.LogoName=newspaperdetailsFromFE.LogoName;
		newspaperdetails.Addedition=newspaperdetailsFromFE.Addedition;
		newspaperdetails.NameofCities=newspaperdetailsFromFE.NameofCities;
		newspaperdetails.BasicratesperText=newspaperdetailsFromFE.BasicratesperText;
		newspaperdetails.BasicratesperClasified=newspaperdetailsFromFE.BasicratesperClasified;
		newspaperdetails.Beforebookingdate=newspaperdetailsFromFE.Beforebookingdate;
		newspaperdetails.Allow=newspaperdetailsFromFE.Allow;
		newspaperdetails.Statename=newspaperdetailsFromFE.Statename;
    	System.out.println("---------------");
    	System.out.println(newspaperdetailsFromFE.NameofCities);
    	
    	
    	newspaperdetailsFromFE.merge();
		
		return ok();
	}
	

    @Transactional
	public static Result getNewspaper()
	{
		List<String> listnewspaper=Newspaperdetails.getAllnewspaperString();
		List<Map> list = new ArrayList<>();
		for(String newspaperdetails : listnewspaper){
			Map<String,String> map = new HashMap<String, String>();
			System.out.println("NewsPaper :: "+newspaperdetails);
			map.put("newspapers", newspaperdetails);
			list.add(map);
		}
		
		return ok(Json.toJson(list));
	}
    
        
    @Transactional
	public static Result getStatename()
	{
		List<String> listcname=State.getallstateString();
		List<Map> list = new ArrayList<>();
		for(String state : listcname){
			Map<String,String> map = new HashMap<String, String>();
			System.out.println("Statename :: "+state);
			map.put("Statename", state);
			list.add(map);
		}
		
		return ok(Json.toJson(list));
	}
    
    @Transactional
    public static Result getCityname(String state){
    	List<String> listcity = City.getallcity(state); 
    	List<Map> list = new ArrayList<>();
    	if(!listcity.isEmpty()) {
    		Iterable<String> subCats = Splitter.on(",").split(listcity.get(0));
    		for(String city : subCats){
    			Map<String,String> map = new HashMap<String, String>();
    			map.put("cityname", city);
    			list.add(map);
    		}
    		return ok(Json.toJson(list));
    	}
    	return ok();
    }
    
	
	
}
