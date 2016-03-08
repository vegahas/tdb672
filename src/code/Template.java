package code;
import java.sql.*;

public class Template {

    private DBConnect dbc;

    public Template(DBConnect dbc){
        this.dbc = dbc;
    }

    public ResultSet getTemplate(int person_id, int workout_id){
        String stmt ="SELECT mal.navn, mal.treningsID, øvelse.id, øvelse.navn FROM mal " +
                "INNER JOIN treningsøvelse ON mal.personID = treningsøvelse.personID " +
                "AND mal.treningsID = treningsØvelse.treningsID " +
                "INNER JOIN øvelse ON øvelse.øvelsesID = treningsøvelse.øvelsesID " +
                "WHERE personID = "+person_id+ " AND treningsID = "+workout_id+";";
        return dbc.getData(stmt);
    }

    public ResultSet getAllTemplates(int person_id){
        String stmt = "SELECT navn, treningsID FROM mal WHERE personID = "+person_id+";";
        return dbc.getData(stmt);
    }

    public boolean loadTemplateToDB(int person_id, int workout_id, String name){
        String stmt = "INSERT INTO mal (personID, treningsID, navn) VALUES " +
                "("+person_id+", "+workout_id+", '"+name+"');";
        return dbc.setData(stmt);
    }

}
