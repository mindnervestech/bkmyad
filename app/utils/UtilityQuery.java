package utils;

import java.util.List;

import javax.persistence.Query;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;


public class UtilityQuery {
	private static final String QUERY2 = "SELECT BasicRateID,"
			+ "City,"
			+ "Basicrate.Nameofthenewspaper,"
			+ "Textaddrate,"
			+ "BasicratesperText,"
			+ "Exstracostperline,"
			+ "Beforebookingdate,"
			+ "Border,"
			+ "Backcolor,"
			+ "Tick,"
			+ "ExtracostperSqcm,"
			+ "Extraborderper,"
			+ "Extrabgper,"
			+ "Tickper, "
			+ "freewords, "
			+ "Allow ";
	private static final String QUERY1 = "SELECT BasicRateID,"
			+ "City,"
			+ "Newspaperdetails.Nameofthenewspaper,"
			+ "Textaddrate,"
			+ "BasicratesperText,"
			+ "Exstracostperline,"
			+ "Beforebookingdate,"
			+ "Border,"
			+ "Backcolor,"
			+ "Tick,"
			+ "ExtracostperSqcm,"
			+ "Extraborderper,"
			+ "Extrabgper,"
			+ "Tickper,"
			+ "freewords,"
			+ "Allow ";
		
	@Transactional	
	public static List<Object[]> getBasicRates(String city,String newspaper,String Category) {
          Query q = JPA.em().createNativeQuery(QUERY1 +
			" FROM Basicrate INNER JOIN Newspaperdetails ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
			"where Basicrate.City= ?1 and Basicrate.Nameofthenewspaper= ?2 and Basicrate.Category= ?3 ");
         q.setParameter(1, city);
         q.setParameter(2, newspaper);
         q.setParameter(3, Category);
         List<Object[]> list = (List<Object[]>)q.getResultList();
         return list;
	}
     
	@Transactional	
     public static List<Object[]> getDiscountedRates(String city,String newspaper,String Category) {
      	
           Query q = JPA.em().createNativeQuery("SELECT Did,Edition,Newspaperdetails.Nameofthenewspaper,Dtotalprice,BasicratesperText,Exstracostperline,Beforebookingdate,Border,Backcolor,Tick,ExtracostperSqcm " +
			" FROM discountprice INNER JOIN Newspaperdetails ON (discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
			"where Edition like ?1 and discountprice.Nameofthenewspaper= ?2 and discountprice.Category= ?3");
	
          q.setParameter(1, city);
          q.setParameter(2, newspaper);
          q.setParameter(3, Category);
          List<Object[]> list = (List<Object[]>)q.getResultList();
	
          return list;
	
     }
     
     @Transactional	
     public static List<Object[]> getBasicRateByNewspaper(String newspaper) {
       	
    	  Query q = JPA.em().createNativeQuery(QUERY1 +
    				" FROM Basicrate INNER JOIN Newspaperdetails ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
    				"where Basicrate.Nameofthenewspaper= ?1");
    	         
    	         q.setParameter(1, newspaper);
    	         
    	         List<Object[]> list = (List<Object[]>)q.getResultList();
    	         return list;
	
   }
     @Transactional	
     public static List<Object[]> getBasicRateByLocation(String city) {
        	
   	  Query q = JPA.em().createNativeQuery(QUERY1 +
   				" FROM Basicrate INNER JOIN Newspaperdetails ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
   				"where Basicrate.City= ?1");
   	         q.setParameter(1, city);
   	         List<Object[]> list = (List<Object[]>)q.getResultList();
   	         return list;
  }
     
     public static List<Object[]> getBasicRateByCategory(String Category) {
     	
      	  Query q = JPA.em().createNativeQuery(QUERY1 +
      				" FROM Basicrate INNER JOIN Newspaperdetails ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
      				"where Basicrate.Category= ?1");
      	  			q.setParameter(1, Category);
      	  			List<Object[]> list = (List<Object[]>)q.getResultList();
      	  			return list;
     }
     
     public static List<Object[]> getBasicRateByNewspaperAndCategory(String newspaper,String Category) {
      	
     	  Query q = JPA.em().createNativeQuery(QUERY1 +
     				" FROM Basicrate INNER JOIN Newspaperdetails ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
     				" where Basicrate.Nameofthenewspaper= ?1 and Basicrate.Category= ?2 and Basicrate.Textaddrate > 0");
     	         q.setParameter(1, newspaper);
     	         q.setParameter(2, Category);
     	         List<Object[]> list = (List<Object[]>)q.getResultList();
     	         return list;
    }
     
     public static List<Object[]>  getDiscountRateByNewspaperAndCategory (String newspaper,String Category) {
    	 
    	  Query q = JPA.em().createNativeQuery("SELECT Did,Edition,Newspaperdetails.Nameofthenewspaper,Dtotalprice,BasicratesperText,Exstracostperline,Border,Backcolor,SpecialDiscount,Tick,ExtracostperSqcm,Extrabgper,Extraborderper,Tickper,freewords,Allow  " +
     				" FROM Discountprice INNER JOIN Newspaperdetails ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
     			" where Discountprice.Nameofthenewspaper= ?1 and Discountprice.Category= ?2 and Discountprice.Dtotalprice > 0 ");
   	                   q.setParameter(1, newspaper);
   	                   q.setParameter(2, Category);
   	                  List<Object[]> listDiscount = (List<Object[]>)q.getResultList();
   	          return listDiscount;
	
  }
     
     public static List<Object[]> getBasicRateByLocationAndCategory(String city,String Category) {
    	  Query q = JPA.em().createNativeQuery(QUERY2 +
    				" FROM Basicrate INNER JOIN Newspaperdetails ON (Basicrate.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
    				" where Basicrate.City= ?1 and Basicrate.Category= ?2 and Basicrate.Textaddrate > 0");
    	         q.setParameter(1, city);
    	         q.setParameter(2, Category);
    	         List<Object[]> list = (List<Object[]>)q.getResultList();
    	         return list;
   }
     public static List<Object[]> getDiscountRateByLocationAndCategory(String city,String Category) {
       
   	  Query q = JPA.em().createNativeQuery("SELECT Did,Edition,Newspaperdetails.Nameofthenewspaper,Dtotalprice,BasicratesperText,Exstracostperline,Border,Backcolor,SpecialDiscount,Tick,ExtracostperSqcm,Extrabgper,Extraborderper,Tickper ,freewords,Allow" +
     				" FROM Discountprice INNER JOIN Newspaperdetails ON (Discountprice.Nameofthenewspaper=Newspaperdetails.Nameofthenewspaper) " +
     			    " where Discountprice.Cities like ?1 and Discountprice.Category = ?2 and  Discountprice.Dtotalprice > 0");
   
   	         q.setParameter(1, "%"+city+"%");
   	         q.setParameter(2, Category);
   	         List<Object[]> list = (List<Object[]>)q.getResultList();
   	         return list;
	
  }
     public static List<Object[]>  getDetailsByOrderId(String orderIdPer) {
		Query q = JPA
				.em()
				.createQuery(
						"SELECT OID,OrderID,Nameofthenewspaper,City,Adtext,TickRate,Bgcolor,BgcolorRate,Border,BorderCost,PublishDate,BasicRate,TotalCost,Category,numberOfWords,orderDate,freeunit,extra,totalExtraCost,totalUnitCost,noOfImpression,rate,bgColorSelect,Tick,adbookedId,Extraborderper,Extrabgper,Tickper,Subcategory,numberOfWords,footerDescption,headerDescption,bodyDescription,footerColor,bodyColor,headerColor,adType,colorAd,imageAd,adSizeSelect,adSelectedType,otherWidth,height,originalFileName,freewords  FROM ComposedAdSave  where OrderId = ?1");
		q.setParameter(1, orderIdPer);
     	        
     	         List<Object[]> list = (List<Object[]>)q.getResultList();
     	         return list;
  	
    }  
}
