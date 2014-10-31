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
    		size = (Long) JPA.em().createQuery("Select count(*) from Adcategory a").getSingleResult();
    	} else {
    		Query query = JPA.em().createQuery("Select count(*) from Adsubcategory a where a.cname LIKE ?2");
    		query.setParameter(2, "%"+cname+"%");
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
	    public static List<Object[]> getAllcategory(String cname, int currentPage, int rowsPerPage, long totalPages) {
	    	int  start=0;
	    	/*Query q;*/
	    	String sql="";
	    	
	    	if(cname.trim().equals("")) {
	    		sql = "SELECT Adcategory.CID,Adcategory.cname,Adsubcategory.Sucategory,Adsubcategory.CSID FROM Adcategory LEFT JOIN Adsubcategory ON Adcategory.cname = Adsubcategory.cname UNION SELECT Adcategory.CID,Adcategory.cname,Adsubcategory.Sucategory,Adsubcategory.CSID FROM Adcategory RIGHT JOIN Adsubcategory ON Adcategory.cname = Adsubcategory.cname";
	    	} else {
	    		sql ="SELECT Adcategory.CID,Adcategory.cname,Adsubcategory.Sucategory,Adsubcategory.CSID FROM  Adcategory ,adsubcategory  where Adcategory.cname = adsubcategory.cname AND  Adcategory.cname LIKE ?1";
	    	}

    		if(currentPage >= 1 && currentPage <= totalPages) {
				start = (currentPage*rowsPerPage)-rowsPerPage;
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
				start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
			}
	    	Query q = JPA.em().createNativeQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
	    	if(!cname.trim().equals("")) {
				q.setParameter(1, "%"+cname+"%");
			}
			
		
			return (List<Object[]>)q.getResultList();
			
			
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
