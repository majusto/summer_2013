import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class ConnectDB
{
    public Connection con = null;
    public Statement statement= null;
    public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public String username = "root",password = null;
    static String dbname = "jdbc:mysql://localhost/sample";
    String sql=null, sql2 = "", sql3 = "", sql4 = "", sql5 = "",q, dbtime, dbtime1, dbtime2, dbtime3, dbtime4, dbtime5, dbtime6, dname=" ", input,id,cID,itemsID;
    int y = 0, id2,cID2,itemsID2;
	boolean b = true;
	static int z=0;
	static ConnectDB conn = new ConnectDB();
    public static void main( String args[] )
    {
    	do{
    	try{
    	int all;
    	all = Integer.parseInt(JOptionPane.showInputDialog("Choose transaction \n1.Customers \n2.Items \n3.Order Line \n4. Exit"));
    	if(all>4 || all<1)
    		{
    		JOptionPane.showMessageDialog(null,"Invalid Input");
    		z=0;
    		}
    	else
    		conn.tables(z=all);
    	}catch(NumberFormatException err){
    		JOptionPane.showMessageDialog(null, "Invalid Input, please enter a number");
    	}
    	}while(z==0);
    	if(z==4)
    		System.exit(0);
    }
    public void tables(int z){
    	int choose2 = 0, x = 0;  	 	   	
    	   	do{
    	   	try{
    		if(z==1 ||z==2){
    			choose2 = Integer.parseInt(JOptionPane.showInputDialog("Choose transaction \n1. View \n2. Insert \n3. Update \n4. Delete \n5.Exit", "Number"));
    			if(choose2>5 || choose2<0)
    				JOptionPane.showMessageDialog(null, "Invalid Input");
    			else
    				x++;
    			if(choose2 == 5)
    				System.exit(0);
    		}
    		else if(z==3){
    		choose2 = Integer.parseInt(JOptionPane.showInputDialog("Choose transaction \n1. View Item \n2. Insert Item \n3. Update \n4.Exit", "Number"));
			if(choose2>4 || choose2 <0)
				JOptionPane.showMessageDialog(null, "Invalid Input");
			else
				x++;
    		}
    	}catch(NumberFormatException e){
        	JOptionPane.showMessageDialog(null, "Invalid Input, please enter a number");
    	}
    	}while(x == 0);
        if(choose2 == 1)
    		conn.View(y = z);	
    	else if(choose2 == 2)
    		conn.Add(y = z);
    	else if(choose2 == 3)
    		conn.update(y = z);
    	else if(choose2 == 4)
    		conn.delete(y = z);
    }
    public void View(int y) {
        	try {
        		dname = " ";
        		Class.forName(JDBC_DRIVER);
            	con = DriverManager.getConnection(dbname,username,password);
            	statement= con.createStatement();
            	if(y==1){
            		 sql="select* from Customers";
            		 ResultSet rs=statement.executeQuery(sql);
            		 while (rs.next()) {
            			 dbtime = rs.getString(1);
            			 dbtime1 = rs.getString(2);
            			 dbtime2 = rs.getString(3);
            			 dbtime3 = rs.getString(4);
            			 dbtime4 = rs.getString(5);
            			 dbtime5 = rs.getString(6);
            			 dbtime6 = rs.getString(7);
            			 dname = dname + dbtime+" / " +dbtime1+", " + dbtime2 + " " +dbtime3+" / "+ dbtime4 + " / "+ dbtime5 +" / "+ dbtime6 +"\n";
            		 }
            		 JOptionPane.showMessageDialog(null, "Customer's ID / Name / Birthday / Contact / Address \n \n"+dname);          		 
            	}
                else if(y==2){
                	sql = "select * from Item";
                	ResultSet rs=statement.executeQuery(sql);
                	while (rs.next()) {
                		dbtime = rs.getString(1);
                		dbtime1 = rs.getString(2);
                		dbtime2 = rs.getString(3);
                		dbtime3 = rs.getString(4);
                		dbtime4 = rs.getString(5);
                		dname = dname + dbtime+ " / " +dbtime1+" / " + dbtime2 + " / " +dbtime3+" / "+ dbtime4 + "\n \n";
                	}
                	JOptionPane.showMessageDialog(null, "Item's ID / Name / Description / Price / Quantity \n \n"+dname);
                }
                else if(y==3){
                	sql = "select concat(c.LastName,\",\",Firstname) AS \"Customer's Name\", i.Name, o.Quantity, o.Transaction_Date, format(sum(i.Price*o.Quantity),2) AS \"TotalPrice\" from Customers AS c, Order_Line AS o, Item AS i where o.Item=i.ID and c.ID=o.Customer group by o.Customer, i.ID";
                	ResultSet rs=statement.executeQuery(sql);
                	while (rs.next()) {
                		dbtime = rs.getString(1);
                		dbtime1 = rs.getString(2);
                		dbtime2 = rs.getString(3);
                		dbtime3 = rs.getString(4);
                		dbtime4 = rs.getString(5);
                		dname = dname + dbtime+ " / " +dbtime1+" / " + dbtime2 + " / " +dbtime3+" / " +dbtime4+"\n";
                	}
                	JOptionPane.showMessageDialog(null, "Customer's Name / Item's ID / Quantity / Transaction Date / Total Cost \n \n"+dname);
                }
            	conn.check();
        	}catch (Exception e) {
        		JOptionPane.showMessageDialog(null,"Not Connected to the Database \n"+e.getMessage());
        		
        	}
    }
    public void Add(int y) {
        try {
        	String lastname, firstname, middlename, name;
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            if(y == 1){
            	do {
            	lastname = JOptionPane.showInputDialog("Enter Lastname");
            	conn.checking(lastname);
            	}while(b == false);
            	do{
            	firstname=JOptionPane.showInputDialog("Enter Firstname");
            	conn.checking(firstname);
            	}while(b == false);
            	do{
            	middlename=JOptionPane.showInputDialog("Enter Middlename");
            	conn.checking(middlename);
            	}while( b == false);
            	String birthday=JOptionPane.showInputDialog("Birth date", "YYYY-MM-DD");
            	String contact=JOptionPane.showInputDialog("Contact No.");
            	String address=JOptionPane.showInputDialog("Address");	
            	sql2 = "insert into Customers(LastName, Firstname,MiddleName, Birthday, Contact, Address) values('"+lastname+"','"+firstname+"','"+middlename+"','"+birthday+ "','"+contact+"','"+address+"')";
            }
            else if(y == 2){
            	do{
            	name = JOptionPane.showInputDialog("Enter Name of Product");
            	conn.checking(name);
            	}while(b==false);
            	String description=JOptionPane.showInputDialog("Description");
            	String price=JOptionPane.showInputDialog("Price");
            	String quantity=JOptionPane.showInputDialog("Quantity");
            	sql2 = "insert into Item(Name, Description, Price, Quantity) values('"+name+"','"+description+"',"+price+","+quantity+")";
            }
            else if(y == 3){
            	do{
            		cID = JOptionPane.showInputDialog("Enter Customer's ID");
            		conn.checkingnumber(cID);
            	}while(b==false);
            	do{
            		itemsID = JOptionPane.showInputDialog("Item's ID");
            		conn.checkingnumber(itemsID);
            	}while(b==false);
            	String price=JOptionPane.showInputDialog("Quantity");
            	String quantity=JOptionPane.showInputDialog("Date", "YYYY-MM-DD");
            	sql2 = "insert into Order_Line(Customer, Item, Quantity, Transaction_Date) values("+cID+","+itemsID+","+price+",'"+quantity+"')";         	
            }
            	statement.execute(sql2);
            	conn.check();
            	return;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Not Connected to the Database \n"+e.getMessage());
            conn.check();
        }
    }
	public void update(int y) {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            do{
            id = JOptionPane.showInputDialog("Enter ID");
            conn.checkingnumber(id);
            }while(b==false);
            if(y==1){
            	String change=JOptionPane.showInputDialog("What do you want to change? \nNote:1st letter must be UPPER CASE \n-LastName \n-Firstname \n-MiddleName \n-Birthday \n-Contact \n-Address");
            	String change2=JOptionPane.showInputDialog("Enter change");
            	sql3 = "update Customers set "+change+"='"+change2+"' where ID="+id+"";
            	statement.execute(sql3);
            }
            else if(y==2){
            	String change=JOptionPane.showInputDialog("What do you want to change? \nNote:1st letter must be UPPER CASE \n-Name \n-Description \n-Price \n-Quantity");
            	String change2=JOptionPane.showInputDialog("Enter change");
            	sql3 = "update Item set "+change+"='"+change2+"' where ID="+id+"";
            	statement.execute(sql3);
            }
            else if(y==3){
            	String date = JOptionPane.showInputDialog("Enter Date", "YYYY-MM-DD");
            	sql5 = "select * from Order_Line where Customer="+id+" and Transaction_Date='"+date+"'";
            	ResultSet rs=statement.executeQuery(sql5);
            	while (rs.next()) {
            		dbtime = rs.getString(1);
            		dbtime1 = rs.getString(2);
            		dbtime2 = rs.getString(3);
            		dbtime3 = rs.getString(4);
            		dname = dname + dbtime+ " / " +dbtime1+" / " + dbtime2 + " / " +dbtime3+"\n";
            	}
            	String change3 = JOptionPane.showInputDialog("Customer's ID / Item's ID / Quantity / Transaction Date \n"+dname+"\nSelect Item's ID");
            	String change=JOptionPane.showInputDialog("What do you want to change? \nNote:1st letter must be UPPER CASE \n-Item \n-Quantity");
            	String change2=JOptionPane.showInputDialog("Enter change");
            	sql3 = "update Order_Line set "+change+"='"+change2+"' where Customer="+id+" and Transaction_Date='"+date+"' and Item='"+change3+"'";
            	statement.execute(sql3);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Not Connected to the Database \n"+e.getMessage());
            conn.check();
        }
    }
    public void delete(int y) {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            if(y==3)
            	System.exit(0);
            do{
            id = JOptionPane.showInputDialog("Enter ID");
            conn.checkingnumber(id);
            }while(b==false);
            if(y==1)
                sql4 = "delete from Customers where ID="+id+"";
            else if(y==2)
            	sql4 = "delete from Item where ID="+id+"";
            statement.execute(sql4);
            conn.check();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Not Connected to the Database \n"+e.getMessage());
            conn.check();
        }
    }
    public void check(){
    	int w = JOptionPane.showConfirmDialog(null, "Do you have other transaction?", "Question", JOptionPane.OK_CANCEL_OPTION);
    	if(w == JOptionPane.OK_OPTION)
    		ConnectDB.main(null);
    	else if(w== JOptionPane.CANCEL_OPTION)
    		System.exit(0);
    		
    }
    public boolean checking(String input)
    {
		if(input.isEmpty()){
			JOptionPane.showMessageDialog(null, "Invalid Input");
			return b = false;
		}
		else{
			for(int checks = 0; checks<=input.length()-1; checks++)
			{
				
				if(input.charAt(0) == 32 || input.charAt(input.length()-1) == 32 || ((input.charAt(checks) ==32)&& (input.charAt(checks-1) == 32)))
				{
					JOptionPane.showMessageDialog(null, "Invalid character");
					return b = false;
				}
				else if((input.charAt(checks) >= 65 && input.charAt(checks) <= 90) || (input.charAt(checks) >= 97 && input.charAt(checks) <= 122) || input.charAt(checks) == 32)
					continue;
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid character");
					return b = false;
				}
			}
		}
		return b = true;
    }
    public boolean checkingnumber(String q){
    	for(int checks = 0; checks<=q.length()-1; checks++)
    		{
    		if(q.charAt(checks) >= 48 && q.charAt(checks) <= 57)
    			continue;
    		else
    		{
				JOptionPane.showMessageDialog(null, "Invalid Input");
				return b = false;
			}
    		}
    	return b = true;
    }
}