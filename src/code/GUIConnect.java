package code;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public class GUIConnect {
    private DBConnect dbc;
    private Category category;
    private Diary diary;
    private Exercise exercise;
    private Goals goals;
    private Manage manage;
    private Template template;
    private Workout workout;

    /* Initialize class */
    public GUIConnect(){
        this.dbc = new DBConnect();
        this.category = new Category(dbc);
        this.diary = new Diary(dbc);
        this.exercise = new Exercise(dbc);
        this.goals = new Goals(dbc);
        this.manage = new Manage(dbc);
        this.template = new Template(dbc);
        this.workout = new Workout(dbc);
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

    /* Get all attributes from every category */
    public ResultSet getAllCategory(){
        return category.getAllCat();
    }

    /*Get all attributes from every sub-category */
    public ResultSet getAllSubCategory(){
        return category.getAllSubCat();
    }

/* DIARY */
    /* Get a ResultSet-object with date, time and note. Sorted ascending by date, time */
    public ResultSet getDiary(int person_id){
        return diary.getDiary(person_id);
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
    /* Create a new user and returns the id (=-1 if fails) */
    public int createUser(String name){
    return manage.createUser(name);
}

    /* Verify user */
    public boolean verifyUser(String name, int id){
        return manage.verifyUser(name, id);
    }


/* TEMPLATE */
    /* Get a ResultSet-object with name and workout-id for every template */
    public ResultSet getAllTemplates(int person_id){
        return template.getAllTemplates(person_id);
    }

    /* Get a ResultSet-object with name, workout-id, exercise-id and -name for a given template */
    public ResultSet getTemplate(int person_id, int workout_id){
        return template.getTemplate(person_id, workout_id);
    }

    /* Load a new template to the database */
    public boolean loadTemplateToDB(int person_id, int workout_id, String name){
        return template.loadTemplateToDB(person_id, workout_id, name);
    }

/* WORKOUT */
    /* Get a ResultSet-object with id, date and start time for every workout */
    public ResultSet getAllWorkouts(int person_id){
        return workout.getAllWorkouts(person_id);
    }

    /* Get a ResultSet-object with name and id of all exercises in a workout */
    public ResultSet getExercisesForWorkout(int person_id, int workout_id){
        return workout.getExercisesForWorkout(person_id, workout_id);
    }

    /* Get the id of a workout, returns -1 if fail or multiple with similarattributes. USE ONLY IF NO OTHER OPTION */
    public int getWorkoutID(int person_id, Date date, Time start_time){
        return workout.getID(person_id, date, start_time);
    }

    /* Get a ResultSet-object with all attributes for a given workout */
    public ResultSet getWorkoutInfo(int person_id, int workout_id, boolean indoor){
        return workout.getInfo(person_id, workout_id, indoor);
    }

    /* Get a ResultSet-object with the id, date and start time for every workout in a given periode */
    public ResultSet getWorkoutsForPeriode(int person_id, Date start_date, Date end_date){
        return workout.getWorkoutsForPeriode(person_id, start_date, end_date);
    }

    /* Load a new indoor-workout to the database */
    public boolean loadIndoorWorkoutToDB(Date date, Time starttime, int duration, int shape, int performance,
                                         String note, int person_id, String air, int spectators){
        return workout.loadIndoorWorkoutToDB(date, starttime, duration,
                shape, performance, note, person_id, air, spectators);
    }

    /* Load a new outdoor-workout to the database */
    public boolean loadOutdoorWorkoutToDB(Date date, Time starttime, int duration, int shape, int performance,
                                         String note, int person_id, String weather, int temperature){
        return workout.loadOutdoorWorkoutToDB(date, starttime, duration,
                shape, performance, note, person_id, weather, temperature);
    }

}
