package viewmodel;

public class DiscountpriceVM {

	public DiscountpriceVM(){}
	
	public DiscountpriceVM(Object[] vm) {
		
		this.Nameofthenewspaper =(String)vm[0]; 
		this.Edition = (String)vm[1];
		this.Tbasicprice = (String)vm[2];
		this.Ttotalprice = (String)vm[3];
		this.BasicratesperText = (String)vm[4];
		this.Toffpercentage = (String)vm[5];
		this.Category = (String)vm[6];
	}
	
	
	public String Nameofthenewspaper;
	public String Edition;
	public String Tbasicprice;
	public String Ttotalprice;
	public String BasicratesperText;
	public String Toffpercentage;
	public String Category;
	
	
	
}
