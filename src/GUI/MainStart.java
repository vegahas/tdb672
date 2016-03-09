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
    public static void showOptionsScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(GUI.MainStart.class.getResource("optionsFXML.fxml"));
<<<<<<< HEAD:src/GUI/Main.java
        Parent root = loader.load(Main.class.getResource("optionsFXML.fxml"));
=======
        Parent root = loader.load(MainStart.class.getResource("optionsFXML.fxml"));
>>>>>>> 036c508513457937d405067f5b0becd301bc36c9:src/GUI/MainStart.java
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //mainLayout.setCenter(loader.load());
    }
<<<<<<< HEAD:src/GUI/MainStart.java
    public void showNewUserScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(MainStart.class.getResource("createUserFXML.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
=======

>>>>>>> refs/remotes/origin/master:src/GUI/Main.java
    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        connect.getData();
    }
}