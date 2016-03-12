package playlist;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sameenislam on 12/03/2016.
 */
public class Main extends Application {
    private static Stage window;
    private static Scene loginScene, homeScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("PlaylistManager - Demo");
        showLogin();
    }

    public static void showLogin() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("view/login.fxml"));
        loginScene = new Scene(root);
        window.setScene(loginScene);
        window.show();

    }

    public static void showHome(ActionEvent event) throws IOException {
        // Get root node and place it in scene
        Parent homeRoot = FXMLLoader.load(Main.class.getResource("view/home.fxml"));
        homeScene = new Scene(homeRoot);
        // now place scene on stage
        Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homeStage.setScene(homeScene);
        homeStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
