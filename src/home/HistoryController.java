package home;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class HistoryController {
    //TODO: connect history to database

    private ObservableList<HistoryController>data;
    private ConnectionClass dc;

    @Override
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
                data.add(new)
            }





        } catch (SQLException ex){
            Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
