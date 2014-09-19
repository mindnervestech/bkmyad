package viewmodel;

import java.util.UUID;

public class CCAvenueDefaultVM {
	public String Merchant_Id = "M_raj28780_28780"; //This id(also User_Id)  available at "Generate Working Key" of "Settings & Options"
	public String Amount = "10.0"; //your script should substitute the amount here in the quotes provided here
	public String Order_Id = UUID.randomUUID().toString();//request.getParameter("order_id");  //your script should substitute the unique order description here in the quotes provided here
	public String Redirect_Url = "http://106.186.119.78/redirect";//your redirect URL where your customer will be redirected after authorisation from CCAvenue
	public String WorkingKey = "3vrz1tf22sk3qcgh4gjvijd1fuqdup0f";   
	//put in the 32 bit alphanumeric key in the quotes provided here.Please note that get this key login to your CCAvenue merchant account and visit the "Generate Working Key" section at the "Settings & Options" page. 
	public String Checksum = "";
	
	public String billing_cust_name;
	public String billing_cust_address;
	public String billing_cust_country="India";
	public String billing_cust_tel;
	public String billing_cust_email;
	public String billing_cust_state;
	public String delivery_cust_name="test";
	public String delivery_cust_address="test";
	public String delivery_cust_country="India";
	public String delivery_cust_state="MH";
	public String delivery_cust_tel="9898989898";
	public String delivery_cust_notes="No notes";
	public String Merchant_Param="Test"; 
	public String billing_city;
	public String billing_zip;
	public String delivery_city = "Mumbai";
	public String delivery_zip = "400059";
}
