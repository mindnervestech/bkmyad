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
public class ComposedAdSave{

	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   public Long OID;
	   public String IpAddress;
	   public String  OrderID;
	   public String Nameofthenewspaper;
	   public String City;
	   public String Adtext;
	   public String TotalNoofline;
	   public String Linecost;
	   public String Tick;
	   public float TickRate;
	   public String Bgcolor;
	   public float BgcolorRate;
	   public String Border;
	   public float BorderCost;
       public String Noofads;
	   public String PublishDate;
	   public String BasicRate;
	   public float TotalCost;
	   public String Guid;
	   public String Extraborderper;
	   public String Extrabgper;
	   public String Tickper;
	   public String  Category;
	   public String  Subcategory;
	   public int numberOfWords;
	   public String paymentOption;
	   public String userEmailId;
	   public String Offer;
	   public String Enhancement;
	   public String orderDate;
	   public String freeunit;
	   public float extra;
	   public float totalExtraCost;
	   public float totalUnitCost;
	   public int noOfImpression;
	   public float rate;
	   public String bgColorSelect; 
	   public String  adbookedId;
	   public String packageType ="";
	   
	   public String footerDescption = "not set";
	   public String headerDescption= "not set";
	   public String bodyDescription= "not set"; 
	   public String footerColor= "not set";
	   public String bodyColor= "not set ";
	   public String headerColor= "not set";  
	   public String adType= "not set ";
	   //public String widthSelected;
	   
	   public String   colorAd= "not set";
	   public String BWAd= "not set";
	   public String imageAd= "not set";
	   public String adSizeSelect= "not set";
	   public String adSelectedType = "textClasified".trim(); 
	   public float extraCost = 0;
	   //hegight and width in cm;
	   public String otherWidth = "1";
	   public String height = "1";
	   public String originalFileName = "Image not Uploaded";
	   //used to define  number of words free for each paper 
	   public String freewords = "22";
	  
	   public String getAdbookedId() {
		return adbookedId;
	}

	public void setAdbookedId(String adbookedId) {
		this.adbookedId = adbookedId;
	}

	public String getBgColorSelect() {
		return bgColorSelect;
	}

	public void setBgColorSelect(String bgColorSelect) {
		this.bgColorSelect = bgColorSelect;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getNoOfImpression() {
		return noOfImpression;
	}

	public void setNoOfImpression(int noOfImpression) {
		this.noOfImpression = noOfImpression;
	}

	public ComposedAdSave() {
	    }  
	   
	   public float getTotalExtraCost() {
		return totalExtraCost;
	}

	public void setTotalExtraCost(float totalExtraCost) {
		this.totalExtraCost = totalExtraCost;
	}

	public float getTotalUnitCost() {
		return totalUnitCost;
	}

	public void setTotalUnitCost(float totalUnitCost) {
		this.totalUnitCost = totalUnitCost;
	}

	
     public Long getOID() {
		return OID;
	   }
	   
	public void setOID(Long oID) {
		OID = oID;
	}
	public String getIpAddress() {
		return IpAddress;
	}
	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getNameofthenewspaper() {
		return Nameofthenewspaper;
	}
	public void setNameofthenewspaper(String nameofthenewspaper) {
		Nameofthenewspaper = nameofthenewspaper;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getAdtext() {
		return Adtext;
	}
	public void setAdtext(String adtext) {
		Adtext = adtext;
	}
	public String getTotalNoofline() {
		return TotalNoofline;
	}
	public void setTotalNoofline(String totalNoofline) {
		TotalNoofline = totalNoofline;
	}
	public String getLinecost() {
		return Linecost;
	}
	public void setLinecost(String linecost) {
		Linecost = linecost;
	}
	public String getTick() {
		return Tick;
	}
	public void setTick(String tick) {
		Tick = tick;
	}
	/* public float getTickRate() {
			return TickRate;
		}

		public void setTickRate(float tickRate) {
			TickRate = tickRate;
		}*/

	public String getBgcolor() {
		return Bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		Bgcolor = bgcolor;
	}
	/*public String getBgcolorRate() {
		return BgcolorRate;
	}
	public void setBgcolorRate(String bgcolorRate) {
		BgcolorRate = bgcolorRate;
	}*/
	public String getBorder() {
		return Border;
	}
	public void setBorder(String border) {
		Border = border;
	}
	/*public String getBorderCost() {
		return BorderCost;
	}
	public void setBorderCost(String borderCost) {
		BorderCost = borderCost;
	}
	public String getNoofads() {
		return Noofads;
	}*/
	public void setNoofads(String noofads) {
		Noofads = noofads;
	}
	/*public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}*/
	public String getBasicRate() {
		return BasicRate;
	}
	public void setBasicRate(String basicRate) {
		BasicRate = basicRate;
	}
	/*public String getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(String totalCost) {
		TotalCost = totalCost;
	}*/
	public String getGuid() {
		return Guid;
	}
	public void setGuid(String guid) {
		Guid = guid;
	}
	public String getExtraborderper() {
		return Extraborderper;
	}
	public void setExtraborderper(String extraborderper) {
		Extraborderper = extraborderper;
	}
	public String getExtrabgper() {
		return Extrabgper;
	}
	public void setExtrabgper(String extrabgper) {
		Extrabgper = extrabgper;
	}
	public String getTickper() {
		return Tickper;
	}
	public void setTickper(String tickper) {
		Tickper = tickper;
	}
	public String getOffer() {
		return Offer;
	}
	public void setOffer(String offer) {
		Offer = offer;
	}
	public String getEnhancement() {
		return Enhancement;
	}
	public void setEnhancement(String enhancement) {
		Enhancement = enhancement;
	}
	
	/*@Transactional	
	public static List<ComposedAdSave> getAllorderOfUser() {
	 String    cname="asd@gmail.com";
		Query q = JPA.em().createQuery("Select a from ComposedAdSave a where a.userEmailId = ?1");
		q.setParameter(1, cname);
		System.out.println("In get all Order db controler method:"+q.getResultList());
		return (List<ComposedAdSave>)q.getResultList();
	}*/
	
	    @Transactional
	    public static List<ComposedAdSave> getAllOrderList(String UserId) {
	    Query q = JPA.em().createQuery("Select a from ComposedAdSave a where a.userEmailId = ?1");
	    q.setParameter(1, UserId);
	    return (List<ComposedAdSave>)q.getResultList();
	    }

	    public static ComposedAdSave findById(Long id) {
	    	Query query = JPA.em().createQuery("Select a from ComposedAdSave a where a.OID = ?1");
			query.setParameter(1, id);
	    	return (ComposedAdSave) query.getSingleResult();
	    }
	    
		@Transactional	
		public static List<ComposedAdSave> getInvoiceOrderDetails(String orderId) {
			//String or="4f4a286a-962f-4271-8884-d41933962e9b";
			Query q = JPA.em().createQuery("Select a from ComposedAdSave a where a.OrderID = ?1");
			q.setParameter(1, orderId);
			return (List<ComposedAdSave>)q.getResultList();
		}
	    
}
  