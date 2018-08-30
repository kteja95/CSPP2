import java.util.*;
class FirstLast6
{
    public static void main(String[] args) 
    {
        System.out.println("enter the size of the array");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();

        }
    if (arr[0]==6 || arr[n-1]==6)
    {
        System.out.println("True");
    }
    }
}