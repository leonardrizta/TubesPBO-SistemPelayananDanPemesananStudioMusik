package home;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    ObservableList<String> studioChoiceList = FXCollections.observableArrayList("Regular", "VIP");
    ObservableList<String> durationChoiceList = FXCollections.observableArrayList("1 Jam", "2 Jam", "3 Jam", "5 Jam");
    String selesai;
    @FXML
    private ChoiceBox<String> studioChoiceBox;
    @FXML
    private ChoiceBox<String> durationChoiceBox;
    @FXML
    private TextField name;
    @FXML
    private Label orderDetail;
    @FXML
    private Label bookResult;
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
        int price, durasi;
        if (studioChoiceBox.getValue().equals("Regular")) {
            if (durationChoiceBox.getValue().equals("1 Jam")) {
                price = 50000;
                durasi = 1;
            } else if (durationChoiceBox.getValue().equals("2 Jam")) {
                price = 100000;
                durasi = 2;
            } else if (durationChoiceBox.getValue().equals("3 Jam")) {
                price = 150000;
                durasi = 3;
            } else {
                price = 200000;
                durasi = 5;
            }
        } else {
            if (durationChoiceBox.getValue().equals("1 Jam")) {
                price = 100000;
                durasi = 1;
            } else if (durationChoiceBox.getValue().equals("2 Jam")) {
                price = 200000;
                durasi = 2;
            } else if (durationChoiceBox.getValue().equals("3 Jam")) {
                price = 300000;
                durasi = 3;
            } else {
                price = 400000;
                durasi = 5;
            }
        }

        Calendar waktuSelesai = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mulai = orderPlayDate.getValue() + " " + orderPlayTime.getText();
        try {
            waktuSelesai.setTime(sdf.parse(mulai));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        waktuSelesai.add(Calendar.HOUR_OF_DAY, + durasi);
        Date date = waktuSelesai.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        selesai = dateFormat.format(date);
        System.out.println("Converted String: " + selesai);

        orderDetail.setText(
                "Nama Pemesan: \t" + name.getText() + "\n\n" +
                        "Jenis Studio:\t\t" + studioChoiceBox.getValue() + "\n\n" +
                        "Durasi Main:\t\t" + durationChoiceBox.getValue() + "\n\n" +
                        "Biaya: \t\t\t" + price + "\n\n" +
                        "Tanggal Main:\t\t" + mulai + "\n" +
                        "Waktu Selesai:\t\t" + selesai + "\n" +
                        "Tanggal Order:\t" + dateTimeFormatter.format(localDateTime)
        );
    }

    public void bookOrder() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        int price;
        String studio_id;

        if (studioChoiceBox.getValue().equals("Regular")) {
            if (durationChoiceBox.getValue().equals("1 Jam")) {
                price = 50000;
            } else if (durationChoiceBox.getValue().equals("2 Jam")) {
                price = 100000;
            } else if (durationChoiceBox.getValue().equals("3 Jam")) {
                price = 150000;
            } else {
                price = 200000;
            }
            studio_id = "R001";
        } else {
            if (durationChoiceBox.getValue().equals("1 Jam")) {
                price = 100000;
            } else if (durationChoiceBox.getValue().equals("2 Jam")) {
                price = 200000;
            } else if (durationChoiceBox.getValue().equals("3 Jam")) {
                price = 300000;
            } else {
                price = 400000;
            }
            studio_id = "V001";
        }
        if(name.getText().trim().length()==0||orderPlayDate.getValue().toString().trim().length()==0||orderPlayTime.getText().toString().trim().length()!=8){
            bookResult.setTextFill(Color.web("#ff000a", 1));
            bookResult.setText("Booking Gagal!");
        }else {
            String sql = "INSERT INTO StudioOrder (name,studio_id,order_price,order_time,order_play,order_finish) VALUES ('" + name.getText() + "','" + studio_id + "'," + price + ",'" + dateTimeFormatter.format(localDateTime) + "','" + orderPlayDate.getValue() + " " + orderPlayTime.getText() + "','" + selesai + "');";
            Statement statement = connection.createStatement();
            try {
                int check = statement.executeUpdate(sql);
                if (check > 0) {
                    bookResult.setTextFill(Color.web("#00ff48", 1));
                    bookResult.setText("Booking Berhasil");
                } else {
                    bookResult.setTextFill(Color.web("#ff000a", 1));
                    bookResult.setText("Booking Gagal!");
                }
            } catch (Exception e) {
                bookResult.setTextFill(Color.web("#ff000a", 1));
                bookResult.setText("Booking Gagal!");
            }
        }
    }
}
