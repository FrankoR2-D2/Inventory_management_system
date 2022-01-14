package sample;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {


    private final String url = "jdbc:postgresql://localhost:5432/rocket_racoon";
    private final String user = "postgres";
    private final String password = "SuperMax7887!";

    public String getUrl(){
        return this.url;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
            System.out.println("Connection established\n \n \nDas Boot:\n");


        }catch (SQLException e_sql)
        {
            System.out.println("SQL exception");
            e_sql.printStackTrace();
        }catch(ClassNotFoundException e_class){
            System.out.println("Class not found. Goodluck.");
            e_class.printStackTrace();
        }
        return con;
    }


    public void closeConnection(Connection c)  {
        try {
            c.close();
            System.out.println("Connection closed.");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public  void getProducts(Connection con)  {
        ArrayList<String> prod_title = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");

            while (query.next()) {
                prod_title.add(String.valueOf(query.getArray("product_title")));
            }

            int n = 0;
            while (n < prod_title.size())
            {
                System.out.println(prod_title.get(n));
                n++;
            }
            System.out.println("Products retrieved");
        }catch (SQLException e)
        {
            System.out.println("Could not get Products");
            e.printStackTrace();
        }

    }

}
