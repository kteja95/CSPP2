import java.util.Scanner;
import java.util.Arrays;
class List {
    public int size;
    public int[] list;
    List()
    {
        this.size=0;
        list= new int[10];
    }
    


    public void add(int item) {
    if(size==list.length) {
        resize();
    }
    list[size++] = item;
    }
    



    public int size() {
        return size;
    }
    private void resize() {
        if(size==list.length)
            list = Arrays.copyOf(list, 2*size);
    }
    


    public void remove(int index) throws Exception {
        int pos=0;
        int j;
        int check=0;
        
        if(index < 0 && index >= size) {
            throw new Exception("Invalid Position Exception");
        }
        int x=list[index];
        for(j=0;j<size;j++) {
            if(list[j]==x){
                check=1;
                pos=j;
                break;
            }
            else
                check=0;
        }
        size-=1;
        if(check==1) {
            for(int i=pos+1;i<size;i++) {
                list[i-1]=list[i];
        }
        }

    }


    public int get(int index) {
        if(index<0 || index>size) {
            return -1;
        }
        return list[index];
    }


    public boolean contains(int item) {
        return indexOf(item)==-1;
    }

    public void addAll(int items[]) {
        int len=size+items.length;
        int k=0;
        for(int i=size; i<len;i++) {
            if(size==list.length) {
                resize();
            }
            list[i] = items[k];
            k+=1;
            size+=1;          
        }
    }


    public void add(int index, int item) {
        int j;
        int pos=0;
        int temp=0;
        int check =0;
        int x=list[index];
        for(j=0;j<size;j++) {
            if(list[j]==x) {
                check=1;
                pos=j;
                break;
            }
            check=0;
        }
        size=size+1;
        if(check==1) {
            for(int i=0;i<size;i++) {
                if(index==i) {
                    temp=list[i];
                    list[i]=item;
                    list[i+1]=temp;
            }

        }
    }
}




    public int indexOf(int item) {
        int i;
        for(i=0;i<size;i++) {
            if(list[i]==item) {
                return i;
            }
        }
        return -1;        
    }


    public int count(int item) {
        int itemcount=0;
        for(int i=0;i<size;i++) {
            if(item==list[i]) {
                itemcount++;
            }
        }
        return itemcount;
    }


    public void removeAll(int[] newarray) throws Exception {
        for(int i=0;i<newarray.length;i++) {
            for(int j=0;j<size;j++) {
                if(list[j]==newarray[i]) {
                    remove(j);
                    j--;
                }
            }
        }
    }

    public List subList(int start, int end) throws Exception {
        if(start<=0 || end>size || end<=0 ) {
            throw new Exception("Index Out of Bounds Exception");
        } else {
            List list1 = new List();
            for(int i= start;i<end;i++) {
                list1.add(list[i]);
            }
            return list1;

        }
    }


    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }

    public boolean equals(List other) {
        return this.toString().equals(other.toString());
    }


    public void clear() {
        for(int i=0;i<size;i++) {
            list[i] = 0;
        }
        size=0;
    }
}

class Solution {
    public static void main(String[] args) {
        List l = new List();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch(tokens[0]) {
                case "add":
                    if(tokens.length==2) {
                        String[] t = tokens[1].split(",");
                        if(t.length==1){
                            l.add(Integer.parseInt(tokens[1]));
                    }
                }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "remove":
                    if(tokens.length==2) {
                        try {
                            l.remove(Integer.parseInt(tokens[1]));
                        }
                        catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                break;
                case "get":
                    if(tokens.length==2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                }
                break;
                case "contains":
                    if(tokens.length==2) {
                        System.out.println(l.contains(Integer.parseInt(tokens[1])));
                }
                break;
                case "indexOf":
                    if(tokens.length==2) {
                        System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                }
                break;
                case "addAll":
                if(tokens.length==2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for(int i=0;i<temp.length;i++) {
                        temp[i] = Integer.parseInt(t1[i]);
                }
                l.addAll(temp);
            }
                break;
                case "add1":
                    l.add(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                break;
                case "subList":
                    String[] temp2 = tokens[1].split(",");
                    try {
                        List obj = l.subList(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]));
                        System.out.println(obj);
                }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                }
                break;
                case "print":
                    System.out.println(l);
                break;
                case "removeAll":
                    if(tokens.length==2) {
                        String[] t2 = tokens[1].split(",");
                        int[] temp3 = new int[t2.length];
                        for(int i=0;i<temp3.length;i++) {
                            temp3[i] = Integer.parseInt(t2[i]);
                    }
                        try {
                            l.removeAll(temp3);
                    }
                        catch(Exception e) {

                    }
            }
                break;
                case "equals":
                if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                case "count":
                    if(tokens.length==2) {
                        System.out.println(l.count(Integer.parseInt(tokens[1])));
                    }
                    break;
                default:
                break;


                }
            }
        }
    }