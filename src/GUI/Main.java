package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by odinblomhoffpedersen on 06.03.2016.
 */
public class Main extends Application{
    private static Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Treningsdatabase");
        this.showLoginScene();
    }
    public void showLoginScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(Main.class.getResource("loginFXML.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void showOptionsScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(GUI.Main.class.getResource("optionsFXML.fxml"));
        Parent root = loader.load(Main.class.getResource("optionsFXML.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //mainLayout.setCenter(loader.load());
    }

    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        connect.getData();
    }
}