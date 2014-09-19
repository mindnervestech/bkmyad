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
import viewmodel.StateCityVM;
import views.html.stateandcity;


public class AddStateCityController extends Controller{
	
	 public static Result index() {
	        return ok(stateandcity.render());
	    }
	    

	@Transactional
	public static Result getStateName(String Statename,int currentPage) {
		long totalPages = City.getAllStatesTotal(Statename, 8);
		List<City> allBasicRate =City.getAllStates(Statename, currentPage, 8, totalPages);
		List<StateCityVM> listOfState = new ArrayList<>();
		
		
		for (City stateCityVM: allBasicRate) {
			
			StateCityVM vm = new StateCityVM(stateCityVM);
			listOfState.add(vm);
		}
		if(currentPage>totalPages && totalPages!=0) {
			currentPage--;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPages", totalPages);
		map.put("currentPage", currentPage);
		map.put("results", listOfState);
		return ok(Json.toJson(map));
	}
	

	
	@Transactional
	public static Result saveCity() {
		
		JsonNode json = request().body().asJson();
		DynamicForm form = DynamicForm.form().bindFromRequest();
		Json.fromJson(json, City.class);
		City city = Json.fromJson(json, City.class);
		
		city.save();
		return ok();
		
		
	}
		
	
	@Transactional
	public static Result updateState() {
		
		JsonNode json = request().body().asJson();
		DynamicForm form = DynamicForm.form().bindFromRequest();
		Json.fromJson(json, City.class);
		City cityform = Json.fromJson(json, City.class);
		
		
		City city = City.findById(form.get("CID"));
		
		city.Cityname =city.Cityname+","+cityform.Cityname;
    	    	
		city.merge();
		
		return ok();
		
		
	}
	

   
	
	
}
