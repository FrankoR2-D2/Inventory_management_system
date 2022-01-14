package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/Log_in.fxml"));
        stage.getIcons().add(new Image("C:\\Users\\f97re\\Desktop\\Fraels\\Current\\Programming\\Java\\Rocket_demo2\\src\\sample\\images\\rocket44.png"));
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Rocket Racoon Inventory");
        stage.setScene(new Scene(root,800, 600) );
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
