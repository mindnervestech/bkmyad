package controllers;

import java.io.File;

import models.ComposedAdSave;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class GetImageController extends Controller{

	@Transactional
	public static Result getImagePath(String  OrderId) {
		String cmposedAdSave = ComposedAdSave.findImagePath(OrderId);
		System.out.println(""+cmposedAdSave);
		
			File f = new File(cmposedAdSave);
		    System.out.println("f"+f);
        return ok(f);		
		
	}
}
