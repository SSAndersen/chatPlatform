package accessClientSide;

import java.io.*;
import java.net.*;
import java.util.Observable;

public class Client extends Observable implements Runnable {
	private String message;
	public void run() {
		try {
			Thread.sleep(1000);
			Socket socket = new Socket("localhost", 666);
			PrintStream printstream = new PrintStream(socket.getOutputStream());
			printstream.println("Clientside --> Serverside");

			InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputReader);

			message = bufferedReader.readLine();
			System.out.println(message);
			setChanged();
			notifyObservers();
			
			Thread.sleep(500);
			
			printstream.println("nr 2");
			setChanged();
			notifyObservers();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getState(){
		return message;
	}


}
