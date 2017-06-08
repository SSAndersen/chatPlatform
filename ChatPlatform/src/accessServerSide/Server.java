package accessServerSide;

import java.io.*;
import java.net.*;

public class Server {
	
	public void run() throws Exception{
	ServerSocket serverSocket = new ServerSocket(666);
	Socket socket = serverSocket.accept();
	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
    
    
    String message = in.readLine();
    System.out.println(message);
    
    if(message != null){
    	PrintStream printStream = new PrintStream(socket.getOutputStream());
    	printStream.println("serverside --> Clintside");
    }
	
	}

}
