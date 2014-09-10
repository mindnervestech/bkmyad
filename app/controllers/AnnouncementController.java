package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Announcement;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.AnnouncementVM;

public class AnnouncementController extends Controller{

	@Transactional
	public static Result getAnnouncements(String title,int currentPage) {
		long totalPages = Announcement.getAllAnnouncementsTotal(title, 2);
		List<Announcement> allAnnouncements = Announcement.getAllAnnouncements(title, currentPage, 2, totalPages);
		
		List<AnnouncementVM> listOfAnnouncements = new ArrayList<>();
		for (Announcement announcement:allAnnouncements) {
			AnnouncementVM vm = new AnnouncementVM(announcement);
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
	public static Result saveAnnouncement() {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Announcement announcement = new Announcement();
		
		announcement.announcementType=form.get("announcementType");
		announcement.description = form.get("description");
		announcement.title = form.get("title");
		try {
			announcement.fromDate = (Date)formatter.parse(form.get("fromDate"));
			announcement.toDate = (Date)formatter.parse(form.get("toDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		announcement.save();
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
