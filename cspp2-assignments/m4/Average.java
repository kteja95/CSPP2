import java.util.*;
class average
{
	public static void main(String[] args) {
		System.out.println("enter the size of the array");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum=0;
		int avg=0;
		int [] arr = new int[n];
		for(int i =0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		for(int j=0;j<arr.length;j++)
		{
			sum=sum+arr[j];

		}
		avg=sum/arr.length;
		System.out.println(avg);


	}
}