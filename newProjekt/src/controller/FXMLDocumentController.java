// Şevval Arslan 170503031
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

/**
 *
 * @author arsla
 */
public class FXMLDocumentController implements Initializable {

    
 
    


    @FXML
    private Button Raporlar;
    @FXML
    private Button Calisanlar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    /*@FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        if(event.getSource()== Calisanlar){
            
   
                System.out.println("deneme3");
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                System.out.println("deneme1");
            try {
               
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Calisanlar.fxml")));
                System.out.println("deneme2");
                stage.setScene(sc);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        if(event.getSource()== Raporlar){
                    

                System.out.println("deneme1");
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                System.out.println("deneme2");
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/raporOlusturma.fxml")));
                System.out.println("deneme3");
                stage.setScene(scene);
                stage.show();
        } 
        
        
    }*/

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
            if(event.getSource()== Calisanlar){  
                System.out.println("deneme3");
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                System.out.println("deneme1");
            try {
               
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Calisanlar.fxml")));
                System.out.println("deneme2");
                stage.setScene(sc);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        if(event.getSource()== Raporlar){
            System.out.println("deneme1");
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();
            System.out.println("deneme2");
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/raporOlusturma.fxml")));
            System.out.println("deneme3");
            stage.setScene(scene);
            stage.show();
        } 
    }


   

    
    
}
