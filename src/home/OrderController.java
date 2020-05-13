package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    ObservableList<String> studioChoiceList = FXCollections.observableArrayList("Regular", "VIP");
    ObservableList<String> durationChoiceList = FXCollections.observableArrayList("1 Jam", "2 Jam", "3 Jam", "5 Jam");
    @FXML
    private ChoiceBox<String> studioChoiceBox;
    @FXML
    private ChoiceBox<String> durationChoiceBox;
    @FXML
    private TextField name;
    @FXML
    private Label orderDetail;
    @FXML
    private DatePicker orderPlayDate;
    @FXML
    private TextField orderPlayTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studioChoiceBox.setItems(studioChoiceList);
        studioChoiceBox.setValue("Regular");
        durationChoiceBox.setItems(durationChoiceList);
        durationChoiceBox.setValue("1 Jam");
    }

    @FXML
    public void checkOrder() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        int price;
        if (studioChoiceBox.getValue().equals("Regular")) {
            price = 50000;
        } else {
            price = 100000;
        }
        orderDetail.setText(
                "Nama Pemesan: \t" + name.getText() + "\n\n" +
                        "Jenis Studio:\t\t" + studioChoiceBox.getValue() + "\n\n" +
                        "Durasi Main:\t\t" + durationChoiceBox.getValue() + "\n\n" +
                        "Biaya: \t\t\t" + price + "\n\n" +
                        "Tanggal Main:\t\t" + orderPlayDate.getValue() + " " + orderPlayTime.getText() + "\n\n" +
                        "Tanggal Order:\t" + dateTimeFormatter.format(localDateTime)
        );
    }
}
