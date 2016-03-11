package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.ResultSet;

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
    private TextField workoutTempName;
    @FXML
    private Label workoutTempNameLabel;
    @FXML
    private DatePicker workoutDate;
    @FXML
    private TextField workoutStart;
    @FXML
    private TextField workoutDuration;
    @FXML
    private ChoiceBox<Integer> workoutShape;
    @FXML
    private ChoiceBox<Integer> workoutPerformance;
    @FXML
    private TextArea workoutNotes;
    @FXML
    private TextArea workoutInfo;
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private ToggleGroup toggleGroup2;
    @FXML
    private RadioButton workoutIn = new RadioButton("workoutIn");
    @FXML
    private RadioButton workoutOut = new RadioButton("workoutOut");
    @FXML
    private TextField workoutAirWeather;
    @FXML
    private ChoiceBox<Integer> workoutSpecTemp;
    @FXML
    private TableView<Mal> workoutTemplates;
    @FXML
    private TableColumn<Mal,String> workoutTemplatesName = new TableColumn<>();
    @FXML
    private TableColumn<Mal, Integer> workoutTemplatesID = new TableColumn<>();
    @FXML
    private CheckBox workoutAsTemplate;
    @FXML
    private ListView workoutExercises;

    private boolean initialize = true;

    private ObservableList<Integer> onetoten = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private ObservableList<Integer> temp = FXCollections.observableArrayList(0, 5, 10, 15, 20, 25, 30);


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
        if (toggleGroup2.getSelectedToggle().equals(workoutIn)) {
            try {
                java.util.Date date = Date.valueOf(workoutDate.getValue());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                int workoutID = guiConnect.loadIndoorWorkoutToDB(sqlDate,workoutStart.getText(), Integer.valueOf(workoutDuration.getText()),
                        workoutShape.getValue(), workoutPerformance.getValue(), workoutNotes.getText(), finalUserID,
                        workoutAirWeather.getText(), workoutSpecTemp.getValue());
                if (workoutAsTemplate.isSelected()){
                    guiConnect.loadTemplateToDB(finalUserID, workoutID, workoutTempName.getText());
                }
                workoutInfo.setText("Success");
            }
            catch (Exception e){
                System.out.println(e);
                workoutInfo.setText("Something is wrong");
            }
        }
        else if (toggleGroup2.getSelectedToggle().equals(workoutOut)){
            try {
                java.util.Date date = Date.valueOf(workoutDate.getValue());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                int workoutID = guiConnect.loadOutdoorWorkoutToDB(sqlDate, workoutStart.getText(), Integer.valueOf(workoutDuration.getText()),
                        workoutShape.getValue(), workoutPerformance.getValue(), workoutNotes.getText(), finalUserID,
                        workoutAirWeather.getText(), workoutSpecTemp.getValue());
                if (workoutAsTemplate.isSelected()){
                    guiConnect.loadTemplateToDB(finalUserID, workoutID, workoutTempName.getText());
                }
                workoutInfo.setText("Success");
            }
            catch (Exception e){
                System.out.println(e);
                workoutInfo.setText("Something is wrong");
            }
        }
        else {
            workoutInfo.setText("Something is wrong");
        }
    }

    @FXML
    public void initialize() {
        if (initialize) {
            workoutSpecTemp.setItems(temp);
            workoutPerformance.setItems(onetoten);
            workoutShape.setItems(onetoten);
            ObservableList<Mal> mal = FXCollections.observableArrayList();
            ObservableList<String> id = FXCollections.observableArrayList();
            //Collection<String> malID = new ArrayList<>();
            //Collection<String> malName = new ArrayList<>();
            ResultSet rs = guiConnect.getAllTemplates(finalUserID);
            try {
                while (rs.next()) {
                    mal.add(new Mal(rs.getString("navn"), rs.getInt("treningsID")));
                }
                //workoutTemplatesID.setCellValueFactory(new PropertyValueFactory<Mal,Integer>("TemplateID"));
                //workoutTemplatesName.setCellValueFactory(new PropertyValueFactory<Mal,String>("TemplateName"));
                //workoutTemplates.setEditable(true);
                System.out.println(mal);
                //workoutTemplates.getColumns().setAll(workoutTemplatesID, workoutTemplatesName);
                System.out.println(workoutTemplates);
                workoutTemplates.setItems(mal);
                System.out.println("success");
                //workoutExercises.setItems();
            } catch (Exception e) {

            }
            this.initialize = false;
        }
    }
    @FXML
    private void saveAsTemplate(){
        if (workoutAsTemplate.isSelected()){
            workoutTempName.setVisible(true);
            workoutTempNameLabel.setVisible(true);
        }
        else{
            workoutTempName.setVisible(false);
            workoutTempNameLabel.setVisible(false);
        }
    }
}
