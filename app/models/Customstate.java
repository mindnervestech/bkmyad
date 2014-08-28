package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;


@Entity
public class Customstate {

	public Customstate() {}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public String Csid;
	public String State;
	public String CState;
	public String CCity;
	public Date LastUpDate;
	
	
	@Transactional	
	public static List<Customstate> getcstate(String state,String city) {
		Query q = JPA.em().createQuery("Select a from Customstate a where State = ?1 and CCity like ?2");
		q.setParameter(1, state);
		q.setParameter(2, "%"+city+"%");
		return (List<Customstate>)q.getResultList();
	}
	
	
}
