package controllers;

import java.util.ArrayList;
import java.util.List;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Booknewspaperaddonlinee43a;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result home() {
        return ok(views.html.home.render());
    }
    
    public static Result Booknewspaperaddonlinee43a() {
    	List<String> testlists = new ArrayList<String>();
    	testlists.add("Amar Ujala");
    	testlists.add("Time of India");
    	testlists.add("Ecomonics Times");
    	return ok(Booknewspaperaddonlinee43a.render(Json.stringify(Json.toJson(testlists))));
    }

}
