import java.util.*;

public class Solution 
{
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result=power(base,exponent);
        System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	static int power(int base,int exponent)
	{
		if (exponent>0)
			return base*power(base,exponent-1);
		return 1;
	}
}
