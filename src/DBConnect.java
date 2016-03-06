//

import java.sql.*;

/**
 * Created by odinblomhoffpedersen on 06.03.2016.
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TreningsDagbok", "root", "");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }

    public void getData() {
        try {

            String query = "select * from  person";
            rs = st.executeQuery(query);
            System.out.println("Henta fra database");
            while(rs.next()) {
                String name = rs.getString("navn");
                System.out.println("Name "+name);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
