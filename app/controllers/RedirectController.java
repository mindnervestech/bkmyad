package controllers;

import play.mvc.Controller;
import play.mvc.Result;


public class RedirectController  extends Controller{
	public static Result index() {
		System.out.println(request().headers().get("Referer")[0]);
        return ok(views.html.redirect.render(request().headers().get("Referer")[0]));
   }
}
