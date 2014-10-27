package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.JPA;

@Entity
public class CCConfig {

	@Id
	public Long id;
	public String Merchant_Id = "M_raj28780_28780"; 
	public String WorkingKey = "3vrz1tf22sk3qcgh4gjvijd1fuqdup0f";   
	public String accessCode = "FAZ76VPSCBFSUREG";
	public boolean ccOld = true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMerchant_Id() {
		return Merchant_Id;
	}
	public void setMerchant_Id(String merchant_Id) {
		Merchant_Id = merchant_Id;
	}
	public String getWorkingKey() {
		return WorkingKey;
	}
	public void setWorkingKey(String workingKey) {
		WorkingKey = workingKey;
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public boolean isCcOld() {
		return ccOld;
	}
	public void setCcOld(boolean ccOld) {
		this.ccOld = ccOld;
	}
	
	public static CCConfig byId(long i) {
		return JPA.em().createQuery("from CCConfig where id = ?1",CCConfig.class)
					.setParameter(1, i).getSingleResult();
			
		
	}
}
