import java.util.Scanner;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function
	static String reverseString(String s)
	{
		String newstring = "";
		for(int i=s.length()-1;i>=0;i--)
		{
			newstring+=s.charAt(i);
		}
		return newstring;


	}

}
