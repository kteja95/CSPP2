import java.util.*;
class fact
{
	static int factorial(int n)
	{
		if (n==1 || n==0)
			return 1;
		else
			return n*factorial(n-1);

	}
	public static void main(String[] args)
	{
		System.out.println("Enter the number for the factorial");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int f = factorial(n);
		System.out.println(f);

	}
}