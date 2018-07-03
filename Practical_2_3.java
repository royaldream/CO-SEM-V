import java.util.*;
import java.lang.*;
class Practical_2_3
{
	public static void main(String arg[])
	{
		Scanner s=new Scanner(System.in);
		String data=s.nextLine();
		int a=0,b=0;
		data=data.toLowerCase();
		data=data.trim();
		int l=data.length();
		System.out.println("Length is : "+l);
		for(int i=0;i<l;i++)
		{	
			char c=data.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				a++;
		}
			
		System.out.println("vowels is : "+a+" consonants is : "+(l-a));
	}
}
