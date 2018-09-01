import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) 
    {
        int composites = 0;
        int i;
        int j;
        for(i=3;i<n;i++)
        {
            if(i%2!=0)
            {
                for(j=3;j<=(int) (Math.sqrt(i));j++)
                {
                    if(i%j==0)
                    {
                        composites+=1;
                            if(composites>0)
                            {
                                System.out.println(i);
                            }


                    }
                }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

