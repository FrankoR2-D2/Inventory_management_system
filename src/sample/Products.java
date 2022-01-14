package sample;

import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;

public class Products {
    private int id;
    private String title;
    private int quantity;
    private double cost;
    private double price;
    private double markup;
    private  String created;
    private  String exp;
//    private String desc;
    private String units;

    public Products(int id, String title, int quantity, double cost, double price, double markup, String created, String exp,  String units) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
        this.markup = markup;
        this.created = created;
        this.exp = exp;

        this.units = units;
    }


    public String getUnits() {
        return units;
    }


    public String getCreated() {
        return created;
    }

    public String getExp() {
        return exp;
    }

    public double getCost() {
        return cost;
    }

    public double getMarkup() {
        return markup;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }






    //------------------------------------------------------------------------------------------------------------------//
//    private   ArrayList<Integer> product_id = new ArrayList<>();
//    private  ArrayList<String> product_title = new ArrayList<>();
//    private ArrayList<String> quantity = new ArrayList<String>();
//    private  ArrayList<String> cost = new ArrayList<String>();
//    private ArrayList<String> price = new ArrayList<String>();
//    private ArrayList<String> markup = new ArrayList<String>();
//    private  ArrayList<String> created = new ArrayList<String>();
//    private  ArrayList<String> expiration = new ArrayList<String>();
//    private ArrayList<String> desc = new ArrayList<>();
//    private  ArrayList<String> units = new ArrayList<>();
//
//    Products(){
//        get_id();
//        get_title();
//        get_quantity();
//        get_cost();
//        get_price();
//        get_created();
//        get_expiration();
//        get_desc();
//        get_units();
//    }
//
//    public  ArrayList<Integer> return_id(){
//        return this.product_id;
//    }
//
//    public ArrayList<String> return_title() {
//        return product_title;
//    }
//
//    public void get_id() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                product_id.add(Integer.valueOf(String.valueOf(query.getArray("product_id"))));
//            }
//
//            int n = 0;
//            while (n < product_id.size()) {
//                System.out.println(product_id.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void get_title() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                product_title.add(String.valueOf(query.getArray("product_title")));
//            }
//
//            int n = 0;
//            while (n < product_title.size()) {
//                System.out.println(product_title.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    public void get_quantity() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                quantity.add(String.valueOf(query.getArray("quantity")));
//            }
//
//            int n = 0;
//            while (n < quantity.size()) {
//                System.out.println(quantity.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public void get_cost() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                cost.add(String.valueOf(query.getArray("cost")));
//            }
//
//            int n = 0;
//            while (n < cost.size()) {
//                System.out.println(cost.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public void get_price() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                price.add(String.valueOf(query.getArray("price")));
//            }
//
//            int n = 0;
//            while (n < price.size()) {
//                System.out.println(price.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public void get_markup() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                markup.add(String.valueOf(query.getArray("markup")));
//            }
//
//            int n = 0;
//            while (n < markup.size()) {
//                System.out.println(markup.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    public void get_created() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                created.add(String.valueOf(query.getArray("created_date")));
//            }
//
//            int n = 0;
//            while (n < created.size()) {
//                System.out.println(created.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void get_expiration() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                expiration.add(String.valueOf(query.getArray("exp_date")));
//            }
//
//            int n = 0;
//            while (n < expiration.size()) {
//                System.out.println(expiration.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    public void get_desc() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                desc.add(String.valueOf(query.getArray("product_desc")));
//            }
//
//            int n = 0;
//            while (n < desc.size()) {
//                System.out.println(desc.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void get_units() {
//        try {
//            DatabaseConnection db_obj = new DatabaseConnection();
//            Connection db_con = db_obj.getConnection();
//            Statement statement = db_con.createStatement();
//            ResultSet query = statement.executeQuery("SELECT * FROM public.inventory;");
//
//            while (query.next()) {
//                units.add(String.valueOf(query.getArray("units")));
//            }
//
//            int n = 0;
//            while (n < units.size()) {
//                System.out.println(units.get(n));
//                n++;
//            }
//            System.out.println("Products retrieved");
//        } catch (SQLException e) {
//            System.out.println("Could not get Products");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void display_title(){
//        int i = 0;
//        while (i<product_title.size())
//        {
//
//            System.out.println(product_title.get(i));
//
//        }
//
//    }
//
//    public void display_id  (){
//        int i = 0;
//        while (i<product_id.size())
//        {
//            System.out.println(product_id.get(i));
//
//            i++;
//        }
//    }
//    public void display_cost  (){
//        int i = 0;
//        while (i<cost.size())
//        {
//            System.out.println(cost.get(i));
//            i++;
//        }
//    }
//    public void display_quantiy  (){
//        int i = 0;
//        while (i<quantity.size())
//        {
//            System.out.println(quantity.get(i));
//            i++;
//        }
//    }
//
//    public void display_price  (){
//        int i = 0;
//        while (i<price.size())
//        {
//            System.out.println(price.get(i));
//            i++;
//        }
//    }
//
//    public void display_markup  (){
//        int i = 0;
//        while (i<markup.size())
//        {
//            System.out.println(markup.get(i));
//            i++;
//        }
//    }
//
//
//    public void display_created  (){
//        int i = 0;
//        while (i<created.size())
//        {
//            System.out.println(created.get(i));
//            i++;
//        }
//    }
//
//
//    public void display_exp  (){
//        int i = 0;
//        while (i<expiration.size())
//        {
//            System.out.println(expiration.get(i));
//            i++;
//        }
//    }
//
//    public void display_desc  (){
//        int i = 0;
//        while (i<desc.size())
//        {
//
//            System.out.println(desc.get(i));
//
//            i++;
//        }
//    }
//
//    public void display_units  (){
//        int i = 0;
//        while (i<units.size())
//        {
//            System.out.println(units.get(i));
//            i++;
//        }
//    }
}
