package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.*;

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

    //WORKOUT SHOW ALL-TABLE
    @FXML
    private TableView<Trening> workoutSAtab;
    @FXML
    private TableColumn<Trening, Integer> workoutIDcol;
    @FXML
    private TableColumn<Trening, String> workoutDateCol;
    @FXML
    private TableColumn<Trening, String> workoutStartCol;
    @FXML
    private TableColumn<Trening, Integer> workoutDurCol;
    @FXML
    private TableColumn<Trening, Integer> workoutShapeCol;
    @FXML
    private TableColumn<Trening, Integer> workoutPerformnaceCol;
    @FXML
    private TableColumn<Trening, String> workoutExercisesCol;


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
    @FXML
    private TextField subCat;
    @FXML
    private TextField delExerciseInfo;

    //EXERCISE SHOW ALL-TABLE
    @FXML
    private TableView<Ovelse> exerciseSAtab;
    @FXML
    private TableColumn<Ovelse, Integer> exerciseIDcol;
    @FXML
    private TableColumn<Ovelse, String> exerciseNameCol;
    @FXML
    private TableColumn<Ovelse, Integer> exerciseLoadCol;
    @FXML
    private TableColumn<Ovelse, Integer> exerciseRepsCol;
    @FXML
    private TableColumn<Ovelse, Integer> exerciseSetsCol;
    @FXML
    private TableColumn<Ovelse, String> exerciseSubCatCol;
    @FXML
    private TableColumn<Ovelse, String> exerciseDescriptionCol;

    //Category
    @FXML
    private TextField categoryName;
    @FXML
    private Button categoryCreate;
    @FXML
    private TextField deleteCategoryName;
    @FXML
    private Button categoryDelete;


    //Subcategory
    @FXML
    private TextField subcatName;
    @FXML
    private Button subcatCreate;
    @FXML
    private TextField deleteSubcatName;
    @FXML
    private Button subcatDelete;
    @FXML
    private ListView categoryList;

    //Diary
    @FXML
    private TableView<Dagbok> diaryTable;
    @FXML
    private TableColumn<Dagbok,String> diaryDate = new TableColumn<>();
    @FXML
    private TableColumn<Dagbok, String> diaryTime = new TableColumn<>();
    @FXML
    private TableColumn<Dagbok, String> diaryNote = new TableColumn<>();
    @FXML
    private Button diaryRefresh;

    //GOAL
    @FXML
    private ListView<String> goalExercises;
    @FXML
    private DatePicker goalStartDate;
    @FXML
    private TextArea goalDescription;
    @FXML
    private TextArea goalInfo;
    @FXML
    private TableView<Maal> goalSAtable;
    @FXML
    private TableColumn<Maal, Integer> goalIDcol;
    @FXML
    private TableColumn<Maal, String> goalExerciseCol;
    @FXML
    private TableColumn<Maal, String> goalStartCol;
    @FXML
    private TableColumn<Maal, String> goalEndCol;
    @FXML
    private TableColumn<Maal, String> goalAchievedCol;
    @FXML
    private TableColumn<Maal, String> goalDescriptionCol;

    //Other
    private boolean initialize = true;

    private ObservableList<Integer> onetoten = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private ObservableList<Integer> temp = FXCollections.observableArrayList(0, 5, 10, 15, 20, 25, 30);


    @FXML
    public void initialize() {
        if (initialize) {
            ObservableList<String> cat = FXCollections.observableArrayList();
            workoutSpecTemp.setItems(temp);
            workoutPerformance.setItems(onetoten);
            workoutShape.setItems(onetoten);
            ObservableList<Mal> mal = FXCollections.observableArrayList();
            ResultSet rs = guiConnect.getAllTemplates(finalUserID);
            workoutTemplatesID.setCellValueFactory(new PropertyValueFactory<Mal,Integer>("malName"));
            workoutTemplatesName.setCellValueFactory(new PropertyValueFactory<Mal,String>("malID"));
            try {
                while (rs.next()) {
                    mal.add(new Mal(rs.getString("navn"),rs.getInt("treningsID")));
                }
                workoutTemplates.setItems(mal);
                System.out.println("success");
                //workoutExercises.setItems();
                ResultSet Rs = guiConnect.getAllCategory();
                while(Rs.next()) {
                    String temp = "Kategori: " + Rs.getString("navn") + " ID: " + Rs.getString("katID");
                    cat.add(temp);
                }
                categoryList.setItems(cat);

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
    private void selectTemplate(){
        try{
        Mal selectedMal = workoutTemplates.getSelectionModel().getSelectedItem();
        ResultSet rest = guiConnect.getTemplate(finalUserID, selectedMal.getMalID());
        while (rest.next()) {
            //something that adds exercises for each iteration
            }
        }
        catch (Exception e){
            System.out.println("Fail :(");
        }
    }
    @FXML
    private void createWorkout(){ //called when button is pressed
        workoutInfo.setVisible(true);
        if (toggleGroup2.getSelectedToggle().equals(workoutIn)) {
            try {
                java.util.Date date = Date.valueOf(workoutDate.getValue());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                int workoutID = guiConnect.loadIndoorWorkoutToDB(sqlDate,workoutStart.getText()+":00", Integer.valueOf(workoutDuration.getText()),
                        workoutShape.getValue(), workoutPerformance.getValue(), workoutNotes.getText(), finalUserID,
                        workoutAirWeather.getText(), workoutSpecTemp.getValue());
                if (workoutAsTemplate.isSelected()){
                    guiConnect.loadTemplateToDB(finalUserID, workoutID, workoutTempName.getText());
                }
                workoutInfo.setText("Success");
                initialize = true;
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

    @FXML
    private void refreshWorkoutShowAll(){
        ObservableList<Trening> trening = FXCollections.observableArrayList();
        workoutIDcol.setCellValueFactory(new PropertyValueFactory<Trening,Integer>("workoutIDcol"));
        workoutDateCol.setCellValueFactory(new PropertyValueFactory<Trening,String>("workoutDateCol"));
        workoutStartCol.setCellValueFactory(new PropertyValueFactory<Trening,String>("workoutStartCol"));
        workoutDurCol.setCellValueFactory(new PropertyValueFactory<Trening,Integer>("workoutDurCol"));
        workoutShapeCol.setCellValueFactory(new PropertyValueFactory<Trening,Integer>("workoutShapeCol"));
        workoutPerformnaceCol.setCellValueFactory(new PropertyValueFactory<Trening,Integer>("workoutPerformanceCol"));
        workoutExercisesCol.setCellValueFactory(new PropertyValueFactory<Trening,String>("workoutExercisesCol"));
        List<Trening> workouts = new ArrayList<Trening>();
        try {
            ResultSet res = guiConnect.getAllforAllWorkouts(finalUserID);
            while (res.next()) {
                Trening treningEl = new Trening(res.getInt("treningsID"), String.valueOf(res.getDate("dato")), String.valueOf(res.getTime("starttidspunkt")),
                        res.getInt("varighet"), res.getInt("personligForm"), res.getInt("prestasjon"), "");
                workouts.add(treningEl);
            }
            res.close();
            for (Trening workout:workouts) {
                Integer workoutID = workout.getWorkoutIDcol();
                ResultSet res2 = guiConnect.getExercisesForWorkout(finalUserID, workoutID);
                String exercises = "";
                while (res2.next()) {
                    exercises += res2.getInt("øvelsesID") + " " + res2.getString("navn") + "| ";
                }
                res2.close();
                workout.setWorkoutExercisesCol(exercises);
            }
            trening.addAll(workouts);
            workoutSAtab.setItems(trening);
        }catch(Exception e){
            System.out.println(e);
        }
    }


    //Exercise**************************************************************************************************************
    @FXML
    private void createExercise(){
        exerciseInfo.setVisible(true);
        try{
            ResultSet RtSt = guiConnect.getAllSubCategory();
            int subCatID = 0;
            String subCategory = subCat.getText().toLowerCase().trim();
            while (RtSt.next()) {
                String sub = RtSt.getString("navn").toLowerCase().trim();
                if (sub.equals(subCategory)) {
                    subCatID = RtSt.getInt("ukatID");
                    break;
                }
            }
            RtSt.close();
            if ((subCatID != 0 && guiConnect.loadExerciseToDB(exerciseName.getText(), exerciseDescription.getText(), Integer.parseInt(exerciseLoad.getText()),
                    Integer.parseInt(exerciseReps.getText()), Integer.parseInt(exerciseSets.getText()), subCatID))){
                exerciseInfo.setText("Success");

            }
            else{
                exerciseInfo.setText("Error");
            }
        }
        catch (Exception e){
            exerciseInfo.setText("Error");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void deleteExercise(){ // !! need to fix unique names for exercises ++++
        try {
            ResultSet ResSet = guiConnect.getIDNamesExercise();
            String exerciseName = delExerciseInfo.getText().toLowerCase().trim();
            while (ResSet.next()) {
                String exName = ResSet.getString("navn").toLowerCase().trim();
                if (exName.equals(exerciseName)) {
                    guiConnect.deleteExercise(ResSet.getInt("øvelsesID"));
                    delExerciseInfo.setText("Exercise deleted.");
                    return;
                }
            }
            delExerciseInfo.setText("Exercise not found");
        } catch (Exception e) {
            System.out.println(e);
            delExerciseInfo.setText("Exercise not found");
        }

    }

    @FXML
    private void refreshExerciseShowAll() {
        ObservableList<Ovelse> ovelse = FXCollections.observableArrayList();
        exerciseIDcol.setCellValueFactory(new PropertyValueFactory<Ovelse, Integer>("exerciseIDcol"));
        exerciseNameCol.setCellValueFactory(new PropertyValueFactory<Ovelse, String>("exerciseNameCol"));
        exerciseLoadCol.setCellValueFactory(new PropertyValueFactory<Ovelse, Integer>("exerciseLoadCol"));
        exerciseRepsCol.setCellValueFactory(new PropertyValueFactory<Ovelse, Integer>("exerciseRepsCol"));
        exerciseSetsCol.setCellValueFactory(new PropertyValueFactory<Ovelse, Integer>("exerciseSetsCol"));
        exerciseSubCatCol.setCellValueFactory(new PropertyValueFactory<Ovelse, String>("exerciseSubCatCol"));
        exerciseDescriptionCol.setCellValueFactory(new PropertyValueFactory<Ovelse, String>("exerciseDescriptionCol"));
        Map<Integer, String> subCat = new HashMap<>();
        List<Integer> exerciseIDs = new ArrayList<>();
        try {
            ResultSet res3 = guiConnect.getAllSubCategory();
            while (res3.next()){
                subCat.put(res3.getInt("ukatID"), res3.getString("navn"));
            }
            res3.close();
            ResultSet res = guiConnect.getIDNamesExercise();
            while (res.next()) {
                Integer exerciseID = res.getInt("øvelsesID");
                exerciseIDs.add(exerciseID);
            }
            for (Integer exerciseID:exerciseIDs) {
                ResultSet res2 = guiConnect.getInfoExercise(exerciseID);
                while (res2.next()) { //runs only once
                    Ovelse o = new Ovelse(exerciseID, res2.getString("navn"), res2.getInt("belastning"),
                            res2.getInt("antall_repetisjoner"), res2.getInt("antall_sett"),
                            subCat.get(res2.getInt("ukatID")), res2.getString("beskrivelse"));
                    ovelse.add(o);
                }
                res2.close();
            }
            exerciseSAtab.setItems(ovelse);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Category**********************************************************************************************************************
    @FXML
    private void createCategory() {
        try {
            guiConnect.createCat(categoryName.getText());
            categoryName.setText("Category created");
        } catch (Exception e) {
            categoryName.setText("Try again...");
        }
    }
    @FXML
    private void deleteCategory(){
        try {
            ResultSet RSS = guiConnect.getEmptyCat();
            while (RSS.next()) {
                if (RSS.getString("navn").equals(deleteCategoryName.getText())) {
                    guiConnect.deleteCat(RSS.getInt("katID"));
                    deleteCategoryName.setText("Category deleted");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void createSubcat() {
        try {
            String input = subcatName.getText();
            int index = input.indexOf(",");
            String name = input.substring(0, index);
            int ID = Integer.parseInt(input.substring(index + 1));
            guiConnect.createSub(name, ID);
            subcatName.setText("Sub category created.");
        } catch (Exception e) {
            System.out.println(e);
        }
        initialize = true;
    }

    @FXML
    private void deleteSubcat() {
        try{
            ResultSet rs = guiConnect.getEmptySubCat();
            while (rs.next()) {
                if ( rs.getString("navn").equals(deleteSubcatName.getText())) {
                    guiConnect.deleteSub(rs.getInt("ukatID"));
                    deleteSubcatName.setText("Sub category deleted.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            }

    }

    //Diary******************************************************************************************************************
    @FXML
    private void refreshDiary(){
        ObservableList<Dagbok> dbok = FXCollections.observableArrayList();
        ResultSet res = guiConnect.getDiary(finalUserID);
        diaryDate.setCellValueFactory(new PropertyValueFactory<Dagbok,String>("dato"));
        diaryTime.setCellValueFactory(new PropertyValueFactory<Dagbok,String>("tid"));
        diaryNote.setCellValueFactory(new PropertyValueFactory<Dagbok,String>("notat"));
        try {
            while (res.next()) {
                dbok.add(new Dagbok(String.valueOf(res.getString("dato")),
                        String.valueOf(res.getString("starttidspunkt")), String.valueOf(res.getString("notat"))));
            }
            diaryTable.setItems(dbok);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Goal********************************************************************************************************************
    @FXML
    private void createGoal(){
        goalInfo.setVisible(true);
        try{
            System.out.println(goalExercises.getSelectionModel().getSelectedItem());
            String selectedExercise = goalExercises.getSelectionModel().getSelectedItem();
            int index = selectedExercise.indexOf(" "); //to make it work for for over 10 exercises
            int selectedExerciseID = Integer.parseInt(selectedExercise.substring(0,index));
            System.out.println(selectedExerciseID);
            if (guiConnect.loadGoalToDB(new java.sql.Date(Date.valueOf(goalStartDate.getValue()).getTime()), false,
                    new java.sql.Date(2019-01-01), goalDescription.getText(), finalUserID, selectedExerciseID)){
                goalInfo.setText("Success");
            }
            else {
                goalInfo.setText("Something is wrong");
            }
        }
        catch (Exception e){
            goalInfo.setText("Fail");
            System.out.println(e);
        }
    }

    @FXML
    private void refreshGoalExercises(){
        ObservableList<String> exs = FXCollections.observableArrayList();
        try {
            ResultSet res = guiConnect.getIDNamesExercise();
            while (res.next()) {
                exs.add(String.valueOf(res.getInt("øvelsesID")) + " " + res.getString("navn"));
            }
            goalExercises.setItems(exs);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void refreshGoalShowAll(){
        goalIDcol.setCellValueFactory(new PropertyValueFactory<Maal, Integer>("goalIDcol"));
        goalExerciseCol.setCellValueFactory(new PropertyValueFactory<Maal, String>("goalExerciseCol"));
        goalStartCol.setCellValueFactory(new PropertyValueFactory<Maal, String>("goalStartCol"));
        goalEndCol.setCellValueFactory(new PropertyValueFactory<Maal, String>("goalEndCol"));
        goalAchievedCol.setCellValueFactory(new PropertyValueFactory<Maal, String>("goalAchievedCol"));
        goalDescriptionCol.setCellValueFactory(new PropertyValueFactory<Maal, String>("goalDescriptionCol"));
        ObservableList<Maal> goalss = FXCollections.observableArrayList();
        List<Maal> goals = new ArrayList<>();
        try {
            ResultSet res = guiConnect.getAllGoals(finalUserID);
            while (res.next()) {
                Boolean achieved = res.getBoolean("oppnådd");
                if (achieved) {
                    goals.add(new Maal(res.getInt("målID"), res.getString("navn"), String.valueOf(res.getDate("startdato")),
                            String.valueOf(res.getDate("sluttdato")), String.valueOf(achieved), res.getString("beskrivelse")));
                }
                else {
                    goals.add(new Maal(res.getInt("målID"), res.getString("navn"), String.valueOf(res.getDate("startdato")),
                            " - ", String.valueOf(achieved), res.getString("beskrivelse")));
                }
            }
            res.close();
            goalss.setAll(goals);
            goalSAtable.setItems(goalss);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
