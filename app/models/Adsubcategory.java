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
public class Adsubcategory {

	public Adsubcategory() {}
	
	@Id 
	public String CSID;
	
	public String cname;
	
	public String Sucategory;
		
	
	@Transactional
    public static long getAllcategoryTotal(String cname,  int rowsPerPage) {
    	long totalPages = 0, size;
    	
    	if(cname.trim().equals("")) {
    		size = (long) JPA.em().createQuery("Select count(*) from Adsubcategory a").getSingleResult();
    	} else {
    		Query query = JPA.em().createQuery("Select count(*) from Adsubcategory a where a.cname LIKE ?2");
    		query.setParameter(2, "%"+cname+"%");
    		size= (long) query.getSingleResult();
    	}
    	
    	totalPages = size/rowsPerPage;
		
    	if(size % rowsPerPage > 0) {
			totalPages++;
		}
    	System.out.println("total pages ::"+totalPages);
    	return totalPages;
    }
	
	 @Transactional
	    public static List<Adsubcategory> getAllcategory(String cname, int currentPage, int rowsPerPage, long totalPages) {
	    	int  start=0;
	    	/*Query q;*/
	    	String sql="";
	    	
	    	System.out.println("------------"+cname+"------------");
	    	if(cname.trim().equals("")) {
	    		sql = "Select a from Adsubcategory a";
	    	} else {
	    		sql ="Select a from Adsubcategory a where a.cname LIKE ?1";
	    		
	    	}

    		if(currentPage >= 1 && currentPage <= totalPages) {
				start = (currentPage*rowsPerPage)-rowsPerPage;
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
				start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
			}
	    	Query q = JPA.em().createQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
	    	if(!cname.trim().equals("")) {
				q.setParameter(1, "%"+cname+"%");
			}
			
		
			return (List<Adsubcategory>)q.getResultList();
			
			
	    }
		
	 public static Adsubcategory findById(String id) {
	    	Query query = JPA.em().createQuery("Select a from Adsubcategory a where a.CSID = ?1");
			query.setParameter(1, id);
	    	return (Adsubcategory) query.getSingleResult();
	    }
	
	
	@Transactional	
	public static List<Adsubcategory> getSubcategotBy(String cname) {
		Query q = JPA.em().createQuery("Select a from Adsubcategory a where a.cname = ?1");
		q.setParameter(1, cname);
		return (List<Adsubcategory>)q.getResultList();
	}
		
	@Transactional
    public void save() {
		this.CSID = UUID.randomUUID().toString();
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
