package code;
import java.sql.*;
public class Testrunner {




    public static void main(String[] args) {
        GUIConnect x = new GUIConnect();
        DBConnect a = new DBConnect();
        a.setData("INSERT INTO test (navn) VALUES ('hei');");
    }
}
