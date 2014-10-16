package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Basicrate;
import models.ComposedAdSave;
import models.Order;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.BasicrateVM;
import viewmodel.ComposedAdSaveVM;
import views.html.viewallorder;


public class ViewAllOrdersController   extends Controller{

	 public static Result index() {
	        return ok(viewallorder.render());
	    } 
	 
	 
	    
		@Transactional
		public static Result viewAllOrdersForAdmin(String City,int currentPage) {
		
			long totalPages = Order.getAllOrdersTotal(City, 8);
			List<Object[]> allUsersOrders = Order.getAllOrdersOfUsers(City, currentPage, 8, totalPages);
			List<ComposedAdSaveVM> listallUsersOrders = new ArrayList<>();
			
			for (Object[] composedAdSaveVM: allUsersOrders) {
				Order order = Order.findById(composedAdSaveVM[0].toString());
				ComposedAdSave composedAdSave = ComposedAdSave.findById(Long.parseLong(composedAdSaveVM[1].toString()));
				ComposedAdSaveVM vm = new ComposedAdSaveVM(order,composedAdSave);
				listallUsersOrders.add(vm);
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalPages", totalPages);
			map.put("currentPage", currentPage);
			map.put("results", listallUsersOrders);
			return ok(Json.toJson(map));
		}
	 
}
