package accessClientSide;
import java.io.*;
import java.net.*;

public class Client {
	public void run() throws Exception{
	Socket socket = new Socket("localhost", 666);
	PrintStream printstream = new PrintStream(socket.getOutputStream());
	printstream.println("Clientside --> Serverside");
	
	InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
	BufferedReader bufferedReader = new BufferedReader(inputReader);
	
	String message = bufferedReader.readLine();
	System.out.println(message);
	}
	

}
