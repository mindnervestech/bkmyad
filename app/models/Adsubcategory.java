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
public class Adsubcategory {

	public Adsubcategory() {}
	
	@Id 
	public String CSID;
	
	public String cname;
	
	public String Sucategory;
		
	@Transactional	
	public static List<Adsubcategory> getSubcategotBy(String cname) {
		Query q = JPA.em().createQuery("Select a from Adsubcategory a where a.cname = ?1");
		q.setParameter(1, cname);
		return (List<Adsubcategory>)q.getResultList();
	}
		
}
