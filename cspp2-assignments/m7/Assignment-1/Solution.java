import java.util.*;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	String str;
	public InputValidator(String str)
	{
		this.str=str;
	}
	public boolean validateData()
	{
		int len = str.length();
		if(len>=6)
			return true;
		else
			return false;
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}