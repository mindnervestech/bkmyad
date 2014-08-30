package controllers;

import java.util.List;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.collect.Lists;

public class TextClassifiedController  extends Controller  {
	
	public static Result index() {
		/*
		
		
		
		
		*/
		return ok(views.html.textClassifiedController.render(
				Json.stringify(Json.toJson(generateTestFixture(1))
						)));
		
	}

	public static class TextClassifiedVM {
		public String adtype;
		public String mainCategory;
		public String subCategory;
		public String selectedNewspaper;
		public String selectedCity;
		public List<Rate> rates;
		public TextClassifiedVM(String adtype, String mainCategory,
				String subCategory, String selectedNewspaper,
				String selectedCity, List<Rate> rates) {
			super();
			this.adtype = adtype;
			this.mainCategory = mainCategory;
			this.subCategory = subCategory;
			this.selectedNewspaper = selectedNewspaper;
			this.selectedCity = selectedCity;
			this.rates = rates;
		}
		
		public TextClassifiedVM(){}
		
	}
	
	public static class Rate {
		public String newspaper;
		public String location;
		public int rate;
		public int rateBy; // line, word 
		public int extra;
		public String unit; // line, word
		public int backgroundColorExtra;
		public int borderExtra;
		
		public Rate(String newspaper, String location, int rate, int rateBy,
				int extra, String unit, int backgroundColorExtra,
				int borderExtra) {
			super();
			this.newspaper = newspaper;
			this.location = location;
			this.rate = rate;
			this.rateBy = rateBy;
			this.extra = extra;
			this.unit = unit;
			this.backgroundColorExtra = backgroundColorExtra;
			this.borderExtra = borderExtra;
		}
		
		public Rate(){}
		
	}
	
	
	
	private static TextClassifiedVM generateTestFixture(int i) {
		switch (i) {
			case 1 :
				return new TextClassifiedVM("Text Classified Ads","Computers","Hardware","Amar Ujala",null,
						Lists.newArrayList(new Rate("Amar Ujala", "Agra", 838, 25 ,15,"words",0,0),
						   new Rate("Amar Ujala", "Alighar", 414, 25 ,15,"words",0,0),
						   new Rate("Amar Ujala", "Rotak", 363, 25 ,15,"words",0,0)));
			case 2 :
			case 3 :
			default:
				return new TextClassifiedVM("Text Classified Ads","Computers","Hardware","Amar Ujala",null,
						Lists.newArrayList(new Rate("Amar Ujala", "Agra", 838, 25 ,15,"words",0,0),
						   new Rate("Amar Ujala", "Alighar", 414, 25 ,15,"words",0,0),
						   new Rate("Amar Ujala", "Rotak", 363, 25 ,15,"words",0,0)));
		}
				
	}
	
	
	
	
	
}
