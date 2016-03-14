package GUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Jenny on 14.03.2016.
 */
public class Ovelse {
    private final SimpleIntegerProperty exerciseIDcol;
    private final SimpleStringProperty exerciseNameCol;
    private final SimpleIntegerProperty exerciseLoadCol;
    private final SimpleIntegerProperty exerciseRepsCol;
    private final SimpleIntegerProperty exerciseSetsCol;
    private final SimpleStringProperty exerciseSubCatCol;
    private final SimpleStringProperty exerciseDescriptionCol;

    public int getExerciseIDcol() {
        return exerciseIDcol.get();
    }

    public SimpleIntegerProperty exerciseIDcolProperty() {
        return exerciseIDcol;
    }

    public void setExerciseIDcol(int exerciseIDcol) {
        this.exerciseIDcol.set(exerciseIDcol);
    }

    public String getExerciseNameCol() {
        return exerciseNameCol.get();
    }

    public SimpleStringProperty exerciseNameColProperty() {
        return exerciseNameCol;
    }

    public void setExerciseNameCol(String exerciseNameCol) {
        this.exerciseNameCol.set(exerciseNameCol);
    }

    public int getExerciseLoadCol() {
        return exerciseLoadCol.get();
    }

    public SimpleIntegerProperty exerciseLoadColProperty() {
        return exerciseLoadCol;
    }

    public void setExerciseLoadCol(int exerciseLoadCol) {
        this.exerciseLoadCol.set(exerciseLoadCol);
    }

    public int getExerciseRepsCol() {
        return exerciseRepsCol.get();
    }

    public SimpleIntegerProperty exerciseRepsColProperty() {
        return exerciseRepsCol;
    }

    public void setExerciseRepsCol(int exerciseRepsCol) {
        this.exerciseRepsCol.set(exerciseRepsCol);
    }

    public int getExerciseSetsCol() {
        return exerciseSetsCol.get();
    }

    public SimpleIntegerProperty exerciseSetsColProperty() {
        return exerciseSetsCol;
    }

    public void setExerciseSetsCol(int exerciseSetsCol) {
        this.exerciseSetsCol.set(exerciseSetsCol);
    }

    public String getExerciseSubCatCol() {
        return exerciseSubCatCol.get();
    }

    public SimpleStringProperty exerciseSubCatColProperty() {
        return exerciseSubCatCol;
    }

    public void setExerciseSubCatCol(String exerciseSubCatCol) {
        this.exerciseSubCatCol.set(exerciseSubCatCol);
    }

    public String getExerciseDescriptionCol() {
        return exerciseDescriptionCol.get();
    }

    public SimpleStringProperty exerciseDescriptionColProperty() {
        return exerciseDescriptionCol;
    }

    public void setExerciseDescriptionCol(String exerciseDescriptionCol) {
        this.exerciseDescriptionCol.set(exerciseDescriptionCol);
    }

    public Ovelse(Integer exerciseIDcol, String exerciseNameCol, Integer exerciseLoadCol, Integer exerciseRepsCol, Integer exerciseSetsCol, String exerciseSubCatCol, String exerciseDescriptionCol) {
        this.exerciseIDcol = new SimpleIntegerProperty(exerciseIDcol);
        this.exerciseNameCol = new SimpleStringProperty(exerciseNameCol);
        this.exerciseLoadCol = new SimpleIntegerProperty(exerciseLoadCol);
        this.exerciseRepsCol = new SimpleIntegerProperty(exerciseRepsCol);
        this.exerciseSetsCol = new SimpleIntegerProperty(exerciseSetsCol);
        this.exerciseSubCatCol = new SimpleStringProperty(exerciseSubCatCol);
        this.exerciseDescriptionCol = new SimpleStringProperty(exerciseDescriptionCol);
    }
}
