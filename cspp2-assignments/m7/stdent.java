import java.util.*;
class student
{
	static void displaydetails(String names, String roll, int[] subjects)
	{
		System.out.println(names);
		System.out.println(roll);
		System.out.println((subjects[0]+subjects[1]+subjects[2])/3.0);
	}
	public static void main(String[] args) {
		System.out.println("Enter the student details");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		String rno = s.nextLine();
		int[] marks = new int[3];
		for(int i=0;i<3;i++)
		{
			marks[i] = s.nextInt();
		}
		student st = new student();
		st.displaydetails(name, rno, marks); 
	}
}