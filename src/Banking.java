import javax.swing.*;
public class Banking {
	public static void main(String args[])
	{	
		List vList = new List();
		boolean q = true;
		do{
		
		for(int marker = ; ;)
		String all = JOptionPane.showInputDialog("Please Choose Process \n1. Add Account \n2. Deposit \n3. Withdraw");
		int choose = Integer.parseInt(all);
		if(choose == 1)
		{
			String account = JOptionPane.showInputDialog("Enter Account Number");
			int number = Integer.parseInt(account);
			String name = JOptionPane.showInputDialog("Enter Your Name");
			String address = JOptionPane.showInputDialog("Enter Your Address");
			String birthday = JOptionPane.showInputDialog("Enter Birth Date");
			String deposit = JOptionPane.showInputDialog("Enter Amount of Deposit");
			int deposit2 = Integer.parseInt(deposit);
			Info variable = new Info(number, name, address, birthday, deposit2);
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
				vList.lastNode = variable;
				vList.lastNode.nextInfo = null;
			}
			JOptionPane.showMessageDialog(null, "This is Your Information: \nAcount Number: "+number+"\nName: "+name+"\nAddress: "+address+"\nBirthday: "+birthday+"\nDeposit: "+deposit);
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}
		if(choose == 2)
		{
			if(vList.firstNode==null)
				JOptionPane.showMessageDialog(null, "No Account is Stored");
			else
			{
				String id = JOptionPane.showInputDialog("Enter ID number");
				int id2 = Integer.parseInt(id);
				String deposit3 = JOptionPane.showInputDialog("Enter Amount");
				int dp3 = Integer.parseInt(deposit3);
			}
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}
		if(choose == 3)
		{
			if(vList.firstNode==null)
				JOptionPane.showMessageDialog(null, "No Account is Stored");
			else{
			String id3 = JOptionPane.showInputDialog("Enter ID number");
			int id4 = Integer.parseInt(id3);
			String deposit4 = JOptionPane.showInputDialog("Enter Amount");
			int dp4 = Integer.parseInt(deposit4);
			}
			int x = JOptionPane.showConfirmDialog(null, "Do You Have Other Transaction","Confirm Message",JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.YES_OPTION)
				continue;
			if(x == JOptionPane.NO_OPTION)
				System.exit(0);
		}
		}while(q = true);
		
	}
}

