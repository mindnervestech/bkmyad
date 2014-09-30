package viewmodel;

import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Objects;

public class CCAvenueDefaultVM {
	public String Merchant_Id = "M_raj28780_28780"; 
	public String Amount = "10.0"; // To be displayed on UI
	public String Order_Id = UUID.randomUUID().toString(); // To be displayed on UI
	public String Redirect_Url = "http://96.126.114.115/redirect";
	public String WorkingKey = "3vrz1tf22sk3qcgh4gjvijd1fuqdup0f";   
	//put in the 32 bit alphanumeric key in the quotes provided here.Please note that get this key login to your CCAvenue merchant account and visit the "Generate Working Key" section at the "Settings & Options" page. 
	public String Checksum = "";
	
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
	
	//return code
	public String nb_bid = "0651055194"; // To be displayed on UI
	public String nb_order_no ="CCABI1FHH635"; // To be displayed on UI
	public String card_category = "NETBANKING"; // To be displayed on UI
	public String bank_name = "ICIC Bank"; // To be displayed on UI
	public String bankRespCode; // To be displayed on UI
	public String bankRespMsg; // To be displayed on UI
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
