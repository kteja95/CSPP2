import java.util.Scanner;
// import java.lang.Math;
/**.
Main class
*/
public final class Solution {
    /**.
    Do not modify this main function.
    **/
    private Solution() {
        /**
           *@constructor
        */

    }
        /**.
        * @param  args the argments
        */


    public static void main(final String[] args) {
        /**.THIS IS THE MAIN FUNCTION**/
        Scanner scan = new Scanner(System.in);
        double a = scan.nextInt();
        double b = scan.nextInt();
        double c = scan.nextInt();
        r(a, b, c);
    }
    /**.
    Need to write the rootsOfQuadraticEquat
    @param    a   the coeffecient
    @param    b   the coefficent
    @param    c    the coeffeicti


    */
    static void r(final double a, final double b, final double c) {
    /**.
         square roots.
        **/
        double r1;
        double r2;
        final int f = 4;
        r1 = (-b + (Math.sqrt(Math.abs(b * b) - f * a * c))) / (2 * a);
        r2 = (-b - (Math.sqrt(Math.abs(b * b) - f * a * c))) / (2 * a);
        System.out.println(r1 + " " + r2);
    }
}
