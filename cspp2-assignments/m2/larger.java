import java.util.*;
class larger
{
	public static void main(String[] args)
	{
		System.out.println("Enter the two numbers");
		Scanner s = new Scanner(System.in);
		int VarA = s.nextInt();
		int VarB = s.nextInt();
		if (VarA>VarB)
			System.out.println("VarA is larger");
		else if (VarA==VarB)
			System.out.println("Both are equal");
		else
			System.out.print("VarB is larger");
		
	}
}