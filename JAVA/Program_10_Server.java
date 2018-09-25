import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
class Server
{
	DataOutputStream out;
	DataInputStream in;
	ServerSocket serversocket;
	Socket socket;
	String line ;
	int port;
	Server(int port)
	{
		this.port=port;
		callServer();
	}
	void callServer()
	{
		try{
			
			serversocket=new ServerSocket(port);
			
			System.out.println("Server started"); 
            System.out.println("Waiting for a client ..."); 
  
            socket = serversocket.accept(); 
            System.out.println("Client accepted"+socket);
            
            out=new DataOutputStream(socket.getOutputStream());
            in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            out.writeUTF("Enter Radius");
            line= in.readUTF();
            //line= in.readUTF();
            while(!Objects.equals(line,"STOP"))
            {
				
				System.out.println(line+"");
				double area;
				try
				{
					int radius=Integer.parseInt(line);
					area=3.14*(radius*radius);
					out.writeUTF("Area is "+area);
					System.out.println("Area is "+area);
				}
				catch(NumberFormatException ex)
				{
					System.out.println("Enter Valid String.");
					out.writeUTF("Enter Valid String.");
				}catch(IOException e)
				{
					System.out.println(e);
				} 
				
				line= in.readUTF();
			}
			socket.close();
			System.out.println("Connection Closed!!!!!!");
            //out=new DataOutputStream();
		}
		catch(EOFException ex)
		{
			
		}catch(IOException e)
		{
			System.out.println(e);
		} 

	}
}
public class Program_10_Server
{
    public static void main(String arg[])
    {
        Server server=new Server(4444);

    }
}
