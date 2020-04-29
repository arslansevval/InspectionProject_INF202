/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newprojekt;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arsla
 */
public class RaporOlusturmaController implements Initializable {

    @FXML
    private BorderPane border;
    @FXML
    private Button geri;
    @FXML
    private Button yenirapor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void show_yenirapor(MouseEvent event) throws IOException {
        Parent yenirapor = FXMLLoader.load(getClass().getResource("/newprojekt/raporlar.fxml"));
        border.setCenter(yenirapor);
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
            }   catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


 

    
}
