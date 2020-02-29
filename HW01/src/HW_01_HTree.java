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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class HW_01_HTree extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	final int WIDTH = 500, HEIGHT = 500;
	Group hTree = new Group();
	final double XCENTERPOS = 100, YCENTERPOS = 100, SIDELENGTH = 100;
	
	BorderPane bp = new BorderPane();
	Label label = new Label("Enter an order: ");
	TextField text_field = new TextField();	

	
	@Override
	public void start(Stage primaryStage) throws Exception{
		

		text_field.setOnAction(this::begin);
		
		Button button = new Button("Display");
		button.setOnAction(this::begin);
		
		HBox hbox = new HBox( label, text_field, button);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		
		VBox vbox = new VBox(hTree, hbox);
		vbox.setAlignment(Pos.CENTER);
		
		
		
		bp.setCenter(hTree);
		bp.setBottom(hbox);
		
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		
		primaryStage.setTitle("HTree Fractal");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void begin(ActionEvent e) {
		
		//checks if user input an integer greater than 0 to start drawing
		if(Integer.parseInt(text_field.getText()) >= 0) {
			hTree.getChildren().clear();
			//drawH();
			drawH(Integer.parseInt(text_field.getText()), XCENTERPOS, YCENTERPOS, SIDELENGTH);
		}else{
			//if anything else then empty
			hTree.getChildren().clear();
		}
	}
	
	public void drawH(int n, double x, double y, double sideLength) {
		//n > 7 used for test purposes to prevent slowing down cpu
		if(n <= 0 || n > 7)
			return;
		
		//Each side has a length of "sideLength"
		//Set horizontal line with center (x = XCENTERPOS = 100, y = YCENTERPOS = 100, sideLength = SIDELENGTH = 100)
		
		//Horizontal line calculation
		
		double startXPos = x - sideLength / 2;
		double endXPos = x + sideLength / 2;
		double startYPos = y;
		double endYPos = y;
		
		Line horizontalLine = new Line(startXPos, startYPos, endXPos, endYPos);
		
		//Left vertical line calculation 
		startXPos = x - sideLength / 2;
		startYPos = y - sideLength / 2;
		endXPos = x - sideLength / 2;
		endYPos = y + sideLength / 2;
		Line verticalLineLeft = new Line(startXPos, startYPos, endXPos, endYPos);
		
		//Left top of the H
		drawH(n-1, startXPos, startYPos, sideLength / 2);
		//Left bottom of the H
		drawH(n-1, endXPos, endYPos, sideLength / 2);
		
		startXPos = x + sideLength / 2;
		startYPos = y - sideLength / 2;
		endXPos = x + sideLength / 2;
		endYPos = y + sideLength / 2;
		Line verticalLineRight = new Line(startXPos, startYPos, endXPos, endYPos);
		
		//Right top of the H
		drawH(n-1, startXPos, startYPos, sideLength / 2);
		//Right bottom of the H
		drawH(n-1, endXPos, endYPos, sideLength / 2);
		
		hTree.getChildren().addAll(horizontalLine, verticalLineLeft, verticalLineRight);
	}
	
}
