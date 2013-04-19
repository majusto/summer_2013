public class Info{
	public int number1;
	public String name1; 
	public String address1;
	public String birthday1;
	public int deposit1;
	public Info nextInfo;
	public Bank banknameInfo1;
	public Info(int number, String name, String address, String birthday, int deposit2, Bank banknameInfo)
	{
		number1 = number;
		name1 = name;
		address1 = address;
		birthday1 = birthday;
		deposit1 = deposit2;
		banknameInfo1 = banknameInfo;
	}	
}
