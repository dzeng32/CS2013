
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Stack;

 

import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.scene.text.FontPosture;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;


public class Lab08 extends Application{
	BorderPane bp = new BorderPane();
	TextField tf = new TextField();
	
	//Displays all words in the inserted order
	TextArea text1 = new TextArea();
	//Displays all the non-duplicate words in ascending order
	TextArea text2 = new TextArea();
	//Arraylist to take in user input
	ArrayList<String> textList1 = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HBox hbox = new HBox();
		Button done = new Button("Done");
		
		tf.setPrefColumnCount(30);
		hbox.getChildren().addAll(new Label("Enter a word: "), tf, done);
		
		bp.setBottom(hbox);
		done.setOnAction(this::display);
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(text1, text2);
		
		bp.setCenter(vbox);
		tf.setOnAction(this::activate);
		
		Scene scene = new Scene(bp, 700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lab 08");
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void activate(ActionEvent e) {		
		textList1.add(tf.getText());		
	}
	
	public void display(ActionEvent e) {
		
		//Start of question 1.
		
		//Display what user entered
		for(int i = 0; i < textList1.size(); i++)
			text1.appendText(textList1.get(i) + " ");
		
		//End of question 1.
		//--------------------------------------------------
		//Start of question 2.
		
		//Remove repeating words
		for(int i = 0; i < textList1.size() -1; i++) {
			for(int j = i + 1; j < textList1.size(); j++) {
				if(textList1.get(i).equals(textList1.get(j))){
					textList1.remove(j);
				}
			}
		}
		
		//sort from the book
		String currentMin;
		int currentMinIndex;
		
		for(int i = 0; i < textList1.size(); i++) {
			currentMin = textList1.get(i);
			currentMinIndex = i;
			
			for(int j = i + 1; j < textList1.size(); j++) {
				if(currentMin.compareTo(textList1.get(j)) > 0) {
					currentMin = textList1.get(j);
					currentMinIndex = j;
				}
			}
			if(currentMinIndex != i) {
				textList1.set(currentMinIndex, textList1.get(i));
				textList1.set(i, currentMin);
			}
		}
		
		//Display non repeat words
		for(int i = 0; i < textList1.size(); i++) {
			text2.appendText(textList1.get(i) + " ");
		}
		
		//End of question 2
		//-----------------------------------------------------		
	}
	
}
