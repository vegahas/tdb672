package code;
import java.sql.*;

public class Workout {

    private DBConnect dbc;

    public Workout(DBConnect dbc){
        this.dbc = dbc;
    }

    public boolean loadIndoorWorkoutToDB(Date date, Time starttime, int duration, int shape, int performance,
                                         String note, int person_id, String air, int spectators){
        return true;
    }

    public boolean loadOutdoorWorkoutToDB(Date date, Time starttime, int duration, int shape, int performance,
                                          String note, int person_id, String weather, int temperature){
        return true;
    }

    private boolean loadWorkoutToDB(int id, Date date, Time starttime, int duration,
                                    int shape, int performance, String note, int person_id){
        return true;
    }

    private int getID(){
        return 0;
    }

    public ResultSet getAllWorkouts(){
        return null;
    }

    public ResultSet getWorkoutsForPeriode(){
        return null;
    }

    public ResultSet getInfo(){
        return null;
    }

    public ResultSet getTemplate(){
        return null;
    }

    public ResultSet getAllTemplates(){
        return null;
    }

}
