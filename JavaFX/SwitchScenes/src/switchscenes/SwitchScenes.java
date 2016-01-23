/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchscenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sameenislam
 */
public class SwitchScenes extends Application {
    
    Stage window;
    Scene scene1, scene2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        Label welcomeLabel = new Label("Welcome to the first scene!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2)); // see lambda expressions
        
        VBox layout1 = new VBox(5); // 20 pixels
        layout1.getChildren().addAll(welcomeLabel, button1);
        scene1 = new Scene(layout1, 200, 100);
        
        Button button2 = new Button("This sucks, go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);
        
        window.setScene(scene1);
        window.setTitle("Alternate Scenes");
        window.show();
        
    }
}
