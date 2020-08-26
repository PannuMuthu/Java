package application;
	
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Main extends Application {
	private double imageScale = 0.9;
	private File file;
	private BorderPane root = new BorderPane();
	private ImageView iv = null;
	private PPMImage image = null;
	   
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Button open = new Button("Open Image");
			open.setPrefWidth(92);
			Button reset = new Button("Reset Image");
			reset.setPrefWidth(94);
			Button vertical = new Button("Flip Vertically");
			Button horizontal = new Button("Flip Horizontally");
			Button grayscale = new Button("Grayscale");
			Button sepia = new Button("Sepia");
			Button negative = new Button("Negative");
			Button filterRed = new Button("Filter Red");
			Button filterGreen = new Button("Filter Green");
			Button filterBlue = new Button("Filter Blue");
			Label minLabel = new Label("Min Range");
			TextField filterMin = new TextField();
			filterMin.setPrefWidth(38);
			Label maxLabel = new Label("Max Range");
			TextField filterMax = new TextField();
			filterMax.setPrefWidth(38);
			Button filter = new Button("Filter");
			Button save = new Button("Save Image");
			ToolBar options = new ToolBar(
					open, reset, vertical, horizontal, grayscale, sepia, negative, filterRed, filterGreen, filterBlue, 
					minLabel,filterMin, maxLabel, filterMax,filter, save
					);
			
			
			FileChooser fileChooser = new FileChooser(); 
			open.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					configureFileChooser(fileChooser);
		            
	                file = fileChooser.showOpenDialog(primaryStage);
	            
	            if (file == null) {
	            	iv = null;
                	root.setCenter(new Label("No file selected!"));
	            }
	            else if (!(file.getName().substring((file.getName().length()-4), (file.getName().length())).equals(".ppm"))) {
	                	iv = null;
	                	root.setCenter(new Label("Invalid input file!"));
	             } else {
	                	displayImage(file);
	                    image = new PPMImage(file);
	             }
                    
				}
			});
			
			
			
			reset.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.resetImage();
					displayImage(image.temp); 
				}
			});
			
			horizontal.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.flipHorizontal();
					displayImage(image.temp); 
				}
			});
			
			vertical.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.flipVertical();
					displayImage(image.temp);
				}
			});
			
			grayscale.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.grayscale();
					displayImage(image.temp);
				}
			});
			
			sepia.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.sepia();
					displayImage(image.temp);
				}
			});
			
			negative.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.negative();
					displayImage(image.temp);
				}
			});
			
			filterBlue.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.resetImage();
					image.filterColors(160.0, 260.0);
					displayImage(image.temp);
				}
			});
			
			filterGreen.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					image.resetImage();
					image.filterColors(60.0, 130.0);
					displayImage(image.temp);
				}
			});
			
			filterRed.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					
					image.resetImage();
					image.filterRed();
					displayImage(image.temp);
				}
			});
			
			save.setOnAction(new EventHandler <ActionEvent>() {
				@Override 
				public void handle(ActionEvent e) {
						
						FileChooser fileChooserOut =  new FileChooser();
					
			            File file = fileChooserOut.showSaveDialog(primaryStage);
			 
			            if (!(file.getName().substring((file.getName().length()-4), (file.getName().length())).equals(".ppm"))) {
			            	iv = null;
			                root.setCenter(new Label("Invalid output file!"));
		                } else {
		                	image.writeImage(file);
			                iv = null;
			                root.setCenter(new Label("File successfully written."));
		                } 
			            
			           
				}
			});
			
			
			filter.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					String min = filterMin.getText();
					String max = filterMax.getText();
					if (Double.parseDouble(min) < 0 || Double.parseDouble(max) > 360 || Double.parseDouble(max) <= Double.parseDouble(min)) {
						iv = null;
						root.setCenter(new Label("Invalid parameters in filter fields!"));
					} else {
						image.resetImage();
						image.filterColors(Double.parseDouble(min), Double.parseDouble(max));
						displayImage(image.temp);
					}
					
				}
			});
			
			
	       
			root.setTop(options);
			
			Scene scene = new Scene(root,1300,800);
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
	
	private void displayImage(File file) {
		 try {
		     iv = new ImageView(SwingFXUtils.toFXImage(ImageIO.read(file), null));
		 } catch (IOException e) {
		     e.printStackTrace();
		 }
		 iv.preserveRatioProperty().setValue(true);
		 iv.setFitWidth(root.getWidth() * this.imageScale);
		 iv.setFitHeight(root.getHeight() * this.imageScale);
		 root.setCenter(iv);
	}
	
	 private static void configureFileChooser(final FileChooser fileChooser){                           
	        fileChooser.setTitle("Select Image");
	        fileChooser.setInitialDirectory(
	            new File(System.getProperty("user.home"))
	        ); 
	        
	    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PPM Files (*.ppm)", "*.ppm");
            fileChooser.getExtensionFilters().add(extFilter);
	    }
	
	
}
