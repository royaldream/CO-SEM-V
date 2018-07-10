import java.util.*;
import java.*;

class Practical_2_6{

 public static void main(String ard[])
 {
    Scanner s=new Scanner(System.in);

    //System.out.println(data);
    int a=0,b=0,f=0,d=0,e=0,k=1,aa,bb,ff,dd,ee;
    //System.out.println("Length is : "+l);
    aa=bb=ff=dd=ee=0;
    while(true)
    {
        String data=s.nextLine();
        data=data.toLowerCase();
        int l=data.length();
        for(int i=0;i<l;i++)
        {
            char c=data.charAt(i);
            if(c == 'a')
                a++;
            else if(c == 'e')
                b++;
            else if(c == 'i')
                f++;
            else if(c == 'o')
                d++;
            else if(c == 'u')
                e++;
        }
        int index=data.indexOf("quit");
        if(index!=-1)
            break;
        System.out.println("Line "+k+" vowels are \n a : "+a+"\n e : "+b+"\n i : "+f+"\n o : "+d+"\n u : "+e);
        aa+=a;bb+=b;ff+=f;dd+=d;ee+=e;
        a=b=f=d=e=0;k++;
    }
        System.out.println("Total vowels are \n a : "+aa+"\n e : "+bb+"\n i : "+ff+"\n o : "+dd+"\n u : "+ee);

 };

}
