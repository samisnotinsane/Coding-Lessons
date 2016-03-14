import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by sameenislam on 14/03/2016.
 */
public class Launcher extends Application{

    public static final ObservableList names = FXCollections.observableArrayList();
    public static final ObservableList data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lists");

        // create root node and lock data arraylist to it
        final ListView listView = new ListView(data);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        // add data to arraylists
        names.addAll(
                "Adam", "Alex", "Alfred", "Albert",
                "Brenda", "Connie", "Derek", "Donny",
                "Lynne", "Myrtle", "Rose", "Rudolph",
                "Tony", "Trudy", "Williams", "Zach"
        );
        for (int i = 0; i < 18; i++) {
            data.add("anonym");
        }
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(names));

        StackPane root = new StackPane(); // set root pane
        root.getChildren().add(listView); // add root node to root pane
        primaryStage.setScene(new Scene(root,200,250)); // add scene to stage
        primaryStage.show(); // show stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
