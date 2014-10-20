package models;

import java.math.BigInteger;
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

	public static User getpassword(String email) {
		Query q = JPA.em().createQuery(
                "SELECT u FROM User u  where  email = ?1 ");
        
        q.setParameter(1, email);
      
        return (User) q.getSingleResult();
	}
	 @Transactional
	    public static long getAllRegisteredUserTotal(String City,  int rowsPerPage) {
	    	long totalPages = 0, size;
	    	BigInteger sizebig;
	    	
	    	if(City.trim().equals("")) {
	    		sizebig = (BigInteger)JPA.em().createNativeQuery("select count(*) from User").getSingleResult();
	    	} else {
	    		Query query = JPA.em().createNativeQuery("select count(*) from User where User.email like ?1");
	    		query.setParameter(1, "%"+City+"%");
	    		sizebig= (BigInteger) query.getSingleResult();
	    	}
	    	//cast to long
	    	size=sizebig.longValue();
	    			
	    	totalPages = size/rowsPerPage;
			
	    	if(size % rowsPerPage > 0) {
				totalPages++;
			}
	    	System.out.println("total pages ::"+totalPages);
	    	return totalPages;
	    }
		
		 @Transactional
		    public static List<Object[]> getAllRegisteredUsers(String City, int currentPage, int rowsPerPage, long totalPages) {
		    	int  start=0;
		    	System.out.println("City selected is "+City);
		    	/*Query q;*/
		    	String sql="";
		    	if(City.trim().equals("")) {
		    		
		    		sql = "select * from User";//
		    	} else {
		    		sql ="select from User where User.email like ?1";
		    	}

	    		if(currentPage >= 1 && currentPage <= totalPages) {
					start = (currentPage*rowsPerPage)-rowsPerPage;
				}
				if(currentPage>totalPages && totalPages!=0) {
					currentPage--;
					start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
				}
		    	Query q = JPA.em().createNativeQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
		    	if(!City.trim().equals("")) {
					q.setParameter(1, "%"+City+"%");
				}
				
				return (List<Object[]>)q.getResultList();
				
		    }
 
}
