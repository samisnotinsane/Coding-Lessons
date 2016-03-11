package employee;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sameenislam on 11/03/2016.
 */
public class Main extends Application {

    public static Stage primaryStage;
    public static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Employee App");
        showMainView();
        showMainItems();
    }

    public static void showMainItems() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("employee/view/MainItems.fxml"));
        BorderPane mainItems = loader.load();
        mainLayout.setCenter(mainItems);
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("employee/view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showElectricalScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("employee/electrical/ElectricalDep.fxml"));
        BorderPane electricalDep = loader.load();
        mainLayout.setCenter(electricalDep);
    }

    public static void showMechanicalScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("employee/mechanical/MechanicalDep.fxml"));
        BorderPane mechanicalDep = loader.load();
        mainLayout.setCenter(mechanicalDep);
    }

    public static void showAddStage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("employee/view/AddNewEmployee.fxml"));
        BorderPane addNewEmployee = new BorderPane();
        Stage addDialogStage = new Stage();
        addDialogStage.setTitle("Add New Employee");
        addDialogStage.initModality(Modality.WINDOW_MODAL);
        addDialogStage.initOwner(primaryStage);
        Scene scene = new Scene(addNewEmployee);
        addDialogStage.setScene(scene);
        addDialogStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
