import java.sql.*;

public class test {
    public static void main(String[] args)throws Exception {

        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/treningsdagbok", "student", "student");
        Statement myStmt = myCon.createStatement();
        String ins = "INSERT INTO poststed" +
                "(postnr, poststed)" +
                "values (0456, 'Oslo');";
        String stmt ="SELECT * FROM poststed" +
                " WHERE postnr > 5000;";
        //myStmt.executeUpdate(ins);
        ResultSet res = myStmt.executeQuery(stmt);

        while (res.next()){
            System.out.println(res.getInt("postnr") +" " +res.getString("poststed"));
        }
    }
}
