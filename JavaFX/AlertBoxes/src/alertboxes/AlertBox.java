/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertboxes;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 *
 * @author sameenislam
 */
public class AlertBox {
    public void display(String title, String message) {
        Stage window = new Stage();
        
        // Make alert box a modal
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label label = new Label();
        label.setText(message);
        
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> window.close());
        
        VBox layout = new VBox(10); // spacing 10 units among children
        layout.getChildren().addAll(label, okButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
    }
}
