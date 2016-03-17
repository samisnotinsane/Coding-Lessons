import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sameenislam on 16/03/2016.
 */
public class DemoController implements Initializable {

    @FXML
    Label response;
    @FXML FlowPane rootNode;
    @FXML ListView<ComputerType> lvComputers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//
//
//
//        response = new Label("Select Computer Type");
//
//        // String entries for ListView
//        final ObservableList<String> computerTypes = FXCollections.observableArrayList("Smartphone", "Tablet",
//                "Notebook", "Desktop");
//
//        // init lv with data
//        lvComputers = new ListView<>(computerTypes);
//
//        // get lv selection model
//        MultipleSelectionModel<String> lvSelModel = lvComputers.getSelectionModel();
//
//        lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                response.setText("Computer selected is "+newValue);
//            }
//        });
//
//
//
//
//
//        primaryStage.show();
//    }
}
