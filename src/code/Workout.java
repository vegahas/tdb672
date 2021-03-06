package code;
import java.sql.*;

public class Workout {

    private DBConnect dbc;

    public Workout(DBConnect dbc){
        this.dbc = dbc;
    }

    public int loadIndoorWorkoutToDB(Date date, Time starttime, int duration, int shape, int performance,
                                         String note, int person_id, String air, int spectators){
        int id = loadWorkoutToDB(date, starttime, duration, shape, performance, note, person_id);
        if (id != -1) {
            String stmt = "INSERT INTO innetrening (personID, treningsID, luft, tilskuere) VALUES (" +
                    person_id + ", " + id + ", '" + air + "', " + spectators + ");";
            dbc.setData(stmt);
        }
        return id;
    }

    public int loadOutdoorWorkoutToDB(Date date, Time starttime, int duration, int shape, int performance,
                                          String note, int person_id, String weather, int temperature){
        int id = loadWorkoutToDB(date, starttime, duration, shape, performance, note, person_id);
        if (id != -1) {
            String stmt = "INSERT INTO utetrening (personID, treningsID, værtype, temperatur) VALUES (" +
                    person_id + ", " + id + ", '" + weather + "', " + temperature + ");";
            dbc.setData(stmt);
        }
        return id;
    }

    private int loadWorkoutToDB(Date date, Time starttime, int duration,
                                    int shape, int performance, String note, int person_id){
        String stmt ="SELECT MAX(treningsID) as 'num' FROM treningsøkt " +
                    "WHERE personID = " +person_id+";";
        ResultSet res = dbc.getData(stmt);
        int id = -1;
        try {
            if (res.next()) {
                id = res.getInt("num");
            }else{
                id = 0;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        if(id != -1) {
            id += 1;
            stmt = "INSERT INTO treningsøkt (treningsID, dato, starttidspunkt, varighet, personligForm, prestasjon, "+
                    "notat, personID) VALUES ("+id+", '"+date+"', '"+starttime+"', "+duration+", "+shape+", "+
                    performance+", '"+ note+"', "+person_id+");";
            dbc.setData(stmt);
            return id;
        }else{
            return -1;
        }
    }

    public int getID(int person_id, Date date, Time start_time){
        String stmt = "SELECT treningsID FROM treningsøkt WHERE personID = "+person_id+" AND " +
                "dato = "+date+" AND starttidspunkt = "+start_time+";";
        ResultSet res = dbc.getData(stmt);
        int index = 0;
        int id = -1;
        try{
            while (res.next()){
                id = res.getInt("treningsID");
                index += 1;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        if (index ==1){
            return id;
        }else{
            return -1;
        }
    }

    public ResultSet getAllWorkouts(int person_id){
        String stmt = "SELECT treningsID, dato, starttidspunkt, varighet, personligForm, prestasjon FROM treningsøkt WHERE personID = "+person_id+";";
        return dbc.getData(stmt);
    }

    public ResultSet getWorkoutsForPeriode(int person_id, Date startDate, Date endDate){
        String stmt = "SELECT treningsID, dato, starttidspunkt FROM treningsøkt WHERE personID = "+person_id+
                " AND dato >= "+startDate+" AND dato <= "+endDate+";";
        return dbc.getData(stmt);
    }

    public ResultSet getInfo(int person_id, int workout_id, boolean indoor){
        String stmt;
        if (indoor) {
            stmt = "SELECT * FROM treningsøkt " +
                    "INNER JOIN innetrening ON innetrening.personID = treningsøkt.personID AND " +
                    "innetrening.treningsID = treningsøkt.treningsID " +
                    "WHERE treningsøkt.personID = " + person_id + " AND treningsøkt.treningsID = " + workout_id + ";";
        }else{
            stmt = "SELECT * FROM treningsøkt " +
                    "INNER JOIN utetrening ON utetrening.personID = treningsøkt.personID AND " +
                    "utetrening.treningsID = treningsøkt.treningsID " +
                    "WHERE treningsøkt.personID = "+person_id+" AND treningsøkt.treningsID = "+workout_id+";";
        }
        return dbc.getData(stmt);
    }

    public ResultSet getExercisesForWorkout(int person_id, int workout_id){
        String stmt = "SELECT øvelse.øvelsesID, navn FROM øvelse " +
                "INNER JOIN treningsøvelse ON " +
                "øvelse.øvelsesID = treningsøvelse.øvelsesID " +
                "WHERE personID = "+person_id+" AND treningsID = "+workout_id+";";
        return dbc.getData(stmt);
    }

    public boolean connectExercise(int person_id, int workout_id, int exercise_id, int result){
        String stmt = "INSERT INTO treningsøvelse (treningsID, øvelsesID, personID, resultat) VALUES " +
                "("+workout_id+", "+exercise_id+", "+person_id+", '"+result+"');";
        return dbc.setData(stmt);
    }

    public ResultSet getAllforAllWorkouts(int person_id){
        String stmt = "SELECT * FROM treningsøkt " +
                "INNER JOIN treningsøvelse ON treningsøkt.treningsID = treningsøvelse.treningsID " +
                "AND treningsøkt.personID = treningsøvelse.personID " +
                "INNER JOIN øvelse ON øvelse.øvelsesID = treningsøvelse.øvelsesID " +
                "WHERE treningsøkt.personID = "+person_id+";";
        return dbc.getData(stmt);
    }
}
