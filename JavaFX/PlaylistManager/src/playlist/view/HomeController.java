package playlist.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import playlist.Main;

import java.io.IOException;

/**
 * Created by sameenislam on 12/03/2016.
 */
public class HomeController {

    @FXML
    public Button btnLogout;

    public void logout() throws IOException {
        System.out.println("Logging out");
        Main.showLogin();
    }


}
