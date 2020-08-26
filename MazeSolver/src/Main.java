import java.io.File;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application{
	private BorderPane root = new BorderPane();
	private GridPane previous = new GridPane();
	private MazeSolver mz;
	@Override
	public void start(Stage primaryStage) {
		try {
			Button load = new Button("Load Maze");
			Button solve = new Button("Solve Maze");
			Region r1 = new Region();
			Region r2 = new Region();
			Region r3 = new Region();
			HBox.setHgrow(r1, Priority.ALWAYS);
			HBox.setHgrow(r2, Priority.ALWAYS);
			HBox.setHgrow(r3, Priority.ALWAYS);
			r1.setPrefWidth(250);
			r2.setPrefWidth(450);
			r3.setPrefWidth(250);
			HBox options = new HBox(r1, load, r2, solve, r3);
			
			ScrollPane display = new ScrollPane(previous);
			display.setFitToHeight(true);
			display.setFitToWidth(true);
			
			Region r4 = new Region();
			Region r5 = new Region();
			Region r6 = new Region();
			Region r7 = new Region();
			Region r8 = new Region();
			Region r9 = new Region();
			HBox.setHgrow(r4, Priority.ALWAYS);
			HBox.setHgrow(r5, Priority.ALWAYS);
			HBox.setHgrow(r6, Priority.ALWAYS);
			HBox.setHgrow(r7, Priority.ALWAYS);
			HBox.setHgrow(r8, Priority.ALWAYS);
			HBox.setHgrow(r9, Priority.ALWAYS);
			r4.setPrefWidth(100);
			r5.setPrefWidth(100);
			r6.setPrefWidth(100);
			r7.setPrefWidth(100);
			r8.setPrefWidth(100);
			r9.setPrefWidth(100);
			Label wall = new Label("Wall - ");
			Label path = new Label("Possible Path - ");
			Label correct = new Label("Correct Path - ");
			Label backtrack = new Label("Backtracked Path - ");
			Label startEnd = new Label("Start/End - ");
			Rectangle wallRect = new Rectangle(20,20);
			wallRect.setFill(Color.RED);
			wallRect.setStroke(Color.BLACK);
			Rectangle pathRect = new Rectangle(20,20);
			pathRect.setFill(Color.LIGHTGOLDENRODYELLOW);
			pathRect.setStroke(Color.BLACK);
			Rectangle correctRect = new Rectangle(20,20);
			correctRect.setFill(Color.LIMEGREEN);
			correctRect.setStroke(Color.BLACK);
			Rectangle backtrackRect = new Rectangle(20,20);
			backtrackRect.setFill(Color.ORANGE);
			backtrackRect.setStroke(Color.BLACK);
			Rectangle startEndRect = new Rectangle(20,20);
			startEndRect.setFill(Color.LIGHTSKYBLUE);
			startEndRect.setStroke(Color.BLACK);
			HBox legend = new HBox(r4,wall,wallRect,r5,path,pathRect,r6,correct,correctRect,r7,backtrack,backtrackRect,r8,startEnd, startEndRect,r9);

			FileChooser fileChooser = new FileChooser();
			load.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event){
					configureFileChooser(fileChooser);
		            
	                File file = fileChooser.showOpenDialog(primaryStage);
	                
	                if (file == null) {
	                	root.setCenter(new Label("No file selected!"));
	                } else {
	                	
	                	previous.getChildren().clear();
	                	mz = new MazeSolver(file);
	                	if (mz.unreadable()) {
	                		root.setCenter(new Label("Unreadable file!"));
	                	} else {
	                		previous.setHgap(10);
		                    previous.setVgap(10);
		                    previous.setPadding(new Insets(10, 10, 10, 10));
		                    previous.prefWidthProperty().bind(primaryStage.widthProperty());
		                    previous.prefHeightProperty().bind(primaryStage.heightProperty());


		                    ColumnConstraints cc = new ColumnConstraints();
		                    cc.setFillWidth(true);
		                    cc.setHgrow(Priority.ALWAYS);

		                    for (int i = 0; i < mz.getWidth(); i++) {
		                       previous.getColumnConstraints().add(cc);
		                    }

		                    RowConstraints rc = new RowConstraints();
		                    rc.setFillHeight(true);
		                    rc.setVgrow(Priority.ALWAYS);

		                    for (int i = 0; i < mz.getHeight(); i++) {
		                        previous.getRowConstraints().add(rc);
		                    }
		                    
		                	for (int i = 0; i < mz.getHeight(); i++) {
		                		for (int j = 0; j < mz.getWidth(); j++) {
		                			HBox box = new HBox();
		                			Text element = new Text(mz.getMaze()[i][j]);
		                			if (mz.getMaze()[i][j].equals("1")) {
		                				 box.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		                			} else if (mz.getMaze()[i][j].equals("0")) {
		                				 box.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		                			} else if (mz.getMaze()[i][j].equals("S") || mz.getMaze()[i][j].equals("E")) {
		                				 box.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		                			}
		                			box.setAlignment(Pos.CENTER);
		                			box.getChildren().add(element);
		                			previous.add(box, j, i);
		                			previous.setMaxWidth(500);
		                			previous.setMaxHeight(500);
		                		}
		                	}
		                	
		                	root.setCenter(display);
	                	}
	                
	                	
	                }
				}
				});
			
			solve.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event){ 
					mz.solve();
					if (!mz.solved()) {
						root.setCenter(new Label("Unsolvable Maze!"));
					} else {
						for (int i = 0; i < mz.getHeight(); i++) {
	                		for (int j = 0; j < mz.getWidth(); j++) {
	                			HBox box = new HBox();
	                			Text element = new Text(mz.getMaze()[i][j]);
	                			if (mz.getMaze()[i][j].equals("1")) {
	                				 box.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
	                			} else if (mz.getMaze()[i][j].equals("0")) {
	                				 box.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
	                			} else if (mz.getMaze()[i][j].equals("S") || mz.getMaze()[i][j].equals("E")) {
	                				 box.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
	                			} else if (mz.getMaze()[i][j].equals("X")) {
	                				 box.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	                			} else if (mz.getMaze()[i][j].equals("B")) {
	                				 box.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
	                			}
	                			box.setAlignment(Pos.CENTER);
	                			box.getChildren().add(element);
	                			previous.add(box, j, i);
	                			previous.setMaxWidth(500);
	                			previous.setMaxHeight(500);
	                		}
	                	}
	                	
	                	root.setCenter(display);
					}
					
				}
				});
			root.setTop(options);
			root.setCenter(display);
			root.setBottom(legend);
			Scene scene = new Scene(root,1200,700);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	 private static void configureFileChooser(final FileChooser fileChooser){                           
	        fileChooser.setTitle("Select Image");
	        fileChooser.setInitialDirectory(
	            new File(System.getProperty("user.home"))
	        ); 
	        
	    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT Files (*.txt)", "*.txt");
         fileChooser.getExtensionFilters().add(extFilter);
	    }
	
}
