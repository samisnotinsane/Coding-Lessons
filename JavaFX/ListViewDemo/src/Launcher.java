import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by sameenislam on 16/03/2016.
 */
public class Launcher extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXML TableView Example");

        // load the FXML document
        Pane rootNode = (Pane) FXMLLoader.load(getClass().getResource("demo.fxml"));

        // create a scene and assign the root node to it
        Scene myScene = new Scene(rootNode);

        // set the scene
        primaryStage.setScene(myScene);

        // show the stage
        primaryStage.show();

        // at this point we have loaded the FXML and displayed it on the stage

    }
}
