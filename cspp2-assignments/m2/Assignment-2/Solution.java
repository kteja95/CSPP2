import java.util.Scanner;
import java.lang.*;

public class Solution 
{
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) 
	{
		// System.out.println("Enter the values of a, b, c");
		Scanner scan = new Scanner(System.in);
		double a = scan.nextInt();
		double b = scan.nextInt();
		double c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	static void rootsOfQuadraticEquation(double a, double b, double c)
	{
		double root1;
		double root2;
		root1 = (-b+(Math.sqrt(Math.abs(b*b)-4*a*c)))/(2*a);
		root2 = (-b-(Math.sqrt(Math.abs(b*b)-4*a*c)))/(2*a);
		System.out.println(root1+" "+root2);
		
	}
}
