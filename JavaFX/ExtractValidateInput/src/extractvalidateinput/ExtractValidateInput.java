/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractvalidateinput;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author buckyroberts
 */
public class ExtractValidateInput extends Application {
    Stage window;
    Scene scene;
    Button button;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Input Extraction - Demo");
        
        //Form
        TextField nameInput = new TextField();
        button = new Button("Click Me");
        button.setOnAction(e -> isInt(nameInput.getText()));
        
        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(nameInput,button);
        
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    private boolean isInt(String value) {
        try {
            int age = Integer.parseInt(value);
            System.out.println("User is: "+ age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert String to Integer.\n"+e.toString());
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
