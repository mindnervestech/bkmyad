package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;


@Entity
public class City {

	public City() {}
	
	@Id
	public String CID;
	public String Statename;
	public String Cityname;
	
	
	

	@Transactional
    public static long getAllStatesTotal(String Statename,  int rowsPerPage) {
    	long totalPages = 0, size;
    	System.out.println("/*-*/*/--"+Statename+"*/*-/-*/-*/");
    	if(Statename.trim().equals("")) {
    		size = (Long) JPA.em().createQuery("Select count(*) from City a").getSingleResult();
    	} else {
    		Query query = JPA.em().createQuery("Select count(*) from City a where a.Statename LIKE ?2");
    		query.setParameter(2, "%"+Statename+"%");
    		size= (Long) query.getSingleResult();
    	}
    	
    	totalPages = size/rowsPerPage;
		
    	if(size % rowsPerPage > 0) {
			totalPages++;
		}
    	System.out.println("total pages ::"+totalPages);
    	return totalPages;
    }
	
	 @Transactional
	    public static List<City> getAllStates(String Statename, int currentPage, int rowsPerPage, long totalPages) {
	    	int  start=0;
	    	
	    	String sql="";
	    	
	    	System.out.println("------------"+Statename+"------------");
	    	if(Statename.trim().equals("")) {
	    		sql = "Select a from City a";
	    	} else {
	    		sql ="Select a from City a where a.Statename LIKE ?1";
	    		
	    	}

    		if(currentPage >= 1 && currentPage <= totalPages) {
				start = (currentPage*rowsPerPage)-rowsPerPage;
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
				start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
			}
	    	Query q = JPA.em().createQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
	    	if(!Statename.trim().equals("")) {
				q.setParameter(1, "%"+Statename+"%");
			}
			
		
			return (List<City>)q.getResultList();
			
			
	    }
		
	 public static City findById(String id) {
	    	Query query = JPA.em().createQuery("Select a from City a where a.CID = ?1");
			query.setParameter(1, id);
	    	return (City) query.getSingleResult();
	    }
	
	
	
	

	@Transactional
	public static List<String> getallcity(String statename)
	{
		System.out.println("******"+statename+"***********");
		Query q=JPA.em().createQuery("Select a.Cityname from City a where a.Statename=?1");
		q.setParameter(1, statename);
		return (List<String>)q.getResultList();
	}

	@Transactional
	public static List<String> getAllCityName()
	{
		
		Query q=JPA.em().createQuery("Select a.Cityname from City a ");
		return (List<String>)q.getResultList();
	}

	@Transactional
    public void save() {
		this.CID = UUID.randomUUID().toString();
        JPA.em().persist(this);
        JPA.em().flush();     
    }
      
    @Transactional
    public void delete() {
        JPA.em().remove(this);
    }
    
    @Transactional
    public void merge() {
        JPA.em().merge(this);
    }
    
    @Transactional
    public void refresh() {
        JPA.em().refresh(this);
    }
	
}
