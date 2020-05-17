package home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginLayout;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    public Label loginResult;

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void actionLogin (){
        if (username.getText().equals("admin") && password.getText().equals("admin")){
            loginResult.setText("Berhasil Login!!!");
            Main main = new Main();
            try {
                main.start(new Stage());
                Stage stage = (Stage) loginLayout.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            loginResult.setTextFill(Color.web("#ff000a", 1));
            loginResult.setText("Username dan Password yang Dimasukkan Salah!!!");
        }
    }
}
