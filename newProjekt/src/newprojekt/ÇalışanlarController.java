package newprojekt;




import com.mysql.cj.protocol.Resultset;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class ÇalışanlarController implements Initializable{

    public ÇalışanlarController(int aInt, String string, String string1, String string2) {
    }
   
    
    @FXML
    private ComboBox<String> combo_box;
    ObservableList<String> list = FXCollections.observableArrayList();
    
    @FXML
    private Button ekle_btt;
    @FXML
    private Button sil_btt;
    @FXML
    private Button duzenle_btt;
    @FXML
    private Button kaydet_btt;
    @FXML
    private TableView<ÇalışanlarController> calisan_table;
    ObservableList<ÇalışanlarController> oblist = FXCollections.observableArrayList();
    @FXML
    private TableColumn<ÇalışanlarController, String> calisan_id;
    @FXML
    private TableColumn<ÇalışanlarController, String> calisan_seviye;
    @FXML
    private TableColumn<ÇalışanlarController, String> calisan_ad;
    @FXML
    private TableColumn<ÇalışanlarController, String> calisan_soyad;
    
    
  
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {

       
    
        
        try {
            
            Connection conn = database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from calisanlar");
            
            while (rs.next()) {                
                oblist.add(new ÇalışanlarController(rs.getInt("Id"), rs.getString("Ad"), rs.getString("Soyad"),rs.getString("Seviye")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ÇalışanlarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        calisan_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        calisan_ad.setCellValueFactory(new PropertyValueFactory<>("Ad"));
        calisan_soyad.setCellValueFactory(new PropertyValueFactory<>("Soyad"));
        calisan_seviye.setCellValueFactory(new PropertyValueFactory<>("Seviye"));
        
        calisan_table.setItems(oblist);
      
    }

}


