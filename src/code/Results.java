package code;
import java.sql.*;

public class Results {

    private DBConnect dbc;

    public Results(DBConnect dbc){
        this.dbc = dbc;
    }

    public ResultSet getAllResults(int person_id){
        String stmt = "SELECT resultat, treningsid FROM treningsøvelse";

        /*
        String stmt = "SELECT øvelsesID, treningsøvelse.treningsID, dato, resultat FROM treningsøvelse " +
                "INNER JOIN treningsøkt ON treningsøkt.treningsID = treningsøvelse.øvelsesID " +
                "AND treningsøkt.personID = treningsøvelse.personID " +
                "WHERE treningsøvelse.personID = "+person_id+";";
        */
        return dbc.getData(stmt);
    }

    public ResultSet getPeriodeBestResults(int person_id, Date start_date, Date end_date){
        String stmt = "SELECT øvelsesID, resultat, dato FROM treningsøvelse " +
                "INNER JOIN treningsøkt ON treningsøkt.treningsID = treningsøvelse.treningsID " +
                "AND treningsøvelse.personID = treningsøkt.personID " +
                "WHERE personID = "+person_id+" AND dato <= "+start_date+" AND dato >= "+end_date+
                " AND resultat = " +
                "(SELECT MAX(resultat) FROM treningsøvelse " +
                "INNER JOIN treningsøkt ON treningsøkt.treningsID = treningsøvelse.treningsID " +
                "AND treningsøvelse.personID = treningsøkt.personID " +
                "WHERE personID = "+person_id+" AND dato <= "+start_date+" AND dato >= "+end_date+");";
        return dbc.getData(stmt);
    }

    public ResultSet getResultsGoals(int person_id, int exercise_id, Date start_date, Date end_date){
        String stmt ="SELECT resultat, dato, beskrivelse FROM treningsøvelse " +
                "INNER JOIN mål ON mål.personID = treningsøvelse.personID " +
                "AND mål.øvelsesID = treningsøvelse.øvelsesID " +
                "INNER JOIN treningsøkt ON treningsøvelse.personID = treningsøkt.personID " +
                "AND treningsøvelse.treningsID = treningsøkt.treningsID " +
                "WHERE personID = "+person_id+" AND dato >= "+start_date+" AND dato <= "+end_date+
                " AND startdato <= "+end_date+" AND sluttdato >= "+start_date+
                " AND øvelsesID = "+exercise_id+";";
        return dbc.getData(stmt);
    }

    public ResultSet getResultsShapePerformance(int person_id, int exercise_id, Date start_date, Date end_date){
        String stmt ="SELECT resultat, personligForm, prestasjon, dato FROM treningsøkt " +
                "INNER JOIN treningsøvelse ON treningsøkt.personID = treningsøvelse.personID " +
                "AND treningsøvelse.treningsID = treningsøkt.treningsID " +
                "WHERE personID = "+person_id+" AND dato <= "+start_date+" AND dato >= "+end_date+
                " AND øvelsesID = "+exercise_id+";";
        return dbc.getData(stmt);
    }
}
