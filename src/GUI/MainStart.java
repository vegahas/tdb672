package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Jenny on 01.03.2016.
 */
public class MainStart extends Application{
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
        Parent root = loader.load(MainStart.class.getResource("loginFXML.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void showOptionsScene() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(GUI.MainStart.class.getResource("optionsFXML.fxml"));
        Parent root = loader.load(MainStart.class.getResource("optionsFXML.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        tdbController tc = new tdbController();
        //mainLayout.setCenter(loader.load());
    }
    public void showNewUserScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(MainStart.class.getResource("createUserFXML.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}