/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepad;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author sameenislam
 */
public class SimplePad extends Application {
    
    Stage window;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("New Note - SimplePad");
        
        //GridPane with padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5, 10, 5, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //Title Label - constrains use (child, column, row)
        Label titleLabel = new Label("Title:");
        GridPane.setConstraints(titleLabel, 0, 0);
        
        //Title Input
        TextField titleInput = new TextField();
        titleInput.setPromptText("Title");
        titleInput.setMaxWidth(400); // having no effects
        GridPane.setConstraints(titleInput, 1, 0);
        
        //Body Label
        Label bodyLabel = new Label("Body:");
        GridPane.setConstraints(bodyLabel, 0, 1);
        
        //Body Input
        TextField bodyInput = new TextField();
        bodyInput.setPromptText("Note");
        bodyInput.setMaxHeight(400); // having no effects
        GridPane.setConstraints(bodyInput, 1, 1);
        
        // Save
        Button saveButton = new Button("Save");
        GridPane.setConstraints(saveButton, 5, 30);
        saveButton.setOnAction(e -> System.out.println("This feature is not ready yet."));
        
        //Add everything to grid
        grid.getChildren().addAll(titleLabel, titleInput, bodyLabel, bodyInput, saveButton);

        Scene scene = new Scene(grid, 350, 350);
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
