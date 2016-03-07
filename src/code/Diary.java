package code;
import java.sql.*;

public class Diary {

    private DBConnect dbc;

    public Diary(DBConnect dbc){
        this.dbc = dbc;
    }

    public ResultSet getDiary(int person_id){
        String stmt = "SELECT dato, starttidspunkt, notat FROM treningsøkt " +
                "ORDER BY dato, starttidspunkt WHERE personID = "+ person_id+";";
        return dbc.getData(stmt);
    }
}
