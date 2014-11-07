package controllers;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.Adler32;

import models.AddressDetails;
import models.CCConfig;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import utils.SendMailUtility;
import viewmodel.CCAvenueDefaultVM;

import com.ccavenue.security.AesCryptUtil;

public class CCAvenueController extends Controller {
	@Transactional
	public static Result ccavenue(String orderId) {
		CCConfig config = CCConfig.byId(1);
		models.Order o = models.Order.byId(orderId);
	    	CCAvenueDefaultVM ccAvenueDefaultVo = new CCAvenueDefaultVM();
	    	ccAvenueDefaultVo.accessCode= config.getAccessCode();
	    	ccAvenueDefaultVo.Merchant_Id = config.getMerchant_Id();
	    	ccAvenueDefaultVo.WorkingKey = config.getWorkingKey();
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
	     	//ccAvenueDefaultVo.billing_cust_address = routes.CCAvenueController.redirect().url();
	     	ccAvenueDefaultVo.Checksum = getChecksum( ccAvenueDefaultVo.Merchant_Id,
	     	ccAvenueDefaultVo.Order_Id, ccAvenueDefaultVo.Amount, ccAvenueDefaultVo.Redirect_Url,
	   		ccAvenueDefaultVo.WorkingKey);
	     	
	     	ccAvenueDefaultVo.ccaRequest = ccAvenueDefaultVo.buildRequest();
        return ok(views.html.ccacheckoutiframe/*ccacheckout*/.render("Your new application is ready.", ccAvenueDefaultVo));
    }
    
	@Transactional
    public static Result redirect() {
    	String encResponse=request().getQueryString("encResp");
    	System.out.println("========" + encResponse);
		CCConfig config = CCConfig.byId(1);
    	AesCryptUtil aesUtil=new AesCryptUtil(config.WorkingKey);
    	String ccaResponse=aesUtil.decrypt(encResponse);
    	System.out.println("====++++++====" + ccaResponse);
    	StringTokenizer tokenizer = new StringTokenizer(ccaResponse, "&");
		HashMap<String,String> hs=new HashMap<String,String>();
		String pair=null, pname=null, pvalue=null;
		while (tokenizer.hasMoreTokens()) {
			pair = (String)tokenizer.nextToken();
			if(pair!=null) {
				StringTokenizer strTok=new StringTokenizer(pair, "=");
				pname=""; pvalue="";
				if(strTok.hasMoreTokens()) {
					pname=(String)strTok.nextToken();
					if(strTok.hasMoreTokens())
						pvalue=(String)strTok.nextToken();
					hs.put(pname, pvalue);
				}
			}
		}
    	System.out.println(hs);
    	CCAvenueDefaultVM ccAvenueDefaultVM = new CCAvenueDefaultVM();
    	ccAvenueDefaultVM.Order_Id = hs.get("order_id");
    	try{
    		models.Order o = models.Order.byId(ccAvenueDefaultVM.Order_Id);
    		ccAvenueDefaultVM.bankRespMsg = hs.toString(); 
    		o.bankMsg = hs.toString();
        	//send mail utility 
        	SendMailUtility sendMail = new SendMailUtility();
            sendMail.sendMailAboutOrder(o.orderId,o.email,o.cc_orderNo);
            JPA.em().merge(o);
            
    	} catch(javax.persistence.NoResultException exception) {
    		return controllers.Application.index();
    	}
    	
    	return ok(views.html.ccaredirect.render(ccAvenueDefaultVM));
    
	}
    
    public static Result redirectTest() {
    	CCAvenueDefaultVM ccAvenueDefaultVo = new CCAvenueDefaultVM();
    	return ok(views.html.ccaredirect.render(ccAvenueDefaultVo));
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
