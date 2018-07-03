import java.util.*;
import java.lang.*;
class Practical_2_4
{
	
	public static void main(String arg[])
	{
		Scanner s=new Scanner(System.in);
		String data=s.nextLine();
		int a=0;
		if(Character.isUpperCase(data.charAt(0)))
			a++;
			int k=0;
		for(int i=1;i<data.length();i++)
		{
			char c=data.charAt(i);
			if( c == ' ')
			{
				k=i+1;
				c=data.charAt(k);
				if(Character.isUpperCase(c))
					a++;
			}
		}
		System.out.println("Word Are : "+a);
	}
}
