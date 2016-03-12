package playlist.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sameenislam on 12/03/2016.
 */
public class LoginController {

    @FXML
    public Label lblAuthStatus;
    @FXML
    public Button btnLogin;
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField pwdLogin;

    @FXML
    public void initialiseLogin(javafx.event.ActionEvent event) throws IOException {
        String login = txtUsername.getText();
        String pwd = pwdLogin.getText();

        if(login.equals("sam@sam.com") && pwd.equals("root") ) {
            // Get root node and place it in scene
            Parent homeRoot = FXMLLoader.load(getClass().getResource("view/home.fxml"));
            Scene homeScene = new Scene(homeRoot, 300, 200);
            // now place scene on stage
            Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            homeStage.setScene(homeScene);
            homeStage.show();
        } else {
            lblAuthStatus.setText("Invalid username/password!");
        }

    }
}
