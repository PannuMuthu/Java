package application;
import java.util.Scanner;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.Date;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Locale;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AttackMonitor {
	Scanner input = new Scanner(System.in); 
	ArrayList<MonsterAttack> attacks = new ArrayList<>();
	private MonsterAttack in;
	 
	public void reportAttack() {
			TextField name = new TextField();
			name.setMinWidth(265);
			TextField location = new TextField();
			location.setMinWidth(262);
			TextField date = new TextField();
			date.setMinWidth(193);
			TextField damages = new TextField();
			Button submit = new Button("Submit");
			Button goBack = new Button("Return to Main Menu");
			HBox nameField = new HBox(
					new Label("Enter monster name:"),
					name
					);
			nameField.setPrefWidth(300);
			HBox locField = new HBox(
					new Label("Enter attack location:"),
					location
					);
			locField.setPrefWidth(300);
			HBox dateField = new HBox(
					new Label("Enter attack date(mm/dd/yyyy): "),
					date
					);
			dateField.setPrefWidth(300);
			HBox damageField = new HBox(
					new Label("Enter damage cost (in millions USD):"),
					damages);
			damageField.setPrefWidth(300);
			VBox packed = new VBox(nameField,locField,dateField,damageField,submit,goBack);
			packed.setSpacing(5);
			Main.root.setCenter(packed);
			Main.root.setTop(new Label(""));
			packed.setAlignment(Pos.CENTER);
			packed.setPadding(new Insets(100));
			goBack.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Main.root.setCenter(Main.mainMenu);
					Main.root.setTop(Main.title);
				}
			});
			submit.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					double damageParsed = Double.parseDouble(damages.getText());
					DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
					Date dateParsed = null;
					try {
						dateParsed = format.parse(date.getText());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					MonsterAttack in = new MonsterAttack(name.getText(),location.getText(),damageParsed,dateParsed);
					attacks.add(in);
					Button success = new Button("Continue");
					Main.root.setCenter(new Label("The attack was successfully recorded!"));
					Main.root.setBottom(success);
					BorderPane.setAlignment(success, Pos.BOTTOM_CENTER);
					BorderPane.setMargin(success, new Insets(0,0,100,0));
					success.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Main.root.setBottom(new Label(""));
							Main.root.setCenter(Main.mainMenu);
							Main.root.setTop(Main.title);
						}
					});
				}
			});
			
			 
	}
	
	public void showAttack() { 
		TableView tableView = new TableView();
		TableColumn<String, MonsterAttack> nameCol = new TableColumn<>("Monster Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("monsterName"));
		nameCol.setPrefWidth(130);
		nameCol.setResizable(false);
		TableColumn<String, MonsterAttack> locCol = new TableColumn<>("Attack Location");
		locCol.setCellValueFactory(new PropertyValueFactory<>("monsterLocation"));
		locCol.setPrefWidth(128);
		locCol.setResizable(false);
		TableColumn<Date, MonsterAttack> dateCol = new TableColumn<>("Attack Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("dateToString"));
		dateCol.setPrefWidth(130);
		dateCol.setResizable(false);
		TableColumn<Double, MonsterAttack> damageCol = new TableColumn<>("Attack Damages in Millions USD");
		damageCol.setCellValueFactory(new PropertyValueFactory<>("monsterDamage"));
		damageCol.setPrefWidth(210);
		damageCol.setResizable(false);
		tableView.getColumns().addAll(nameCol,locCol,dateCol,damageCol);
		for (int i=0; i<attacks.size(); i++) {
			tableView.getItems().add(attacks.get(i));
		}
		VBox tableBox = new VBox(tableView);
		Button goBack = new Button("Return to Main Menu");
		goBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main.root.setCenter(Main.mainMenu);
				Main.root.setTop(Main.title);
				Main.root.setBottom(new Label(""));
			}
		});
		Main.root.setTop(new Label(""));
		Main.root.setCenter(tableBox);
		Main.root.setBottom(goBack);
		BorderPane.setAlignment(goBack, Pos.BOTTOM_CENTER);
		
	}
	
	public void showDamages() {	
		Button goBack = new Button("Return to Main Menu");
		BorderPane.setAlignment(goBack, Pos.BOTTOM_CENTER);
		goBack.setPadding(new Insets(10));
		BorderPane.setMargin(goBack, new Insets(30));
		double totalDamages = 0;
		for (int i = 0; i < attacks.size(); i++) {
			totalDamages += attacks.get(i).getMonsterDamage();
		}
		double meanDamage = totalDamages/attacks.size();
		Label totalLabel = new Label("Total Damages in Millions USD: " + totalDamages);
		totalLabel.setPrefWidth(350);
		totalLabel.setFont(new Font("Cambria", 15));
		Label meanLabel = new Label("Mean Damage in Millions USD: " + meanDamage);
		meanLabel.setPrefWidth(350);
		meanLabel.setFont(new Font("Cambria", 15));
		VBox damages = new VBox(totalLabel, meanLabel);
		damages.setPadding(new Insets(0,0,0,30));
		damages.setAlignment(Pos.CENTER);
		Main.root.setTop(new Label(""));
		Main.root.setCenter(damages);
		Main.root.setBottom(goBack);
		goBack.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle(ActionEvent event) {
				Main.root.setTop(Main.title);
				Main.root.setBottom(new Label(""));
				Main.root.setCenter(Main.mainMenu);
			}
			
		});
		
	}
	
	public void showMonsters() {
		Button goBack = new Button("Return to Main Menu");
		BorderPane.setAlignment(goBack, Pos.BOTTOM_CENTER);
		goBack.setPadding(new Insets(10));
		BorderPane.setMargin(goBack, new Insets(30));
		VBox monsterBox = new VBox();
		ArrayList<Boolean> visited = new ArrayList<Boolean>(); 
	    for (int index = 0; index < attacks.size(); index++) {
	    	visited.add(false);
	    }
	   
	    for (int i = 0; i < attacks.size(); i++) { 
	        if (visited.get(i) == true) 
	            continue; 
	        
	        int count = 1; 
	        for (int j = i + 1; j < attacks.size(); j++) { 
	            if (attacks.get(i).getMonsterName().equals(attacks.get(j).getMonsterName())) { 
	                visited.set(j, true); 
	                count++; 
	            } 
	        } 
	        Label unique = new Label(attacks.get(i).getMonsterName() + ": " + count + " attack(s)");
	        unique.setFont(new Font("Cambria", 15));
	        monsterBox.getChildren().add(unique);
	    }
	    monsterBox.setAlignment(Pos.CENTER);
	    Main.root.setTop(new Label(""));
	    Main.root.setCenter(monsterBox);
	    Main.root.setBottom(goBack);
		goBack.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle(ActionEvent event) {
				Main.root.setTop(Main.title);
				Main.root.setBottom(new Label(""));
				Main.root.setCenter(Main.mainMenu);
			}
			
		});
	}
	
	public void findEarliestAttack() {
		Button goBack = new Button("Return to Main Menu");
		BorderPane.setAlignment(goBack, Pos.BOTTOM_CENTER);
		goBack.setPadding(new Insets(10));
		BorderPane.setMargin(goBack, new Insets(30));
		ArrayList<Date> dates = new ArrayList<Date>(); 
		Date min = new Date();
		int index = 0;
		for (int i = 0; i < attacks.size(); i++) {
			dates.add(attacks.get(i).getMonsterDate());
		}
		for (int j = 0; j < dates.size(); j++) {
			if (dates.get(j).before(min)) {
				min = dates.get(j);
				index = j;
			}
		}
		Label earlyName = new Label("Monster Name: " + attacks.get(index).getMonsterName());
		Label earlyLoc = new Label("Attack Location: " + attacks.get(index).getMonsterLocation());
		Label earlyDate = new Label("Attack Date: " + attacks.get(index).getMonsterDate());
		Label earlyDamage = new Label("Damages in Million USD: " + attacks.get(index).getMonsterDamage());
		VBox earliest = new VBox(earlyName,earlyLoc,earlyDate,earlyDamage);
		earliest.setAlignment(Pos.CENTER);
		Main.root.setCenter(earliest);
		Main.root.setTop(new Label(""));
		Main.root.setBottom(goBack);
		goBack.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle(ActionEvent event) {
				Main.root.setTop(Main.title);
				Main.root.setBottom(new Label(""));
				Main.root.setCenter(Main.mainMenu);
			}
			
		});

	}
	
	public void saveToFile() {
		Button goBack = new Button("Return to Main Menu");
		BorderPane.setAlignment(goBack, Pos.BOTTOM_CENTER);
		goBack.setPadding(new Insets(10));
		BorderPane.setMargin(goBack, new Insets(30));
		Label instructions = new Label("What is the complete intended filepath of the file? (Ex: ~/User/Desktop/attacks.txt) ");
		instructions.setPadding(new Insets(0,0,0,8));
		TextField filePath = new TextField();
		filePath.setMaxWidth(350);
		Button submit = new Button("Save to CSV File");
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					PrintWriter output = new PrintWriter(filePath.getText());
					for (int i = 0; i< attacks.size(); i++) {
						output.print(attacks.get(i).getMonsterName() + ",");
						output.print(attacks.get(i).getMonsterLocation() + ",");
						output.print(attacks.get(i).getDateToString() + ",");
						output.print(attacks.get(i).getMonsterDamage());
						output.println();
					}
					output.close();
					Button success = new Button("Continue");
					Main.root.setCenter(new Label("The data was successfully obtained!"));
					Main.root.setBottom(success);
					success.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event) {
							Main.root.setTop(Main.title);
							Main.root.setCenter(Main.mainMenu);
							Main.root.setBottom(new Label(""));
						}
						
					});
				} catch (FileNotFoundException e) {
					Label error = new Label("Invalid file path format (Tips: do not add extension to file name, and add the final / after your file path)");
					Button tryAgain = new Button("Try Again");
					VBox errorBox = new VBox(error,tryAgain);
					errorBox.setAlignment(Pos.CENTER);
					Main.root.setCenter(errorBox);
				}
			}
			
		});
		VBox saveBox = new VBox(instructions,filePath,submit);
		saveBox.setAlignment(Pos.CENTER);
		Main.root.setCenter(saveBox);
		Main.root.setTop(new Label(""));
		Main.root.setBottom(goBack);
		goBack.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle(ActionEvent event) {
				Main.root.setTop(Main.title);
				Main.root.setBottom(new Label(""));
				Main.root.setCenter(Main.mainMenu);
			}
			
		});
	}
	
	public void readFromFile() {
		Button goBack = new Button("Return to Main Menu");
		BorderPane.setAlignment(goBack, Pos.BOTTOM_CENTER);
		goBack.setPadding(new Insets(10));
		BorderPane.setMargin(goBack, new Insets(30));
		Label instructions = new Label("Please enter the complete filepath of the source file. For example, if your file is named ");
		Label inst2 = new Label("attacks.csv and located on your desktop, then type '~/User/Desktop/attacks.csv' ");
		instructions.setPadding(new Insets(0,0,0,8));
		inst2.setPadding(new Insets(0,0,0,8));
		TextField filePath = new TextField();
		filePath.setMaxWidth(250);
		Button submit = new Button("Read from CSV File");
		VBox readBox = new VBox(instructions,inst2,filePath,submit);
		readBox.setAlignment(Pos.CENTER);
		Main.root.setTop(new Label(""));
		Main.root.setCenter(readBox);
		Main.root.setBottom(goBack);
		goBack.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle(ActionEvent event) {
				Main.root.setTop(Main.title);
				Main.root.setBottom(new Label(""));
				Main.root.setCenter(Main.mainMenu);
			}
			
		});
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent event) {
				File sourceFile = new File(filePath.getText());
				ArrayList<String> monsters = new ArrayList<>(); 
				try (Scanner inp = new Scanner(sourceFile)) {
					attacks.clear();
					while(inp.hasNextLine()) {
						String monster = inp.nextLine();
						monsters.add(monster);
					}
					Button success = new Button("Continue");
					success.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Main.root.setCenter(Main.mainMenu);
							Main.root.setTop(Main.title);
							Main.root.setBottom(new Label(""));
						}
						
					});
					Main.root.setCenter(new Label("The data was successfully read!"));
					Main.root.setBottom(success);
				} catch (FileNotFoundException e) {
					
					Label error = new Label("Source File not Found");
					Button tryAgain = new Button("Try Again");
					tryAgain.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event) {
							Main.root.setCenter(readBox);
						}
					});
					VBox errorBox = new VBox(error,tryAgain);
					errorBox.setAlignment(Pos.CENTER);
					Main.root.setCenter(errorBox);
				}
				for (int i = 0; i < monsters.size(); i++) {
					MonsterAttack in = new MonsterAttack(i);
					String[] fields = monsters.get(i).split(",");
					String[] dateField = fields[2].split("/");
					in.setMonsterName(fields[0]);
					in.setMonsterLocation(fields[1]);
					in.setMonsterDate(Integer.parseInt(dateField[0]), Integer.parseInt(dateField[1]), Integer.parseInt(dateField[2]));
					in.setMonsterDamage(Double.parseDouble(fields[3]));
					attacks.add(in);
				}
			}
		});
		
		
	}
}


