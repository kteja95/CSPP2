import java.util.*;
class concatinate
{
	public static void main(String[] args) {
		String s = "Hello ";
		System.out.println("Enter a string");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println(s.concat(name));
	}
}