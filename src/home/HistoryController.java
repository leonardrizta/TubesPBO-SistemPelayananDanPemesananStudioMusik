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
    private TableView<Main> tableDetails;

    @FXML
    private TableColumn<Main, Integer> columnNo;

    @FXML
    private TableColumn<Main, String> columnTanggalPesan;

    @FXML
    private TableColumn<Main, String> columnPemesan;

    @FXML
    private TableColumn<Main, String> columnStudioId;

    @FXML
    private TableColumn<Main, String> columnTanggalMain;

    @FXML
    private TableColumn<Main, String> columnDurasi;

    @FXML
    private Button btnrefresh;

    private ObservableList<Main> data;
    private ConnectionClass dc;

    public void initialize(URL url, ResourceBundle rb){
        dc = new ConnectionClass();
    }

    @FXML
    private void loadDataFromDataBase(ActionEvent event){
        try {
            Connection conn = dc.getConnection();
            data = FXCollections.observableArrayList();
            //execute query and store result
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM studioorder");
            while (rs.next()){
                data.add(new Main(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        columnTanggalPesan.setCellValueFactory(new PropertyValueFactory<>("tanggalPemesanan"));
        columnPemesan.setCellValueFactory(new PropertyValueFactory<>("nama"));
        columnStudioId.setCellValueFactory(new PropertyValueFactory<>("idStudio"));
        columnTanggalMain.setCellValueFactory(new PropertyValueFactory<>("tanggalMain"));
        columnDurasi.setCellValueFactory(new PropertyValueFactory<>("durasiMain"));

        tableDetails.setItems(null);
        tableDetails.setItems(data);


    }
}
