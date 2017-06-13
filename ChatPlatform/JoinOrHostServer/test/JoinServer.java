package test;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class JoinServer {
	TextField ipAdressText;
	TextField portText;
	
	public GridPane createGrid(TextField ipAdressText, TextField portText){
		this.ipAdressText = ipAdressText;
		this.portText = portText;
		
		GridPane grid = new GridPane();
		
		HBox ipAdressHBox = writeHboxCreator("Write ipadress: ", this.ipAdressText = new TextField());
		HBox portHBox = writeHboxCreator("Write portnr.: ", this.portText = new TextField());

		grid.add(ipAdressHBox, 0, 0);
		grid.add(portHBox, 0, 1);
		grid.add(joinButton(), 0, 2);
		
		return grid;
	}
	
	private HBox writeHboxCreator(String labelText, TextField textField) {
		HBox writeHBox = new HBox();
		Label label = new Label(labelText);

		writeHBox.getChildren().addAll(label, textField);

		return writeHBox;
	}

	private Button joinButton() {
		Button joinButton = new Button("Join");
		joinButton.setOnAction(EventHandler -> {
			String ipAdress = "Ipadress: " + ipAdressText.getText();
			String port = "Port: " + portText.getText();

			System.out.println(ipAdress);
			System.out.println(port);
		});
		return joinButton;
	}
}
