/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

/**
 *
 * @author arsla
 */
public class FXMLDocumentController implements Initializable {

    
 
    


    @FXML
    private Button calisanlar;
    @FXML
    private Button Raporlar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        if(event.getSource()== calisanlar){
            
            System.out.println("deneme3");
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();
            System.out.println("deneme1");
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/Calisanlar.fxml")));
            System.out.println("deneme2");
            stage.setScene(scene);
            stage.show();
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
