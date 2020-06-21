
package database;

import controller.CalisanlarController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import newprojekt.Calisanlar;
import newprojekt.Ekipman;
import newprojekt.Musteri;


public class DataAccessObject {
    
    private static database db = new database();
    private static ResultSet rs;
    private static PreparedStatement pstmt;
    private static Connection connect;
    public static CalisanlarController ca = new CalisanlarController();




    public String query,name,nachname,seviye,id;
    private boolean EDIT=false, ADD=true;
    PreparedStatement ps;
        
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
		list.add(new Calisanlar(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
	}
        catch(Exception e) {
            e.printStackTrace();
	}
		
	return list;
	}

	
    public void deleteCalisan(String id) {
        try {
            String query = "DELETE FROM calisanlar WHERE calisan_id="+id+"";
            ps=database.connect.prepareStatement(query);
            saveData(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
    public void updateCalisan(String id , String name, String nachname, String seviye){ 
        try {
        // for updating existing account
        String query = "UPDATE calisanlar SET calisan_ad=?, calisan_soyad=?, calisan_seviye=? WHERE calisan_id=? ";
        ps=database.connect.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, nachname);
        ps.setString(3, seviye);
        ps.setString(4, id);
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
    public void insertCalisan(String id , String name, String nachname, String seviye) { 
        try {
        // for adding new account
        ResultSet rs = null;
        String query="INSERT INTO calisanlar(calisan_id, calisan_ad, calisan_soyad, calisan_seviye) VALUES(?,?,?,?)";
        // INSERT INTO `deneme`.`calisanlar` (`calisan_id`, `calisan_ad`, `calisan_soyad`, `calisan_seviye`) VALUES ('8', 'a', 'b', 'Seviye 3');
        
        
        ps=database.connect.prepareStatement(query);
        ps.setString(1, id);
        ps.setString(2, name);
        ps.setString(3, nachname);
        ps.setString(4, seviye);
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ObservableList<Musteri> getMusteriData(String query){
	ObservableList list = FXCollections.observableArrayList();
	try {
            connect = db.getConnection();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()) {
		list.add(new Musteri(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
	}
        catch(Exception e) {
            e.printStackTrace();
	}
		
	return list;
	}
    public String sqlMusteriAd() throws SQLException{
        String sql = "SELECT musteri_ad from musteriler ";
        return sql;
    }
    /*public String sqlrefresh() throws SQLException{
        String query = "SELECT * from calisanlar ";
        return query;
    }*/
    public String sqlEkipmanCihaz() throws SQLException{
        String query = "SELECT ekipman_cihaz from ekipmanlar";
        return query;
    }
    
    public ObservableList<String> showMusteri(String sql) throws SQLException {
        ObservableList<String> musteriList = FXCollections.observableArrayList();
        connect = db.getConnection();
        pstmt = connect.prepareStatement(sql);
        rs = pstmt.executeQuery("SELECT musteri_ad from musteriler ");
        while(rs.next()){
            musteriList.addAll(rs.getString("musteri_ad"));
        }
        return musteriList;
    }
    
    
    public static ObservableList<Ekipman> getEkipmanData(String query){
	ObservableList list = FXCollections.observableArrayList();
	try {
            connect = db.getConnection();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()) {
		list.add(new Ekipman(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
	}
        catch(Exception e) {
            e.printStackTrace();
	}
		
	return list;
    }
    public ObservableList<String> showCihaz(String sql) throws SQLException {
        ObservableList<String> cihazList = FXCollections.observableArrayList();
        connect = db.getConnection();
        pstmt = connect.prepareStatement(sql);
        rs = pstmt.executeQuery("SELECT ekipman_cihaz from ekipmanlar");
        while(rs.next()){
            cihazList.addAll(rs.getString("ekipman_cihaz"));
        }
        return cihazList;
    }
    public static Ekipman getOtherCihazInformation(String cihazAd){
        Ekipman ek = null;
        try {
            String query = "SELECT * from ekipmanlar WHERE ekipman_cihaz= ?";
            connect = db.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, cihazAd);
            rs = pstmt.executeQuery();
            System.out.println("calisiyo mu ");
            while(rs.next()){
                System.out.println("calisiyo mu2");
                ek = new Ekipman(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ek;
    }
    
    public static ObservableList<Calisanlar> choiceCalisan(){
	ObservableList<Calisanlar> list = FXCollections.observableArrayList();
        String query = "SELECT * from calisanlar";
	try {
            connect = db.getConnection();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Calisanlar c = new Calisanlar(rs.getString(2), rs.getString(3));
                list.addAll(c);
            }
	}
        catch(Exception e) {
            e.printStackTrace();
	}
		
	return list;
	}
    public static String getSeviye(String ad, String soyad){  
        
        String l = null;
        
        try {
            String query = "SELECT calisan_seviye from calisanlar WHERE (calisan_ad,calisan_soyad) =(?,?)";
            connect = db.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, ad);
            pstmt.setString(2, soyad);
            rs = pstmt.executeQuery();
            System.out.println("devamkee");
            while(rs.next()){
                System.out.println("devamke22");
               l = (rs.getString("calisan_seviye"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }        
    
    


}
        
        
        
      

