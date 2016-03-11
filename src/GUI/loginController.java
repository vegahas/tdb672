package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jenny on 01.03.2016.
 */
public class loginController extends Controller{

    @FXML
    private TextField userName;
    @FXML
    private TextField userID;
    @FXML
    private Label infoText;

    private MainStart main = new MainStart();

    @FXML
    private void login() throws Exception {
        int id = Integer.valueOf(userID.getText());
        if (guiConnect.verifyUser(userName.getText(), id)) {
            finalUserID = id;
            main.showOptionsScene();
        } else {
            infoText.setVisible(true);
            infoText.setText("Username and/or userID is wrong. Username is casesensitive");
        }
    }
    @FXML
    private void newUser() throws IOException {
        main.showNewUserScene();
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

    }
}
