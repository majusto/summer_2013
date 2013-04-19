public class Bank{
	public String bankname1; 
	public String description1;
	public String branch1;
	public String bankadd1;
	public Bank nextBank;
	public Bank(String bankname, String description, String branch, String bankadd)
	{
		bankname1 = bankname;
		description1 = description;
		branch1 = branch;
		bankadd1 = bankadd;
	}	
}