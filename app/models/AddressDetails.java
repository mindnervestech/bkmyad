package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;

@Entity
public class AddressDetails {
	   @Id 
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   public Long id;
	   
	   public String pinCode;
	   public String  fullName;
	   public String address;
	  // public String nearestLandmark;
	   public String city;
	   public String state;
	   public String  mobile;
	//   public String landLine;
	   public String userEmailid;
	   public String orderId;
	public static AddressDetails findById(String email) {
		return JPA.em().createQuery("from AddressDetails where email = :email",AddressDetails.class)
				.setParameter("email", email).getSingleResult();
	}
	
	public static AddressDetails findByOrderId(String orderId) {
		return JPA.em().createQuery("from AddressDetails where orderId = :orderId",AddressDetails.class)
				.setParameter("orderId", orderId).getSingleResult();
	}
	    
}
