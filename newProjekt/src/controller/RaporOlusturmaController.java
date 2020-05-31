/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.FXMLDocumentController;
import database.DataAccessObject;
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
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import newprojekt.Calisanlar;


public class RaporOlusturmaController implements Initializable {

    
    @FXML
    private Button geri;
    @FXML
    private ComboBox<Calisanlar> operator_box;
    @FXML
    private ComboBox<Calisanlar> degerlendiren_box;
    @FXML
    private ComboBox<Calisanlar> onay_box;
    @FXML
    private Button yeniRapor;
    
    static Calisanlar secilen;
    static Calisanlar secilen2;
    static Calisanlar secilen3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        

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
            }   catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(event.getSource()== yeniRapor){
            try {
                secilen = operator_box.getSelectionModel().getSelectedItem();
                System.out.println(secilen);
                secilen2 = degerlendiren_box.getSelectionModel().getSelectedItem();
                System.out.println(secilen2);
                secilen3 = onay_box.getSelectionModel().getSelectedItem();
                System.out.println(secilen3);
                System.out.println("farkli1");
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                System.out.println("farkli2");
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/raporlar.fxml")));

                stage.setScene(scene);
                stage.show();

                System.out.println("deneme3");
            }   catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    DataAccessObject da = new DataAccessObject();
    @FXML
    private void operatorSetOnClicked(MouseEvent event) {
        operator_box.setItems(da.choiceCalisan());
    }

    @FXML
    private void degerlendirenSetOnClicked(MouseEvent event) {
        degerlendiren_box.setItems(da.choiceCalisan());
    }

    @FXML
    private void onaySetOnClicked(MouseEvent event) {
        onay_box.setItems(da.choiceCalisan());
    }

  
    


 

    
}
