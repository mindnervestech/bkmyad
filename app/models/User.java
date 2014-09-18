package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;

@Entity
public class User {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   public Long id;
	   
	   @Required
	   public String name;
	   @Required
	   public String password;
	   @Required
	   public String mobileNum;
	   @Required
	   public String email;
	   public String role;
	   
	   
	   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	 public static User findByCredentials(final String email,final String password) {
	        try {
	            Query q = JPA.em().createQuery(
	                    "SELECT u FROM User u  where  email = ?1 and password = ?2 ");
	            
	            q.setParameter(1, email);
	            q.setParameter(2, password);
	            return (User) q.getSingleResult();
	            
	        } catch (NoResultException e) {
	            return null;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public static User findExistingUser(String email)
	{
		 try {
	            Query q = JPA.em().createQuery(
	                    "SELECT u FROM User u  where  email = ?1 ");
	            
	            q.setParameter(1, email);
	          
	            return (User) q.getSingleResult();
	            
	        } catch (NoResultException e) {
	            return null;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}
	public static User ValidateUsernameUnique(String email) {
		// TODO Auto-generated method stub
		
			try {
            Query q = JPA.em().createQuery(
                    "SELECT u FROM User u  where  email = ?1 ");
            
            q.setParameter(1, email);
          
            return (User) q.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
		
	}
 
}
