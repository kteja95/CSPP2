import java.util.*;
public class Solution {
    /* Fill the main function to print resultant of addition of matrices*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = s.nextInt();
            }
        }
        int p = s.nextInt();
        int q = s.nextInt();
        int[][] ar = new int[p][q];
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<q;j++)
            {
                ar[i][j] = s.nextInt();
            }
        }
        int[][] newarray = new int[n][m];
    if(n==p && m==q)
    {
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                newarray[i][j]=arr[i][j]+ar[i][j];
            }
        }
    }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(newarray[i][j]+" ");
            }
        System.out.println();
        }
    }
}