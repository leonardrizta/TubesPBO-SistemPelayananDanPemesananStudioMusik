package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane mainPane = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Sistem Pelayanan Dan Pemesanan Studio Musik");
        primaryStage.setScene(new Scene(mainPane, 853, 480));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
