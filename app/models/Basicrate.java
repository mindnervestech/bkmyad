package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import viewmodel.ResultVM;
import viewmodel.NewspaperVM;


@Entity
public class Basicrate {

	public Basicrate() {}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
		
		
	
		
}
