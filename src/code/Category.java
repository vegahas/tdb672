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
        String stmt = "INSERT INTO ukategori (navn, katID) " +
                "VALUES ('" + name + "', '" + category_ID + "');";
        return dbc.setData(stmt);
    }

    public boolean deleteCat(int id){
        String stmt = "DELETE FROM kategori " +
                "WHERE katID = " + id+";";
        return dbc.setData(stmt);
    }

    public boolean createCat(String name){
        String stmt = "INSERT INTO kategori (navn) " +
                "VALUES ('" + name + "');";
        return dbc.setData(stmt);
    }

    public ResultSet getAllSubCat(){
        String stmt = "SELECT * FROM ukategori ORDER BY navn;";
        return dbc.getData(stmt);
    }

    public ResultSet getAllCat(){
        String stmt = "SELECT * FROM kategori ORDER BY navn;";
        return dbc.getData(stmt);
    }

    public ResultSet getEmptySubCat(){
        String stmt = "SELECT navn, ukatID FROM ukategori " +
                "LEFT JOIN øvelse ON øvelse.ukatID = ukategori.ukatID " +
                "WHERE øvelsesID IS NULL;";
        return dbc.getData(stmt);
    }

    public ResultSet getEmptyCat(){
        String stmt = "SELECT navn, katID FROM kategori " +
                "LEFT JOIN ukategori ON kategori.katID = ukategori.katID " +
                "WHERE ukatID IS NULL;";
        return dbc.getData(stmt);
    }
}
