import java.util.*;

class Practical_2_1
{
	public static void main(String a[])
	{
		int b[]=new int[a.length];
		int n=a.length,temp;
		for(int i=0;i<n;i++)
			b[i]=Integer.parseInt(a[i]);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(b[i]<b[j])
				{
					temp=b[i];
					b[i]=b[j];
					b[j]=temp;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(b[i]);
			
	}
}
