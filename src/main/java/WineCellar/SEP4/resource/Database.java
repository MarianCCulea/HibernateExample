package WineCellar.SEP4.resource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    private static Database instance;

    public Database() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            String url = "jdbc:sqlserver://localhost;database=SupplyVetSep3;";
            this.connection = DriverManager.getConnection(url, "second", "password");
            System.out.println("Connection established ");
        } catch (Exception exception) {
            System.out.println("Connection failed");
            exception.printStackTrace();
        }

    }

    public synchronized static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public ArrayList<Item> getAllItems() throws SQLException
    {
        ArrayList<Item> items = new ArrayList<>();
        statement = connection.createStatement();
        String sql = "select * from item";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {

            Item item = new Item(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5),
                    resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8),
                    resultSet.getInt(9));
            items.add(item);
        }
        return items;
    }

}