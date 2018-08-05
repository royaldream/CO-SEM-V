import java.lang.*;
import java.*;
import java.util.*;

class Wind1{
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
static float calArea(float r)
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
		float rA,rB;
		long costA,costB;
		float efA,efB,v,density;
		long totalcost,area;
		float areaA,areaB;
		Scanner s=new Scanner(System.in);
		density=1.23f;
		/*System.out.print("Radius A :-");
			rA=s.nextFloat();
		s.nextLine();
		System.out.print("COST A :- ");
		costA=s.nextLong();
		s.nextLine();
		System.out.print("Effi A :- ");
		efA=s.nextFloat();
		s.nextLine();
		
		System.out.print("Radius B :-");
			rB=s.nextFloat();
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
		s.nextLine();*/
		rA=39.5f;

		costA=30000;

		efA=0.52f;

		rB=37.5f;

		costB=32000;

		efB=0.59f;

		totalcost=225000;

		area=65500;

		v=11.5f;
		
		areaA=calArea(rA);
		areaB=calArea(rB);
		
	
		double powerA,powerB;
		double noofwindA,noofwindB;
		double noofwindAA=area/(2*rA*rA);
		double noofwindAB=area/(2*rB*rB);
		double noofwindCA=totalcost/costA;
		double noofwindCB=totalcost/costB;
		//areaA=areaB=1;
		powerA=((density*(areaA*(Math.pow(v,3)*efA)))/2)/1000000;
		powerB=((density*(areaB*(Math.pow(v,3)*efB)))/2)/1000000;
		noofwindA=min(noofwindAA,noofwindCA);
		noofwindB=min(noofwindAB,noofwindCB);
		double totalpowerA,totalpowerB;
		totalpowerA=noofwindA*powerA;
		totalpowerB=noofwindB*powerB;
		if(totalpowerA>totalpowerB)
		{
          	System.out.println(totalpowerA);
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
			System.out.println((noofwind)+"\n1"+"\n"+totalpowerA);
		}else
		{
          	System.out.println(totalpowerB);
			float areaNew;
			long costNew;
			areaNew=area-(2*rA*rA);
			costNew=totalcost-costA;
			noofwindAA=areaNew/(2*rB*rB);
			noofwindCA=costNew/costB;
			noofwindA=min(noofwindAB,noofwindCB);
			int noofwind=(int)noofwindB;
			totalpowerB=powerB*noofwind;
			totalpowerB+=powerA;
			System.out.println("1"+"\n"+(noofwind)+"\n"+totalpowerB);
		}
	}	
}
