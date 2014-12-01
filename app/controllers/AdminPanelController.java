package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.adminpan;

public class AdminPanelController extends Controller {

	// addbasicrate.render()
	public static Result index() {
		return ok(adminpan.render());
	}
}
