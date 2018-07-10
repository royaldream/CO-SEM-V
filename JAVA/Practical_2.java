import java.util.Scanner;

class Math
{
	static double a, b;
	public static double add ()
	{
		return (a+b);
	}
	public static double subtract ()
	{
		return (a-b);
	}
	public static double divide ()
	{
		return (a/b);
	}
	public static double multiply ()
	{
		return (a*b);
	}
}

public class Practical_2
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner (System.in);
		Math m = new Math();
		System.out.println("Enter a : ");
		m.a = sc.nextDouble();
		System.out.println("Enter b : ");
		m.b = sc.nextDouble();
		System.out.println("Addition : "+m.add());
		System.out.println("Subtraction : "+m.subtract());
		System.out.println("Division : "+m.divide());
		System.out.println("Multiplication : "+m.multiply());
	}
}