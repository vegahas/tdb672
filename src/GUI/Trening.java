package GUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Jenny on 14.03.2016.
 */
public class Trening {
    private final SimpleIntegerProperty workoutIDcol;
    private final SimpleStringProperty workoutDateCol;
    private final SimpleStringProperty workoutStartCol;
    private final SimpleIntegerProperty workoutDurCol;
    private final SimpleIntegerProperty workoutShapeCol;
    private final SimpleIntegerProperty workoutPerformanceCol;
    private final SimpleStringProperty workoutExercisesCol;

    public int getWorkoutIDcol() {
        return workoutIDcol.get();
    }

    public SimpleIntegerProperty workoutIDcolProperty() {
        return workoutIDcol;
    }

    public void setWorkoutIDcol(int workoutIDcol) {
        this.workoutIDcol.set(workoutIDcol);
    }

    public String getWorkoutDateCol() {
        return workoutDateCol.get();
    }

    public SimpleStringProperty workoutDateColProperty() {
        return workoutDateCol;
    }

    public void setWorkoutDateCol(String workoutDateCol) {
        this.workoutDateCol.set(workoutDateCol);
    }

    public String getWorkoutStartCol() {
        return workoutStartCol.get();
    }

    public SimpleStringProperty workoutStartColProperty() {
        return workoutStartCol;
    }

    public void setWorkoutStartCol(String workoutStartCol) {
        this.workoutStartCol.set(workoutStartCol);
    }

    public int getWorkoutDurCol() {
        return workoutDurCol.get();
    }

    public SimpleIntegerProperty workoutDurColProperty() {
        return workoutDurCol;
    }

    public void setWorkoutDurCol(int workoutDurCol) {
        this.workoutDurCol.set(workoutDurCol);
    }

    public int getWorkoutShapeCol() {
        return workoutShapeCol.get();
    }

    public SimpleIntegerProperty workoutShapeColProperty() {
        return workoutShapeCol;
    }

    public void setWorkoutShapeCol(int workoutShapeCol) {
        this.workoutShapeCol.set(workoutShapeCol);
    }

    public int getWorkoutPerformanceCol() {
        return workoutPerformanceCol.get();
    }

    public SimpleIntegerProperty workoutPerformanceColProperty() {
        return workoutPerformanceCol;
    }

    public void setWorkoutPerformanceCol(int workoutPerformanceCol) {
        this.workoutPerformanceCol.set(workoutPerformanceCol);
    }

    public String getWorkoutExercisesCol() {
        return workoutExercisesCol.get();
    }

    public SimpleStringProperty workoutExercisesColProperty() {
        return workoutExercisesCol;
    }

    public void setWorkoutExercisesCol(String wokroutExercisesCol) {
        this.workoutExercisesCol.set(wokroutExercisesCol);
    }

    public Trening(Integer workoutIDcol, String workoutDateCol, String workoutStartCol, Integer workoutDurCol, Integer workoutShapeCol, Integer workoutPerformanceCol, String workoutExercisesCol) {
        this.workoutIDcol = new SimpleIntegerProperty(workoutIDcol);
        this.workoutDateCol = new SimpleStringProperty(workoutDateCol);
        this.workoutStartCol = new SimpleStringProperty(workoutStartCol);
        this.workoutDurCol = new SimpleIntegerProperty(workoutDurCol);
        this.workoutShapeCol = new SimpleIntegerProperty(workoutShapeCol);
        this.workoutPerformanceCol = new SimpleIntegerProperty(workoutPerformanceCol);
        this.workoutExercisesCol = new SimpleStringProperty(workoutExercisesCol);
    }
}
