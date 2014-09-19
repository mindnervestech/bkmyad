package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.jpa.JPA;

@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@Column(length=50)
	public String orderId;
	
	public float total;
	
	public String email;
	
	//@Cascade(value={CascadeType.ALL})
	@OneToMany(cascade={CascadeType.ALL})
	public List<ComposedAdSave> composedAd;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ComposedAdSave> getComposedAd() {
		return composedAd;
	}

	public void setComposedAd(List<ComposedAdSave> composedAd) {
		this.composedAd = composedAd;
	}
	
	public static Order byId(String orderId) {
		return JPA.em().createQuery("from Order where orderId = :orderId",Order.class)
				.setParameter("orderId", orderId).getSingleResult();
		
	}

}
