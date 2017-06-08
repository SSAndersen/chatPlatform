package appGUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Stage {
	Scene scene;
	GridPane grid;

	public MainMenu() {
		this.setTitle("Main menu");
		grid = new GridPane();
		scene = new Scene(grid);
		this.setScene(scene);
		start();
	}

	private void start() {
		grid.add(menuItems(), 0, 0);

		grid.setAlignment(Pos.TOP_CENTER);
		this.setMinHeight(300);
		this.setMinWidth(200);

		this.show();
	}

	private VBox menuItems() {
		VBox vbox = new VBox();
		Button chatButton = chatButton();

		vbox.getChildren().addAll(chatButton);
		return vbox;
	}

	private Button chatButton() {
		Button chatButton = new Button("Open Chat");
		chatButton.setOnAction(EventHandler -> {
			new ChatWindow();
			this.close();
		});

		return chatButton;

	}
}
