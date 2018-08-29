
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/**. Fill the main function to print the number of 7's between 1 to n
*/

    public static void main(String[] args) 
    {

  		// System.out.println("Enter the limit");
        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        final int f = 10;
        for(int i=0;i<=n;i++)
        {
        	int temp = i;
        	while(temp>0)
        	{
        		if (temp%10 ==7)
        		{
        			count=count+1;
        		}
        	temp = Math.round(temp/f);
        	}
        	
        }
    System.out.println(count);

    }
}