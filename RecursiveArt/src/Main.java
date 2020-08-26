import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		try{
			
			AnchorPane root = new AnchorPane();
			TextField splitNumberField = new TextField();
			ToggleGroup radioGroup = new ToggleGroup();
			RadioButton thirdsBaseFractionButton = new RadioButton("1/3");
			RadioButton fourthsBaseFractionButton = new RadioButton("1/4");
			RadioButton fifthsBaseFractionButton = new RadioButton("1/5");
			Button drawArt = new Button("Draw Art");
			Group rectGroup = new Group();
			thirdsBaseFractionButton.setToggleGroup(radioGroup);
			fourthsBaseFractionButton.setToggleGroup(radioGroup);
			fifthsBaseFractionButton.setToggleGroup(radioGroup);
			thirdsBaseFractionButton.setSelected(true);
			ToolBar options = new ToolBar(new Label("Level Of Subdivisions: "), 
					splitNumberField, 
					new Label("Base fraction: "),
					thirdsBaseFractionButton,
					fourthsBaseFractionButton,
					fifthsBaseFractionButton,
					drawArt);
			options.prefWidthProperty().bind(primaryStage.widthProperty());
			Label noInput = new Label("You did not specify the level of subdivisions!");
			Label notNumeric = new Label("Invalid input for level of subdivisions!");
			Label invalid = new Label("Invalid level of subdivisions!");
			Rectangle zeroSubdiv = new Rectangle();
			drawArt.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event){
					rectGroup.getChildren().clear();
					root.getChildren().remove(noInput);
					root.getChildren().remove(notNumeric);
					root.getChildren().remove(invalid);
					root.getChildren().remove(zeroSubdiv);
					if (splitNumberField.getText().isEmpty()) { 
						AnchorPane.setTopAnchor(noInput,320.0);
						AnchorPane.setLeftAnchor(noInput, 510.0);
						root.getChildren().add(noInput);
					} 
					else if (!splitNumberField.getText().chars().allMatch(Character::isDigit)) {
						AnchorPane.setTopAnchor(notNumeric,320.0);
						AnchorPane.setLeftAnchor(notNumeric, 510.0);
						root.getChildren().add(notNumeric);
					}
					else if (Integer.parseInt(splitNumberField.getText()) < 0) {
						AnchorPane.setTopAnchor(invalid,320.0);
						AnchorPane.setLeftAnchor(invalid, 510.0);
						root.getChildren().add(invalid);
					} else if (Integer.parseInt(splitNumberField.getText()) == 0) {
						zeroSubdiv.setWidth(1200);
						zeroSubdiv.setHeight(700);
						zeroSubdiv.setX(0);
						zeroSubdiv.setY(0);
						zeroSubdiv.setFill(Color.hsb((zeroSubdiv.getHeight()*zeroSubdiv.getWidth() % 361), 1, 1));
						AnchorPane.setTopAnchor(zeroSubdiv, 70.0);
						AnchorPane.setLeftAnchor(zeroSubdiv, 35.0);
						root.getChildren().add(zeroSubdiv);

					}
					
					else {
						
						int splitNumber = Integer.parseInt(splitNumberField.getText());
						double baseFraction = 0;
						if (thirdsBaseFractionButton.isSelected()) {
							 baseFraction = 1.0/3;
						} else if (fourthsBaseFractionButton.isSelected()) {
							 baseFraction = 1.0/4;
						} else {
							 baseFraction = 1.0/5;
						} 
						Rectangle base = new Rectangle();
						base.setWidth(1200);
						base.setHeight(700);
						RecursiveArt pane = new RecursiveArt(base,baseFraction,splitNumber);
						rectGroup.getChildren().addAll(pane.getArray());
						rectGroup.setClip(base);
						AnchorPane.setTopAnchor(rectGroup, 70.0);
						AnchorPane.setLeftAnchor(rectGroup, 35.0);

					}
					
				}
			});
			
			root.getChildren().add(rectGroup);
			root.getChildren().add(options);
			Scene scene = new Scene(root,1220,760);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
