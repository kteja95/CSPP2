import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
class InvalidSubsetSelectionException extends Exception {
    InvalidSubsetSelectionException(String s) {
        super(s);
    }
}
class SetEmptyException extends Exception {
    SetEmptyException(String s) {
        super(s);
    }
}

class Set {

    /**
     * This constant is used to create an array
     * with the initial capacity.
     */
    public static final int TEN = 10;

    /**
     * holds the elemtns in this Set array.
     */
    public int[] set;

    /**
     * indicates the number of elememnts of this set.
     */
    public int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    public Set() {
        set = new int[TEN];
        size = 0;
    }

    /**
     * add the item to this set at the last.
     * If the set is full, resize the set to double
     * the size of the current set.
     * @param item to be inserted at the last.
     */
    public void add(int item) {
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            set[size++] = item;
        }
    }

    /**
     * resize the set by double, when it is full.
     */
    private void resize() {
        set = java.util.Arrays.copyOf(set, size * 2);
    }
    /**
     *@param arr
     */
    public void add(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * Finds the intersection of the two sets.
     * @param  other as set 2.
     * @return the result that contains the common
     * elements of the two sets.
     */
    public Set intersection(final Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    /**
     * retains all the elements from the set.
     * @param  arr is a form of set2.
     * @return the set that contains all the elements
     * of this set.
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * This finds out the cartesian product of two sets.
     * @param  other as a Set 2.
     * @return the cartesian product in the form of 2D array.
     */
    public int[][] cartesianProduct(final Set other) {
        int [][] result = new int[this.size() * other.size()][2];
        int k = -1;
        if (this.size() == 0 || other.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < other.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = other.get(j);
            }
        }
        return result;
    }

    /**
     * This methods finds out the number of elements in the set.
     * @return the integer value indicates the number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * This method finds out the elements
     * at a particular index.
     * @param  index to return the element at this index.
     * @return the element at this index, otherwise return -1.
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
        }
    }

    /**
     * String version of the object.
     * @return string.
     */
    public String toString() {
        if (this.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(set[i] + ", ");
        }
        sb.append(set[size - 1] + "}");
        return sb.toString();
    }

    /**
     * returns true if this set contains the item.
     * @param  item as a parameter to be checked in the set.
     * @return      true if the item present in the set,
     *                   otherwise false.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Finds the index of the item in this set.
     * @param  item to be find in this set.
     * @return the index if the item is found in this set,
     * otherwise false.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
/**. Sortedset is the class */
class Sortedset extends Set {
    /**.
@param fromElement the starting element.
@param toElement the ending element.
@return returns the copy of array.
*/
    public int[] subSet(final int fromElement, final int toElement) throws InvalidSubsetSelectionException{
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
    public int[] headSet(final int toElement) throws SetEmptyException {
        int[] result = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < toElement) {
                result[i] = set[i];
                count++;
            }
        }
        if(count==0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return Arrays.copyOf(result, count);
    }
    /**.
    @return the return for last element
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
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "headSet":
                try {
                    int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                    System.out.println(Arrays.toString(obj).replace("[",
                                "{").replace("]", "}"));
                    }
                catch(Exception e) {
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
                catch(Exception e) {
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

