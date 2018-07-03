import java.util.*;
import java.lang.*;
class Practical_2_5
{
	public static void main(String arg[])
	{
		Scanner s=new Scanner(System.in);
		String data=s.nextLine();
		int l=data.length();
		//System.out.println("Length is : "+(l%2));
		if((l%2)==0)
		{
			String data1=data.substring(l/2);
			String data2=data.substring(0,l/2);
			data2=new StringBuffer(data2).reverse().toString();
			if(data1.equals(data2))
				System.out.println("String is Palindrome");
			else
				System.out.println("String is Not Palindrome");
		}else
		{
			String data1=data.substring((l/2)+1);
			String data2=data.substring(0,(l/2));
			data2=new StringBuffer(data2).reverse().toString();
			if(data1.equals(data2))
				System.out.println("String is Palindrome");
			else
				System.out.println("String is Not Palindrome");
		}
	}
	
}
