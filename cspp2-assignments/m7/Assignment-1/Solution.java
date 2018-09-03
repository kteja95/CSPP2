import java.util.*;
class InputValidator {
    /**.Write the atrributes and methods for InputValidator*/
    String str;
    public InputValidator(String str) {
        this.str = str;
    }
    public boolean validateData() {
        final int six = 6;
        int len = str.length();
        if (len >= six) {
            return true;
        } else {
            return false;
        }
    }
}
/**. Solution the class
*/
public class Solution {
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
