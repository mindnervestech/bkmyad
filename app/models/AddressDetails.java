package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

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
	   public String nearestLandmark;
	   public String city;
	   public String state;
	   public String  mobile;
	   public String landLine;
	   public String userEmailid;
	   
	   public static AddressDetails findById(Long id2) {
	    	Query query = JPA.em().createQuery("Select a from AddressDetails a where a.id = ?1");
			query.setParameter(1, id2);
	    	return (AddressDetails) query.getSingleResult();
	    }
	    
}
