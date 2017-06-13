package test;

import java.net.UnknownHostException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JoinOrHostServer extends Stage {
	Scene scene;
	GridPane grid;
	TextField ipAdressText;
	TextField portText;
	Boolean isHostMenuOpen = false;
	GridPane hostServerGrid = new GridPane();

	public JoinOrHostServer() {
		this.setTitle("Join or host server");
		scene = new Scene(createGrid());
		this.setScene(scene);

		start();
	}

	private void start() {
		this.sizeToScene();
		this.show();
	}

	private GridPane createGrid() {
		ipAdressText = new TextField();
		portText = new TextField();
		GridPane joinServerGrid = new JoinServer().createGrid(ipAdressText, portText);

		grid = new GridPane();
		grid.add(joinServerGrid, 0, 0);
		grid.add(openHostMenuButton(), 0, 2);

		return grid;
	}

	private Button openHostMenuButton() {
		Button hostButton = new Button("Open host menu");
		hostButton.setOnAction(EventHandler -> {
			if (!isHostMenuOpen) {
				hostButton.setText("Close host menu");
				isHostMenuOpen = true;

				try {
					hostServerGrid = new HostServer().createGrid();
				} catch (UnknownHostException e) {
					System.out.println("couldn't find ipadress");
					e.printStackTrace();
				}

				grid.add(hostServerGrid, 0, 1);
				this.sizeToScene();
			} else {
				hostButton.setText("Open host menu");
				isHostMenuOpen = false;
				grid.getChildren().remove(hostServerGrid);
				this.sizeToScene();
			}
		});

		return hostButton;
	}
}
