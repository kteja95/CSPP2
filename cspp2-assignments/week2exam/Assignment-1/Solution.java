import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int size;
    private int[] array;
    Set() {
         size = 0;
         array = new int[10];
    }
    public int size() {
        return size;
    }
    private void resize()
    {
        array = Arrays.copyOf(array, 4*size);
    }
    public boolean contains(int item) {
        int itemcount =0;
        for(int i=0;i<size;i++) {
            if(item==array[i])
            {
                itemcount++;
            }
        }
        if(itemcount>0)
        {
            return true;
        } else {
            return false;
        }
    }
    public String toString()
    {
        if(size==0)
            return "{}";
        String str="{";
        for(int i=0;i<size;i++)
        {
            str = str + array[i] +",";
        }
        return str+"}";
    }
    public Set add(int item)
    {
        if(size==0)
            array[size++]=item;
        else
            for(int i=0;i<size;i++)
            {
                if(item!=array[i]) {
                    array[i]=item;
                    size+=1;
                }
            }
        return this;
    }
    public void add(int[] items) 
    {
        int j=0;
        for(int i=size;j<items.length;i++)
        {
            if(array[i]!=items[j]) {
                array[i]=items[j];
                size+=1;
                j++;
            }

        }

    }
    public Set intersection(Set set2)
    {
        Set newSet = new Set();
        if(size==array.length)
            resize();
        for(int i=0; i<size; i++) {
            if(set2.contains(array[i])) {
                newSet = newSet.add(array[i]);
            }
        }
        return newSet;

    }

    public Set retainAll(int[] items)
    {
        int j=0;
        for(int i=0;j<items.length;i++) {
            if(array[i]==items[j]) {
                this.add(items[j]);
                j++;
            }

        }
        return this;

    }
    public Set[][] cartesianProduct(Set set3)
    {
        Set[][] m= new Set[size][set3.array.length];
        for(int i=0;i<size;i++) {
            for(int j=0;j<set3.array.length;j++)
            {
                m[i][j] = this.add(array[i]);
            }
        }
        return m;

    }
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
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
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
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
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
