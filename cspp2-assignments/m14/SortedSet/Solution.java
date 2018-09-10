import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

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
        Arrays.sort(set);
        System.out.println(set);
    }

    /**
     * resize the set by double, when it is full.
     */
    private void resize() {
        set = java.util.Arrays.copyOf(set, size * 2);
    }

    /**
     * add all elements of the array to this Set.
     * @param arr as an arr to be added in this set,
     *            if the element is not present in this set.
     */
    public void addAll(int[] arr) {
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
    public Set intersection(Set other) {
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
    public int[] subSet(int toElement, int fromElement) {
        int [] newarray = new int[size];
        if(toElement > fromElement) {
            System.out.println("Invalid​ ​ Arguments​ ​ to​ ​ Subset​ ​ Exception");
        }
        int i;
        int j=0;
        for(i=toElement;i<fromElement;i++) {
            newarray[j] = set[i];
            j++;
        }
         Arrays.sort(newarray);
         return newarray;
    }
    public int[] headSet(int toElement) {
        int[] newset = new int[size];
        for(int i=0;i<toElement;i++) {
            newset[i]=set[i];
        }
         Arrays.sort(newset);
         return newset;
    }
    public int last() {
         Arrays.sort(set);
         return set[size-1];
    }

}
public class Solution extends Set {
    Solution() {

    }
    public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        Solution l = new Solution();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
                case "addAll":
                final int value = tokens.length-1;
                int[] array = new int[value];
                for(int i=0;i<value;i++) {
                    array[i] = Integer.parseInt(tokens[i+1]);
                }
                l.addAll(array);
                // case ""
                default:
                break;
    }


}
}
}
