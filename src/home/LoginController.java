package home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Label notif;

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void actionLogin (){
        if (username.getText().equals("admin") && password.getText().equals("admin")){
            notif.setText("Berhasil Login!!!");
        }else{
            notif.setText("Username dan Password yang Dimasukkan Salah!!!");
        }
    }
}
