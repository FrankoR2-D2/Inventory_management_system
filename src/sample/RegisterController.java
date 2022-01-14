package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {
    private String name, surname, email, phone, role, password, username, password_second;

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword_second(String password_second) {
        this.password_second = password_second;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getName(){
        return this.name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
    public String getPassword2() {
        return password_second;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_register;

    @FXML
    private Label lbl_confirm;

    @FXML
    private Label lbl_email;

    @FXML
    private Label lbl_firstname;

    @FXML
    private Label lbl_password;

    @FXML
    private Label lbl_role;

    @FXML
    private Label lbl_surname;

    @FXML
    private Label lbl_username;

    @FXML
    private PasswordField txf_confirm_pass;

    @FXML
    private TextField txf_email;

    @FXML
    private TextField txf_firstname;

    @FXML
    private PasswordField txf_password;

    @FXML
    private TextField txf_reg_username;

    @FXML
    private TextField txf_role;

    @FXML
    private TextField txf_surname;

    @FXML
    private Button btn_login_scene;

    @FXML
    private TextField txf_phone;

    @FXML
    private Label lbl_promt_msg;

    public void on_btn_login_scene_clicked(ActionEvent event)
    {
        open_login_scene();
        Stage stage = (Stage) btn_login_scene.getScene().getWindow();
        stage.close();
    }

    public void on_clicked_close(ActionEvent event){
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }

    public void on_clicked_register_user(ActionEvent event)
    {
        register_user();
        if(staff_created()){
            lbl_promt_msg.setText("Staff member Registered.");
        }
    }
    public void staff_created(Boolean msg){
        if(msg) {
            staff_created();
        }
    }
    public Boolean staff_created(){
        return true;
    }

    public void register_user(){
        get_input();
        Boolean staff_created = false;
        try {
            String insert = "INSERT INTO public.staff(\n" +
                    "\t fk_store_id, staff_name, staff_surname, staff_email, staff_phone, staff_role, password, username)\n" +
                    "\tVALUES ( '3', '"+getName()+"', '"+getSurname()+"', '"+getEmail()+"', '"+getPhone()+"', '"+getRole()+"', '"+getPassword()+"', '"+getUsername()+"');";


            DatabaseConnection db_obj = new DatabaseConnection();
            Connection db_con = db_obj.getConnection();

            PreparedStatement preparedStatement = db_con.prepareStatement(insert);
            ResultSet result = preparedStatement.executeQuery();
            System.out.println("Staff member Registered.");
            staff_created=true;
            staff_created(staff_created);
            db_con.close();
        }catch(SQLException e)
        {
            //e.printStackTrace();
        }
        staff_created(staff_created);
    }

public void get_input(){
    setName(txf_firstname.getText());
    setSurname(txf_surname.getText());
    setEmail(txf_email.getText());
    setPhone(txf_phone.getText());
    setRole(txf_role.getText());
    setPassword(txf_password.getText());
    setPassword_second(txf_confirm_pass.getText());
    setUsername(txf_reg_username.getText());

    if(check_passwords()){

    }
    else {
        lbl_promt_msg.setText("Invalid Input. Check Your Password fields.");
    }
}

public Boolean check_passwords()
{
    Boolean is_valid = false;
    String p1 = getPassword();
    String p2 = getPassword();
    if(p1.contentEquals(p2)){
        is_valid=true;
    }
    return is_valid;
}


    public void open_login_scene()
    {
        try{
            Stage register_scene = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("views/Log_in.fxml"));
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
