import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for task.
 */

 /**Create a class named Task with its 6 properties. Add an overloaded constructor with the
parameters String title, String assignedTo, int timeToComplete, boolean important, boolean
urgent, String status. Also, add a toString method to display the Task object.
The first 3 test case files input000, input001, input002 must pass for the 2 marks to be awarded.
Main method is already provided and handles the input and output.*/
class Task {
	String title;
	String assignedTo;
	int timeToComplete;
	boolean important;
	boolean urgent;
	String status;
	
	Task(String t, String to, int time, boolean imp,
	     boolean u, String s) throws Exception {
		if (t == null || t.equals("")) throw new Exception("Title not provided"); // WRTING EXCEPTIONS FOR THE TITLE.
		if (!s.equals("todo") && !s.equals("done")) throw new Exception("Invalid status " + status);//WRITING THE EXCEPTION FOR TASK.
		if (time < 0) throw new Exception("Invalid timeToComplete " + time);
		this.title = t;
		this.assignedTo = to;
		this.timeToComplete = time;
		this.important = imp;
		this.urgent = u;
		this.status = s;
	}
	public String toString() {
		String a = "Not Important";
		String b = "Not Urgent";
		if(important) a = "Important";
		if(urgent) b = "Urgent";
		String display = title + ", " + assignedTo+", "+ timeToComplete+", "+ a+", "+ b+", "+status;
		return display;
	}
}