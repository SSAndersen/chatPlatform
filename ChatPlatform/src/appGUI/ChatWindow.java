package appGUI;

import java.util.Observable;
import java.util.Observer;

import accessClientSide.Client;
import accessServerSide.Server;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Stage implements Observer {
	GridPane chatGrid;
	Scene scene;
	TextArea messagesHistory;
	Client clientSide;

	public ChatWindow() {
		this.setTitle("Chat window");
		chatGrid = new GridPane();
		scene = new Scene(chatGrid);
		this.setScene(scene);

		serverSetup();

		this.start();
	}

	private void start() {
		chatGrid.add(chat(), 0, 0);

		this.show();
	}

	private VBox chat() {
		VBox chat = new VBox();
		messagesHistory = new TextArea();

		HBox messageSend = new HBox();
		TextArea sendTextArea = new TextArea();
		Button sendButton = new Button("Send");

		messageSend.getChildren().addAll(sendTextArea, sendButton);

		chat.getChildren().addAll(messagesHistory, messageSend);
		return chat;
	}

	private void serverSetup() {
		clientSide = new Client();
		Server serverSide = new Server();
		new Thread(serverSide).start();
		clientSide.addObserver(this);
		new Thread(clientSide).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Client) {
			String message = ((Client) o).getState();
			messagesHistory.appendText(message + "\n");
		} else if (o instanceof Server) {
		}
	}
}
