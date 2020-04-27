/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newprojekt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author arsla
 */
public class CalisanlarController implements Initializable {



    @FXML
    private TableView<Calisanlar> calisan_table;
    @FXML
    private TableColumn<Calisanlar, Integer> calisan_id;
    @FXML
    private TableColumn<Calisanlar, String> calisan_seviye;
    @FXML
    private TableColumn<Calisanlar, String> calisan_ad;
    @FXML
    private TableColumn<Calisanlar, String> calisan_soyad;
    
    @FXML
    private ComboBox<String> combo_box;
    ObservableList<String> seviyeList = FXCollections.observableArrayList();
    @FXML
    private Button ekle_btt;
    @FXML
    private Button sil_btt;
    private Button geri;
    
    private FXMLLoader loader;
    private String query, ad, soyad, seviye;
    private int id;
    DataAccessObject dao;
    private database db;
    private Connection connect;
    private boolean EDIT=false, ADD=true;
    
    @FXML
    private TextField txtfield_id;
    @FXML
    private TextField txtfield_ad;
    @FXML
    private TextField txtfield_soyad;
    @FXML
    private Button btt_duzenle;
    
   
 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       database.getConnection();
      dao = new DataAccessObject();
      loadData();
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
    
    private void initTable() {
        calisan_id.setCellValueFactory(cell->cell.getValue().getpID().asObject());
	calisan_ad.setCellValueFactory(cell->cell.getValue().getpFirstname());
	calisan_soyad.setCellValueFactory(cell->cell.getValue().getpLastname());
	calisan_seviye.setCellValueFactory(cell->cell.getValue().getpSeviye());
	}
	
    private void refreshTable() {
	initTable();
	query = "SELECT * from calisanlar ";
	calisan_table.setItems(dao.getCalisanData(query));
		
	} 
        /*private void insertNewAccount() { // for adding new account
		txtfield_id.setText("");
                txtfield_ad.setText("");
		txtfield_soyad.setText("");
                combo_box.getSelectionModel().select(0);
		
	}*/


    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== geri){
            try {
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
            
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/newprojekt/FXMLDocument.fxml")));
                stage.setScene(scene);
                stage.show();
            }   catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    PreparedStatement ps;
    @FXML
    private void addSetOnAction(MouseEvent event) throws SQLException {
        String name=txtfield_ad.getText();
        String nach=txtfield_soyad.getText();
	String id=txtfield_id.getText();
        String seviye=combo_box.getValue().toString();
        
        String sql="INSERT INTO calisanlar(calisan_id, calisan_ad, calisan_soyad, calisan_seviye) VALUES(?,?,?,?)";
       // INSERT INTO `deneme`.`calisanlar` (`calisan_id`, `calisan_ad`, `calisan_soyad`, `calisan_seviye`) VALUES ('8', 'a', 'b', 'Seviye 3');

        ps=database.connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, name);
        ps.setString(3, nach);
        ps.setString(4, seviye);
        
        System.out.println("geldi");
        ps.executeUpdate();
        System.out.println("geldi2");
        refreshTable();
    }

    @FXML
    private void deleteSetOnAction(MouseEvent event) throws SQLException {
        String id=txtfield_id.getText();
        System.out.println("biiiirr");
        String sql = "DELETE  from calisanlar where calisan_id=?";
        ps=database.connect.prepareStatement(sql);
        
        ps.setString(1, id);
        
        ps.executeUpdate();
        System.out.println("2");
	refreshTable();        
    }

    /*@FXML
    private void updateSetOnAction(MouseEvent event){
        System.out.println("geldi3");
         String isim=txtfield_ad.getText();
        String soy=txtfield_soyad.getText();
	String km=txtfield_id.getText();
        String lev=combo_box.getValue().toString();
        
        String sql="UPDATE calisanlar SET calisan_ad=?,calisan_soyad=?,calisan_seviye=?  WHERE calisan_id=?";
        System.out.println("geldi");
        //UPDATE `deneme`.`calisanlar` SET `calisan_soyad` = 'veli', `calisan_seviye` = 'seviye 2' WHERE (`calisan_id` = '1');

        try {
            
            ps=database.connect.prepareStatement(sql);
            System.out.println("geldi3");
            ps.setString(1, isim);
            ps.setString(2, soy);
            ps.setString(3, km);
            ps.setString(4, lev);

            
            ps.executeUpdate();
            System.out.println("geldi2");
            refreshTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }*/
    
    @FXML
    private void updateSetOnAction(MouseEvent event) throws SQLException {

        String name=txtfield_ad.getText();
        String nach=txtfield_soyad.getText();
	String id=txtfield_id.getText();
        String seviye=combo_box.getValue().toString();
        
        String sql="UPDATE calisanlar SET calisan_ad=?, calisan_soyad=?, calisan_seviye=? WHERE calisan_id=?";
       // INSERT INTO `deneme`.`calisanlar` (`calisan_id`, `calisan_ad`, `calisan_soyad`, `calisan_seviye`) VALUES ('8', 'a', 'b', 'Seviye 3');

        ps=database.connect.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, nach);
        ps.setString(3, seviye);
        ps.setString(4, id);
        
        System.out.println("geldi");
        ps.executeUpdate();
        System.out.println("geldi2");
        refreshTable();
        
    }

 

}

    




