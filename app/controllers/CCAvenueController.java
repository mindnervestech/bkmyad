package controllers;

import java.util.zip.Adler32;

import javax.persistence.criteria.Order;

import models.AddressDetails;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.CCAvenueDefaultVM;

import com.ccavenue.security.AesCryptUtil;

public class CCAvenueController extends Controller {
	@Transactional
	public static Result ccavenue(String orderId) {
		models.Order o = models.Order.byId(orderId);
	    	CCAvenueDefaultVM ccAvenueDefaultVo = new CCAvenueDefaultVM();
	     	ccAvenueDefaultVo.Order_Id = orderId;
	     	ccAvenueDefaultVo.Amount = o.total + "";
	     	AddressDetails addressDetails = AddressDetails.findByOrderId(orderId);
	     	ccAvenueDefaultVo.billing_cust_name = addressDetails.fullName;
	     	ccAvenueDefaultVo.billing_cust_address = addressDetails.address;
	     	ccAvenueDefaultVo.billing_cust_country = "India";
	     	ccAvenueDefaultVo.billing_zip = addressDetails.pinCode;
	     	ccAvenueDefaultVo.billing_cust_email = o.email;
	     	ccAvenueDefaultVo.billing_cust_state = addressDetails.state;
	     	ccAvenueDefaultVo.billing_cust_tel = addressDetails.mobile;
	     	
	     	ccAvenueDefaultVo.delivery_cust_name = addressDetails.fullName;
	     	ccAvenueDefaultVo.delivery_cust_address = addressDetails.address;
	     	ccAvenueDefaultVo.delivery_cust_country = "India";
	     	ccAvenueDefaultVo.delivery_zip = addressDetails.pinCode;
	     	ccAvenueDefaultVo.delivery_cust_state = addressDetails.state;
	     	ccAvenueDefaultVo.delivery_cust_tel = addressDetails.mobile;
	     	ccAvenueDefaultVo.billing_cust_city = addressDetails.city;
	     	ccAvenueDefaultVo.Checksum = getChecksum( ccAvenueDefaultVo.Merchant_Id,
	     			ccAvenueDefaultVo.Order_Id, ccAvenueDefaultVo.Amount, ccAvenueDefaultVo.Redirect_Url,
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
