package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Adcategory;
import models.Newspaperdetails;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.addsiplay;

public class AdDisplayController extends Controller {

	@Transactional
	public static Result index() {
		// get the list of adcategory
		List<Adcategory> listcategory = Adcategory.getAllArticles();
		// get the list of news paper
		List<String> listNewspaper = Newspaperdetails.getNameofallenewspaper();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categories", listcategory);
		map.put("newspapers", listNewspaper);
		return ok(addsiplay.render(Json.stringify(Json.toJson(map))));

	}

}