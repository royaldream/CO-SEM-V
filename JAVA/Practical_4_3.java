import java.lang.*;
import java.util.*;

abstract class Shape
{
    double base ,height;
    Shape()
    {
        base=height=0.0;
    }
    abstract void getdata();
    abstract void area();
    abstract void putdata();
}
class Rectangle extends Shape
{
    double area;
    Rectangle()
    {
        area=0.0;
    }
    void getdata()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Base :- ");
        base=s.nextDouble();
        s.nextLine();
        System.out.print("Enter Height :- ");
        height=s.nextDouble();
        s.nextLine();
        //super.getdata();
        area();
    }
    void area()
    {
        area=base*height;
    }
    void putdata()
    {
        System.out.println("------------Rectangle------------");
        System.out.println("Base :- "+base);
        System.out.println("Height :- "+height);
        System.out.println("Area is :- "+area);
    }
}
class Triangle extends Shape
{

    double area;
    Triangle()
    {
        area=0.0;
    }
    void getdata()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Base :- ");
        base=s.nextDouble();
        s.nextLine();
        System.out.print("Enter Height :- ");
        height=s.nextDouble();
        s.nextLine();
        area();
    }
    void area()
    {
        area=0.5*base*height;
    }
    void putdata()
    {
        System.out.println("------------Triangle------------");
        System.out.println("Base :- "+base);
        System.out.println("Height :- "+height);
        System.out.println("Area is :- "+area);
    }
}
class Practical_4_3
{
    public static void main(String arg[])
    {
        Shape t=new Triangle();
        Shape r=new Rectangle();
        System.out.println("Triangle");
        t.getdata();
        t.putdata();
        System.out.println("Rectangle");
        r.getdata();
        r.putdata();
    };

}

