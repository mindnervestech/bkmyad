package viewmodel;

public class ResultVM {

	public ResultVM(){}
	
	public ResultVM(Object[] vm) {
		this.BasicRateID = (String)vm[0];
		this.City = (String)vm[1];
		this.Textaddrate = (String)vm[2];
		this.clasifiedadrate = (String)vm[3];
		this.BasicratesperText = (String)vm[4];
		this.BasicratesperClasified = (String)vm[5];
		this.Category = (String)vm[6];
	}
	
	
	public String BasicRateID;
	public String City;
	public String Textaddrate;
	public String clasifiedadrate;
	public String BasicratesperText;
	public String BasicratesperClasified;
	public String Category;
	
	
}
