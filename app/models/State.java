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
public class State {

	public State() {}
	
	@Id
	public String SID;
	public String Statename;
	
		
	@Transactional
	public static List<State> getallstate()
	{
		Query q=JPA.em().createQuery("Select a.Statename from State a");
		return (List<State>)q.getResultList();
	}
	
	@Transactional
	public static List<String> getallstateString()
	{
		Query q=JPA.em().createQuery("Select a.Statename from State a");
		return (List<String>)q.getResultList();
	}
	
	@Transactional
    public void save() {
		this.SID = UUID.randomUUID().toString();
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
