package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	   public String TickRate;
	   public String Bgcolor;
	   public String BgcolorRate;
	   public String Border;
	   public String BorderCost;
	   public String Noofads;
	   public String  PublishDate;
	   public String BasicRate;
	   public String TotalCost;
	   public String Guid;
	   public String Extraborderper;
	   public String Extrabgper;
	   public String Tickper;
	 
	   
	   public ComposedAdSave() {
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
	public String getTickRate() {
		return TickRate;
	}
	public void setTickRate(String tickRate) {
		TickRate = tickRate;
	}
	public String getBgcolor() {
		return Bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		Bgcolor = bgcolor;
	}
	public String getBgcolorRate() {
		return BgcolorRate;
	}
	public void setBgcolorRate(String bgcolorRate) {
		BgcolorRate = bgcolorRate;
	}
	public String getBorder() {
		return Border;
	}
	public void setBorder(String border) {
		Border = border;
	}
	public String getBorderCost() {
		return BorderCost;
	}
	public void setBorderCost(String borderCost) {
		BorderCost = borderCost;
	}
	public String getNoofads() {
		return Noofads;
	}
	public void setNoofads(String noofads) {
		Noofads = noofads;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getBasicRate() {
		return BasicRate;
	}
	public void setBasicRate(String basicRate) {
		BasicRate = basicRate;
	}
	public String getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(String totalCost) {
		TotalCost = totalCost;
	}
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
	public String Offer;
	   public String Enhancement;
	 
}
  