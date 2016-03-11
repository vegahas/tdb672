package code;
import java.sql.*;

public class Diary {

    private DBConnect dbc;

    public Diary(DBConnect dbc){
        this.dbc = dbc;
    }

    public ResultSet getDiary(int person_id){
        String stmt = "SELECT dato, starttidspunkt, notat FROM treningsøkt " +
                "WHERE personID = "+ person_id+" ORDER BY dato, starttidspunkt;";
        return dbc.getData(stmt);
    }
}
