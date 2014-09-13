package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Transient;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;


@Entity
public class Newspaperdetails {

	public Newspaperdetails() {}
	
	@Id
	public String NewsId;
	public String Nameofthenewspaper;
	public String LogoFileExtention;
	public String LogoName;
	public String Addedition;
	@Transient
public List<String> NameofCities;
	
	public String Nameofcities;
	
	@Transient
	public String Unit;
	
	@Transient
	public String Value;
	
	public String BasicratesperText;
	public String BasicratesperClasified;
	public String Beforebookingdate;
	public String Allow;
	public String Statename;
	
	
	
	@Transactional
    public static long getAllnewpaperTotal(String Nameofthenewspaper,  int rowsPerPage) {
    	long totalPages = 0, size;
    	
    	if(Nameofthenewspaper.trim().equals("")) {
    		size = (long) JPA.em().createQuery("Select count(*) from Newspaperdetails a").getSingleResult();
    	} else {
    		Query query = JPA.em().createQuery("Select count(*) from Newspaperdetails a where a.Nameofthenewspaper LIKE ?2");
    		query.setParameter(2, "%"+Nameofthenewspaper+"%");
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
	    public static List<Newspaperdetails> getAllNewspaper(String Nameofthenewspaper, int currentPage, int rowsPerPage, long totalPages) {
	    	int  start=0;
	    	/*Query q;*/
	    	String sql="";
	    	
	    	System.out.println("------------"+Nameofthenewspaper+"------------");
	    	if(Nameofthenewspaper.trim().equals("")) {
	    		sql = "Select a from Newspaperdetails a";
	    	} else {
	    		sql ="SelectSelect a from Newspaperdetails a where a.Nameofthenewspaper LIKE ?1";
	    		
	    	}

    		if(currentPage >= 1 && currentPage <= totalPages) {
				start = (currentPage*rowsPerPage)-rowsPerPage;
			}
			if(currentPage>totalPages && totalPages!=0) {
				currentPage--;
				start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
			}
	    	Query q = JPA.em().createQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
	    	if(!Nameofthenewspaper.trim().equals("")) {
				q.setParameter(1, "%"+Nameofthenewspaper+"%");
			}
			
		
			return (List<Newspaperdetails>)q.getResultList();
			
			
	    }
	
	 public static Newspaperdetails findById(String id) {
	    	Query query = JPA.em().createQuery("Select a from Newspaperdetails a where a.NewsId = ?1");
			query.setParameter(1, id);
	    	return (Newspaperdetails) query.getSingleResult();
	    }
	
	/*---------------------------------------*/
	
	
	@Transactional	
	public static List<Newspaperdetails> getAllnewspaper() {
		Query q = JPA.em().createQuery("Select a.Nameofthenewspaper from Newspaperdetails a order by Nameofthenewspaper Asc");
		return (List<Newspaperdetails>)q.getResultList();
	}
	
	@Transactional	
	public static List<String> getAllnewspaperString() {
		Query q = JPA.em().createQuery("Select a.Nameofthenewspaper from Newspaperdetails a order by Nameofthenewspaper Asc");
		return (List<String>)q.getResultList();
	}
	
	@Transactional	
	public static List<Newspaperdetails> getbeforebookingdate(String nname) {
		Query q = JPA.em().createQuery("Select a from Newspaperdetails a where a.Nameofthenewspaper = ?1");
		q.setParameter(1, nname);
		return (List<Newspaperdetails>)q.getResultList();
	}


	@Transactional	
	public static List<String> getNameofallenewspaper() {
		Query q = JPA.em().createQuery("Select a.Nameofthenewspaper from Newspaperdetails a order by Nameofthenewspaper Asc");
		return (List<String>)q.getResultList();
	}

	@Transactional
    public void save() {
		this.NewsId = UUID.randomUUID().toString();
		this.Nameofcities = this.NameofCities.toString();
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
