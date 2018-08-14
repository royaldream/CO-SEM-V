import java.lang.*;
import java.util.*;

class Shape
{
    double base ,height;
    Shape()
    {
        base=height=0.0;
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
    }
    void putdata()
    {
        System.out.println("Base :- "+base);
        System.out.println("Height :- "+height);
    }
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
        super.getdata();
        area=base*height;
    }
    void putdata()
    {
        System.out.println("------------Rectangle------------");
        super.putdata();
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
        super.getdata();
        area=0.5*base*height;
    }
    void putdata()
    {
        System.out.println("------------Triangle------------");
        super.putdata();
        System.out.println("Area is :- "+area);
    }
}
class Practical_4_2
{
    public static void main(String arg[])
    {
        Triangle t=new Triangle();
        Rectangle r=new Rectangle();
        System.out.println("Triangle");
        t.getdata();
        t.putdata();
        System.out.println("Ractangle");
        r.getdata();
        r.putdata();
    };

}
