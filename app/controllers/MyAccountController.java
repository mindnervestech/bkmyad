package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Adcategory;
import models.Basicrate;
import models.ComposedAdSave;
import models.Newspaperdetails;
import models.State;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.BasicrateVM;
import viewmodel.OrderListVM;
import views.html.myaccount;


public class MyAccountController extends Controller {
	@Transactional
	public static Result index() {
		return ok(myaccount.render());
		//return ok(myaccount.render(Json.stringify(Json.toJson(makeOrderList()))));
	}
	@Transactional
	public static Result getAllUserOrder(String UserId) {
		List<ComposedAdSave> allOrderList = ComposedAdSave.getAllOrderList(UserId);
		List<OrderListVM> listOfOrder = new ArrayList<OrderListVM>();
		System.out.println("++++++++++++++++++++++++++");
		for (ComposedAdSave orderlistVM: allOrderList) {
			OrderListVM vm = new OrderListVM(orderlistVM);
			listOfOrder.add(vm);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("results", listOfOrder);
		return ok(Json.toJson(map));
	}
}
