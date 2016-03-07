package code;
import java.sql.*;

public class Exercise {

    private DBConnect dbc;

    public Exercise(DBConnect dbc){
        this.dbc = dbc;
    }

    public boolean loadToDB(String name, String description, int load, int reps, int sets, int subCatID){
        String stmt = "INSERT INTO øvelse (navn, beskrivelse, belastning, antall_repetisjoner, " +
                "antall_sett, ukatID) VALUES ('" + name + "', '"
                + description + "', " + load + ", " + reps + ", " + sets + ", " + subCatID + ");";
        return dbc.setData(stmt);
    }

    public ResultSet getAllIDNames(){
        String stmt = "SELECT øvelsesID, navn FROM øvelse " +
                "ORDER BY navn;";
        return dbc.getData(stmt);
    }

    public ResultSet getInfo(int id){
        String stmt = "SELECT * FROM øvelse " +
                "INNER JOIN ukategori ON øvelse.ukatID = ukategori.ukatID " +
                "WHERE øvelsesID = "+id+";";
        return dbc.getData(stmt);
    }

    public ResultSet getSubstitutes(int id){
        String stmt = "SELECT navn, øvelsesID FROM øvelse " +
                "INNER JOIN ukategori ON øvelse.ukatID = ukategori.ukatID " +
                "WHERE øvelsesID = " + id+" " +
                "ORDER BY øvelse.navn";
        return dbc.getData(stmt);
    }

    public boolean deleteExcerise(int id){
        String stmt = "DELETE FROM øvelse " +
                "WHERE øvelsesID = " + id+";";
        return dbc.setData(stmt);
    }

    public boolean changeSub(int id, int new_subcat_id){
        String stmt = "UPDATE øvelse SET øvelsesID = " + new_subcat_id +
                " WHERE øvelsesID = " + id+";";
        return dbc.setData(stmt);
    }
}
