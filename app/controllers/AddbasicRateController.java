package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
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
import views.html.addbasicrate;

public class AddbasicRateController extends Controller{

	//addbasicrate.render()
	 public static Result index() {
	        return ok(addbasicrate.render());
	    }
	    
	@Transactional
	public static Result getBasicrate(String City, String Category ,int currentPage) {
		long totalPages = Basicrate.getAllAnnouncementsTotal(City,Category, 50);
		List<Basicrate> allBasicRate = Basicrate.getAllAnnouncements(City,Category, currentPage, 50, totalPages);
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
		
		JsonNode json = request().body().asJson();
		//get the category list selected on the UI.
		String category = json.get("Category").toString();
		String categoryUnique[]=category.split(",");
		for (int i=0;i<categoryUnique.length;i++){
		DynamicForm form = DynamicForm.form().bindFromRequest();
	
		Basicrate basicrate = new Basicrate();
		basicrate.Nameofthenewspaper=form.get("Nameofthenewspaper");
		basicrate.City=form.get("City");
    	basicrate.Textaddrate=form.get("Textaddrate");
    	basicrate.clasifiedadrate=form.get("clasifiedadrate");
    	basicrate.Exstracostperline=form.get("Exstracostperline");
    	 //check for borderrs	
       if(form.get("borderRs") == null || form.get("borderRs") == ""){
    	basicrate.Border="0";
    	}else{
    		basicrate.Border=form.get("borderRs");
    	}
       //check for borderPer	
      
    	if(form.get("borderPercentage") == null || form.get("borderPercentage") == "" ){
    		basicrate.Extraborderper="0";
    	}else{
    		basicrate.Extraborderper=form.get("borderPercentage");
    	}
    	 //check for bgrs	
    	if(form.get("bgRs") == null || form.get("bgRs") == ""){
    		basicrate.Backcolor="0";
    	}else{
    		basicrate.Backcolor=form.get("bgRs");
    	}
    	 //check for bgPer	
    	if(form.get("bgPercentage")==null || form.get("bgPercentage")== ""){
    		basicrate.Extrabgper = "0";
    	}else{
    		basicrate.Extrabgper=form.get("bgPercentage");
    	}
    	
    	 //check for tickrs	
    	if(form.get("tickRs") == null || form.get("tickRs") == "" ){
    		basicrate.Tick= "0";
    	}else{
    		basicrate.Tick=form.get("tickRs");
    	}
    	 //check for tickPer	
        if(form.get("tickPercentage") == null || form.get("tickPercentage") == ""){
        	basicrate.Tickper ="0";
        	
        }else{
        	basicrate.Tickper=form.get("tickPercentage"); 
        }
        if(form.get("freewords") == null || form.get("freewords") == "" ){
    		basicrate.freewords= "22";
    	}else{
    		basicrate.freewords=form.get("freewords");
    		System.out.println("basicrate.freewords"+basicrate.freewords);
    	}
        basicrate.SpecialDiscount=form.get("SpecialDiscount");
    	basicrate.Category=categoryUnique[i].trim();//.replaceAll("[^\\p{L}\\p{Nd}]+", "");
    	basicrate.Category = basicrate.Category.replace("[","");
    	basicrate.Category = basicrate.Category.replace("]","");
    	basicrate.Category = basicrate.Category.replace("\"",""); 	
    	basicrate.ExtracostperSqcm=form.get("ExtracostperSqcm");
    	basicrate.Statename=form.get("Statename");
		basicrate.save();
		}
		return ok();
	}
	
	@Transactional
	public static Result deleteBasicRate(String id) {
		Basicrate basicrate =  Basicrate.findById(id);
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
    	 //check for borderRs	
    	if(form.get("Border") == null || form.get("Border") == ""){
    	basicrate.Border="0";
    	}else{
    		basicrate.Border=form.get("Border");
    	}
    	 //check for borderPer	
    	System.out.println("Extraborderper"+form.get("Extraborderper") );
    	if(form.get("Extraborderper") == null || form.get("Extraborderper") == ""){
    		basicrate.Extraborderper="0";
    	}else{
    		basicrate.Extraborderper=form.get("Extraborderper");
    	}
    	 //check for bgRs	
    	if(form.get("Backcolor") == null ||  form.get("Backcolor") == ""){
    		basicrate.Backcolor="0";
    	}else{
    		basicrate.Backcolor=form.get("Backcolor");
    	}
        //check for bgPer	
    	if(form.get("Extrabgper")== null || form.get("Extrabgper")== ""){
    		basicrate.Extrabgper = "0";
    	}else{
    		basicrate.Extrabgper=form.get("Extrabgper");
    	}
    	
    	//check for tickRs
    	if(form.get("Tick") == null || form.get("Tick") == ""){
    		basicrate.Tick= "0";
    	}else{
    		basicrate.Tick=form.get("Tick");
    	}
    	 //check for tickPer	
        if(form.get("Tickper") == null || form.get("Tickper") == ""){
        	basicrate.Tickper ="0";
        	
        }else{
        	basicrate.Tickper=form.get("Tickper"); 
        }
        if(form.get("freewords") == null || form.get("freewords") == ""){
        	basicrate.freewords ="22";
        	
        }else{
        	basicrate.freewords=form.get("freewords"); 
        }
        basicrate.SpecialDiscount=form.get("SpecialDiscount");
    	basicrate.ExtracostperSqcm=form.get("ExtracostperSqcm");
    	basicrate.Statename=form.get("Statename");
    	basicrate.Category=form.get("Category");
    	basicrate.merge();
		return ok();
	}

    @Transactional
	public static Result getNewspaper()
	{
		List<String> listnewspaper=Newspaperdetails.getAllnewspaperString();
		List<Map> list = new ArrayList<>();
		for(String newspaperdetails : listnewspaper){
			Map<String,String> map = new HashMap<String, String>();
		
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
