import java.util.*;
import java.lang.*;

class Practical_2_2
{
	public static void main(String arg[])
	{
		Scanner s=new Scanner(System.in);
		String data=s.nextLine();
		int l=data.length();
		System.out.println("Length is : "+l);
		for(int i=l/2;i<l;i++)
			System.out.print(data.charAt(i));
		//System.out.println(data.substring(l/2));	
	}
	
}
