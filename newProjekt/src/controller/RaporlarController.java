// Şevval Arslan 170503031
package controller;

import database.DataAccessObject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import export.ExportToExcel;
import export.ExportToPDF;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import newprojekt.Ekipman;


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
    @FXML
    private TextField txtfield_kutupMesafesi;
    @FXML
    private ChoiceBox<String> cihaz_box;
    @FXML
    private TextField txtfield_mpTasiyiciOrtam;
    @FXML
    private TextField txtfield_miknatislamaTeknigi;
    @FXML
    private TextField txtfield_uvİsikSiddeti;
    @FXML
    private TextField txtfield_isikMesafesi;
    static String str;
    static String a;
    @FXML
    private TextField txtfield_opSeviye;
    @FXML
    private TextField txtfield_deSeviye;
    @FXML
    private TextField txtfield_onSeviye;
    @FXML
    private Button exportToPDF;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField raporNo;
    public int raporNumarasi = 1000;
    DataAccessObject dao = new DataAccessObject();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
            this.txtfield_opAdSoyad.setText(String.valueOf(RaporOlusturmaController.secilen11));
            this.txtfield_deAdSoyad.setText(String.valueOf(RaporOlusturmaController.secilen2));
            this.txtfield_onAdSoyad.setText(String.valueOf(RaporOlusturmaController.secilen3));
            
            this.txtfield_opSeviye.setText(RaporOlusturmaController.secilenOpSeviye);
            this.txtfield_deSeviye.setText(RaporOlusturmaController.secilenDeSeviye);
            this.txtfield_onSeviye.setText(RaporOlusturmaController.secilenOnSeviye);
            this.raporNo.setText(String.valueOf(raporNumarasi));
            cihaz_box.setOnAction(e->{
                loadOtherCihazInformation();
                
            });
            ExportToExcel ex = new ExportToExcel();
            ExportToPDF pd = new ExportToPDF();
            
            loadMusteri();           
            loadCihaz();
            exportToXLS.setOnAction(e->{
                
                try {
                    String musteriAd = musteri_box.getValue();
                    String cihazAd = cihaz_box.getValue();
                    String kutupMesafesi = txtfield_kutupMesafesi.getText();
                    String opAd = txtfield_opAdSoyad.getText();
                    String deAd = txtfield_deAdSoyad.getText();
                    String onAd = txtfield_onAdSoyad.getText();
                    String opSeviye = txtfield_opSeviye.getText();
                    String deSeviye = txtfield_deSeviye.getText();
                    String onSeviye = txtfield_onSeviye.getText();
               
                    
                    String rapor = String.valueOf(raporNumarasi);
                    raporNumarasi++;
                    this.raporNo.setText(String.valueOf(raporNumarasi));
                    ex.excel(musteriAd, cihazAd, kutupMesafesi, opAd, deAd, onAd, opSeviye, deSeviye, onSeviye, rapor);
                } catch (IOException ex1) {
                    Logger.getLogger(RaporlarController.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            });
            

            //Stage primaryStage = new Stage();
            exportToPDF.setOnAction(e->{
                pd.pdf(anchorPane);
            });
        } catch (SQLException ex1) {
            Logger.getLogger(RaporlarController.class.getName()).log(Level.SEVERE, null, ex1);
        }
   


    }
    public void loadMusteri() throws SQLException{
        DataAccessObject dao = new DataAccessObject();
        String sql = dao.sqlMusteriAd();
        musteri_box.getItems().addAll(dao.showMusteri(sql));
    } 
    public void loadCihaz() throws SQLException{
        DataAccessObject dao = new DataAccessObject();
        String sql = dao.sqlEkipmanCihaz();
        cihaz_box.getItems().addAll(dao.showCihaz(sql));

    }

    private void loadOtherCihazInformation(){
        str = cihaz_box.getSelectionModel().getSelectedItem();
        System.out.println(str);
        Ekipman a = DataAccessObject.getOtherCihazInformation(str);
        txtfield_kutupMesafesi.setText(a.getKutupMesafesi().getValue()); 
        

        
        //txtfield_mpTasiyiciOrtam.setText(String.valueOf(DataAccessObject.getOtherCihazInformation(str)));
        //txtfield_miknatislamaTeknigi.setText(String.valueOf(DataAccessObject.getOtherCihazInformation(str)));
        //txtfield_uvİsikSiddeti.setText(String.valueOf(DataAccessObject.getOtherCihazInformation(str)));
        //txtfield_isikMesafesi.setText(String.valueOf(DataAccessObject.getOtherCihazInformation(str)));
    }



    
    
}
