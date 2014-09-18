package controllers;

import java.util.zip.Adler32;

import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.CCAvenueDefaultVM;

import com.ccavenue.security.AesCryptUtil;

public class CCAvenueController extends Controller {
	public static Result ccavenue() {
    	CCAvenueDefaultVM ccAvenueDefaultVo = new CCAvenueDefaultVM();
    	ccAvenueDefaultVo.Order_Id = "";// Akash to put actual value here
    	ccAvenueDefaultVo.Amount = "";// Akash to put actual value here
    	ccAvenueDefaultVo.Checksum = getChecksum(
    			ccAvenueDefaultVo.Merchant_Id,
    			ccAvenueDefaultVo.Order_Id,  
    			ccAvenueDefaultVo.Amount, 
    			ccAvenueDefaultVo.Redirect_Url,
    			ccAvenueDefaultVo.WorkingKey);
        return ok(views.html.ccacheckout.render("Your new application is ready.", ccAvenueDefaultVo));
    }
    
    public static Result redirect() {
    	String WorkingKey = "3vrz1tf22sk3qcgh4gjvijd1fuqdup0f" ; //put in the 32 bit working key in the quotes provided here
    	String encResponse=request().getQueryString("encResponse");
    	AesCryptUtil aesUtil=new AesCryptUtil(WorkingKey);
    	String ccaResponse=aesUtil.decrypt(encResponse);	
    	return ok(views.html.ccaredirect.render("Your new application is ready. " + ccaResponse));
    }
    
    private static String verifyChecksum(String MerchantId , String OrderId, String Amount, String AuthDesc, String WorkingKey, String CheckSum) throws Exception 	{
    	String str = MerchantId+"|"+OrderId+"|"+Amount+"|"+AuthDesc+"|"+WorkingKey;
    	
    	Adler32  adl = new Adler32();                 
    	adl.update(str.getBytes());
    	long adler = adl.getValue();

    	String newChecksum = String.valueOf(adl.getValue());
    	return (newChecksum.equals(CheckSum)) ? "true" : "false";
    	
    }


    private static String getChecksum(String MerchantId, String OrderId, String Amount, String redirectUrl, String WorkingKey)  {
    	String str = MerchantId + "|" + OrderId + "|" + Amount + "|" + redirectUrl + "|" + WorkingKey;

    	Adler32  adl = new Adler32();
    	adl.update(str.getBytes());
    	return String.valueOf(adl.getValue());
    }

}
