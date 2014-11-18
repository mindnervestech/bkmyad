package controllers;

import play.mvc.Controller;
import play.mvc.Result;


public class RedirectController  extends Controller{
	public static Result index() {
        return ok(views.html.redirect.render());
   }
}
