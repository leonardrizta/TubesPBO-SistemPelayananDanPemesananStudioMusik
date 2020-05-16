package home;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final StringProperty tanggalPemesanan;
    private final StringProperty nama;
    private final StringProperty idStudio;
    private final StringProperty tanggalMain;
    private final StringProperty durasiMain;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        BorderPane mainPane = FXMLLoader.load(getClass().getResource("main.fxml"));
        mainPane.setCenter(FXMLLoader.load(getClass().getResource("home.fxml")));
        primaryStage.setTitle("Sistem Pelayanan Dan Pemesanan Studio Musik");
        primaryStage.setScene(new Scene(mainPane, 853, 480));
        primaryStage.show();
        //TODO "Do Backend here"
    }

    public Main(String tanggalPemesanan, String nama, String idStudio, String tanggalMain, String durasiMain){
        this.tanggalMain = new SimpleStringProperty(tanggalMain);
        this.nama = new SimpleStringProperty(nama);
        this.idStudio = new SimpleStringProperty(idStudio);
        this.tanggalMain = new SimpleStringProperty(tanggalMain);
        this.durasiMain = new SimpleStringProperty(durasiMain);
    }

    public String getTanggalPesan(){
        return tanggalMain.get();
    }

    public String getNama() {
        return nama.get();
    }
    public String getIdStudio(){
        return idStudio.get();
    }

    public String getTanggalMain() {
        return tanggalMain.get();
    }

    public String getDurasiMain() {
        return durasiMain.get();
    }

    public void setTanggalPemesanan(String value){
        tanggalPemesanan.set(value);
    }
    public void setNama(String value){
        nama.set(value);
    }
    public void setIdStudio(String value){
        idStudio.set(value);
    }
    public void setTanggalMain(String value){
        tanggalMain.set(value);
    }
    public void setDurasiMain(String value){
        durasiMain.set(value);
    }

    public StringProperty tanggalPemesananProperty(){
        return tanggalPemesanan;
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public StringProperty idStudioProperty() {
        return idStudio;
    }

    public StringProperty tanggalMainProperty() {
        return tanggalMain;
    }

    public StringProperty durasiMainProperty() {
        return durasiMain;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
