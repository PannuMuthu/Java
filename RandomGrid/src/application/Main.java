package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Button set = new Button("Generate Random");
		ToolBar input = new ToolBar(set);
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(15,15,15,15));
		set.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int row = 0; row < 10; row++) {
					for (int column = 0; column < 10; column++) {
						int random = (int)(Math.random()*2);
						TextField text = new TextField();
						if (random == 0) {
							text.setText("0");
						} else {
							text.setText("1");
						}
						pane.add(text, column, row);
					}
				}
			}
		});
		root.setTop(input);
		root.setCenter(pane);
		Scene scene = new Scene(root, 300, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}