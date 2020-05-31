
package controller;

import database.DataAccessObject;
import database.database;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import export.ExportToExcel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import newprojekt.Calisanlar;


public class RaporlarController implements Initializable {

    @FXML
    private Text text_anabaslik;
    @FXML
    private Text text_üst;
    @FXML
    private Text text_altbaslik;
    @FXML
    private ChoiceBox<String> musteri_box;
    
    @FXML
    private ChoiceBox<String> projektName_box;
    @FXML
    private Text text_musteri;
    @FXML
    private Text text_customer;
    @FXML
    private Button exportToXLS;
    @FXML
    private TextField txtfield_opAdSoyad;
    @FXML
    private TextField txtfield_deAdSoyad;
    @FXML
    private TextField txtfield_onAdSoyad;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        this.txtfield_opAdSoyad.setText(String.valueOf(RaporOlusturmaController.secilen));
        this.txtfield_deAdSoyad.setText(String.valueOf(RaporOlusturmaController.secilen2));
        this.txtfield_onAdSoyad.setText(String.valueOf(RaporOlusturmaController.secilen3));
        
        try {
            ExportToExcel ex = new ExportToExcel();
            loadMusteri();
            exportToXLS.setOnAction(e->{
                String musteriAd = musteri_box.getValue();
                String opAd = txtfield_opAdSoyad.getText();
                String deAd = txtfield_deAdSoyad.getText();
                String onAd = txtfield_onAdSoyad.getText();
                try {
                    ex.excel(musteriAd, opAd, deAd, onAd);
                } catch (IOException ex1) {
                    Logger.getLogger(RaporlarController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            });
        } catch (SQLException ex1) {
            Logger.getLogger(RaporlarController.class.getName()).log(Level.SEVERE, null, ex1);
        }

    }
    public void loadMusteri() throws SQLException{
        DataAccessObject dao = new DataAccessObject();
        String sql = "SELECT musteri_ad from musteriler ";
        musteri_box.getItems().addAll(dao.showMusteri(sql));
    }



    
    
}
