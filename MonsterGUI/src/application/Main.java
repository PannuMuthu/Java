package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Main extends Application {
	public static BorderPane root = new BorderPane();
	public static VBox mainMenu = new VBox();
	public static Label title = new Label("Attack Monitor");
	@Override
	public void start(Stage primaryStage) {
		try {
			AttackMonitor monitor = new AttackMonitor();
			Button report = new Button("Report a new attack");
			report.setPrefWidth(250);
			Button show = new Button("View all attacks");
			show.setPrefWidth(250);
			Button showMonsters = new Button("View attacks by each monster");
			showMonsters.setPrefWidth(250);
			Button showDamage = new Button("View damage statistics");
			showDamage.setPrefWidth(250);
			Button showEarliest = new Button("View earliest attack");
			showEarliest.setPrefWidth(250);
			Button saveToFile = new Button("Save attacks to file");
			saveToFile.setPrefWidth(250);
			Button readFromFile = new Button("Read attacks from file");
			readFromFile.setPrefWidth(250);
			Button quit = new Button("Quit");
			quit.setPrefWidth(250);
			mainMenu.setSpacing(5);
			mainMenu.setAlignment(Pos.TOP_CENTER);
			mainMenu.getChildren().addAll(report,
					show,
					showMonsters,
					showDamage,
					showEarliest,
					saveToFile,
					readFromFile,
					quit);
			
			report.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.reportAttack();
				}
			});
			
			show.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.showAttack();
				}
			});
			
			showDamage.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.showDamages();
				}
			});
			
			showEarliest.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.findEarliestAttack();
				}
			});
			
			showMonsters.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.showMonsters();
				}
			});
			
			saveToFile.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.saveToFile();
				}
			});
			
			readFromFile.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					monitor.readFromFile();
				}
			});
			
			quit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(1);
				}
			});
			
			title.setPadding(new Insets(50,15,15,15));
			title.setFont(new Font("Cambria", 30));
			
			
			
			root.setTop(title);
			BorderPane.setAlignment(title, Pos.CENTER);
			root.setCenter(mainMenu);
			Scene scene = new Scene(root,600,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
