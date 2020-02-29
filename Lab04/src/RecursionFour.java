
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class RecursionFour extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
    public void start(Stage primaryStage) {
         SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
         /*Original Code
         TextField tfOrder = new TextField(); 
         tfOrder.setOnAction(e -> trianglePane.setOrder(Integer.parseInt(tfOrder.getText())));
         tfOrder.setPrefColumnCount(4);
         tfOrder.setAlignment(Pos.BOTTOM_RIGHT); */
         
         Button minus = new Button("-");
         Button plus = new Button("+");
         minus.setOnAction(e -> trianglePane.clickMinus(e));
         plus.setOnAction(e -> trianglePane.clickPlus(e));
         
         HBox hBox = new HBox(10);
         //Original Code
         //hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
         hBox.getChildren().addAll(minus, plus);
         hBox.setAlignment(Pos.CENTER);
         
         BorderPane borderPane = new BorderPane();
         borderPane.setCenter(trianglePane);
         borderPane.setBottom(hBox);
         
         Scene scene = new Scene(borderPane, 500, 500);
         primaryStage.setTitle("SierpinskiTriangle");
         primaryStage.setScene(scene); 
         primaryStage.show(); 
         
         scene.widthProperty().addListener(ov -> trianglePane.paint());
         scene.heightProperty().addListener(ov -> trianglePane.paint());
         
    }
    
    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;
        
        /* Original Code
        public void setOrder(int order) {
            this.order = order;
            paint();
        } */
        
        public void clickMinus(ActionEvent e) {
        	if(order <= 0) {
        		this.order = 0;
        		paint();
        	}else {
        		this.order--;
        		paint();
        	}
        }
        
        public void clickPlus(ActionEvent e) {
        	this.order++;
        	paint();
        }
        
        SierpinskiTrianglePane() {
            
        }
        
        protected void paint() {
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
            
            this.getChildren().clear(); 
            
            displayTriangles(order, p1, p2, p3);
        }
        
        private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
            if (order == 0) {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);

                this.getChildren().add(triangle);
            }
            else {
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);
                
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);

            }
        }
    }
}
