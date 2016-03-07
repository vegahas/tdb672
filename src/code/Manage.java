package code;
import java.sql.*;

public class Manage{
    private DBConnect dbc;


    public Manage(DBConnect dbc){
        this.dbc = dbc;
    }

    public boolean verifyUser(String name, int id){
        String stmt = "SELECT navn from person " +
                "WHERE personId = " + id+";";
        ResultSet res = dbc.getData(stmt);
        try{
            while (res.next()) {
                if (name.equals(res.getString("navn"))){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean createUser(String name){
        String stmt = "SELECT MAX(personID) FROM person;";
        ResultSet res = dbc.getData(stmt);      //get current max id
        int id = 0;
        try {
            if (res.next()) {
                id = res.getInt("personID");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        id += 1;
        stmt = "INSERT INTO person (personID, navn) VALUES ('" + id +"', '"+ name +"');";  //SQL
        return dbc.setData(stmt);
    }


}
