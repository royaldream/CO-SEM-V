import java.util.*;
import java.*;
 class Student
{
    int roll_no;
    String name,address,branch;
    Student()
    {
        roll_no=0;
        name=address=branch=null;
    }
    Student(int roll_no,String name,String address,String branch)
    {
        this.roll_no=roll_no;
        this.name=name;
        this.address=address;
        this.branch=branch;

    }
    void showdata()
    {
        System.out.println(" Student Details\n Name : "+name+"\n Roll No. : "+roll_no+"\n Address. : "+address+"\n Branch. : "+branch);
    }
}
class Practical_3_1 {

 public static void main(String arg[])
 {
     Scanner s=new Scanner(System.in);
     System.out.println("Enter Number Of Student : ");
     int n=s.nextInt();
     s.nextLine();
     Student student[]=new Student[n];
     int roll_no;
     String name,address,branch;
        for(int i=0;i<n;i++)
        {
             System.out.println("Student Name : ");
             name=s.nextLine();
             System.out.println("Roll No : ");
             roll_no=s.nextInt();
             s.nextLine();
             System.out.println("Address : ");
             address=s.nextLine();
             System.out.println("Branch : ");
             branch=s.nextLine();
             student[i]=new Student(roll_no,name,address,branch);
             student[i].showdata();
        }
 }

}
