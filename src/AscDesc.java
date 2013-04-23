
import javax.swing.JOptionPane;
public class AscDesc{
	public static void main(String args []){
		String x = JOptionPane.showInputDialog("Enter Number of Inputs");
		int a = Integer.parseInt(x);
		int[] array;
		array = new int[a];	
		for(int d = 0; a > 0; a--, d++)
		{
		String c = JOptionPane.showInputDialog("Enter number:");
		int b = Integer.parseInt(c);
		array[d] = b;
		}
		for(int q = 0; q<array.length-1; q++)
		{
			if((array[q]<array[q+1]))
			continue;
			if(array[q]>array[q+1])
			{
			array[q] = array[q] + array[q+1];
			array[q+1] = array[q] - array[q+1];
			array[q] = array[q] - array[q+1];
			q = -1;	
			}
		}
		System.out.print("Ascending: ");
		for(int y = 0; y<array.length; y++)
		{
			if(y == array.length-1)
				System.out.print(array[y]);
			else{
			System.out.print(array[y]);
			System.out.print(",");
			}
		}
		System.out.println(" ");
		System.out.print("Descending: ");
		for(int y = array.length-1; y>=0; y--)
		{
			if(y == 0)
				System.out.print(array[y]);
			else{
			System.out.print(array[y]);
			System.out.print(",");
			}
		}
	}

}

