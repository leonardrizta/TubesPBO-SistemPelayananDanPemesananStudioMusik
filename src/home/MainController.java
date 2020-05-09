package home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void changeHomeLayout() {
        mainPane.setCenter(loadUI("home"));
    }

    @FXML
    public void changeOrderLayout() {
        mainPane.setCenter(loadUI("order"));
    }

    @FXML
    public void changeHistoryLayout() {
        mainPane.setCenter(loadUI("history"));
    }

    private HBox loadUI(String filename) {
        HBox a = null;
        try {
            a = FXMLLoader.load(getClass().getResource(filename + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }
}
