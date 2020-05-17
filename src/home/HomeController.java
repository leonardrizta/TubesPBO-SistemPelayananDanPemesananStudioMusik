package home;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Label result_regular;
    @FXML
    private Label result_vip;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataFromDataBase();
    }
    @FXML
    public void loadDataFromDataBase() {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlRegular = "select count(order_id) from studioorder where studio_id='R001'";
        String sqlVip = "select count(order_id) from studioorder where studio_id='V001'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeQuery(sqlRegular);
            result_regular.setText(Objects.requireNonNull(statement).getResultSet().toString());
            statement.executeQuery(sqlVip);
            result_vip.setText(Objects.requireNonNull(statement).getResultSet().toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
