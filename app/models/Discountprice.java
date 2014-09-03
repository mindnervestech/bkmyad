package models;

import java.util.ArrayList;
import java.util.List;

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
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
		public String Border;
		public String Backcolor;
		public String SpecialDiscount;
		public String Tick;
		public String Category;
		public String Extraborderper;
		public String Extrabgper;
		public String Tickper;
		public String LastDate;
		public String ExtracostperSqcm;
		
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
		
}
