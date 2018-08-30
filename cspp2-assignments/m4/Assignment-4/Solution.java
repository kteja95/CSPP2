import java.util.Scanner;
/**.Solution is the class
*/
final class Solution
{/*
    Do not modify the main function 
    */
    private Solution() {
        /**.
        @Constructor
*/
    }
/**.
@param args The arguments
@return return the string
*/
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);  
        System.out.println(reverse);
        
    }
    //Write reverseString function
    static String reverseString(final String s)
    {
        String newstring = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            newstring += s.charAt(i);
        }
        return newstring;


    }

}
