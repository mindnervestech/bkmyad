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
public class Adcategory {

	public Adcategory() {}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public String CID;
	
	public String cname;
		
	@Transactional	
	public static List<Adcategory> getAllArticles() {
		Query q = JPA.em().createQuery("Select a.cname from Adcategory a order by cname Asc");
		return (List<Adcategory>)q.getResultList();
	}

	@Transactional	
	public static List<String> getAllArticlesString() {
		Query q = JPA.em().createQuery("Select a.cname from Adcategory a order by cname Asc");
		return (List<String>)q.getResultList();
	}
	
	
	
	@Transactional	
	public static List<String> getArticleName() {
		Query q = JPA.em().createQuery("Select a.cname from Adcategory a order by cname Asc");
		return (List<String>)q.getResultList();
	}
		
}
