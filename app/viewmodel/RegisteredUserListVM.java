package viewmodel;



public class RegisteredUserListVM {
	
	
	public String  name;
	public String mobileNum;
	public String email;
	
	   public RegisteredUserListVM(Object[] registeredUserListVM) {
		   this.name =(String)registeredUserListVM[1];
		   this.email =(String)registeredUserListVM[3];
		   this.mobileNum = (String)registeredUserListVM[2];
		   
	   }
}
