package home;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
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

    public void bookOrder() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime localDateTime = LocalDateTime.now();
        int price;
        String studio_id;
        if (studioChoiceBox.getValue().equals("Regular")) {
            price = 50000;
            studio_id = "R001";
        } else {
            price = 100000;
            studio_id = "V001";
        }

        String sql = "INSERT INTO StudioOrder (name,studio_id,order_price,order_time,order_play,order_finish) VALUES ('"+name.getText()+"','"+studio_id+"',"+price+",'"+dateTimeFormatter.format(localDateTime)+"','"+orderPlayDate.getValue() + " " + orderPlayTime.getText()+"','"+"2020:10:15 23:00:00.000');";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
