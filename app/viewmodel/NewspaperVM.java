package viewmodel;

public class NewspaperVM {

	public NewspaperVM(){}
	
	public NewspaperVM(Object[] vm) {
		
		this.BasicRateID = (String)vm[0];
		this.Nameofthenewspaper =(String)vm[1]; 
		this.City = (String)vm[2];
		this.Textaddrate = (String)vm[3];
		this.clasifiedadrate = (String)vm[4];
		this.BasicratesperText = (String)vm[5];
		this.BasicratesperClasified = (String)vm[6];
		this.Category = (String)vm[7];
	}
	
	
	public String BasicRateID;
	public String Nameofthenewspaper;
	public String City;
	public String Textaddrate;
	public String clasifiedadrate;
	public String BasicratesperText;
	public String BasicratesperClasified;
	public String Category;
	
	
}
