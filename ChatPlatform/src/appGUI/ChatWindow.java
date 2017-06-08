package appGUI;

import accessServerSide.Server;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Stage {
	GridPane root;
	Scene scene;

	public ChatWindow() {
		this.setTitle("Chat window");
		root = new GridPane();
		scene = new Scene(root);
		this.setScene(scene);

//		Server serverSide = new Server();
//		Thread threadServer = new Thread(serverSide);
//
//		serverSide.start();

		this.start();
	}

	private void start() {
		root.add(chat(), 0, 0);

		this.show();
	}

	private VBox chat() {
		VBox chat = new VBox();
		TextArea messagesHistory = new TextArea();
		
		HBox messageSend = new HBox();
		TextArea sendTextArea = new TextArea();
		Button sendButton = new Button();
		
		messageSend.getChildren().addAll(sendTextArea, sendButton);
		
		
		chat.getChildren().addAll(messagesHistory, messageSend);
		return chat;
	}
}
