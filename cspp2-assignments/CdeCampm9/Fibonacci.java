import java.util.Scanner;

/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
/**. Fibonacciis the class that is the client to the class List*/

final class Fibonacci {
    /*
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
/**.
@param n the the limit for the series.
@return returns the fibo object
*/
    public static List fib(final int n) {
        List fibo = new List(n);
        int a = 0;
        int b = 1;
        int valuesfromget = 0;
        fibo.add(a);
        fibo.add(b);
        for (int f = 2; f < n; f++) {
            valuesfromget = fibo.get(f - 1) + fibo.get(f - 2);
            fibo.add(valuesfromget);
        }
        return fibo;
    }
/**.
@param args the arguments
*/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}