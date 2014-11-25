package controllers;

import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import utils.SendMailUtility;

public class TempGuestUserController extends Controller {

	
	@Transactional
	public static Result sendMailAboutTempUserInfo(String tempuserName , String tempuserMobnumber){
		SendMailUtility  sendMailUtility =  new SendMailUtility();
		sendMailUtility.sendMailAboutGuestUser(tempuserName,tempuserMobnumber);
		return ok("success");
		
	}
	@Transactional
	public static Result sendMailAboutClassifiedAd(String tempuserName , String tempuserMobnumber,String tempuserNote){
		SendMailUtility  sendMailUtility =  new SendMailUtility();
		sendMailUtility.sendMailAboutClassifiedAd(tempuserName,tempuserMobnumber,tempuserNote);

		return ok("success");
		
	}
	

}
