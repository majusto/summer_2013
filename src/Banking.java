import javax.swing.*;
public class Banking {
	public static void main(String args[])
	{	
		List vList = new List();
		ListBank vBank  = new ListBank();
		Bank bank = null, mark;
		String bankname = null, description = null, branch = null, bankadd = null;
		int q = 0, choose= 0;
		do{
			
		try{
		int w = 0;
		for(Info marker = vList.firstNode; marker!=null; marker = marker.nextInfo)
			w++;
		choose = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Choose Process \n1. Add Bank \n2. Add Account \n3. Deposit \n4. Withdraw \n5.Print Account \nNo. of Accounts: " +w, "Transaction",JOptionPane.OK_CANCEL_OPTION));
		//BANK ================================================================================================================================
		if(choose == 1){
			
			int bankaccount = 0, bankaccount2 = 0, bankaccount3 = 0, bankaccount4 = 0;
			do{
			bankname = JOptionPane.showInputDialog("Name of the Bank");
			if(bankname.isEmpty() || bankname.equals(" "))
					JOptionPane.showMessageDialog(null, "Error");
			else
				bankaccount++;
			}while(bankaccount == 0);
			do{
			description = JOptionPane.showInputDialog("Description of the Bank");
			if(description.isEmpty() || description.equals(" "))
				JOptionPane.showMessageDialog(null, "Error");
			else
				bankaccount2++;
			}while(bankaccount2 == 0);
			do{
			branch = JOptionPane.showInputDialog("From Which Branch?");
			if(branch.isEmpty() || branch.equals(" "))
				JOptionPane.showMessageDialog(null, "Error");
			
			else
			{
				bankaccount3++;
			}
			}while(bankaccount3 == 0);
			do{
			bankadd = JOptionPane.showInputDialog("Address of the Bank");
			if(bankadd.isEmpty() || bankadd.equals(" "))
				JOptionPane.showMessageDialog(null, "Error");
			else
				{
				bankaccount4++;
				}
			}while(bankaccount4 == 0);
			Bank bankvariable = new Bank(bankname, description, branch, bankadd);
			if(vBank.firstBank==null)
			{
				vBank.firstBank = vBank.lastBank = bankvariable;
				vBank.lastBank.nextBank = null;
			}
			else if(vBank.firstBank == vBank.lastBank)
			{
				/*for(Bank marker4 = vBank.firstBank; marker4!=null; marker4 = marker4.nextBank)
					if((bankname == marker4.bankname1)&& (description == marker4.description1) && (branch == marker4.branch1) && (bankadd == marker4.bankadd1))
						JOptionPane.showMessageDialog(null, "Bank already exist");			
					else
						{*/
						vBank.lastBank = vBank.firstBank.nextBank = bankvariable;
						vBank.lastBank.nextBank = null;
			}
			else
			{
				vBank.lastBank.nextBank = bankvariable;
				vBank.lastBank = bankvariable;
				vBank.lastBank.nextBank = null;
			}
			JOptionPane.showMessageDialog(null, "Bank Name: "+bankname+"\nBank Description: "+description+"\nBranch: "+branch+"\nBank Address: "+bankadd, "Bank Information", JOptionPane.OK_OPTION);
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}//END BANKS
		
		//ACOUNTS ================================================================================================================================
		if(choose == 2)
		{	
			int m = 0, bankaccount = 0, bankaccount2 = 0, bankaccount3 = 0, bankaccount4 = 0;
			if(vBank.firstBank == null)
				JOptionPane.showMessageDialog(null, "List of Banks is Empty");
			else
			{
			do{
			String bname = " ";
			for(Bank marker = vBank.firstBank; marker!=null; marker = marker.nextBank)
				bname = bname + ("\n") + marker.bankname1;
			String bankLink = JOptionPane.showInputDialog("Choose a Bank: " +bname);
			for(mark = vBank.firstBank; mark!=null; mark = mark.nextBank)
			{
				if(mark.bankname1.equalsIgnoreCase(bankLink))
					{
					bank = new Bank(mark.bankname1, mark.description1, mark.branch1, mark.bankadd1);
					m++;
					break;
					}
				else if(!mark.bankname1.equalsIgnoreCase(bankLink)&& (mark.nextBank != null))
					continue;
				else if(!mark.bankname1.equalsIgnoreCase(bankLink) && (mark.nextBank == null))
					{
					JOptionPane.showMessageDialog(null, "Bank does not exist");
					break;
					}
			}
			}while(m == 0);
				int number = 0 , deposit2 = 0, t = 0 , t2 = 0;
			if(vList.firstNode == null)
			{
				String account = JOptionPane.showInputDialog("Enter Account Number");
				number = Integer.parseInt(account);
			}
			else{
			do{
			String account = JOptionPane.showInputDialog("Enter Account Number");
			number = Integer.parseInt(account);
			for(Info marker = vList.firstNode; marker!=null; marker = marker.nextInfo)
			{
				if(number==marker.number1)
					JOptionPane.showMessageDialog(null, "Account Number has already Taken", " Error", JOptionPane.ERROR_MESSAGE);
				else
					t++;
			}
			}while(t == 0);
			}
			String lastname = JOptionPane.showInputDialog("Enter Your Lastname");
			String givenname = JOptionPane.showInputDialog("Enter Your Firstname");
			String middlename = JOptionPane.showInputDialog("Enter Your Middlename");
			String address = JOptionPane.showInputDialog("Enter Your Address");
			String birthday = JOptionPane.showInputDialog("Enter Birth Date", "YYYY-MM-DD");
			do{
			String deposit = JOptionPane.showInputDialog("Enter Amount of Deposit");
			deposit2 = Integer.parseInt(deposit);
			if(deposit2 < 100)
				JOptionPane.showMessageDialog(null, "Deposit must be Greater than 100");
			else
				t2++;
			}while(t2 == 0);
			Info variable = new Info(number, lastname, givenname, middlename, address, birthday, deposit2, bank);
			if(vList.firstNode==null)
			{
				vList.firstNode = vList.lastNode = variable;
				vList.lastNode.nextInfo = null;
			}
			else if(vList.firstNode == vList.lastNode)
			{
				vList.lastNode = vList.firstNode.nextInfo = variable;
				vList.lastNode.nextInfo = null;
			}
			else
			{
				vList.lastNode.nextInfo = variable;
				vList.lastNode = variable;
				vList.lastNode.nextInfo = null;
			}
			JOptionPane.showMessageDialog(null, "This is Your Information: \nAcount Number: "+number+"\nName: "+lastname+", " +givenname+ " "+middlename+ "\nAddress: "+address+"\nBirthday: "+birthday+"\nDeposit: "+deposit2+ 
					"\n \nBank Information: \nBankname:" +mark.bankname1+ "\nDescription:" +mark.description1+ "\nBranch: " +mark.branch1+ "\nAddress: " +mark.bankadd1);
			}
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}//END ACCOUNTS
		
		// DEPOSIT================================================================================================================================
		if(choose == 3)
		{
			int id2 = 0, t3 = 0, t4 = 0;
			if(vList.firstNode==null)
				JOptionPane.showMessageDialog(null, "No Account Stored");
			else
			{
				int dp3 = 0;
				do{
				String id = JOptionPane.showInputDialog("Enter ID number");
				id2 = Integer.parseInt(id);
				for(Info marker = vList.firstNode; marker!=null; marker = marker.nextInfo)
					{
						if((id2 != marker.number1) && (marker.nextInfo!= null))
							continue;
						else if(id2 == marker.number1)
						{
							t3++;
							break;
						}
						else if((id2!= marker.number1) && (marker.nextInfo == null))
							JOptionPane.showMessageDialog(null, "Account Number Does Not Exist");
					}
				}while(t3 == 0);	
				do{
				String deposit3 = JOptionPane.showInputDialog("Enter Amount");
				dp3 = Integer.parseInt(deposit3);
				if(dp3<0)
					JOptionPane.showMessageDialog(null, "Invalid Amount");
				else
					t4++;
				}while(t4 ==0);
				for(Info marker = vList.firstNode; marker!=null; marker = marker.nextInfo)
					if(id2 == marker.number1)
						{
						marker.deposit1 = marker.deposit1 + dp3;
						JOptionPane.showMessageDialog(null, "Your New Balance is: "+marker.deposit1);
						}		
			}
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}//END DEPOSIT
		
		// WITHDRAW================================================================================================================================
		if(choose == 4)
		{
			Info marker;
			int t5 = 0, t3 = 0, t4 = 0, diff = 0, id4 = 0, dp4 = 0;
			if(vList.firstNode==null)
				JOptionPane.showMessageDialog(null, "No Account Stored");
			else{
			do{
				String id3 = JOptionPane.showInputDialog("Enter ID number");
				id4 = Integer.parseInt(id3);
				for(Info marker2 = vList.firstNode; marker2 != null; marker2 = marker2.nextInfo)
				{
					if((id4 != marker2.number1) && (marker2.nextInfo!= null))
						continue;
					else if(id4 == marker2.number1)
					{
						t3++;
						break;
					}
					else if((id4 != marker2.number1) && (marker2.nextInfo == null))
						JOptionPane.showMessageDialog(null, "Account Number Does Not Exist");
				}
			}while(t3 == 0);
			do{
				t4=0;
			do{
			String deposit4 = JOptionPane.showInputDialog("Enter Amount");
			dp4 = Integer.parseInt(deposit4);
			if(dp4<0)
				JOptionPane.showMessageDialog(null, "Invalid Amount");
			else
				t4++;
			}while(t4 == 0);
				for(marker = vList.firstNode; marker!=null; marker = marker.nextInfo)
				if(id4 == marker.number1)
					{
					diff = marker.deposit1 - dp4;
					if(diff<100)
					{
						JOptionPane.showMessageDialog(null, "There must be 100 Maintaning Balance");
						break;
					}
					else{
						marker.deposit1 = diff;
						JOptionPane.showMessageDialog(null, "Your New Balance is: "+marker.deposit1);
						t5++;
					}
					}
			}while(t5 == 0);
			}
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}//END WITHDRAW
		
		//PRINT ================================================================================================================================
		if(choose == 5){
			int number, t = 0;
			do{
				if(vList.firstNode == null)
				{
					JOptionPane.showMessageDialog(null, "No Account Stored");
					t++;
				}
				else{
				do{
				String account = JOptionPane.showInputDialog("Enter Account Number");
				number = Integer.parseInt(account);
				for(Info marker = vList.firstNode; marker!=null; marker = marker.nextInfo)
				{
					if(number==marker.number1)
						{
						JOptionPane.showMessageDialog(null, "Account Number: " +marker.number1+ "\nName: " +marker.lastname1+ ", " +marker.givenname1+ " "+marker.middlename1+ "\nBalance: " +marker.deposit1+ "\nBank: " +marker.banknameInfo1.bankname1);
						int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
						if(x == JOptionPane.YES_OPTION)
							t++;
						if(x == JOptionPane.NO_OPTION)
							System.exit(0);
						}
					else if((number!=marker.number1) && (marker.nextInfo == null))
						JOptionPane.showMessageDialog(null, "Account Number does not exist");
				}
				}while(t == 0);
				}
				}while(t == 0);
		}//END PRINT
		}catch(Throwable wew){
			JOptionPane.showMessageDialog(null, "Invalid Input");
		}
		}while(q == 0);
	}
}

