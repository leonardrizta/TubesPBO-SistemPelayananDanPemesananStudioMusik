package home;

import Connectivity.ConnectionClass;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

public class History {
    private final StringProperty tanggalPemesanan;
    private final StringProperty nama;
    private final StringProperty idStudio;
    private final StringProperty tanggalMain;
    private final StringProperty durasiMain;

    public History(String tanggalPemesanan, String nama, String idStudio, String tanggalMain, String durasiMain){
        this.tanggalPemesanan = new SimpleStringProperty(tanggalPemesanan);
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

}
