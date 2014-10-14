package models;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

@Entity
public class AddressDetails {
	   @Id 
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   public Long id;
	   public String pinCode;
	   public String  fullName;
	   public String address;
	   public String city;
	   public String state;
	   public String  mobile;
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
	
	    @Transactional
	    public static AddressDetails getAddressDetails(String emailId) {
	    try{
	    Query q = JPA.em().createNativeQuery("select * from AddressDetails where userEmailid = ?1 order by id DESC LIMIT 1 ",AddressDetails.class);
	    q.setParameter(1, emailId);
	    System.out.println("q"+q);
	    return (AddressDetails) q.getSingleResult();
	    }
	    catch(NoResultException e) {
	       return null;
	    }
	    }
}
