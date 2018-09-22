import java.util.*;
import java.io.*;
// import java.util.Map;
// import java.util.Collections;
class plagiarism {
public HashMap frequency(String f) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    try{
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        while(line!=null) {
            String[] word = line.split(" ");
            for(int i=0;i<word.length;i++) {
                word[i] = word[i].replaceAll("[!@#$?%^&*()-.]", "").trim().toLowerCase();
                if(word[i].length()>0) {
                    if(map.containsKey(word[i])) {
                        map.put(word[i], map.get(word[i])+1);
                    } map.putIfAbsent(word[i], 1);
            }

            }
            line = reader.readLine();
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return map;
    }

}
class dotp {
    public int dotproduct(HashMap<String, Integer> h1, HashMap<String, Integer> h2) {
        HashMap<String, Integer> hashmap1, hashmap2;
        hashmap1 = h1;
        hashmap2 = h2;
        int product = 0;
        for(String words : hashmap1.keySet()) {
            if(hashmap2.containsKey(words)) {
                product = product + hashmap1.get(words) * hashmap2.get(words);
            }
        }
        return product;
    }
}
class solution {
    public static void main(String[] args) {
        plagiarism p = new plagiarism();
        HashMap<String, Integer> first = p.frequency("Test/File3.txt");
        // Map<String, Integer> syncMap = Collections.synchronizedMap(first);
        // System.out.println(syncMap);
        double squares = 0;
        int distance;
        double similarity;
        // HashMap<String, Integer> second = p.frequency("Test/File4.txt");
        // first.putAll(second);
        // System.out.println(first);
        System.out.println(first);
        for(int i : first.values()) {
            squares = squares + Math.pow(i, 2);
        }
        squares = Math.sqrt(squares);
        HashMap<String, Integer> second = p.frequency("Test/File4.txt");
        double squares1 = 0;
        System.out.println(second);
        for(int i : second.values()) {
            squares1 = squares1 + Math.pow(i, 2);
        }
        squares1 = Math.sqrt(squares1);
        dotp d = new dotp();
        distance = d.dotproduct(first, second);
        similarity = distance / (squares * squares1);
        System.out.println(similarity*100);
    }
}



// // class Solution {
// //     public static void main(String[] args) {
        
// //     }
// // }
// // class bye {
// //     Solution h = new Solution();
// //     System.out.println(h);
// // }

// class Solution {
//     public static void main(String[] args) {
//         HashMap<String, Integer> map = new HashMap<String, Integer>();
//         map.put("one", 1);
//         map.put("two", 2);
//         map.put("three", 3);
//         map.put("four", 4);
//         System.out.println(map);
//         HashMap<String, Integer> map1 = new HashMap<String, Integer>(map);
//         map1.put("hundred", 100);
//         map1.put("hello", 133213);
//         map.putAll(map1);
//         // Collections.sort(map);
//         // map.clear();
//         // System.out.println(map);
//         // System.out.println("*********");
//         // System.out.println(map.size());
//         // System.out.println(map1);
//         // System.out.println(map1.remove("hello"));
//         // System.out.println(map1);
//         // map1.putIfAbsent("two", 22);
//         // map1.putIfAbsent("ten", 10);
//         // Map<String, Integer> syncMap = Collections.synchronizedMap(map1);
//         // System.out.println(syncMap);
//     }
// }

// // HashTable is synchronized....thread
// // HasMap is not synchronized...thread
