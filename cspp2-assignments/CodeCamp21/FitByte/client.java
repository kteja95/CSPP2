import java.util.*;
class Foodlog {
    private String foodname;
    private int qty;
    private String date;
    Foodlog() {

    }
    Foodlog(String foodname1, int qty1, String date1) {
        this.foodname = foodname1;
        this.qty = qty1;
        this.date = date1;
    }
    public String getFoodname() {
        return foodname;
    }
    public int getQty() {
        return qty;
    }
    public String getDate() {
        return date;
    }
}
class Waterlog {
    public String waterqty;
    Waterlog() {

    }
    Waterlog(String waterqty1) {
        this.waterqty = waterqty1;
    }
    public String getWater() {
        return waterqty;
    }
}
class Physical {
    private String activityname;
    private String starttime;
    private String endtime;
    private String date;
    Physical(){ 

    }

    Physical(String activityname1, String starttime1, String endtime1, String date1) {
        this.activityname = activityname1;
        this.starttime = starttime1;
        this.endtime = endtime1;
        this.date = date1;
    }

    public String getAct() {
        return activityname;
    }

    public String getStart() {
        return starttime;
    }

    public String getEnd() {
        return endtime;
    }

    public String getDate() {
        return date;
    }
}
class Sleep {
    private String start;
    private String end;
    Sleep() {


    }

    Sleep(String start1, String end1) {
        this.start = start1;
        this.end = end1;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
class Fatpercent {
    private double weight;

    Fatpercent(){

    }

    Fatpercent(double weight1){
        this.weight = weight1;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getFat() {
        return (this.weight * 1.082) + 94.42; 
    }
}

class Fitbyte { 
    private Fatpercent[] f;
    private Foodlog[] food;
    private Waterlog[] w;
    private Physical[] p;
    private Sleep[] s;
    int foodarraysize;
    int waterarraysize;
    int personarraysize;
    int physicalarraysize;
    int fatsize;
    int sleepsize;
    final int TEN = 10;

    Fitbyte(){
        f = new Fatpercent[TEN];
        food = new Foodlog[TEN];
        w= new Waterlog[TEN];
        p = new Physical[TEN];
        s = new Sleep[TEN];
        this.foodarraysize = 0;
        this.waterarraysize = 0;
        this.personarraysize = 0;
        this.physicalarraysize = 0;
        this.fatsize = 0;
        this.sleepsize = 0;

    }
    private void physicalresize() {
        p = Arrays.copyOf(p, 2 * physicalarraysize);
    }

    private void foodresize() {
        food = Arrays.copyOf(food, 2 * foodarraysize);
    }

    private void waterresize() {
        w = Arrays.copyOf(w, 2 * waterarraysize);
    }

    private void fatresize() {
        f = Arrays.copyOf(f, 2 * fatsize);
    }

    private void sleepresize() {
        s = Arrays.copyOf(s, 2 * sleepsize);
    }

    public void addFood(String item, int q, String dated) {
        Foodlog fd = new Foodlog(item, q, dated);
        if (foodarraysize == food.length) {
            foodresize();
        }
        food[foodarraysize++] = fd;
    }
    
    public void addWater(String qty) {
        Waterlog water = new Waterlog(qty);
        if (waterarraysize == w.length) {
            waterresize();
        }
        w[waterarraysize++] = water;
     }
     
    public void addPhysical(String activity, String s, String e, String d) {
        Physical ph = new Physical(activity, s, e, d);
        if (physicalarraysize == p.length) {
            physicalresize();
        }
        p[physicalarraysize++] = ph;
     }
    public void addFat(int wt) {
        Fatpercent fp = new Fatpercent(wt);
        if (fatsize == f.length) {
            fatresize();
        }
        f[fatsize++] = fp;
    }
    public void addSleep(String begin, String ended) {
        Sleep sl = new Sleep(begin, ended);
        if(sleepsize == s.length)  {
            sleepresize();
        }
        s[sleepsize++] = sl;
    }
    
    public void displayAll() {
        for (int i = 0; i < waterarraysize ; i++) {
            System.out.println(w[i].getWater());
        }

        for (int i = 0; i < foodarraysize; i++) {
            System.out.println(food[i].getFoodname() + " " + food[i].getQty() + " " + food[i].getDate());
        }

        for (int i = 0; i < physicalarraysize; i++) {
            System.out.println(p[i].getAct() + " " + p[i].getStart() + " " + p[i].getEnd() + " " + p[i].getDate());
        }

        for (int i = 0; i < fatsize; i++) {
            System.out.println(f[i].getWeight() + " " +  f[i].getFat());
        }

        for(int i = 0; i < sleepsize; i++) {
            System.out.println(s[i].getStart() + " " + s[i].getEnd());
        }
     }
}

class client {
    public static void main(String[] args) {
        Fitbyte ft = new Fitbyte();
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        while(s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch(tokens[0]) {
            case "addWater":
                ft.addWater(tokens[1]); 
            break;
            case "addPhysical":
                String[] temp = tokens[1].split(",");
                ft.addPhysical(temp[0], temp[1], temp[2], temp[3]);
            break;
            case "addFood":
                String[] line = tokens[1].split(",");
                ft.addFood(line[0], Integer.parseInt(line[1]), line[2]);
            break;
            case "addFat":
                ft.addFat(Integer.parseInt(tokens[1]));
            break;
            case "addSleep": 
                String[] temp2 = tokens[1].split(",");
                ft.addSleep(temp2[0], temp2[1]);
            break;
            case "display":
                ft.displayAll();
            break;
            default:
            break;                  
            }

        }
     }    
}

