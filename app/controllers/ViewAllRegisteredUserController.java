package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.User;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.RegisteredUserListVM;
import views.html.viewallreguser;

public class ViewAllRegisteredUserController  extends Controller{

	 public static Result index() {
	        return ok(viewallreguser.render());
	        
	    }
	 
	 public ViewAllRegisteredUserController(){} 
	 
		@Transactional
		public static Result viewAllRegisteredUserForAdmin(String name,int currentPage) {
		
			long totalPages = User.getAllRegisteredUserTotal(name, 50);
			List<Object[]> allRegisteredUsers = User.getAllRegisteredUsers(name, currentPage, 50, totalPages);
			List<RegisteredUserListVM> listallRegisteredUsers = new ArrayList<>();
			
			for (Object[] registeredUserListVM: allRegisteredUsers) {
				RegisteredUserListVM vm = new RegisteredUserListVM(registeredUserListVM);
				listallRegisteredUsers.add(vm);
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalPages", totalPages);
			map.put("currentPage", currentPage);
			map.put("results", listallRegisteredUsers);
			return ok(Json.toJson(map));
		}
}
