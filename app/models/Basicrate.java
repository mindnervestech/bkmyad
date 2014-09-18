package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import viewmodel.AnnouncementVM;
import viewmodel.ResultVM;
import viewmodel.NewspaperVM;


@Entity
public class Basicrate {

	public Basicrate() {}
	
		@Id 
		public String BasicRateID;
		public String Nameofthenewspaper;
		public String City;
		public String Textaddrate;
		public String clasifiedadrate;
		public String Exstracostperline;
		public String Border;
		public String Backcolor;
		public String SpecialDiscount;
		public String Tick;
		public String Category;
		public String Extraborderper;
		public String Extrabgper;
		public String Tickper;
		public String ExtracostperSqcm;
		public String Statename;
				
		
		@Transactional
	    public static long getAllAnnouncementsTotal(String City,  int rowsPerPage) {
	    	long totalPages = 0, size;
	    	
	    	if(City.trim().equals("")) {
	    		size = (long) JPA.em().createQuery("Select count(*) from Basicrate a").getSingleResult();
	    	} else {
	    		Query query = JPA.em().createQuery("Select count(*) from Basicrate a where a.City LIKE ?2");
	    		query.setParameter(2, "%"+City+"%");
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
		    public static List<Basicrate> getAllAnnouncements(String City, int currentPage, int rowsPerPage, long totalPages) {
		    	int  start=0;
		    	/*Query q;*/
		    	String sql="";
		    	
		    	System.out.println("------------"+City+"------------");
		    	if(City.trim().equals("")) {
		    		sql = "Select a from Basicrate a";
		    	} else {
		    		sql ="Select a from Basicrate a where a.City LIKE ?1";
		    		
		    	}

	    		if(currentPage >= 1 && currentPage <= totalPages) {
					start = (currentPage*rowsPerPage)-rowsPerPage;
				}
				if(currentPage>totalPages && totalPages!=0) {
					currentPage--;
					start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
				}
		    	Query q = JPA.em().createQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
		    	if(!City.trim().equals("")) {
					q.setParameter(1, "%"+City+"%");
				}
				
			
				return (List<Basicrate>)q.getResultList();
				
				
		    }
		
		 public static Basicrate findById(String id) {
		    	Query query = JPA.em().createQuery("Select a from Basicrate a where a.BasicRateID = ?1");
				query.setParameter(1, id);
		    	return (Basicrate) query.getSingleResult();
		    }
		 
		 
		 
	@Transactional	
		public static List<Object[]> getallcity(String cname,String nname) {
			Query q = JPA.em().createNativeQuery("SELECT BasicRateID,City,Textaddrate,clasifiedadrate,BasicratesperText,BasicratesperClasified,Category " +
					"FROM Basicrate INNER JOIN Newspaperdetails " +
					"ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Basicrate.Category= ?1 and Basicrate.Nameofthenewspaper= ?2 " +
					"order by City Asc");
			q.setParameter(1, cname);
			q.setParameter(2, nname);
			List<Object[]> list = (List<Object[]>)q.getResultList();
			return list;
			
			
		}
		
		
		
		@Transactional	
		public static List<Object[]> getbasicdatanewspaperwise(String cname,List<String> city) {
			System.out.println(cname);
			Query q = JPA.em().createNativeQuery("SELECT BasicRateID,Basicrate.Nameofthenewspaper,City,Textaddrate,clasifiedadrate,BasicratesperText,BasicratesperClasified,Category  " +
		            "FROM Basicrate INNER JOIN Newspaperdetails " +
					"ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Basicrate.Category = ?1 and Basicrate.City IN ?2 " +
					"order by City Asc");
			
			q.setParameter(1, cname);
			q.setParameter(2, city);
			List<Object[]> list = (List<Object[]>)q.getResultList();
			return list;
			
			
		}
		
		@Transactional	
		public static List<Object[]> getbasicdatacitywise(String cname,String[] city,List<String> newspaper) {
			List<String> c = Arrays.asList(city);
			Query q = JPA.em().createNativeQuery("SELECT BasicRateID,Basicrate.Nameofthenewspaper,City,Textaddrate,clasifiedadrate,BasicratesperText,BasicratesperClasified,Category  " +
		            "FROM Basicrate INNER JOIN Newspaperdetails " +
					"ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Basicrate.Category = ?1 and Basicrate.City IN ?2 and Basicrate.Nameofthenewspaper IN ?3 ");
			
			q.setParameter(1, cname);
			q.setParameter(2, c);
			q.setParameter(3, newspaper);
			List<Object[]> list = (List<Object[]>)q.getResultList();
			return list;
			
			
		}
		
		
		
		
		@Transactional	
		public static List<Object[]> getnewspaper(String cname,String city) {
			Query q = JPA.em().createNativeQuery("SELECT BasicRateID,Basicrate.Nameofthenewspaper,City,Textaddrate,clasifiedadrate,BasicratesperText,BasicratesperClasified,Category  " +
		            "FROM Basicrate INNER JOIN Newspaperdetails " +
					"ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Basicrate.Category = ?1 and Basicrate.City= ?2 " +
					"order by City Asc");
			q.setParameter(1, cname);
			q.setParameter(2, city);
			List<Object[]> list = (List<Object[]>)q.getResultList();
			return list;
			
			
		}
		
		@Transactional
	    public void save() {
			this.BasicRateID = UUID.randomUUID().toString();
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
