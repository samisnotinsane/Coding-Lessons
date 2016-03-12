package playlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
        window.setTitle("Login");
        showLogin();
    }

    public static void showLogin() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("view/login.fxml"));
        loginScene = new Scene(root);
        window.setScene(loginScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
