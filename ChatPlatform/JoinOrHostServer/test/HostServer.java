package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HostServer {

	public GridPane createGrid() throws UnknownHostException {
		GridPane grid = new GridPane();
		grid.add(new Label("Your ipadress: " + InetAddress.getLocalHost().getHostAddress()), 0, 0);
		grid.add(new Label("Your port: "), 0, 1);
		
		grid.add(hostButton(), 0, 2);

		return grid;
	}

	private Button hostButton() {
		Button hostButton = new Button("Host");
		hostButton.setOnAction(EventHandler -> {
			System.out.println("Functionality not implementet yet");
			hostButton.setText("Functionality not implementet yet");
		});
		
		return hostButton;
	}
}
