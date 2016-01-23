/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sameenislam
 */
public class LambdaExpr extends Application {
    
    Button button;
    
    @Override
    public void start(Stage primaryStage) {
         primaryStage.setTitle("Annonomous Inner Classes - Demo");
        button = new Button();
        button.setText("Click Me!"); // button will not display without putting it in a layout
        
        // event handler for the button - uses lambda 
        button.setOnAction( e ->  {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null); // will cause a header banner to be displayed if not set to 'null'
            alert.setContentText("Well Done!");
            alert.showAndWait(); // won't be visible if this is left out
        });

            
        
        StackPane layout = new StackPane(); // this will be the root node
        layout.getChildren().addAll(button); // adds button to layout, still doesn't cause it to be displayed
        Scene scene = new Scene(layout, 300.00, 250.00); // (rootNode, width, height)
        primaryStage.setScene(scene); // sets the scene for this stage
        primaryStage.show(); // display the stage
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
