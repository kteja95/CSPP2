
import java.util.Scanner;
/*
    Do not modify this main function.
    */
/**.
    Solution the class
*/
final class Solution {
    private Solution() {
        /**.
        @constructor
        */
    }
/**.
    @param args the arguments
*/
    public static void main(final String[] args) {
     Scanner s = new Scanner(System.in);
        final int n1 = s.nextInt();
        final int n2 = s.nextInt();
        System.out.println(gcd(n1,n2));
        // int result = 0;
        // result= System.out.println(gcd(n1,n2));
    }
    /*
    Need to write the gcd function and print the output.
    */
    static int gcd(final int n1, final int n2) {
         int temp = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 %i == 0 && n2 % i == 0) {
                if (temp < i) {;
                temp = i;
            }
            }
        }
        return temp;
    }
}