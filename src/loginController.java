import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by Jenny on 01.03.2016.
 */
public class loginController {

    private Main main = new Main();

    @FXML
    private void login() throws IOException {
        main.showOptionsScene();
    }

}
