package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import viewmodel.DiscountpriceVM;


@Entity
public class Discountprice {

	public Discountprice() {}
	
	    @Id
		public String Did;
		public String Nameofthenewspaper;
		public String Edition;
		public String Tbasicprice;
		public String Toffpercentage;
		public String Ttotalprice;
		public String Dbasicprice;
		public String Doffprice;
		public String Dtotalprice;
		public String Exstracostperline;
		public String Border="0";
		public String Backcolor="0";
		public String SpecialDiscount;
		public String Tick ="0";
		public String Category;
		public String Extraborderper="0";
		public String Extrabgper="0";
		public String Tickper="0";
		public String LastDate;
		public String ExtracostperSqcm;
		public String Cities;
		//public String packageName;
		public String notes= "Not Set";
		
		
		public static List<Object[]> getfewdiscount(String nname,String cname) {
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category " +
					"FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Discountprice.Nameofthenewspaper= ?1 and Discountprice.Category= ?2 " +
					"order by Edition Asc");
			q.setParameter(1, nname);
			q.setParameter(2, cname);
			List<Object[]> list = (List<Object[]>)q.getResultList();
			return list;
			
			
		}
		
	
		@Transactional	
		public static List<Object[]> getdiscountednewspaperwise(String cname,String city) {
			
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category  " +
		            "FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Discountprice.Category = ?1 and Edition like ?2 "+
					"order by Edition Asc");
			
			q.setParameter(1, cname);
			q.setParameter(2, "%"+city+"%");
			List<Object[]> list = (List<Object[]>)q.getResultList();
			
			return list;
						
		}
		
		@Transactional	
		public static List<Object[]> getdiscountedcity(String cname,String city,String nname) {
			
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category  " +
		            "FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Discountprice.Category = ?1 and Edition like ?2 "+
					"order by Edition Asc");
			
			q.setParameter(1, cname);
			q.setParameter(2, "%"+city+"%");
			q.setParameter(2, "%"+nname+"%");			
			List<Object[]> list = (List<Object[]>)q.getResultList();
			
			return list;
						
		}
		
		
		public static List<Object[]> getyesUPNull(String cname,String city) {
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category " +
					"FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Edition like ?2 and Discountprice.Category= ?1 or Edition like '%UP%'"+
					"and Discountprice.Category= ?1 " +
					"order by Edition Asc");
			q.setParameter(1, cname);
			q.setParameter(2, "%"+city+"%");
			List<Object[]> list = (List<Object[]>)q.getResultList();
			System.out.println(list.size());
			return list;
					
		}
		
		public static List<Object[]> getyesUPnotNull(String cname,String city, String state) {
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category " +
					"FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Edition like ?2 and Discountprice.Category= ?1 or Edition like '%UP%'"+
					"and Discountprice.Category= ?1 or Edition like ?3  and Discountprice.Category= ?1 "+
					"order by Edition Asc");
			q.setParameter(1, cname);
			q.setParameter(2, "%"+city+"%");
			q.setParameter(3, "%"+state+"%");
			List<Object[]> list = (List<Object[]>)q.getResultList();
			System.out.println(list.size());
			return list;
					
		}
		
		public static List<Object[]> getnoUPNull(String cname,String city,String state) {
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category " +
					"FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Edition like ?2 and Discountprice.Category= ?1 or Edition like ?3 "+
					"and Discountprice.Category= ?1 "+
					"order by Edition Asc");
			q.setParameter(1, cname);
			q.setParameter(2, "%"+city+"%");
			q.setParameter(3, "%"+state+"%");
			List<Object[]> list = (List<Object[]>)q.getResultList();
			System.out.println(list.size());
			return list;
					
		}
		
		
		public static List<Object[]> getnoUPnotNull(String cname,String city,String dstate,String cstate) {
			Query q = JPA.em().createNativeQuery("SELECT Discountprice.Nameofthenewspaper,Edition,Tbasicprice,Ttotalprice,BasicratesperText,Toffpercentage,Category " +
					"FROM Discountprice INNER JOIN Newspaperdetails " +
					"ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper)" +
					"where Edition like ?2 and Discountprice.Category= ?1 or Edition like ?3 "+
					"and Discountprice.Category= ?1 or Edition like ?4 and Discountprice.Category= ?1 "+
					"order by Edition Asc");
			q.setParameter(1, cname);
			q.setParameter(2, "%"+city+"%");
			q.setParameter(3, "%"+dstate+"%");
			q.setParameter(4, "%"+cstate+"%");
			List<Object[]> list = (List<Object[]>)q.getResultList();
			System.out.println(list.size());
			return list;
					
		}
		//Get all package  rate   
		@Transactional
	    public static long getAllPackageRateTotal(String newsPaper,  int rowsPerPage) {
	    	long totalPages = 0, size;
	    	
	    	if(newsPaper.trim().equals("")) {
	    		size = (Long) JPA.em().createQuery("Select count(*) from Discountprice a").getSingleResult();
	    	} else {
	    		Query query = JPA.em().createQuery("Select count(*) from Discountprice a where a.Nameofthenewspaper LIKE ?2");
	    		query.setParameter(2, "%"+newsPaper+"%");
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
		    public static List<Discountprice> getAllPackageRate(String newsPaper, int currentPage, int rowsPerPage, long totalPages) {
		    	int  start=0;
		    	/*Query q;*/
		    	String sql="";
		    	if(newsPaper.trim().equals("")) {
		    		sql = "Select a from Discountprice a";
		    	} else {
		    		sql ="Select a from Discountprice a where a.Nameofthenewspaper LIKE ?1";
		    	}

	    		if(currentPage >= 1 && currentPage <= totalPages) {
					start = (currentPage*rowsPerPage)-rowsPerPage;
				}
				if(currentPage>totalPages && totalPages!=0) {
					currentPage--;
					start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
				}
		    	Query q = JPA.em().createQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
		    	if(!newsPaper.trim().equals("")) {
					q.setParameter(1, "%"+newsPaper+"%");
				}
				
				return (List<Discountprice>)q.getResultList();
				
		    }

		 

		 public static Discountprice findById(String id) {
		    	Query query = JPA.em().createQuery("Select a from Discountprice a where a.Did = ?1");
				query.setParameter(1, id);
		    	return (Discountprice) query.getSingleResult();
		    }
		 
		@Transactional
	    public void save() {
			this.Did = UUID.randomUUID().toString();
	        JPA.em().persist(this);
	        JPA.em().flush();     
	    }

		 @Transactional
		  public void merge() {
			 
		        JPA.em().merge(this);
		  }
		
	
		  @Transactional
		    public void delete() {
		        JPA.em().remove(this);
		    }
		    

		
}
