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
public class State {

	public State() {}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	
	
	

	
	
		
}
