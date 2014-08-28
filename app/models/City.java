package models;

import java.util.List;

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
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public String CID;
	public String Statename;
	public String Cityname;
	

	@Transactional
	public static List<City> getallcity(String statename)
	{
		Query q=JPA.em().createQuery("Select a from City a where a.Statename=?1");
		q.setParameter(1, statename);
		return (List<City>)q.getResultList();
	}

		
	
	@Transactional	
	public static List<Adsubcategory> getAllnewspaper(String cname) {
		Query q = JPA.em().createQuery("Select a from Adsubcategory a where a.cname = ?1");
		q.setParameter(1, cname);
		return (List<Adsubcategory>)q.getResultList();
	}
	
}
