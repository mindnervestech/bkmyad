package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Announcement;
import models.Basicrate;
import models.Discountprice;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.AnnouncementVM;
import viewmodel.BasicrateVM;
import viewmodel.DiscountpriceVM;
import viewmodel.NewspaperVM;

public class AddbasicRateController extends Controller{

	@Transactional
	public static Result getBasicrate(String City,int currentPage) {
		long totalPages = Basicrate.getAllAnnouncementsTotal(City, 10);
		
		List<Basicrate> allAnnouncements = Basicrate.getAllAnnouncements(City, currentPage, 10, totalPages);
		List<BasicrateVM> listOfAnnouncements = new ArrayList<>();
		
		System.out.println("++++++++++++++++++++++++++");
		
		/*List<Object[]> getDiscount = Discountprice.getdiscountednewspaperwise(cname, city);
	 	List<DiscountpriceVM> list = new ArrayList<>();
	 	for(Object[] discountpriceVM : getDiscount){
	 		DiscountpriceVM vm = new DiscountpriceVM(discountpriceVM);
	 		list.add(vm);
	 	} 	
		*/
		
		for (Basicrate basicrateVM: allAnnouncements) {
			BasicrateVM vm = new BasicrateVM(basicrateVM);
			listOfAnnouncements.add(vm);
		}
		if(currentPage>totalPages && totalPages!=0) {
			currentPage--;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPages", totalPages);
		map.put("currentPage", currentPage);
		map.put("results", listOfAnnouncements);
		return ok(Json.toJson(map));
	}
	
	@Transactional
	public static Result saveBasicRate() {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		
		Basicrate basicrate = new Basicrate();
		
		basicrate.Nameofthenewspaper=form.get("Nameofthenewspaper");
		basicrate.City=form.get("City");
    	basicrate.Textaddrate=form.get("Textaddrate");
    	basicrate.clasifiedadrate=form.get("clasifiedadrate");
    	basicrate.Exstracostperline=form.get("Exstracostperline");
    	basicrate.Border=form.get("Border");
    	basicrate.Backcolor=form.get("Backcolor");
    	basicrate.SpecialDiscount=form.get("SpecialDiscount");
    	basicrate.Tick=form.get("Tick");
    	basicrate.Category=form.get("Category");
    	basicrate.Extraborderper=form.get("Extraborderper");
    	basicrate.Extrabgper=form.get("Extrabgper");
    	basicrate.Tickper=form.get("Tickper");
    	basicrate.ExtracostperSqcm=form.get("ExtracostperSqcm");
		
		basicrate.save();
		return ok();
	}
	
	@Transactional
	public static Result deleteAnnouncement(Long id) {
		Announcement announcement =  Announcement.findById(id);
		announcement.delete();
		return ok();
	}
	
	@Transactional
	public static Result updateAnnouncement() {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Announcement announcement = Announcement.findById(Long.parseLong(form.get("id")));
		announcement.announcementType=form.get("announcementType");
		announcement.description = form.get("description");
		announcement.title = form.get("title");
		try {
			announcement.fromDate = (Date)formatter.parse(form.get("fromDate"));
			announcement.toDate = (Date)formatter.parse(form.get("toDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		announcement.merge();
		/*System.out.println("INSIDE UPDATE"+form.get("ic.id"));*/
		return ok();
	}
	
	
	
}
