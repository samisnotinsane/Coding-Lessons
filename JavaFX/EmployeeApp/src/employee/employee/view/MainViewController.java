package employee.employee.view;

import employee.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by sameenislam on 11/03/2016.
 */
public class MainViewController {

    private Main main;

    @FXML
    private void goHome() throws IOException {
        main.showMainItems();
    }

    @FXML
    private void addBtn() {
        main.showAddStage();
    }
}
