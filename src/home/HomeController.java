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
    private Label resultRegular;
    @FXML
    private Label resultVip;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataFromDataBase();
    }

    @FXML
    public void loadDataFromDataBase() {
        ResultSet resultSet;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlRegular = "select count(order_id) as totalRegular from studioorder where studio_id='R001';";
        String sqlVip = "select count(order_id) as totalVip from studioorder where studio_id='V001';";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlRegular);
            resultSet.next();
            resultRegular.setText(resultSet.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            statement.executeQuery(sqlVip);
            resultSet = statement.executeQuery(sqlVip);
            resultSet.next();
            resultVip.setText(resultSet.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}