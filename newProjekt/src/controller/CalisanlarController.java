// Şevval Arslan 170503031
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import newprojekt.Calisanlar;
import database.DataAccessObject;
import database.database;



public class CalisanlarController implements Initializable {



    @FXML
    public TableView<Calisanlar> calisan_table;
    @FXML
    public TableColumn<Calisanlar, String> calisan_id;
    @FXML
    public TableColumn<Calisanlar, String> calisan_seviye;
    @FXML
    public TableColumn<Calisanlar, String> calisan_ad;
    @FXML
    public TableColumn<Calisanlar, String> calisan_soyad;
    
    @FXML
    ComboBox<String> combo_box;
    ObservableList<String> seviyeList = FXCollections.observableArrayList();
    @FXML
    private Button ekle_btt;
    @FXML
    private Button sil_btt;
 
    
  
    
    
    
    private database db;
    private DataAccessObject dao;
    private String query,id,name,nachname,seviye;
    private static boolean EDIT = false, ADD = true;
    public FXMLLoader loader;
    
    @FXML
     TextField txtfield_id;
    @FXML
     TextField txtfield_ad;
    @FXML
    TextField txtfield_soyad;
    @FXML
    private Button btt_duzenle;
    @FXML
    private Button btt_kaydet;
    @FXML
    private Button geri;
    
   
 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
            DataAccessObject dao = new DataAccessObject();
            db.getConnection();
            loadData();
            ekle_btt.setOnAction(e->{

                String i = txtfield_id.getText();
                String na = txtfield_ad.getText();
                String nach = txtfield_soyad.getText();
                String sevi = combo_box.getValue();
                dao.insertCalisan(i, na, nach, sevi);
                refreshTable();

            });
            sil_btt.setOnAction(e->{

                Calisanlar selected = calisan_table.getSelectionModel().getSelectedItem();
                id = selected.getcID().get();
                dao.deleteCalisan(id);
                refreshTable();

                
                
            });
            btt_duzenle.setOnAction(e->{

                ADD = false;
                EDIT = true;
                editAccount();
                refreshTable();

            });
            btt_kaydet.setOnAction(e->{
                id= txtfield_id.getText();
                name = txtfield_ad.getText();
                nachname = txtfield_soyad.getText();
                seviye = combo_box.getValue();
                dao.updateCalisan(id, name, nachname, seviye);
                refreshTable();      
            });
            initTable();
            refreshTable();




        
                
    }
    private void loadData() {
    seviyeList.removeAll(seviyeList);
    String a = "Seviye 1";
    String b = "Seviye 2";
    String c = "Seviye 3";
    seviyeList.addAll( a, b, c );
    combo_box.getItems().addAll(seviyeList);
  }
    
    public void initTable() {
        calisan_id.setCellValueFactory(cell->cell.getValue().getcID());
	calisan_ad.setCellValueFactory(cell->cell.getValue().getcFirstname());
	calisan_soyad.setCellValueFactory(cell->cell.getValue().getcLastname());
	calisan_seviye.setCellValueFactory(cell->cell.getValue().getcSeviye());
    }
	
    
    private void refreshTable() {
	initTable();
	query ="SELECT * from calisanlar ";
	calisan_table.setItems(DataAccessObject.getCalisanData(query));
		
    } 
    private void editAccount() {
        Calisanlar selected = calisan_table.getSelectionModel().getSelectedItem();
        txtfield_id.setText(selected.getcID().get());
        txtfield_ad.setText(selected.getcFirstname().get());
        txtfield_soyad.setText(selected.getcLastname().get());
        combo_box.getSelectionModel().select(selected.getcSeviye().get());
    }


    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== geri){
            try {
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
            
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml")));
                stage.setScene(scene);
                stage.show();
            }   
            catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }








}

    




