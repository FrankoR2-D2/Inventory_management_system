package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class RocketController implements Initializable {


    @FXML
    private Button btn_add_product;

    @FXML
    private Button btn_all_products;

    @FXML
    private Button btn_category;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_remove_product;

    @FXML
    private Label btn_settings;

    @FXML
    private TableColumn<Products, Double> col_cost;

    @FXML
    private TableColumn<Products, String> col_created;

    @FXML
    private TableColumn<Products, String> col_expire;

    @FXML
    private TableColumn<Products, Integer> col_id;

    @FXML
    private TableColumn<Products, Double> col_markup;

    @FXML
    private TableColumn<Products, Double> col_price;

    @FXML
    private TableColumn<Products, Integer> col_quantity;

    @FXML
    private TableColumn<Products, String> col_title;

    @FXML
    private TableColumn<Products, String> col_units;

    @FXML
    private ImageView lbl_rocket;

    @FXML
    private ImageView lbl_title;

    @FXML
    private Label lbl_title_heading;

    @FXML
    private ListView<String> list_categories;

    @FXML
    private Tab pane_add_products;

    @FXML
    private Tab pane_sub_cat;

    @FXML
    private TabPane tab_pane_controls;

    @FXML
    private TableView<Products> tbl_products;

    @FXML
    URL url;
    @FXML
    ResourceBundle resourceBundle;

    @FXML
    private TextField txf_cost;

    @FXML
    private TextField txf_created;

    @FXML
    private TextArea txf_desc;

    @FXML
    private TextField txf_exp;

    @FXML
    private TextField txf_markup;

    @FXML
    private TextField txf_price;

    @FXML
    private TextField txf_quantity;

    @FXML
    private TextField txf_remove_id;

    @FXML
    private TextField txf_remove_title;

    @FXML
    private TextField txf_title;

    @FXML
    private TextField txf_units;

    @FXML
    private ComboBox<String> btn_combo_cat;


    @FXML
    private TextField txf_tcost;
    @FXML
    private TextField txf_tmarkup;
    @FXML
    private TextField txf_tprice;
    @FXML
    private TextField txf_profit;
    @FXML
    private TextField txf_quan;
    @FXML
    private Label lbl_quan_val;
    @FXML
    private Button btn_quan_increment;
    @FXML
    private Button btn_quan_decrement;

    @FXML
    public void on_clicked_quan_add(ActionEvent event){

    }
    @FXML
    public void on_clicked_quan_minus(ActionEvent event){

    }
    @FXML
    private Button btn_select;

    ArrayList<String> sub_id = new ArrayList<>();
    ArrayList<String> sub_title = new ArrayList<>();
    ArrayList<String> fk_cat_id = new ArrayList<>();
    ArrayList<String> cat_id = new ArrayList<>();
    ArrayList<String> cat_title = new ArrayList<>();
    ArrayList<String> cat_desc = new ArrayList<>();


    @Override
    public void initialize(URL url,ResourceBundle resourceBundle ) {

        on_clicked_get_categories();
        categories();
        ObservableList<String> cat_t = FXCollections.observableArrayList(cat_title);
        btn_combo_cat.setItems(cat_t);
        calculate_markup();
        get_totals();
        showProducts();
    }

    public void on_clicked_btn_close(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }


    public void on_clicked_btn_all_products(ActionEvent event) {

        showProducts();
    }

    public void on_click_categories(ActionEvent event){
        showCategories();
    }

    public void on_clicked_get_categories(){
        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();
            Statement statement = db_con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.sub_category;");



            while ((rs.next())) {
                sub_id.add(String.valueOf(rs.getArray("sub_id")));
                sub_title.add(String.valueOf(rs.getArray("sub_title")));
                fk_cat_id.add(String.valueOf(rs.getArray("fk_cat_id")));
            }


        } catch (SQLException e) {
            System.out.println("Could not get Products");
            e.printStackTrace();
        }


        showCategories();
    }


    public ObservableList<Products> getProductsList() {
        ObservableList<Products> product_list = FXCollections.observableArrayList();

        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();
            Statement statement = db_con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.inventory;");

            Products products;

            while ((rs.next())) {
                products = new Products(rs.getInt("product_id"), rs.getString("product_title"),
                        rs.getInt("quantity"), rs.getDouble("cost"), rs.getDouble("price"),
                        rs.getDouble("markup"), rs.getString("created_date"), rs.getString("exp_date"), rs.getString("units"));
                product_list.add(products);
            }


        } catch (SQLException e) {
            System.out.println("Could not get Products");
            e.printStackTrace();
        }
        return product_list;
    }




    public void categories(){
        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();
            Statement statement = db_con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.category;");


            while ((rs.next())) {
                cat_id.add(String.valueOf(rs.getArray("cat_id")));
                cat_title.add(String.valueOf(rs.getArray("cat_title")));
                cat_desc.add(String.valueOf(rs.getArray("cat_desc")));
            }


        } catch (SQLException e) {
            System.out.println("Could not get Products");
            e.printStackTrace();
        }


    }


    public void showCategories() {

        list_categories.getItems().addAll(sub_title);
    }

    public void showProducts() {
        ObservableList<Products> list = getProductsList();

        col_id.setCellValueFactory(new PropertyValueFactory<Products, Integer>("id"));
        col_title.setCellValueFactory(new PropertyValueFactory<Products, String>("title"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<Products,Integer>("quantity"));
        col_cost.setCellValueFactory(new PropertyValueFactory<Products, Double>("cost"));
        col_price.setCellValueFactory(new PropertyValueFactory<Products,Double>("price"));
        col_markup.setCellValueFactory(new PropertyValueFactory<Products,Double>("markup"));
        col_created.setCellValueFactory(new PropertyValueFactory<Products, String>("created"));
        col_expire.setCellValueFactory(new PropertyValueFactory<Products,String>("exp"));
        col_units.setCellValueFactory(new PropertyValueFactory<Products, String>("units"));

        tbl_products.setItems(list);
    }


    public void insert_products(ActionEvent event){
        String query = "INSERT INTO public.inventory(product_title, quantity," +
                " cost, price, markup, created_date, exp_date, "
        +"product_desc, units)" + " VALUES ( '"+txf_title.getText()+"', '"+txf_quantity.getText()
                +"', '"+txf_cost.getText()+"', '"+txf_price.getText()+"', '"+txf_markup.getText()+"', '"+txf_created.getText()
                +"', '"+txf_exp.getText()+"', '"+txf_desc.getText()+"', '"+txf_units.getText()+"');";
        System.out.println(query);

        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            PreparedStatement preparedStatement = db_con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Staff member Registered.");

            db_con.close();
        }catch (SQLException e)
        {

        }
        showProducts();

    }

    public void delete_product(ActionEvent event){

    String id = txf_remove_id.getText();
    String title = txf_remove_title.getText();

    if(id.isBlank()==false){
        String query_id = "DELETE FROM public.inventory " +
                " WHERE product_id = "+txf_remove_id.getText();
        System.out.println(query_id);

        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            PreparedStatement preparedStatement = db_con.prepareStatement(query_id, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Product deleted (by id).");

            db_con.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    if(title.isBlank()==false){

        String query_title = "DELETE FROM public.inventory " +
                " WHERE product_title = '"+txf_remove_title.getText()+"'";
        System.out.println(query_title);

        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            PreparedStatement preparedStatement = db_con.prepareStatement(query_title);
            int update = preparedStatement.executeUpdate();
            System.out.println("Product deleted (by title).");

            db_con.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    showProducts();
}



    public static void calculate_markup(){
    HashMap<Integer, Double> markup_map = new HashMap<Integer, Double>();

    String query = "SELECT  product_id, cost, price FROM public.inventory;";
    String update_markup = "";
    int id;
    double cost, price, markup;
    try {
        DatabaseConnection db_obj = new DatabaseConnection();
        Connection db_con = db_obj.getConnection();

        Statement statement = db_con.createStatement();

        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            id = rs.getInt("product_id");
            cost = rs.getDouble("cost");
            price = rs.getDouble("price");
            markup = ((price - cost) / cost) * 100;

            markup_map.put(id, markup);

            update_markup = "UPDATE public.inventory " +
                    "SET markup= " + markup_map.get(id) +
                    " WHERE product_id= " + id + ";";

            PreparedStatement preparedStatement = db_con.prepareStatement(update_markup);
            double m_up = preparedStatement.executeUpdate();
            System.out.println(m_up + " Was updated.");

            System.out.println("Markup updated (by id).");
        }
        db_con.close();
    }catch (SQLException e)
    {
        e.printStackTrace();
    }
}



    public void get_totals(){
        ArrayList<Double> cost = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        try {
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            Statement statement = db_con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.inventory;");

            int n = 0;
            while ((rs.next())) {
                cost.add(rs.getDouble("cost"));
                price.add(rs.getDouble("price"));
                System.out.println('A');
                n++;
            }
            calc_totals(cost, price, n);

        db_con.close();

        } catch (SQLException e) {
            System.out.println("Could not get Products");
            e.printStackTrace();
        }
    }


    private void calc_totals(ArrayList<Double> cost, ArrayList<Double> price, int size){
        int k = 0;
        double tot_cost = 0;
        double  tot_price = 0;

        while (k < size){
            System.out.println(cost.get(k));
            tot_cost += cost.get(k);
            tot_price += price.get(k);
            k++;
        }
        System.out.println("Total cost: " + tot_cost );
        double tot_markup = ((tot_price - tot_cost)/tot_cost)*100;
        double tot_profit = tot_price-tot_cost;

        txf_tcost.setText(String.valueOf(tot_cost));
        txf_tprice.setText(String.valueOf(tot_price));
        txf_tmarkup.setText(String.valueOf(tot_markup));
        txf_profit.setText(String.valueOf(tot_profit));
    }

    public  void btn_select(ActionEvent event)
    {
        set_quant_id();
    }

    public void set_quant_id(){

        String id = txf_quan.getText();
        if (id.isBlank())
        {
            JOptionPane.showMessageDialog(null, "Enter the Title id: ");
        }
        System.out.println("Quantity id = " + id);
        try{
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();
            String str = "SELECT quantity FROM public.inventory where product_id = " + id+";";
            Statement statement = db_con.createStatement();
            ResultSet  rs = statement.executeQuery(str);
            while (rs.next()){
                System.out.println(rs.getString("quantity"));
                lbl_quan_val.setText(rs.getString("quantity"));
            }

            db_con.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }



}

