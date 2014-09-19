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
import models.Announcement;
import models.Basicrate;
import models.City;
import models.Newspaperdetails;
import models.State;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.CategorySubCatVM;

import views.html.addcatabdsubcat;

public class AddCategorySubcatController extends Controller{
	
	 public static Result index() {
	        return ok(addcatabdsubcat.render());
	    }
	    

	@Transactional
	public static Result getCategory(String cname,int currentPage) {
		long totalPages = Adsubcategory.getAllcategoryTotal(cname, 4);
		
		List<Adsubcategory> allcategory =Adsubcategory.getAllcategory(cname, currentPage, 4, totalPages);
		List<CategorySubCatVM> listOfCat = new ArrayList<>();
		
		
		for (Adsubcategory categorySubCatVM: allcategory) {
			CategorySubCatVM vm = new CategorySubCatVM(categorySubCatVM);
			listOfCat.add(vm);
		}
		if(currentPage>totalPages && totalPages!=0) {
			currentPage--;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPages", totalPages);
		map.put("currentPage", currentPage);
		map.put("results", listOfCat);
		return ok(Json.toJson(map));
	}
	
	
	@Transactional
	public static Result saveCategory() {
		
		JsonNode json = request().body().asJson();
		DynamicForm form = DynamicForm.form().bindFromRequest();
		Json.fromJson(json, Adcategory.class);
		Adcategory cat = Json.fromJson(json, Adcategory.class);
		
		Adsubcategory subcat =new Adsubcategory();
		
		subcat.cname=form.get("cname");
			
		subcat.save();
		cat.save();
		return ok();
		
		
	}
	
	
	
	@Transactional
	public static Result updateSucategory() {
		
		JsonNode json = request().body().asJson();
		DynamicForm form = DynamicForm.form().bindFromRequest();
		Json.fromJson(json, Adsubcategory.class);
		Adsubcategory SubCatform = Json.fromJson(json, Adsubcategory.class);
		
		
		Adsubcategory subcat = Adsubcategory.findById(form.get("CSID"));
		if(subcat.Sucategory!= null)
		{
			subcat.Sucategory =subcat.Sucategory+","+SubCatform.Sucategory;
	    }else{
	    	subcat.Sucategory = SubCatform.Sucategory;
	    }
		
		    	
		subcat.merge();
		
		return ok();
	}
	

   
	
	
}
