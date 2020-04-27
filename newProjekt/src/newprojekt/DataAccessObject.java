
package newprojekt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DataAccessObject {
    
    private static database db = new database();
    private static ResultSet rs;
    private static PreparedStatement pstmt;
    private static Connection connect;
        
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
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
    
}
        
        
        
      

