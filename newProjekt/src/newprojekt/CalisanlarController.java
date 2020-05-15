/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newprojekt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author arsla
 */
public class CalisanlarController implements Initializable {



    @FXML
    public TableView<Calisanlar> calisan_table;
    @FXML
    public TableColumn<Calisanlar, Integer> calisan_id;
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
    @FXML
    private Button geri;
    
  
    
    
    
    private database db;
    private DataAccessObject dao;
    private Connection connect;
    private String query;
    
    @FXML
     TextField txtfield_id;
    @FXML
     TextField txtfield_ad;
    @FXML
     TextField txtfield_soyad;
    @FXML
    private Button btt_duzenle;
    
   
 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db.getConnection();
        loadData();
        dao.initTable();
        dao.refreshTable();
        String name=txtfield_ad.getText();
        String nach=txtfield_soyad.getText();
        String seviye=combo_box.getValue();
        
                
    }
    private void loadData() {
    seviyeList.removeAll(seviyeList);
    String a = "Seviye 1";
    String b = "Seviye 2";
    String c = "Seviye 3";
    seviyeList.addAll( a, b, c );
    combo_box.getItems().addAll(seviyeList);
  }
    
    void initTable() {
        calisan_id.setCellValueFactory(cell->cell.getValue().getcID().asObject());
	calisan_ad.setCellValueFactory(cell->cell.getValue().getcFirstname());
	calisan_soyad.setCellValueFactory(cell->cell.getValue().getcLastname());
	calisan_seviye.setCellValueFactory(cell->cell.getValue().getcSeviye());
    }
	
    
    private void refreshTable() {
	initTable();
	query = "SELECT * from calisanlar ";
	calisan_table.setItems(dao.getCalisanData(query));
		
    } 



    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== geri){
            try {
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
            
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/newprojekt/FXMLDocument.fxml")));
                stage.setScene(scene);
                stage.show();
            }   
            catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /*
    PreparedStatement ps;
    @FXML
    private void addSetOnAction(MouseEvent event) throws SQLException {
        String name=txtfield_ad.getText();
        String nach=txtfield_soyad.getText();
	String id=txtfield_id.getText();
        String seviye=combo_box.getValue();
        
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


    
    @FXML
    private void updateSetOnAction(MouseEvent event) throws SQLException {

        String name=txtfield_ad.getText();
        String nach=txtfield_soyad.getText();
	String id=txtfield_id.getText();
        String seviye=combo_box.getValue();
        
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

 */

    @FXML
    private void setOnAction(ActionEvent event) throws SQLException {
        String id=txtfield_id.getText();
        database.deleteSetOnAction(id);
        db.refreshTable();  
    }





}

    




