package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class DisplayAdDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
    public String adcategory;
    public String newspaper;
    public String releasedate;
    public String expectedsize;
    public String budget;
    public String addmatter;
    @Required
    public String specialinstruction;
    @Required
    public String name;
    @Required
    public String mobilenum;
    public String telephonenum;
    public String docfile;
    @Required
    public String email;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdcategory() {
		return adcategory;
	}
	public void setAdcategory(String adcategory) {
		this.adcategory = adcategory;
	}
	public String getNewspaper() {
		return newspaper;
	}
	public void setNewspaper(String newspaper) {
		this.newspaper = newspaper;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	
	public String getAddmatter() {
		return addmatter;
	}
	public void setAddmatter(String addmatter) {
		this.addmatter = addmatter;
	}
	public String getExpectedsize() {
		return expectedsize;
	}
	public void setExpectedsize(String expectedsize) {
		this.expectedsize = expectedsize;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getSpecialinstruction() {
		return specialinstruction;
	}
	public void setSpecialinstruction(String specialinstruction) {
		this.specialinstruction = specialinstruction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getTelephonenum() {
		return telephonenum;
	}
	public void setTelephonenum(String telephonenum) {
		this.telephonenum = telephonenum;
	}
	public String getDocfile() {
		return docfile;
	}
	public void setDocfile(String docfile) {
		this.docfile = docfile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
