package code;
import java.sql.*;

public class Category {
    private DBConnect dbc;

    public Category(DBConnect dbc){
        this.dbc = dbc;
    }

    public boolean deleteSub(int id){
        String stmt = "DELETE FROM ukategori " +
                "WHERE ukatID = " + id;
        return dbc.setData(stmt);
    }

    public boolean changeCat(int id, int new_category_ID){
        String stmt = "UPDATE ukategori SET katID = " + new_category_ID +
                " WHERE ukatID = " + id+";";
        return dbc.setData(stmt);
    }

    public boolean createSub(String name, int category_ID){
        String stmt = "SELECT MAX(ukatID) FROM ukategori;";
        ResultSet res = dbc.getData(stmt);
        int id = -1;
        try{
            if (res.next()){
                id = res.getInt("ukatID");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        if (id != -1){
            stmt = "INSERT INTO ukategori (ukatID, navn, katID) " +
                    "VALUES ('" + id + "', '" + name + "', '" + category_ID + "');";
            return dbc.setData(stmt);
        }
        else{
            return false;
        }
    }

    public boolean deleteCat(int id){
        String stmt = "DELETE FROM kategori " +
                "WHERE katID = " + id+";";
        return dbc.setData(stmt);
    }

    public boolean createCat(String name){
        String stmt = "SELECT MAX(katID) FROM kategori;";
        ResultSet res = dbc.getData(stmt);
        int id = -1;
        try{
            if (res.next()){
                id = res.getInt("katID");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        if (id != -1){
            stmt = "INSERT INTO ukategori (katID, navn) " +
                    "VALUES ('" + id + "', '" + name + "');";
            return dbc.setData(stmt);
        }
        else{
            return false;
        }
    }
}
