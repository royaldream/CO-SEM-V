import java.lang.*;
import java.util.*;

interface Shape
{

     void getdata();
     void putdata();
     void area();
}
class Rectangle implements Shape
{
    double area;
     double base;
     double height;
    Rectangle()
    {
        area=0.0;
    }
    @Override
    public void getdata()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Base :- ");
        base=s.nextDouble();
        s.nextLine();
        System.out.print("Enter Height :- ");
        height=s.nextDouble();
        s.nextLine();
    }
    @Override
    public void area()
    {
        area=base*height;
    }
    @Override
    public void putdata()
    {
        System.out.println("------------Rectangle------------");
        System.out.println("Base :- "+base);
        System.out.println("Height :- "+height);
        System.out.println("Area is :- "+area);
    }
}
class Circle implements Shape
{
    double radius;
    double PI=3.14;
    double area;
    Circle()
    {
        area=0.0;
    }
    @Override
    public void getdata()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Radius :- ");
        radius=s.nextDouble();
        s.nextLine();
    }
    @Override
    public void area()
    {
        area=PI*radius*radius;
    }
    @Override
    public void putdata()
    {
        System.out.println("------------Triangle------------");
        System.out.println("Radius :- "+radius);
        //System.out.println("Height :- "+height);
        System.out.println("Area is :- "+area);
    }
}
class Practical_4_4
{
    public static void main(String arg[])
    {
        Circle t=new Circle();
        Rectangle r=new Rectangle();
        System.out.println("Circle");
        t.getdata();
        t.area();
        t.putdata();
        System.out.println("Rectangle");
        r.getdata();
        r.area();
        r.putdata();
    };

}


