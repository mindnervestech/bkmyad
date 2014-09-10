package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Query;

import org.apache.commons.lang3.builder.EqualsBuilder;

import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

/**
 * Announcement are not frequently updated. Put in the cache and set ttl to e.g. 10mins.
 */
@Entity
public class Announcement  {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @Required
    @Column(length=2000)
    public String title;
    
    @Column(length=2000)
    public String description;
    
    public String url;
    
    
    public String announcementType;
    
    public Date fromDate;
    
    public Date toDate;
    
    
    
    public Announcement() {}
    

    
    @Transactional
    public static long getAllAnnouncementsTotal(String title,  int rowsPerPage) {
    	long totalPages = 0, size;
    	if(title.trim().equals("")) {
    		size = (long) JPA.em().createQuery("Select count(*) from Announcement a").getSingleResult();
    	} else {
    		Query query = JPA.em().createQuery("Select count(*) from Announcement a where a.title LIKE ?2");
    		query.setParameter(2, "%"+title+"%");
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
    public static List<Announcement> getAllAnnouncements(String title, int currentPage, int rowsPerPage, long totalPages) {
    	int  start=0;
    	
    	String sql="";
    	if(title.trim().equals("")) {
    		sql = "Select a from Announcement a";
    	} else {
    		sql = "Select a from Announcement a where a.title LIKE ?1";
    	}
		
    	if(currentPage >= 1 && currentPage <= totalPages) {
			start = (currentPage*rowsPerPage)-rowsPerPage;
		}
		if(currentPage>totalPages && totalPages!=0) {
			currentPage--;
			start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
		}
    	Query q = JPA.em().createQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
		
		if(!title.trim().equals("")) {
			q.setParameter(1, "%"+title+"%");
		}
	
		return (List<Announcement>)q.getResultList();
    }
    
    public static Announcement findById(Long id) {
    	Query query = JPA.em().createQuery("Select a from Announcement a where a.id = ?1");
		query.setParameter(1, id);
    	return (Announcement) query.getSingleResult();
    }
    
   
    
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Announcement) {
            final Announcement other = (Announcement) o;
            return new EqualsBuilder().append(id, other.id).isEquals();
        } 
        return false;
    }
    
    @Override
    public  String toString() {
        return "[" + announcementType + "|" + title + "|" + description + "|"  
                 + "|"  + url + "|" + fromDate + "|" + toDate + "]";
    }
    
    @Transactional
    public void save() {
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
