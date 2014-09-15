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
public class Adcategory {

	public Adcategory() {}
	
	@Id
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
		
	@Transactional
    public void save() {
		this.CID = UUID.randomUUID().toString();
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
