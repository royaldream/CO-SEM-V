import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
class Client
{
    String ipaddress;
    int port;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Client(String server,int port)
    {
        this.ipaddress=server;
        this.port=port;
        callServerandCreateSocket();
    }
    void callServerandCreateSocket()
    {
		try{
				socket = new Socket(ipaddress,port);
				System.out.println("Connetion Succesfully!!!!!!!");
				in=new DataInputStream(System.in);
				out=new DataOutputStream(socket.getOutputStream());
				out.writeUTF("AAAAAAA");
			}
		catch(UnknownHostException u) 
			{ 
					System.out.println(u); 
			} 
		catch(IOException i) 
			{ 
					System.out.println(i); 
			} 
    }
    
};
public class Program_10
{
    public static void main(String arg[])
    {
        Client client=new Client("172.16.2.161",4444);

    }
}
