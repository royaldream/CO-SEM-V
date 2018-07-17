import java.util.*;
import java.*;

class Complex
{
    int real,img;
    Complex()
    {
        real=img=0;
    }
    Complex(int real,int img)
    {
        this.real=real;
        this.img=img;
    }
    void getNumber()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Complex Number By Real or Img Number :- ");
        real=s.nextInt();
        img=s.nextInt();
    }
    void addTwoNumber(Complex b,Complex a)
    {
        real=b.real+a.real;
        img=b.img+a.img;
    }
    void addTwoNumber(Complex a)
    {
        real=real+a.real;
        img=img+a.img;
    }
    void ShowData()
    {
        System.out.println("Complex Number is : "+real+" + "+img+"i \n");
    }
}
class Practical_3_2
{
     public static void main(String arg[])
     {
        Scanner s=new Scanner(System.in);

        Complex n1,n2,n3;
        n3=new Complex();
        n1=new Complex(10,20);
        n2=new Complex(10,20);
        n1.getNumber();
        n2.getNumber();
        n3.addTwoNumber(n1,n2);
        n1.addTwoNumber(n2);
        System.out.println("Passing Only One Object");
        n1.ShowData();
        System.out.println("Passing All Object");
        n3.ShowData();
     }
}
