package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

    /**
     * Created by Jenny on 07.03.2016.
     */
public class createUserController extends Controller{

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
        int id = guiConnect.createUser(userName.getText());
        if (id != -1) {
            userIDLabel.setVisible(true);
            userIDLabel.setText("Your userID is " + id + ". Remember it.");
            confirmButton.setDisable(true);
        }
        else{
            userIDLabel.setVisible(true);
            userIDLabel.setText("Something is wrong, try another username");
        }
    }

    public static void main(String[] args) {
        createUserController cu = new createUserController();
        cu.initialize();
    }

    private void initialize(){
        userIDLabel.setVisible(false);
        System.out.println("hei");
    }
}