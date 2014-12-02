package controllers;

import play.mvc.Controller;
import play.mvc.Result;


public class RedirectController  extends Controller{
	public static Result index() {
		System.out.println(request().headers());
        return ok(views.html.redirect.render("ad2book.in"));
   }
}
