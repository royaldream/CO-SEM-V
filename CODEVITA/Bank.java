import java.lang.*;
import java.*;
import java.util.*;

class Bank{

public static void main(String arg[])
{
	long amount;
	int tenure,slab1,slab2;
	Scanner s=new Scanner(System.in);
	
	amount=s.nextLong();
	s.nextLine();
	tenure=s.nextInt();
	s.nextLine();
	System.out.println("Bank 1");
	slab1=s.nextInt();
	
	int sy1[]=new int[slab1];
	float sr1[]=new float[slab1];
	for(int i=0;i<slab1;i++)
	{
		//s.nextLine();
		sy1[i]=s.nextInt();
		sr1[i]=s.nextFloat();
	}
	s.nextLine();
	System.out.println("Bank 2");
	slab2=s.nextInt();
	
	int sy2[]=new int[slab2];
	float sr2[]=new float[slab2];
	for(int i=0;i<slab1;i++)
	{
		s.nextLine();
		sy2[i]=s.nextInt();
		sr2[i]=s.nextFloat();
	}
	
	float EMI;
	int y1=0,y2=0;
	long t1=0,t2=0;
	
	for(int i=0;i<slab1;i++)
	{
		int year=sy1[i]*12;
		float rate=(1+(sr1[1]/12));
		EMI=(float)((amount*(sr1[i]/12))/(1-(1/Math.pow(rate,year))));
		System.out.println(EMI);
		t1+=(EMI*year);
		y1+=sy1[i];
		
	}
	System.out.println(t1);
	
	for(int i=0;i<slab2;i++)
	{
		int year=sy2[i]*12;
		float rate=(1+(sr2[1]/12));
		EMI=(float)((amount*(sr2[i]/12))/(1-(1/Math.pow(rate,year))));
		System.out.println(EMI);
		t2+=(EMI*year);
		y2+=sy2[i];
		
	}
	System.out.println(t2);
	if(t1>t2)
	{
		System.out.println("Bank B");
	}
	else if(t1<t2)
	{
		System.out.println("Bank A");
	}
}

}
