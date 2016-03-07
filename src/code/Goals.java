package code;
import java.sql.*;

public class Goals {

    private DBConnect dbc;

    public Goals(DBConnect dbc){
        this.dbc = dbc;
    }

    public boolean loadToDB(Date start, boolean done, Date finish,
                            String description, int person_id, int exercise_id){
        String stmt ="SELECT MAX(målID) FROM mål;";
        ResultSet res = dbc.getData(stmt);
        int id = 0;
        try {
            if (res.next()) {
                id = res.getInt("målID");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        id += 1;
        stmt = "INSERT INTO mål (målID, startdato, oppnådd, sluttdato, beskrivelse, personID, øvelsesID) " +
                "VALUES (" + id + ", " + start + ", " + done + ", " + finish + ", '" + description + "', " +
                person_id + ", " + exercise_id + ");";
        return dbc.setData(stmt);
    }

    public ResultSet getInfo(int id, int person_id, int øvelses_id){
        String stmt = "SELECT * FROM mål WHERE personID = "+person_id+" AND øvelsesID = "+øvelses_id +" " +
                "AND øvelsesID = " + id +";";
        return dbc.getData(stmt);
    }

    public ResultSet getAllGoals(int person_id){
        String stmt = "SELECT målID, startdato, oppnådd, øvelse.navn FROM mål " +
                "INNER JOIN øvelse ON mål.øvelsesID = øvelse.øvelsesID " +
                "WHERE personID = "+person_id +" " +
                "ORDER BY målID;";
        return dbc.getData(stmt);
    }

}
