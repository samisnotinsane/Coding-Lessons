package employee.employee.view;

import employee.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by sameenislam on 11/03/2016.
 */
public class MainItemsController {

    private Main main;

    @FXML
    private void goElectrical() throws IOException {
        main.showElectricalScene();
    }

    @FXML
    private void goMechanical() throws IOException {
        main.showMechanicalScene();
    }
}
