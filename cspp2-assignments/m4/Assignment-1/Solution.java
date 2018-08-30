
import java.util.Scanner;
import java.util.Arrays;
/**. Solution is the class for largest*/
final  class Solution {
/**.
    Fill this main function to print maximum of given array
    */
    private Solution() {
        /**.
        @constructor
        */
    }
    /**.
    @param args THE ARGUMENTS
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);

    }
}

