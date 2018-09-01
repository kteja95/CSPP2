import java.util.Scanner;
/**.
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : J.Krishna Teja
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
    static void oddComposites(final int n) {
        int numberofcomposites = 0;
        final int x = 3;
        for (int i = x; i <= n; i++) {
                if (i % 2 != 0) {
                    numberofcomposites = 0;
                    for (int j = x; j < i; j++) {
                        if (i % j == 0) {
                            numberofcomposites += 1;
                        }
                    }
                    if (numberofcomposites > 0) {
                       System.out.println(i);
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


