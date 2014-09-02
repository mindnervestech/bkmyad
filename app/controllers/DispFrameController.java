package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import views.html.dispcalssifiedcontroller;

public class DispFrameController  extends Controller{

	
	
	public static Result index() {
		
	    return ok(dispcalssifiedcontroller.render() );
		}
}
