
import javax.swing.JOptionPane;
public class Reverse{
	public static void main(String args []){
		String input = "";
		input = JOptionPane.showInputDialog("Please Enter a Word: " );
		for(int a = input.length(); a > 0; a--){
			System.out.print(input.charAt(a-1));	
		}	
	}
}

