package viewmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;


import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class Rate {

	
        public String id;
        public String location; //Agra
        public String newspaper; //Time of India
        public String rate; //200
       // public String disRate; // This is for discounted Value
        public String unit; //word
        public String unitVal; //2
        public String extra; //15
        //public String freeUnit; // 20
       
        public String extraFortick;
        public String extraCostpersqcm;
        public String cutOfBookingDate;
        public String extraForBorder;
        public String extraForBackgroud;
       
        
        
        public static Rate byId(String id) {
                        Rate rate = new Rate();
                        rate.id = id;
                        return rate;
        }
       
        public Rate withCityAndNewspaper(String location, String newspaper) {
                        this.newspaper = newspaper;
                        this.location = location;
                        return this;
        }
       
        public Rate withAmountAndFreeUnit(String amount, String unit,String unitVal) {
                        this.unit = unit;
                        this.unitVal=unitVal;
                        this.rate = amount;
                        return this;
        }
       
        public Rate withOverUnit(String extra,String cutOfBookingDate,String extraForBorder,String extraForBackgroud, String extraFortick,String extraCostpersqcm) {
                        this.extra = extra;
                        this.cutOfBookingDate=cutOfBookingDate;
                        this.extraForBorder=extraForBorder;
                        this.extraForBackgroud=extraForBackgroud;
                        this.extraFortick=extraFortick;
                        this.extraCostpersqcm=extraCostpersqcm;
                        return this;
        }
        
        
        public static List<Rate> buildForBasicRate(List<Object[]> resultSet) {
        	List<Rate> rates = new ArrayList<>();
        	
     
        	for(Object[] rs :resultSet) {
        		
        		
        		String str; 
            	str=rs[4].toString();
           	 String number = "";
                String letter = "";
            
                for (int i = 0; i < str.length(); i++) {
                       char a = str.charAt(i);
                       if (Character.isDigit(a)) {
                             number = number + a;

                       } else if (Character.isAlphabetic(a)) {
                             letter = letter + a;

               }
                }
                            		
        		rates.add(Rate.byId(rs[0].toString())
        				.withCityAndNewspaper(rs[1].toString(),rs[2].toString())
        				.withAmountAndFreeUnit(rs[3].toString(),letter,number)
        				.withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()) );
        		        		
        	}
        	
        	return rates;
        }
               
        
        
    public static List<Rate> buildForDiscountedRate(List<Object[]> resultSet) {
        	List<Rate> rates = new ArrayList<>();
        	
        	for(Object[] rs :resultSet) {
        		
        		String str; 
            	str=rs[4].toString();
           	 String number = "";
                String letter = "";
            
                for (int i = 0; i < str.length(); i++) {
                       char a = str.charAt(i);
                       if (Character.isDigit(a)) {
                             number = number + a;

                       } else if (Character.isAlphabetic(a)) {
                             letter = letter + a;
                        }
                }
                      		
        		rates.add(Rate.byId(rs[0].toString()).withCityAndNewspaper(rs[1].toString(),rs[2].toString()).withAmountAndFreeUnit(rs[3].toString(),letter,number).withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()));
        		
        	}
        	
        	return rates;
        }
    
    
    public static List<Rate> buildForBasicRateByNewspaper(List<Object[]> resultSet) {
    	List<Rate> rates = new ArrayList<>();
    	
    	for(Object[] rs :resultSet) {
    		
    		String str; 
        	str=rs[4].toString();
       	 String number = "";
            String letter = "";
        
            for (int i = 0; i < str.length(); i++) {
                   char a = str.charAt(i);
                   if (Character.isDigit(a)) {
                         number = number + a;

                   } else if (Character.isAlphabetic(a)) {
                         letter = letter + a;
                    }
            }
         	
    		rates.add(Rate.byId(rs[0].toString()).withCityAndNewspaper(rs[1].toString(),rs[2].toString()).withAmountAndFreeUnit(rs[3].toString(),letter,number).withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()));
    		
    	}
    	
    	return rates;
    }
    
    
    public static List<Rate> buildForBasicRateByLocation(List<Object[]> resultSet) {
    	List<Rate> rates = new ArrayList<>();
    	
    	for(Object[] rs :resultSet) {
    		
    		String str; 
        	str=rs[4].toString();
       	 String number = "";
            String letter = "";
        
            for (int i = 0; i < str.length(); i++) {
                   char a = str.charAt(i);
                   if (Character.isDigit(a)) {
                         number = number + a;

                   } else if (Character.isAlphabetic(a)) {
                         letter = letter + a;
                    }
            }
         	
    		rates.add(Rate.byId(rs[0].toString()).withCityAndNewspaper(rs[1].toString(),rs[2].toString()).withAmountAndFreeUnit(rs[3].toString(),letter,number).withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()));
    		
    	}
    	
    	return rates;
    }
    
    public static List<Rate> buildForgetBasicRateByCategory(List<Object[]> resultSet) {
    	List<Rate> rates = new ArrayList<>();
    	
    	for(Object[] rs :resultSet) {
    		
    		String str; 
        	str=rs[4].toString();
       	 String number = "";
            String letter = "";
        
            for (int i = 0; i < str.length(); i++) {
                   char a = str.charAt(i);
                   if (Character.isDigit(a)) {
                         number = number + a;

                   } else if (Character.isAlphabetic(a)) {
                         letter = letter + a;
                    }
            }
         	
    		rates.add(Rate.byId(rs[0].toString()).withCityAndNewspaper(rs[1].toString(),rs[2].toString()).withAmountAndFreeUnit(rs[3].toString(),letter,number).withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()));
    		
    	}
    	
    	return rates;
    }
    
    public static List<Rate> buildForgetBasicRateByNewspaperAndCategory(List<Object[]> resultSet) {
    	List<Rate> rates = new ArrayList<>();
    	
    	for(Object[] rs :resultSet) {
    		
    		String str; 
        	str=rs[4].toString();
       	 String number = "";
            String letter = "";
        
            for (int i = 0; i < str.length(); i++) {
                   char a = str.charAt(i);
                   if (Character.isDigit(a)) {
                         number = number + a;

                   } else if (Character.isAlphabetic(a)) {
                         letter = letter + a;
                    }
            }
         	
    		rates.add(Rate.byId(rs[0].toString()).withCityAndNewspaper(rs[1].toString(),rs[2].toString()).withAmountAndFreeUnit(rs[3].toString(),letter,number).withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()));
    		
    	}
    	
    	return rates;
    }
    
    public static List<Rate> buildForgetBasicRateByLocationAndCategory(List<Object[]> resultSet) {
    	List<Rate> rates = new ArrayList<>();
    	
    	for(Object[] rs :resultSet) {
    		
    		String str; 
        	str=rs[4].toString();
       	 String number = "";
            String letter = "";
        
            for (int i = 0; i < str.length(); i++) {
                   char a = str.charAt(i);
                   if (Character.isDigit(a)) {
                         number = number + a;

                   } else if (Character.isAlphabetic(a)) {
                         letter = letter + a;
                    }
            }
         	
    		rates.add(Rate.byId(rs[0].toString()).withCityAndNewspaper(rs[1].toString(),rs[2].toString()).withAmountAndFreeUnit(rs[3].toString(),letter,number).withOverUnit(rs[5].toString(), rs[6].toString(), rs[7].toString(),rs[8].toString(),rs[9].toString(),rs[10].toString()));
    		
    	}
    	
    	return rates;
    }
    
}
          
                         
                               
                               
   
    
