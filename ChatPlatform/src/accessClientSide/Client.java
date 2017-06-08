package accessClientSide;

import java.io.*;
import java.net.*;

public class Client implements Runnable {
	public void run() {
		try {
			Socket socket = new Socket("localhost", 666);
			PrintStream printstream = new PrintStream(socket.getOutputStream());
			printstream.println("Clientside --> Serverside");

			InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputReader);

			String message = bufferedReader.readLine();
			System.out.println(message);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
