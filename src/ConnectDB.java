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
    String sql="select * from Item", sql2 = "", sql3 = "", sql4 = "";
    String dbtime, dbtime1, dbtime2, dbtime3,dbtime4, dname=" ";

    public static void main( String args[] )
    {
        int choose;
        choose = Integer.parseInt(JOptionPane.showInputDialog("Choose transaction \n1. View Item \n2. Insert Item \n3. Update \n4. Delete", "Number"));
    	if(choose == 1)
        {
    		ConnectDB conn = new ConnectDB();
    		conn.View();
        }
    	else if(choose == 2)
    	{
    		ConnectDB conn = new ConnectDB();
    		conn.Add();
    	}
    	else if(choose == 3)
    	{
    		ConnectDB conn = new ConnectDB();
    		conn.update();
    	}
    	else if(choose == 4)
    	{
    		ConnectDB conn = new ConnectDB();
    		conn.delete();
    	}
    }
    
    public void View() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
            	dbtime = rs.getString(1);
            	dbtime1 = rs.getString(2);
            	dbtime2 = rs.getString(3);
            	dbtime3 = rs.getString(4);
            	dbtime4 = rs.getString(5);
            	dname = dname + dbtime+ "/" +dbtime1+"/" + dbtime2 + "/" +dbtime3+"/"+ dbtime4 + "\n";
            }
            JOptionPane.showMessageDialog(null, dname);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"not connected"+e.getMessage());
        }
    }

    public void Add() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            
            String name = JOptionPane.showInputDialog("Enter Name of Product");
            String description=JOptionPane.showInputDialog("Description");
            String price=JOptionPane.showInputDialog("Price");
            String quantity=JOptionPane.showInputDialog("Quantity");
            sql2 = "insert into Item(Name, Description, Price, Quantity) values('"+name+"','"+description+"',"+price+","+quantity+")";
            statement.execute(sql2);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"not connected"+e.getMessage());
        }
    }
    
    public void update() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID"));
            String change=JOptionPane.showInputDialog("What do you want to change? \nNote:1st letter must be UPPER CASE \n-Name \n-Description \n-Price \n-Quantity");
            String change2=JOptionPane.showInputDialog("Enter change");
            sql3 = "update Item set "+change+"='"+change2+"' where ID="+id+"";
            statement.execute(sql3);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"not connected"+e.getMessage());
        }
    }
    public void delete() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID"));
            sql4 = "delete from Item where ID="+id+"";
            statement.execute(sql4);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"not connected"+e.getMessage());
        }
    }
}