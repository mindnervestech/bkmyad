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
public class Newspaperdetails {

	public Newspaperdetails() {}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public String NewsId;
	public String Nameofthenewspaper;
	public String LogoFileExtention;
	public String LogoName;
	public String Addedition;
	public String Nameofcities;
	public String BasicratesperText;
	public String BasicratesperClasified;
	public String Beforebookingdate;
	public String Allow;
	
	@Transactional	
	public static List<Newspaperdetails> getAllnewspaper() {
		Query q = JPA.em().createQuery("Select a.Nameofthenewspaper from Newspaperdetails a order by Nameofthenewspaper Asc");
		return (List<Newspaperdetails>)q.getResultList();
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

	
	
		
}
