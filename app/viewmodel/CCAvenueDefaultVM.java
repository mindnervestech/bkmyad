package viewmodel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ccavenue.security.AesCryptUtil;

public class CCAvenueDefaultVM {
	public String Merchant_Id = "M_raj28780_28780"; 
	public String Amount = "10.0"; // To be displayed on UI
	public String Order_Id ; // To be displayed on UI
	public String Redirect_Url = "http://arihantbooking.com/redirect";
	public String  cancel_url = "http://arihantbooking.com/redirect";
	public String WorkingKey = "3vrz1tf22sk3qcgh4gjvijd1fuqdup0f";   
	//put in the 32 bit alphanumeric key in the quotes provided here.Please note that get this key login to your CCAvenue merchant account and visit the "Generate Working Key" section at the "Settings & Options" page. 
	public String Checksum = "";
	public String accessCode = "FAZ76VPSCBFSUREG";
	public String billing_cust_name="Test";
	public String billing_cust_address="Test";
	public String billing_cust_country="India";
	public String billing_cust_tel="9898898898";
	public String billing_cust_email="test@test.info";
	public String billing_cust_state="MH";
	public String delivery_cust_name="test";
	public String delivery_cust_address="test";
	public String delivery_cust_country="India";
	public String delivery_cust_state="MH";
	public String delivery_cust_tel="9898989898";
	public String delivery_cust_notes="No notes";
	public String Merchant_Param="Test"; 
	public String billing_cust_city = "Mumbai";
	public String billing_zip = "400059";
	public String delivery_city = "Mumbai";
	public String delivery_zip = "400059";
	public String AuthDesc;
	public String currency = "INR";
	public String language = "EN";
	public String ccaRequest="";
	
	//return code
	public String nb_bid; // To be displayed on UI
	public String nb_order_no; // To be displayed on UI
	public String card_category; // To be displayed on UI
	public String bank_name; // To be displayed on UI
	public String bankRespCode; // To be displayed on UI
	public String bankRespMsg; // To be displayed on UI
	public String orderStatus;
	public String trackingId;
	public String bankReferenceNumber;
	public String orderStatusMsg;
	public String buildRequest() {
		
		 
		try {
			ccaRequest = ccaRequest + "merchant_id" + "=" + URLEncoder.encode(Merchant_Id,"UTF-8") + "&";
			ccaRequest = ccaRequest + "amount" + "=" + URLEncoder.encode(Amount,"UTF-8") + "&";
			ccaRequest = ccaRequest + "cancel_url" + "=" + URLEncoder.encode(cancel_url,"UTF-8") + "&";
			
			ccaRequest = ccaRequest + "order_id" + "=" + URLEncoder.encode(Order_Id,"UTF-8") + "&";
			ccaRequest = ccaRequest + "redirect_url" + "=" + URLEncoder.encode(Redirect_Url,"UTF-8") + "&";
			ccaRequest = ccaRequest + "currency" + "=" + URLEncoder.encode(currency,"UTF-8") + "&";
			ccaRequest = ccaRequest + "language" + "=" + URLEncoder.encode(language,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_name" + "=" + URLEncoder.encode(billing_cust_name,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_address" + "=" + URLEncoder.encode(billing_cust_address,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_city" + "=" + URLEncoder.encode(billing_cust_city,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_state" + "=" + URLEncoder.encode(billing_cust_state,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_zip" + "=" + URLEncoder.encode(billing_zip,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_country" + "=" + URLEncoder.encode(billing_cust_country,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_tel" + "=" + URLEncoder.encode(billing_cust_tel,"UTF-8") + "&";
			ccaRequest = ccaRequest + "billing_email" + "=" + URLEncoder.encode(billing_cust_email,"UTF-8") + "&";
			ccaRequest = ccaRequest + "integration_type" + "=" + URLEncoder.encode("iframe_normal","UTF-8");
			AesCryptUtil aesUtil=new AesCryptUtil(WorkingKey);
			return  aesUtil.encrypt(ccaRequest);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 
		 return null;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
}
