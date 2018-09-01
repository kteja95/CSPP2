import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : J.Krishna Teja
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**.
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {
        final int x = 100;
        final int y = 200;
        final int z = 300;
        final int w = 400;
        final int t = 500;
        final int p = 0;
        final int u = 50;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] < u) {
                   a[i][j] = p;
                } else if (a[i][j] > u && a[i][j] < x) {
                    a[i][j] = x;
                } else if (a[i][j] > x && a[i][j] < x + u) {
                    a[i][j] = x;
                } else if (a[i][j] > x + u && a[i][j] < y) {
                    a[i][j] = y;
                } else if (a[i][j] > y && a[i][j] < y + u) {
                    a[i][j] = y;
                } else if (a[i][j] > y + u && a[i][j] < z) {
                    a[i][j] = z;
                } else if (a[i][j] > z && a[i][j] < z + u) {
                    a[i][j] = z;
                } else if (a[i][j] > z + u && a[i][j] < w) {
                    a[i][j] = w;
                } else if (a[i][j] > w && a[i][j] < w + u) {
                    a[i][j] = w;
                } else if (a[i][j] > w + u && a[i][j] < t) {
                    a[i][j] = t;
                }
               }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
