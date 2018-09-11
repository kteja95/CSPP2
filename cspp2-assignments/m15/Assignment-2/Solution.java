import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**.
InvalidSubSetSelectionException the user defined exception class.
*/
class InvalidSubsetSelectionException extends Exception {
/**.
@InvalidSubsetSelectionException the constructor*/
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**.
SetEmptyException the user defined exception class.
*/
class SetEmptyException extends Exception {
/**.
@SetEmptyException the constructor*/
    SetEmptyException(final String s) {
        super(s);
    }
}


/**. Sortedset is the class */
class Sortedset extends Set {
    /**.
@param fromElement the starting element.
@param toElement the ending element.
@return returns the copy of array.
*/
/**.
@throws throws the exception
*/
/**.
@param fromElement the start.
@param toElement the end.
*/
    public int[] subSet(final int fromElement, final int toElement) throws InvalidSubsetSelectionException {
        if (fromElement > toElement) {
            throw new InvalidSubsetSelectionException("Invalid Arguments to Subset Exception");

        }
        int[] result = new int[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromElement) {
                for (int j = i; j < size; j++) {
                    if (set[j] < toElement) {
                        result[k++] = set[i];
                    }
                    break;
                }
            }
        }
        return Arrays.copyOf(result, k);
    }
    /**.
    *@param toElement should be the ending limit
    *@return the returns the copy of array.
    */
/**.
@param toElement the ending limit element.
*/
    public int[] headSet(final int toElement) throws SetEmptyException {
        int[] result = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < toElement) {
                result[i] = set[i];
                count++;
            }
        }
        if (count == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return Arrays.copyOf(result, count);
    }
    /**.
    @return the return for last element
    */
    /**.
    @throws throws the exception
    */
    public int last() throws SetEmptyException {
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return set[size - 1];
    }
/**.
* @param item the array to be added
*/
    public void addAll(final int[] item) {
            for (int i:item) {
                this.add(i);
        }
    }
/**
*@param arr the array passed as set array.
*/
    public void sort(final int[] arr) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * add method.
     * @param item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            set[size++] = item;
        }
        sort(set);
    }
}
/**. Solution the class*/
final class Solution {
    /**
     * COnstructor.
     */
    private Solution() {
        //Constructor.
    }
/**.
@return returns the int array
@param s the string
*/
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**.
    @param args the argument =s
    */
    public static void main(final String[] args) {
        Sortedset s = new Sortedset();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
         while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "subSet":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(Arrays.toString(object).replace("[",
                            "{").replace("]", "}"));
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "headSet":
                try {
                    int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                    System.out.println(Arrays.toString(obj).replace("[",
                                "{").replace("]", "}"));
                    }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "last":
                try {
                    if (tokens.length != 1) {
                        break;
                    }
                    int temp = s.last();
                    System.out.println(temp);
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "addAll":
                int[] intArr = intArray(tokens[1]);
                if (intArr.length == 1) {
                    s.add(intArr[0]);
                } else {
                    s.add(intArr);
                }
                break;
                case "print":
                System.out.println(s);
                break;
                case "intersection":
                    s = new Sortedset();
                    Sortedset t = new Sortedset();
                    int[] intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    t.addAll(intArray);
                    System.out.println(s.intersection(t));
                break;
                case "retainAll":
                    s = new Sortedset();
                    intArray = intArray(tokens[1]);
                    s.addAll(intArray);
                    intArray = intArray(tokens[2]);
                    System.out.println(s.retainAll(intArray));
                break;
                default:
                break;
            }
        }
    }
}

