package home;

import Connectivity.ConnectionClass;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoryController {
    //TODO: connect history to database
    @FXML
    private TableView<History> tableDetails;

    @FXML
    private TableColumn<History, Integer> columnNo;

    @FXML
    private TableColumn<History, String> columnTanggalPesan;

    @FXML
    private TableColumn<History, String> columnPemesan;

    @FXML
    private TableColumn<History, String> columnStudioId;

    @FXML
    private TableColumn<History, String> columnTanggalMain;

    @FXML
    private TableColumn<History, String> columnDurasi;

    @FXML
    private Button btnrefresh;

    private ObservableList<History> data;
    private ConnectionClass dc;

    public void initialize(URL url, ResourceBundle rb) {  }

    @FXML
    public void loadDataFromDataBase(MouseEvent mouseEvent) {
        try {
            dc = new ConnectionClass();
            Connection conn = dc.getConnection();
            data = FXCollections.observableArrayList();
            //execute query and store result
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM studioorder");
            while (rs.next()){
                data.add(new History(rs.getString(1), rs.getString(5), rs.getString(2) ,rs.getString(3), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        columnNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        columnTanggalPesan.setCellValueFactory(new PropertyValueFactory<>("tanggalPemesanan"));
        columnPemesan.setCellValueFactory(new PropertyValueFactory<>("nama"));
        columnStudioId.setCellValueFactory(new PropertyValueFactory<>("idStudio"));
        columnTanggalMain.setCellValueFactory(new PropertyValueFactory<>("tanggalMain"));
        columnDurasi.setCellValueFactory(new PropertyValueFactory<>("durasiMain"));
        tableDetails.setItems(null);
        tableDetails.setItems(data);
    }
}
