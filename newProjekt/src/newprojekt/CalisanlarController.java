/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newprojekt;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * FXML Controller class
 *
 * @author arsla
 */
public class CalisanlarController implements Initializable {



    @FXML
    private TableView<CalisanlarController> calisan_table;
  
    @FXML
    private TableColumn<CalisanlarController, String> calisan_id;
    @FXML
    private TableColumn<CalisanlarController, String> calisan_seviye;
    @FXML
    private TableColumn<CalisanlarController, String> calisan_ad;
    @FXML
    private TableColumn<CalisanlarController, String> calisan_soyad;
    @FXML
    private ComboBox<String> combo_box;
    @FXML
    private Button ekle_btt;
    @FXML
    private Button sil_btt;
    @FXML
    private Button duzenle_btt;
    @FXML
    private Button kaydet_btt;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
    }



}

