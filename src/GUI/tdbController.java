package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.Date;
import java.sql.ResultSet;

/**
 * Created by Jenny on 01.03.2016.
 */
public class tdbController extends Controller{

    //WORKOUT
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
    @FXML
    private AnchorPane exerciseTempPane;

    //EXERCISE
    @FXML
    private TextField exerciseName;
    @FXML
    private TextField exerciseLoad;
    @FXML
    private TextField exerciseReps;
    @FXML
    private TextField exerciseSets;
    @FXML
    private TextField exerciseLength;
    @FXML
    private TextField exerciseDuration;
    @FXML
    private TextArea exerciseDescription;
    @FXML
    private Button exerciseCreate;
    @FXML
    private TextArea exerciseInfo;

    //Category
    //Category
    @FXML
    private TextField categoryName;
    @FXML
    private Button categoryCreate;
    @FXML
    private TextArea categoryInfo;
    @FXML
    private TextField deleteCategoryName;
    @FXML
    private Button categoryDelete;
    @FXML
    private TextArea deleteInfo;


    //Other
    private boolean initialize = true;

    private ObservableList<Integer> onetoten = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private ObservableList<Integer> temp = FXCollections.observableArrayList(0, 5, 10, 15, 20, 25, 30);

    @FXML
    public void initialize() {
        if (initialize) {
            workoutSpecTemp.setItems(temp);
            workoutPerformance.setItems(onetoten);
            workoutShape.setItems(onetoten);
            ObservableList<Mal> mal = FXCollections.observableArrayList();
            ObservableList<Integer> id = FXCollections.observableArrayList();
            //Collection<String> malID = new ArrayList<>();
            //Collection<String> malName = new ArrayList<>();
            ResultSet rs = guiConnect.getAllTemplates(finalUserID);
            workoutTemplatesID.setCellValueFactory(new PropertyValueFactory<Mal,Integer>("malName"));
            workoutTemplatesName.setCellValueFactory(new PropertyValueFactory<Mal,String>("malID"));
            try {
                while (rs.next()) {
                    mal.add(new Mal(rs.getString("navn"),rs.getInt("treningsID")));
                    //id.add(rs.getInt("treningsID"));
                }
                //workoutTemplates.setEditable(true);
                System.out.println(mal);
                //workoutTemplates.getColumns().setAll(workoutTemplatesID, workoutTemplatesName);
                workoutTemplates.setItems(mal);
                workoutExercises.setItems(id);
                System.out.println("success");
                //workoutExercises.setItems();
            } catch (Exception e) {

            }
            this.initialize = false;
        }
    }

    //Workout**********************************************************************************************************

    @FXML
    private void handleTemplate(){ //working
        if (toggleGroup.getSelectedToggle().equals(templateRadio)){
            exerciseTempPane.setMaxSize(300,700);
            exerciseTempPane.setMinSize(300,700);
            //enable list of templates
        }
        else {
            exerciseTempPane.setMaxSize(0,700);
            exerciseTempPane.setMinSize(0,700);
        }
    }
    @FXML
    private void createWorkout(){ //called when button is pressed
        workoutInfo.setVisible(true);
        System.out.println(workoutExercises.getSelectionModel().getSelectedItems());
        System.out.println(workoutTemplates.getSelectionModel().getSelectedItems());
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


    //Exercise**************************************************************************************************************
    @FXML
    private void createExercise(){
        exerciseInfo.setVisible(true);
        try{
            int subCatID = 1; //needs to be fixed
            if ((guiConnect.loadExerciseToDB(exerciseName.getText(), exerciseDescription.getText(), Integer.valueOf(exerciseLoad.getText()),
                    Integer.valueOf(exerciseReps.getText()), Integer.valueOf(exerciseSets.getText()), subCatID))){
                exerciseInfo.setText("Success");
            }
            else{
                exerciseInfo.setText("Error");
            }

        }
        catch (Exception e){
            exerciseInfo.setText("Error");
        }
    }


    //Category**********************************************************************************************************************
    @FXML
    private void createCategory() {
        categoryInfo.setVisible(true);
        try {
            guiConnect.createCat(categoryName.getText());
            categoryInfo.setText("Category created");
        } catch (Exception e) {
            categoryInfo.setText(("Try again..."));

        }
    }
        @FXML
        private void deleteCategory(){
            deleteInfo.setVisible(true);
            try {
                ResultSet RS = guiConnect.getEmptyCat();
                while (RS.next()) {
                    if (RS.getString("navn").equals(deleteCategoryName.getText())) {
                        guiConnect.deleteCat(RS.getInt("katID"));
                        deleteInfo.setText("Category deleted");
                    }
                }

            } catch (Exception e) {
                deleteInfo.setText(("Couldn't delete the category."));

            }

        }

}
