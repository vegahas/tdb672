package GUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Jenny on 15.03.2016.
 */
public class Maal {
    private final SimpleIntegerProperty goalIDcol;
    private final SimpleStringProperty goalExerciseCol;
    private final SimpleStringProperty goalStartCol;
    private final SimpleStringProperty goalEndCol;
    private final SimpleStringProperty goalAchievedCol;
    private final SimpleStringProperty goalDescriptionCol;

    public int getGoalIDcol() {
        return goalIDcol.get();
    }

    public SimpleIntegerProperty goalIDcolProperty() {
        return goalIDcol;
    }

    public void setGoalIDcol(int goalIDcol) {
        this.goalIDcol.set(goalIDcol);
    }

    public String getGoalExerciseCol() {
        return goalExerciseCol.get();
    }

    public SimpleStringProperty goalExerciseColProperty() {
        return goalExerciseCol;
    }

    public void setGoalExerciseCol(String goalExerciseCol) {
        this.goalExerciseCol.set(goalExerciseCol);
    }

    public String getGoalStartCol() {
        return goalStartCol.get();
    }

    public SimpleStringProperty goalStartColProperty() {
        return goalStartCol;
    }

    public void setGoalStartCol(String goalStartCol) {
        this.goalStartCol.set(goalStartCol);
    }

    public String getGoalEndCol() {
        return goalEndCol.get();
    }

    public SimpleStringProperty goalEndColProperty() {
        return goalEndCol;
    }

    public void setGoalEndCol(String goalEndCol) {
        this.goalEndCol.set(goalEndCol);
    }

    public String getGoalAchievedCol() {
        return goalAchievedCol.get();
    }

    public SimpleStringProperty goalAchievedColProperty() {
        return goalAchievedCol;
    }

    public void setGoalAchievedCol(String goalAchievedCol) {
        this.goalAchievedCol.set(goalAchievedCol);
    }

    public String getGoalDescriptionCol() {
        return goalDescriptionCol.get();
    }

    public SimpleStringProperty goalDescriptionColProperty() {
        return goalDescriptionCol;
    }

    public void setGoalDescriptionCol(String goalDescriptionCol) {
        this.goalDescriptionCol.set(goalDescriptionCol);
    }

    public Maal(Integer goalIDcol, String goalExerciseCol, String goalStartCol, String goalEndCol, String goalAchievedCol, String goalDescriptionCol){
        this.goalIDcol = new SimpleIntegerProperty(goalIDcol);
        this.goalExerciseCol = new SimpleStringProperty(goalExerciseCol);
        this.goalStartCol = new SimpleStringProperty(goalStartCol);
        this.goalEndCol = new SimpleStringProperty(goalEndCol);
        this.goalAchievedCol = new SimpleStringProperty(goalAchievedCol);
        this.goalDescriptionCol = new SimpleStringProperty(goalDescriptionCol);

    }
}
