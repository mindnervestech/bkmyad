package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Splitter;

import models.Adcategory;
import models.Adsubcategory;
import models.Basicrate;
import models.City;
import models.Newspaperdetails;
import models.State;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.BasicrateVM;


public class AddbasicRateController extends Controller{

	@Transactional
	public static Result getBasicrate(String City,int currentPage) {
		long totalPages = Basicrate.getAllAnnouncementsTotal(City, 8);
		
		List<Basicrate> allBasicRate = Basicrate.getAllAnnouncements(City, currentPage, 8, totalPages);
		List<BasicrateVM> listOfBasicrate = new ArrayList<>();
		
		
		for (Basicrate basicrateVM: allBasicRate) {
			BasicrateVM vm = new BasicrateVM(basicrateVM);
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
	public static Result saveBasicRate() {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		
		Basicrate basicrate = new Basicrate();
		
		basicrate.Nameofthenewspaper=form.get("Nameofthenewspaper");
		basicrate.City=form.get("City");
    	basicrate.Textaddrate=form.get("Textaddrate");
    	basicrate.clasifiedadrate=form.get("clasifiedadrate");
    	basicrate.Exstracostperline=form.get("Exstracostperline");
    	basicrate.Border=form.get("Border");
    	basicrate.Backcolor=form.get("Backcolor");
    	basicrate.SpecialDiscount=form.get("SpecialDiscount");
    	basicrate.Tick=form.get("Tick");
    	basicrate.Category=form.get("Category");
    	basicrate.Extraborderper=form.get("Extraborderper");
    	basicrate.Extrabgper=form.get("Extrabgper");
    	basicrate.Tickper=form.get("Tickper");
    	basicrate.ExtracostperSqcm=form.get("ExtracostperSqcm");
    	basicrate.Statename=form.get("Statename");
		
		basicrate.save();
		return ok();
	}
	
	@Transactional
	public static Result deleteBasicRate(String id) {
		System.out.println("/*/*/*/"+id+"/*/*/*");
		Basicrate basicrate =  Basicrate.findById(id);
		System.out.println("/*/*/*/"+id+"/*/*/*");
		basicrate.delete();
		return ok();
	}
	
	@Transactional
	public static Result updateBasicRate() {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		
		Basicrate basicrate = Basicrate.findById(form.get("BasicRateID"));
        		
		basicrate.Nameofthenewspaper=form.get("Nameofthenewspaper");
		basicrate.City=form.get("City");
    	basicrate.Textaddrate=form.get("Textaddrate");
    	basicrate.clasifiedadrate=form.get("clasifiedadrate");
    	basicrate.Exstracostperline=form.get("Exstracostperline");
    	basicrate.Border=form.get("Border");
    	basicrate.Backcolor=form.get("Backcolor");
    	basicrate.SpecialDiscount=form.get("SpecialDiscount");
    	basicrate.Tick=form.get("Tick");
    	basicrate.Category=form.get("Category");
    	basicrate.Extraborderper=form.get("Extraborderper");
    	basicrate.Extrabgper=form.get("Extrabgper");
    	basicrate.Tickper=form.get("Tickper");
    	basicrate.ExtracostperSqcm=form.get("ExtracostperSqcm");
    	basicrate.Statename=form.get("Statename");
    	
    	    	
    	basicrate.merge();
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
