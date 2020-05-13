package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    ObservableList<String> studioChoiceList = FXCollections.observableArrayList("Regular", "VIP");
    ObservableList<String> durationChoiceList = FXCollections.observableArrayList("1 Jam", "2 Jam", "3 Jam", "5 Jam");
    @FXML
    private ChoiceBox<String> studioChoiceBox;
    @FXML
    private ChoiceBox<String> durationChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studioChoiceBox.setItems(studioChoiceList);
        studioChoiceBox.setValue("Regular");
        durationChoiceBox.setItems(durationChoiceList);
        durationChoiceBox.setValue("1 Jam");
    }
}
