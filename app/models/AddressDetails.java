package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class AddressDetails {
	   @Id 
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   public Long id;
	   
	   public String pinCode;
	   public String  fullName;
	   public String address;
	   public String nearestLandmark;
	   public String city;
	   public String state;
	   public String  mobile;
	   public String landLine;
	   public String userEmailid;
	    
}
