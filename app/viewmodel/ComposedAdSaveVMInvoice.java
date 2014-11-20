package viewmodel;

import models.ComposedAdSave;
import models.Order;

public class ComposedAdSaveVMInvoice {
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
	   
	   public float extraCost;
	   
	   public ComposedAdSaveVMInvoice(ComposedAdSave composedAdSave) {
	    	this.OrderID=composedAdSave.OrderID;
	    	this.orderDate=composedAdSave.orderDate;
	    	this.userEmailId=composedAdSave.userEmailId;
	    	this.Adtext=composedAdSave.Adtext;
	    	this.Nameofthenewspaper=composedAdSave.Nameofthenewspaper;
	    	this.TotalCost=composedAdSave.TotalCost;
	    	this.Bgcolor = composedAdSave.Bgcolor;
	    	this.Border = composedAdSave.Border;
	    	this.PublishDate = composedAdSave.PublishDate;
	    	this.numberOfWords = composedAdSave.numberOfWords;
	    	this.paymentOption = composedAdSave.paymentOption;
	    	this.Tick = composedAdSave.Tick;
	    	this.Category = composedAdSave.Category;
	    	this.City = composedAdSave.City;
	    	this.Subcategory = composedAdSave.Subcategory;
	    	
	    	this.totalExtraCost = composedAdSave.totalExtraCost;
	    	this.totalUnitCost  = composedAdSave.totalUnitCost;
	    	 
	    	this.numberOfWords = composedAdSave.numberOfWords;
	    	this.extraCost = composedAdSave.extraCost;
	    	System.out.println("this.Subcategory"+this.Subcategory);
	    	System.out.println("this.paymentOption"+this.paymentOption);
	    	
	    	
	    }

	public float getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(float extraCost) {
		this.extraCost = extraCost;
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

	public String getAdtext() {
		return Adtext;
	}

	public void setAdtext(String adtext) {
		Adtext = adtext;
	}

	public String getTick() {
		return Tick;
	}

	public void setTick(String tick) {
		Tick = tick;
	}

	public String getBgcolor() {
		return Bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		Bgcolor = bgcolor;
	}

	public String getBorder() {
		return Border;
	}

	public void setBorder(String border) {
		Border = border;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public float getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(float totalCost) {
		TotalCost = totalCost;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		
		Category = category;
	}

	public String getSubcategory() {
		return Subcategory;
	}

	public void setSubcategory(String subcategory) {
		Subcategory = subcategory;
	}
	
	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalExtraCost() {
		return totalExtraCost;
	}
	
	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
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

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	  
}
