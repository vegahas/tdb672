package code;

import java.sql.Date;
import java.sql.ResultSet;

public class GUIConnect {
    private DBConnect dbc;
    private Category category;
    private Exercise exercise;
    private Goals goals;
    private Manage manage;

    /* Initialize class */
    public GUIConnect(){
        this.dbc = new DBConnect();
        this.category = new Category(dbc);
        this.exercise = new Exercise(dbc);
        this.goals = new Goals(dbc);
        this.manage = new Manage(dbc);
    }

/* CATEGORY */
    /* Change which category a subcategory belongs to */
    public boolean changeCat(int id, int new_category_id){
        return category.changeCat(id, new_category_id);
    }

    /* Create a new category */
    public boolean createCat(String name){
        return category.createCat(name);
    }

    /* Create a new subcategory */
    public boolean createSub(String name, int category_id){
        return category.createSub(name, category_id);
    }

    /* Delete a category */
    public boolean deleteCat(int id){
        return category.deleteCat(id);
    }

    /* Delete a subcategory */
    public boolean deleteSub(int id){
        return category.deleteSub(id);
    }


/* EXERCISE */
    /* Change which sub-category an exercise belongs to */
    public boolean changeSub(int id, int new_subcat_id){
        return exercise.changeSub(id, new_subcat_id);
    }

    /* Delete an exercise */
    public boolean deleteExercise(int id){
        return exercise.deleteExcerise(id);
    }

    /* Get a ResultSet-object with id and name of every exercise, sorted by name */
    public ResultSet getIDNamesExercise(){
        return exercise.getAllIDNames();
    }

    /* Get a ResultSet-object with all attributes of a given exercise, including subcat-attributes */
    public ResultSet getInfoExercise(int id){
        return exercise.getInfo(id);
    }

    /* Get a ResultSet-object with name and id of all exercises in the same sub-category as the given exercise */
    public ResultSet getSubstitues(int id){
        return exercise.getSubstitutes(id);
    }

    /* Load a new exercise to the database */
    public boolean loadExerciseToDB(String name, String description, int load, int reps, int sets, int subCatID){
        return exercise.loadToDB(name, description, load, reps, sets, subCatID);
    }


/* GOALS */
    /* Get a ResultSet-object with id, name, done(boolean) and exercise-name for every goal */
    public ResultSet getAllGoals(int person_id){
        return goals.getAllGoals(person_id);
    }

    /* Get a ResultSet-object with all information about a given goal */
    public ResultSet getGoalInfo(int id, int person_id, int exercise_id){
        return goals.getInfo(id, person_id, exercise_id);
    }

    /* Load a new goal to the database */
    public boolean loadGoalToDB(Date start, boolean done, Date finish, String description,
                                int person_id, int exercise_id){
        return goals.loadToDB(start, done, finish, description, person_id, exercise_id);
    }


/* MANAGE */
    /* Create a new user */
    public boolean createUser(String name){
    return manage.createUser(name);
}

    /* Verify user */
    public boolean verifyUser(String name, int id){
        return manage.verifyUser(name, id);
    }

}
