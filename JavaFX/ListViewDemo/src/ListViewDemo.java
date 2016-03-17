import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by sameenislam on 16/03/2016.
 */
public class ListViewDemo extends Application {

    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("ListView Demo");

        FlowPane rootNode = new FlowPane(10,10);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 200, 120);

        myStage.setScene(myScene);

        response = new Label("Select Compter Type");

        ObservableList<String> computerTypes = FXCollections.observableArrayList("Smartphone", "Tablet",
                "Notebook", "Desktop");

        ListView<String> lvComputers = new ListView<>(computerTypes);

        lvComputers.setPrefSize(100,70);

        MultipleSelectionModel<String> lvSelModel =
                lvComputers.getSelectionModel();

        lvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) ->
                response.setText("Computer selected is " + newValue));

        rootNode.getChildren().addAll(lvComputers, response);

        myStage.show();
    }
}
