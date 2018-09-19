import java.util.Arrays;
import java.io.*;
import java.util.*;
class solution {
    solution() {

    }
    public void getConnections(String[] friends) {
        int i;
        for(i = 1; i < friends.length; i++) {
            System.out.println(friends[i]);
        }
    }
    public void addConnections(String[] everybody, String head, String newguy) {
        int size = 0;
        size = everybody.length;
        if(everybody[0].equals(head)) {
            everybody[1] += ","+newguy;
        }
        for(int i = 1; i < size; i++) {
            System.out.println(everybody[i]);
        }

     }

    public void getComonConnections(String[] n, String[] a) {
        String s = "";
        String[] newarray = n[1].split(",");
        String[] array = a[1].split(",");
        for(int i = 1; i < newarray.length; i++) {            
            for(int j = 1; j < array.length; j++) {
                if(newarray[i].equals(array[j])) {
                    s = s+ newarray[i]+", ";
                }
            }

        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        BufferedReader reader;
        solution s = new solution();
        int c = 1;
        String[] str;
        String[] f;
        String name = "Krishna";
        try {
            reader = new BufferedReader(new FileReader("SocialNetwork.txt"));
            String line = reader.readLine();
            while(line!=null) {
                str = line.split(" is connected to ");
                s.getConnections(str);
                s.addConnections(str, str[0], name);
                line = reader.readLine();
                f = line.split(" is connected to ");
                s.getComonConnections(str, f);
                c++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}