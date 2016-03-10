package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Jenny on 01.03.2016.
 */
public class tdbController extends Controller{

    //Create work-out
    @FXML
    private RadioButton templateRadio = new RadioButton("templateRadio");
    @FXML
    private RadioButton noTemplateRadio = new RadioButton("noTemplateRadio");
    @FXML
    private TextField workoutName;
    @FXML
    private DatePicker workoutDate;
    @FXML
    private TextField workoutStart;
    @FXML
    private TextField workoutDuration;
    @FXML
    private TextField workoutShape;
    @FXML
    private TextField workoutPerformance;
    @FXML
    private TextArea workoutNotes;
    @FXML
    private TextArea workoutInfo;
    @FXML
    private ToggleGroup toggleGroup;

    public static void main(String[] args) {
        tdbController tdb = new tdbController();
        tdb.setUp();
    }

    private void setUp(){
    }

    @FXML
    private void handleTemplate(){ //working
        System.out.println(toggleGroup.getSelectedToggle());
        if (toggleGroup.getSelectedToggle().equals(templateRadio)){
            System.out.println("hei");
            //enable list of templates
        }
        else {
            //disable list of templates
        }
    }
    @FXML
    private void createWorkout(){ //called when button is pressed
        workoutInfo.setVisible(true);
        if (true) {
            workoutInfo.setText("Success");
        }
        else {
            workoutInfo.setText("Something is wrong");
        }
    }
}
