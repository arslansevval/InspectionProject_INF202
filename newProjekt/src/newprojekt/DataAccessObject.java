
package newprojekt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import static newprojekt.database.ps;


public class DataAccessObject {
    
    private static database db = new database();
    private static ResultSet rs;
    private static PreparedStatement pstmt;
    private static Connection connect;
    public static CalisanlarController ca = new CalisanlarController();
    private String query,name,nachname,seviye,id;
    private boolean EDIT=false, ADD=true;
        
    public DataAccessObject() {
        
    }    
    public void saveData(String query) {
            try {
                connect = db.getConnection(); // get connection 
                pstmt = connect.prepareStatement(query);
                pstmt.executeUpdate();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                db.close(connect, pstmt, null);
            }
    } 
    
    public static ObservableList<Calisanlar> getCalisanData(String query){
	ObservableList list = FXCollections.observableArrayList();
	try {
            connect = db.getConnection();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()) {
		list.add(new Calisanlar(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
	}
        catch(Exception e) {
            e.printStackTrace();
	}
		
	return list;
	}

	
    private void deleteAccount() {
	Calisanlar selected = ca.calisan_table.getSelectionModel().getSelectedItem();
	id = selected.getcID();
	query = "DELETE FROM account WHERE account_ID="+ID+"";
	dao.saveData(query);
	refreshTable();
	}
	
    private void editAccount() { // for updating existing account
	Test selected = tblview.getSelectionModel().getSelectedItem();
	ID = selected.getpID().get();
	txt_firstname.setText(selected.getpFirstname().get());
	txt_lastname.setText(selected.getpLastname().get());
	combo_gender.getSelectionModel().select(selected.getpGender().get());
	combo_position.getSelectionModel().select(selected.getpPosition().get());
	}
	
    private void insertNewAccount() { // for adding new account
	txt_firstname.setText("");
	txt_lastname.setText("");
	combo_gender.getSelectionModel().select(0);
	combo_position.getSelectionModel().select(0);
	}

    
       /* @FXML
        public void addSetOnAction(MouseEvent event) throws SQLException {
            String name=ca.txtfield_ad.getText();
            String nach=ca.txtfield_soyad.getText();
            String id=ca.txtfield_id.getText();
            String seviye=ca.combo_box.getValue();
        
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
        public static void deleteSetOnAction(String id) throws SQLException {
            
            System.out.println("biiiirr");
            String sql = "DELETE  from calisanlar where calisan_id=?";
            ps=database.connect.prepareStatement(sql);
        
            ps.setString(1, id);
        
            ps.executeUpdate();
            System.out.println("2");
                  
        }


    
        @FXML
        public void updateSetOnAction(MouseEvent event) throws SQLException {

            String name=ca.txtfield_ad.getText();
            String nach=ca.txtfield_soyad.getText();
            String id=ca.txtfield_id.getText();
            String seviye=ca.combo_box.getValue();
        
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
}
        
        
        
      

