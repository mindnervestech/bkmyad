package viewmodel;

import models.AddressDetails;


public class AddressDetailsVM {
	
	   
	   public String pinCode;
	   public String  fullName;
	   public String address;
	   public String city;
	   public String state;
	   public String  mobile;
	
	   public AddressDetailsVM(AddressDetails addressDetails) {
	    	this.pinCode=addressDetails.pinCode;
	    	this.fullName=addressDetails.fullName;
	    	this.city=addressDetails.city;
	    	this.state=addressDetails.state;
	    	this.mobile=addressDetails.mobile;
	    	
	    }
	   
}
