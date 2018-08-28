import java.util.Scanner;
/**.
Main class
*/
public class Solution
{
    /*
    Do not modify this main function.
    */
    private Solution() {
        /**
           *@constructor
        */

    }
    /**.
        * @param  args the argments
        */
    public static void main(String[] args) {    
    //THIS IS THE MAIN FUNCTION//
        Scanner s=new Scanner(System.in);
        final int base = s.nextInt();
        final int exponent = s.nextInt();
        long result=power(base,exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    /**.
    Need to write the rootsOfQuadraticEquat
    @param    base   the base
    @param    exponent  the exponent
    */
    static long power(final int base,final int exponent) {
        /**.
        POWER*/
        if (exponent > 0) {
            return base * power(base, exponent - 1);
        }
        return 1;
    }
}

