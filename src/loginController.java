import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Jenny on 01.03.2016.
 */
public class loginController {

    @FXML
    private TextField userName;
    private TextField userID;

    private Main main = new Main();

    @FXML
    private void login() throws IOException {
        /*
        logikk som sjekker om brukeren godkjennes
         */
        main.showOptionsScene();
    }

}
