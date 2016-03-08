package code;
import java.sql.*;

public class DBConnect {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/tdb67";
    static final String USER = "student";
    static final String PASS = "student";

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet getData(String query) {
        try {
            rs = st.executeQuery(query);
        } catch (Exception ex) {
            System.out.println(ex);
            rs = null;
        }
        return rs;
    }

    public boolean setData(String query) {
        try{
            st.executeUpdate(query);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
