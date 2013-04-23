public class Info{
	public int number1;
	public String lastname1;
	public String givenname1;
	public String middlename1;
	public String address1;
	public String birthday1;
	public int deposit1;
	public Info nextInfo;
	public Bank banknameInfo1;
	public Info(int number, String lastname, String givenname, String middlename, String address, String birthday, int deposit2, Bank banknameInfo)
	{
		number1 = number;
		lastname1 = lastname;
		givenname1 = givenname;
		middlename1 = middlename;
		address1 = address;
		birthday1 = birthday;
		deposit1 = deposit2;
		banknameInfo1 = banknameInfo;
	}	
}
