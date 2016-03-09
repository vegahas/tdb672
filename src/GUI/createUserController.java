package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Jenny on 07.03.2016.
 */
public class createUserController {

    private MainStart main = new MainStart();
    @FXML
    private Label userIDLabel;
    @FXML
    private TextField userName;
    @FXML
    private Button confirmButton;
    @FXML
    private void back() throws IOException{
        main.showLoginScene();
    }
    @FXML
    private void createUser() throws IOException{
        //String userID = something(userName.getText())
        //userName.setText("Your userID is " + userID + ". Remember it.");
        userName.setVisible(true);
        confirmButton.setDisable(true);

    }
}