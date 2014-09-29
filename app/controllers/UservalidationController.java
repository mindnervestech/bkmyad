package controllers;

import models.User;

import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class UservalidationController extends Controller {
	
	    // check for unique email when sign up
	    @Transactional
	    public static Result  ValidateUsernameUnique() {
	    DynamicForm form = DynamicForm.form().bindFromRequest();
	    String email = form.get("txtEmail");
	    User existingUser = User.ValidateUsernameUnique(email);
		   
	    if (existingUser != null) {
		return ok("true");
		} 
	    else{
		     
	    }
	    return ok("false");
   } 

	    // check for unique email when sign up
	    @Transactional
	    public static Result  CheckAlreadyExitUser(String userId) {
	   
	    User existingUser = User.ValidateUsernameUnique(userId);
		   
	    if (existingUser != null) {
		return ok("true");
		} 
	    else{
		     
	    }
	    return ok("false");
   } 
	    

}
