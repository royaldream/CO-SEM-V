import java.util.Scanner;

class StudentMarks
{
	static int[] mark = new int[6];
	static char grade;
	static float per;
	public static void calculate()
	{
		int total=0;
		for (int i=0; i<6; i++)
			total += mark[i];
		per = (float) total/6;
		if (per > 85.0f)
			grade = 'A';
		else if (per > 75.0f)
			grade = 'B';
		else if (per > 65.0f)
			grade = 'C';
		else if (per > 50.0f)
			grade = 'D';
		else if (per > 35.0f)
			grade = 'E';
		else
			grade = 'F';
	}
	public static void display()
	{
		System.out.println("Percentage : "+per+"%");
		System.out.println("Grade : "+grade);
	}
}
public class Practical_1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StudentMarks st = new StudentMarks();
		System.out.print("Enter Marks of 6 Subjects : ");
		for (int i=0; i<6; i++) 
			st.mark[i] = sc.nextInt();
		st.calculate();
		st.display();
	}
}