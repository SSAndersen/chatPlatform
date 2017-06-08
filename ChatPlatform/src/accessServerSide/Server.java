package accessServerSide;

import java.io.*;
import java.net.*;
import java.util.Observable;

public class Server extends Observable implements Runnable {

	public void run() {
		ServerSocket serverSocket;
		try {
			Thread.sleep(1000);
			serverSocket = new ServerSocket(666);

			Socket socket = serverSocket.accept();
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String message = in.readLine();
			System.out.println(message);

			if (message != null) {
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				
				printStream.println(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
