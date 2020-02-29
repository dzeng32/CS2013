//package homework;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class HW_02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	String[] wordBank = { "tutor", "student", "instructor"};
	
	static final int WIDTH = 800;
	static final int HEIGHT = 800;
	static boolean gameStart = false;
	static int mistakes = 0; //Count user mistakes
	static String pickedWord;
	static ArrayList<Text> currentWord = new ArrayList<>(); //To show current word as "_" blanks
	static ArrayList<Character> checkGameWin = new ArrayList<>(); //Compares to currentWord to see if won
	BorderPane bp = new BorderPane();
	Group platform = new Group();
	TextField userInput = new TextField();
	HBox rightLetters = new HBox();
	HBox wrongLetters = new HBox();
	
	Set<Character> usedLetters = new HashSet<>();
	Set<Character> wrongUsedLetters = new HashSet<>();
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// TODO Auto-generated method stub
		
		Button newGame = new Button("New Game");
		newGame.setOnAction(e -> {
			platform.getChildren().clear();
			drawPlatform();
			startGame();
		});
		
		userInput.setOnAction(e -> {
			
			String userChar = userInput.getText().toLowerCase();

			if(gameStart && userInput.getText().length() == 1 && 
					userInput.getText().charAt(0) >= 'a' && 
					userInput.getText().charAt(0) <= 'z' &&
					!usedLetters.contains(userChar.charAt(0))) {
					
					boolean correctLetter = false;

					if(!usedLetters.contains(userChar.charAt(0))) {
						for(int i = 0; i < pickedWord.length(); i++) {
							if(pickedWord.charAt(i) == userChar.charAt(0)) {
								correctLetter = true;
								currentWord.get(i).setText(userChar);
							}
						}

					}

					if(!correctLetter) {
						Text wrong = new Text(userChar);
						wrong.setStyle("-fx-fill: red;");
						wrongUsedLetters.add(userChar.charAt(0)); //set of wrong char's
						wrongLetters.getChildren().add(wrong);
						mistakes++;
						updateGame(mistakes);
					}
					
					usedLetters.add(userChar.charAt(0)); //set of correct char's

					
					if(mistakes == 7) {
						gameStart = false;
						wrongLetters.getChildren().clear();
						Text result = new Text("YOU LOSE!!");
						result.setStyle("-fx-font-size: 50; -fx-fill: red;");
						wrongLetters.getChildren().add(result);
						
					}
					if(usedLetters.containsAll(checkGameWin)) {
						gameStart = false;
						wrongLetters.getChildren().clear();
						Text result = new Text("YOU WIN!!");
						result.setStyle("-fx-font-size: 50; -fx-fill: green;");
						wrongLetters.getChildren().add(result);
					}
					/*
					boolean gameWin = false;
					do{
						
					}while(!gameWin);*/
					
			}
		});

		HBox hboxButton = new HBox(newGame);
		hboxButton.setAlignment(Pos.CENTER);
		
		//User input fx
		HBox user = new HBox(new Label("Enter a letter: "), userInput);
		user.setAlignment(Pos.CENTER);
		
		rightLetters.setAlignment(Pos.CENTER);
		wrongLetters.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(rightLetters, wrongLetters, user, hboxButton);
		
		bp.setCenter(platform);
		bp.setBottom(vbox);
		
		
		Scene sc = new Scene(bp);
		
		primaryStage.setTitle("Hangman");
		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);
		primaryStage.setScene(sc);
		primaryStage.show();
	}


	public void startGame() {
		//Clear all the old user input
		rightLetters.getChildren().clear();
		wrongLetters.getChildren().clear();
		usedLetters.clear();
		wrongUsedLetters.clear();
		checkGameWin.clear();
		currentWord.clear();
		gameStart = true;
		mistakes = 0;

		Random r = new Random();
		
		//Pick a random word from the word bank
		pickedWord = wordBank[r.nextInt(wordBank.length)];
		
		for(int i = 0; i < pickedWord.length(); i++) {
			Text text = new Text("_");
			text.setWrappingWidth(50);
			text.setStyle("-fx-font-size: 40pt;");
			currentWord.add(text);
			checkGameWin.add(pickedWord.charAt(i));
		}
		rightLetters.getChildren().addAll(currentWord);
		
	}
	
	public void drawPlatform() {
		
		Line base = new Line(0, 0, 400, 0);
		base.setStrokeWidth(10);
		
		Line vertical = new Line(250, 0, 250, -350);
		vertical.setStrokeWidth(10);
		
		Line top = new Line(250, -350, 100, -350);
		top.setStrokeWidth(10);
		
		platform.getChildren().addAll(base, vertical, top);
	}
	
	public void updateGame(int mistake) {
		Circle head = new Circle(100, -250, 50);
		
		Line torso = new Line(100, -200, 100, -125);
		torso.setStrokeWidth(5);
		
		Line leftArm = new Line(100, -175, 50, -200);
		leftArm.setStrokeWidth(5);
		
		Line rightArm = new Line(100, -175, 150, -200);
		rightArm.setStrokeWidth(5);
		
		Line leftLeg = new Line(100, -125, 50, -50);
		leftLeg.setStrokeWidth(5);
		
		Line rightLeg = new Line(100, -125, 150, -50);
		rightLeg.setStrokeWidth(5);
		
		Line rope = new Line(100, -350, 100, -275);
		rope.setStrokeWidth(5);
		
		if(mistake == 1)
			platform.getChildren().add(head);
		else if(mistake == 2)
			platform.getChildren().add(torso);
		else if(mistake == 3)
			platform.getChildren().add(leftArm);
		else if(mistake == 4)
			platform.getChildren().add(rightArm);
		else if(mistake == 5)
			platform.getChildren().add(leftLeg);
		else if(mistake == 6)
			platform.getChildren().add(rightLeg);
		else if(mistake == 7)
			platform.getChildren().add(rope);
		
	}

}
