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

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Splitter;

public class AddNewspaperController extends Controller{

	@Transactional
	public static Result getNewpaper(String Nameofthenewspaper,int currentPage) {
		long totalPages = Newspaperdetails.getAllnewpaperTotal(Nameofthenewspaper, 4);
		
		List<Newspaperdetails> allnewspaper = Newspaperdetails.getAllNewspaper(Nameofthenewspaper, currentPage, 4, totalPages);
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
				
		/*newspaperdetails.Nameofthenewspaper=form.get("Nameofthenewspaper");
		newspaperdetails.LogoFileExtention=form.get("LogoFileExtention");
		newspaperdetails.LogoName=form.get("LogoName");
		newspaperdetails.Addedition=form.get("Addedition");
		System.out.println("form.get(NameofCities); :::::::::::: "+form.get("NameofCities[]"));
		newspaperdetails.NameofCities=form.get("NameofCities");
		newspaperdetails.BasicratesperText=form.get("BasicratesperText");
		newspaperdetails.BasicratesperClasified=form.get("BasicratesperClasified");
		newspaperdetails.Beforebookingdate=form.get("Beforebookingdate");
		newspaperdetails.Allow=form.get("Allow");*/
		
		newspaperdetails.save();
		return ok();
	}
	
	@Transactional
	public static Result deleteNewpaper(String id) {
		System.out.println("/*/*/*/"+id+"/*/*/*");
		Newspaperdetails newspaperdetails =  Newspaperdetails.findById(id);
		System.out.println("/*/*/*/"+id+"/*/*/*");
		newspaperdetails.delete();
		return ok();
	}
	
	
	
	@Transactional
	public static Result updateNewpaper() {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		
		Newspaperdetails newspaperdetails = Newspaperdetails.findById(form.get("NewsId"));
        		
		/*newspaperdetails.Nameofthenewspaper=form.get("Nameofthenewspaper");
		newspaperdetails.LogoFileExtention=form.get("LogoFileExtention");
		newspaperdetails.LogoName=form.get("LogoName");
		newspaperdetails.Addedition=form.get("Addedition");
		newspaperdetails.NameofCities=form.get("NameofCities");
		newspaperdetails.BasicratesperText=form.get("BasicratesperText");
		newspaperdetails.BasicratesperClasified=form.get("BasicratesperClasified");
		newspaperdetails.Beforebookingdate=form.get("Beforebookingdate");
		newspaperdetails.Allow=form.get("Allow");
		newspaperdetails.State=form.get("State");*/
    	
    	    	
		newspaperdetails.merge();
		/*System.out.println("INSIDE UPDATE"+form.get("ic.id"));*/
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
	public static Result getCategory()
	{
		List<String> listcname=Adcategory.getAllArticlesString();
		List<Map> list = new ArrayList<>();
		for(String adcategory : listcname){
			Map<String,String> map = new HashMap<String, String>();
			System.out.println("cname :: "+adcategory);
			map.put("cname", adcategory);
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
    	
	/*@Transactional
    public static Result getCityname(String state){
    	List<String> listcity = City.getallcity(state); 
    	
    	if(!listcity.isEmpty()) {
    		Iterable<String> subCats = Splitter.on(",").split(listcity.get(0));
    		return ok(Json.toJson(subCats));
    	}
    	return ok();
    }*/
	
	
}
