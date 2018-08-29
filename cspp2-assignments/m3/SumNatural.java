import java.util.*;
class sumnatural
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the limit for finding the sum");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int c = 0;
		for(int i=1;i<=n;i++)
			c+=i;
    System.out.println(c);
		
	}
}