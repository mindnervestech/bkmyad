package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Basicrate;
import models.ComposedAdSave;
import models.Order;
import models.User;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.BasicrateVM;
import viewmodel.ComposedAdSaveVM;
import viewmodel.RegisteredUserListVM;
import views.html.viewallorder;


public class ViewAllOrdersController   extends Controller{

	 public static Result index() {
	        return ok(viewallorder.render());
	    } 
	 
	 
	    
		@Transactional
		public static Result viewAllOrdersForAdmin(String City,int currentPage) {
		
			long totalPages = Order.getAllOrdersTotal(City, 50);
			List<Object[]> allUsersOrders = Order.getAllOrdersOfUsers(City, currentPage, 50, totalPages);
			List<ComposedAdSaveVM> listallUsersOrders = new ArrayList<>();
			
			for (Object[] composedAdSaveVM: allUsersOrders) {
				//Order order = Order.findById(composedAdSaveVM[0].toString());
				//ComposedAdSave composedAdSave = ComposedAdSave.findById(Long.parseLong(composedAdSaveVM[1].toString()));
				//ComposedAdSaveVM vm = new ComposedAdSaveVM(order,composedAdSave);
				ComposedAdSaveVM adSaveVM = new ComposedAdSaveVM(composedAdSaveVM);
				/*adSaveVM.bank_name = composedAdSaveVM.bank_name;
				adSaveVM.OrderID = composedAdSaveVM.orderId;
				adSaveVM.userEmailId = composedAdSaveVM.email;
				adSaveVM.TotalCost = composedAdSaveVM.total;
				adSaveVM.bankMsg = composedAdSaveVM.bankMsg;
				adSaveVM.cc_bid = composedAdSaveVM.cc_bid;
				adSaveVM.cc_category = composedAdSaveVM.cc_category;
				adSaveVM.cc_orderNo = composedAdSaveVM.cc_orderNo;*/
				listallUsersOrders.add(adSaveVM);
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
			}
			
		/*	List<Object[]> allRegisteredUsers = User.getAllRegisteredUsers(name, currentPage, 50, totalPages);
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
			return ok(Json.toJson(map));*/
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalPages", totalPages);
			map.put("currentPage", currentPage);
			map.put("results", listallUsersOrders);
			return ok(Json.toJson(map));
		}
	 
}
