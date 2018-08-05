import java.lang.*;
import java.*;
import java.util.*;

class Wind{
/*
static long powerCal(float density,float area,float v,float ef)
{
	long power;
	//((((((1/2)*density)*areaA)*noofwindA)*Math.pow(v,3))*efA)
	power=(new Double((Math.pow(v,3))*ef)).longValue();
	power*=area;
	power*=density;
	power*=1/2;
	return power;
	
}*/
static float calArea(int r)
{
	return (3.14f*r*r);
}
static double min(double a,double b)
{
	if(a>b)
		return b;
	else
		return a;
	}
public static void main(String arg[])
{
		int rA,rB;
		long costA,costB;
		float efA,efB,v,density;
		long totalcost,area;
		float areaA,areaB;
		Scanner s=new Scanner(System.in);
		density=1.23f;
		System.out.print("Radius A :-");
		rA=s.nextInt();
		s.nextLine();
		System.out.print("COST A :- ");
		costA=s.nextLong();
		s.nextLine();
		System.out.print("Effi A :- ");
		efA=s.nextFloat();
		s.nextLine();
		
		System.out.print("Radius B :-");
		rB=s.nextInt();
		s.nextLine();
		System.out.print("COST B :- ");
		costB=s.nextLong();
		s.nextLine();
		System.out.print("Effi B :- ");
		efB=s.nextFloat();
		s.nextLine();
		
		System.out.print("Total Budget B :-");
		totalcost=s.nextLong();
		s.nextLine();
		System.out.print("Area  :- ");
		area=s.nextLong();
		s.nextLine();
		System.out.print("Wind Speed :- ");
		v=s.nextFloat();
		s.nextLine();
		/*rA=25;

		costA=40000;

		efA=0.56f;

		rB=35;

		costB=800000;

		efB=0.52f;

		totalcost=22000000;

		area=60000;

		v=11.5f;
		*/
		areaA=calArea(rA);
		areaB=calArea(rB);
		
		//System.out.println("Area A :-"+areaA);
		//System.out.println("Area B :-"+areaB);
		
		double powerA,powerB;
		double noofwindA,noofwindB;
		double noofwindAA=area/(2*rA*rA);
		double noofwindAB=area/(2*rB*rB);
		double noofwindCA=totalcost/costA;
		double noofwindCB=totalcost/costB;
		//areaA=areaB=1;
		powerA=((density*(areaA*(Math.pow(v,3)*efA)))/2)/1000000;
		//powerA=powerCal(density,areaA,v,efA);
		//powerB=powerCal(density,areaA,v,efA);
		powerB=((density*(areaB*(Math.pow(v,3)*efB)))/2)/1000000;
		//System.out.print("Power For A :-"+powerA+"\t\n"+noofwindAA+"\t\n"+noofwindCA+"\nPower For B :-"+powerB+"\t"+noofwindAB+"\t"+noofwindCB);
		noofwindA=min(noofwindAA,noofwindCA);
		noofwindB=min(noofwindAB,noofwindCB);
		
		double totalpowerA,totalpowerB;
		totalpowerA=noofwindA*powerA;
		totalpowerB=noofwindB*powerB;
		//System.out.println("A : "+(totalpowerA)+" B : "+totalpowerB);
		//System.out.println(Math.pow(v,3)+""+((((((1/2)*density)*areaA)*noofwindA)*Math.pow(v,3))*efA));
		if(totalpowerA>totalpowerB)
		{
			float areaNew;
			long costNew;
			areaNew=area-(2*rB*rB);
			costNew=totalcost-costB;
			noofwindAA=areaNew/(2*rA*rA);
			noofwindCA=costNew/costA;
			noofwindA=min(noofwindAA,noofwindCA);
			int noofwind=(int)noofwindA;
			totalpowerA=powerA*noofwind;
			totalpowerA+=powerB;
			System.out.println("A : "+(noofwind)+" B : 1"+"Actual Power is "+totalpowerA);
		}else
		{
			float areaNew;
			long costNew;
			areaNew=area-areaA;
			costNew=totalcost-costA;
			noofwindAA=areaNew/areaB;
			noofwindCA=costNew/costB;
			noofwindA=min(noofwindAB,noofwindCB);
			int noofwind=(int)noofwindB;
			totalpowerB=powerB*noofwind;
			totalpowerB+=powerA;
			System.out.println("A : 1"+" B : "+(noofwind)+" Actual Power is "+totalpowerB);
		}
	}	
}
