package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtAdd;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtCheck;

    @FXML
    private ListView<ShoppingItem> lstShoppingList;

    @FXML
    private Label lblCheck;

    private ObservableList<ShoppingItem> shoppingList;

    @FXML
    void handleBtnAdd(ActionEvent event) {

        // Add string in txtAdd to lstShoppingList.
        ShoppingItem shoppingItem = new ShoppingItem(txtAdd.getText());
        this.shoppingList.add(shoppingItem);
        txtAdd.setText("");

    }

    @FXML
    void handleBtnCheck(ActionEvent event) {

        // Search strings in lstShoppingList for string given in txtCheck.
        String txtCheckStr = txtCheck.getText();

        for(ShoppingItem item : this.shoppingList) {
            String itemName = item.getName();
            if(itemName.equalsIgnoreCase(txtCheckStr)) {
                lblCheck.setText("Yup.");
                return;
            }
        }
        lblCheck.setText("Nope.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.shoppingList = FXCollections.observableArrayList();
        lstShoppingList.setItems(this.shoppingList);


    }
}
