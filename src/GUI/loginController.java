package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Jenny on 01.03.2016.
 */
public class loginController {

    @FXML
    private TextField userName;
    @FXML
    private TextField userID;
    @FXML
    private Label infoText;

    private Main main = new Main();

    @FXML
    private void login() throws IOException {
        /*
        logikk som sjekker om brukeren godkjennes
         */
        /*if (checkUser(userName.getText(), userID.getText())) {
            main.showOptionsScene();
        }
        else{
            infoText.setVisible(true);
        //}*/
        main.showOptionsScene();
    }
    @FXML
    private void newUser() throws IOException {
        main.showNewUserScene();
    }

}
