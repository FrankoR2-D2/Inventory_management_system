package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.text.LabelView;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;


public class LoginController implements Initializable {

    private String staff_member, password;

    public String getStaff_member(){
        return this.staff_member;
    }
    public String get_password(){
        return this.password;
    }
    private void set_staff_member(String staff){
        this.staff_member = staff;
    }
    private void set_password(String psw){
        this.password = psw;
    }
    @FXML
    private Button bnt_cancel;

    @FXML
    private Label lbl_message;

    @FXML
    private ImageView imageview_branding;
    @FXML
    private ImageView imageview_login;

    @FXML
    private TextField txf_username;

    @FXML
    private PasswordField txf_password;

    @FXML
    private Label lbl_register;

    @FXML
    private Button btn_register;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("C:\\Users\\f97re\\Desktop\\Fraels\\Current\\Programming\\Java\\Rocket_demo2\\src\\sample\\images\\RocketHome.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        imageview_branding.setImage(brandingImage);

        File loginFile = new File("C:\\Users\\f97re\\Desktop\\Fraels\\Current\\Programming\\Java\\Rocket_demo2\\src\\sample\\images\\RocketLogin.png");
        Image loginImage = new Image(loginFile.toURI().toString());
        imageview_login.setImage(loginImage);
    }



    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) bnt_cancel.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) {
        lbl_message.setText("You tried to login.");
        if (txf_username.getText().isBlank() == false && txf_password.getText().isBlank() == false) {
            lbl_message.setText("Validate login");
            validateLogin();
        } else {
            lbl_message.setText("Please enter username and password.");
        }
    }

    public void validateLogin() {

        if(validate_user())
        {
            lbl_message.setText("Welcome Back.");
            set_staff_member(return_user());
            set_password(return_password());
            create_rocket_view();
            Stage stage = (Stage) btn_register.getScene().getWindow();
            stage.close();

        }else{
            lbl_message.setText("Invalid Login. Please try again.");
        }


    }

    public void create_rocket_view(){
        try{
            Stage register_scene = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("views/RocketView.fxml"));
            register_scene.getIcons().add(new Image("C:\\Users\\f97re\\Desktop\\Fraels\\Current\\Programming\\Java\\Rocket_demo2\\src\\sample\\images\\rocket44.png"));
            //stage.initStyle(StageStyle.UNDECORATED);
            register_scene.setTitle("Rocket Racoon Inventory");
            register_scene.setScene(new Scene(root,1280, 800) );
            register_scene.show();
            register_scene.setResizable(false);

        }catch (Exception e){
            e.printStackTrace();
            getClass();
        }
    }

    private  Boolean validate_user(){
        Boolean user = false;
        try {
            String verifyLogin1 = "SELECT count(1) FROM public.staff WHERE username = '" + txf_username.getText()
                    + "' AND password = '" + txf_password.getText() + "';";
            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            System.out.println("kyk nou");

            Statement st1 = db_con.createStatement();
            ResultSet rs = st1.executeQuery(verifyLogin1);
            int count = 0;
            while (rs.next()){
                System.out.println("Count: "+Integer.valueOf(rs.getInt("count")));
                count = Integer.valueOf(rs.getInt("count"));

            }
            if(count==1)
            {
                lbl_message.setText("Welcome Back.");
                user =true;

            }
            db_con.close();
            return  user ;


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;
    }

    public  String return_user(){
        String user = "Oops";
        try {
            String strUsername = "SELECT staff.username FROM public.staff WHERE password = '"+ txf_password.getText() +"';";

            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            System.out.println("kyk nou");


            Statement st = db_con.createStatement();
            ResultSet rs = st.executeQuery(strUsername);
            while (rs.next()){
                System.out.println("Username: "+String.valueOf(rs.getString("username")));
                user = String.valueOf(rs.getString("username"));
            }
            db_con.close();
            return user;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;
    }


    public String return_password(){
        String pass = "admin123";
        try {
            String strPassword = "SELECT staff.password FROM public.staff WHERE username= '"+ txf_username.getText() +"';";

            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            System.out.println("kyk nou");


            Statement st = db_con.createStatement();
            ResultSet rs = st.executeQuery(strPassword);
            while (rs.next()){
                System.out.println("Password: "+String.valueOf(rs.getString("password")));
                pass = String.valueOf(rs.getString("password"));
            }
            db_con.close();
            return pass;


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return pass;
    }




        public void onClickedToReg(ActionEvent event){
            create_account_form();
            Stage stage = (Stage) btn_register.getScene().getWindow();
            stage.close();

        }

        public void create_account_form()
        {
            try{
                Stage register_scene = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("views/Register.fxml"));
                register_scene.getIcons().add(new Image("C:\\Users\\f97re\\Desktop\\Fraels\\Current\\Programming\\Java\\Rocket_demo2\\src\\sample\\images\\rocket44.png"));
                //stage.initStyle(StageStyle.UNDECORATED);
                register_scene.setTitle("Rocket Racoon Inventory");
                register_scene.setScene(new Scene(root,800, 600) );
                register_scene.show();
            }catch (Exception e){
                e.printStackTrace();
                getClass();
            }
        }

}
