import java.util.*;
import java.*;

class Player
{
    int age;
    String name,nationality,typePlayer;
    Player()
    {
        age=0;
        name=nationality=typePlayer=null;
    }
    void getData()
    {
        Scanner s=new Scanner(System.in);
        name=s.nextLine();
        age=s.nextInt();
        s.nextLine();
        typePlayer=s.nextLine();
        if(typePlayer.equals("cricket")||typePlayer.equals("Cricket"))
            typePlayer="cricket";
        nationality=s.nextLine();
    }
    void showData()
    {
        System.out.println("---------------------Player-------------------\nName : "+name+"\nAge : "+age+"\nType : "+typePlayer+"\nNationality : "+nationality);
    }
}
class CricketPlayer extends Player
{
    String type;
    void getData()
    {
        super.getData();
        if((super.typePlayer).equals("cricket"))
            {
                System.out.println("Type Cricket Player (1-Batsman,2-Bowler): ");
                Scanner s=new Scanner(System.in);
                int ch;
                ch=s.nextInt();
                s.nextLine();
                if(ch==1)
                    type="batsman";
                else if(ch==2)
                    type="bowler";
                else
                    System.out.println("Wrong Choice");
            }
    }
    void showData()
    {
        super.showData();
        if((super.typePlayer).equals("cricket"))
            System.out.println("\nType Cricket Player : "+type);
    }
}
class Batsman extends CricketPlayer
{
    int nomatch,runs;
    void getData()
    {
        super.getData();
        if((super.type).equals("batsman"))
        {
            Scanner s=new Scanner(System.in);
            System.out.println("No of Match :- ");
            nomatch=s.nextInt();
            s.nextLine();
            System.out.println("Runs :- ");
            runs=s.nextInt();
            s.nextLine();
        }
    }
    void showData()
    {
        super.showData();
        if((super.type).equals("batsman"))
            System.out.println("No of Match : "+nomatch+"\nRuns : "+runs);
    }
}
class Bowler extends CricketPlayer
{
    int noover,wickets;
    void getData()
    {
        super.getData();
        if((super.type).equals("bowler"))
        {
            Scanner s=new Scanner(System.in);
            System.out.println("No of Over :- ");
            noover=s.nextInt();
            s.nextLine();
            System.out.println("Wickets :- ");
            wickets=s.nextInt();
            s.nextLine();
        }
    }
    void showData()
    {
        super.showData();
        if((super.type).equals("bowler"))
            System.out.println("No of Match : "+noover+"\nRuns : "+wickets);
    }
}

class Practical_4_1
{
    public static void main(String arg[])
    {
        Batsman player1=new Batsman();
        Bowler player2=new Bowler();
        int ch;
        Scanner s=new Scanner(System.in);
        System.out.println("Menu\n1:Batsman\n2:Bowler\n0:Exit\n");
        ch=s.nextInt();
        while(true)
        {
            if(ch==1)
            {
                player1.getData();
                player1.showData();
            }
            else if(ch==2)
            {
                player2.getData();
                player2.showData();
            }
            else if(ch==0)
                break;
            else
                System.out.println("Wrong Choice");
            System.out.println("Menu\n1:Batsman\n2:Bowler\n0:Exit\n");
            ch=s.nextInt();
        }
    }
}
