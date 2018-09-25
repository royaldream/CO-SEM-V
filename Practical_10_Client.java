import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
class Client
{
	DataOutputStream out;
	DataInputStream in;
	String ipaddress;
	int port;
	Socket socket;
	String s;
	Client(String server,int port)
	{
		ipaddress=server;
		this.port=port;
		callServerandCreateSocket();
	}
	void callServerandCreateSocket()
	{
		try{
		socket=new Socket(ipaddress,port);
		System.out.println("connection succeded");
		
		in=new DataInputStream(socket.getInputStream());
		out=new DataOutputStream(socket.getOutputStream());
		String line = in.readUTF();
		System.out.println(line);
		try{
		while(true)
		{
		Scanner sc=new Scanner(System.in);
		s=sc.nextLine();
		out.writeUTF(s);
		String area = in.readUTF();
		System.out.println(area);
		}
		}
		catch(EOFException e)
		{
			System.out.println("Connection closed");
		}
		}
		catch(UnknownHostException e)
		{
			System.out.println(e);
		}
		catch(IOException u)
		{
			System.out.println(u);
		}
	}
		
}

class prac10
{
	public static void main(String args[])
	{
		Client client =new Client("172.16.1.139",4444);
	}
}
