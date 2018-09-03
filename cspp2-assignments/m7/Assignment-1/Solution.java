import java.util.Scanner;
/**. Input validator is the class that returns true if length is 6*/
class InputValidator {
    /**.Write the atrributes and methods for InputValidator.*/
    String newstring;
    public InputValidator(final String str) {
        this.newstring = str;
    }
/**.validateData is the function.
@return return it returns a bool
*/
    public boolean validateData() {
        final int six = 6;
        int len = newstring.length();
        if (len >= six) {
            return true;
        } else {
            return false;
        }
    }
}
/**. Solution the class
*/
final class Solution {
    private Solution() {
    /**.
    @Solution the constructor.
    */
    }
/**.
@param args the arguments
*/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
