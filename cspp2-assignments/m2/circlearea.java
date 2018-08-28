import java.util.*;
class area
{   static double area(int r)
	{
		double pi = pi();
		return (pi*r*r);
	}
	static double pi()
	{
		
		return 3.14;
	}
	public static void main(String[] args)
	{
		System.out.println("Enter the radius r");
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		System.out.println(area(r));

	}


}