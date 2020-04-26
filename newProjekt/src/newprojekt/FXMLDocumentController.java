/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newprojekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author arsla
 */
public class FXMLDocumentController implements Initializable {

    
 
    
    @FXML
    private BorderPane border_pane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void show_calisanlar(MouseEvent event) throws IOException {
        Parent çalışanlar = FXMLLoader.load(getClass().getResource("/newprojekt/Calisanlar.fxml"));
        border_pane.setCenter(çalışanlar);
        System.out.println("bu fonksiyona giriyor");
    }

    @FXML
    private void show_raporlar(MouseEvent event) throws IOException {
        Parent raporlar = FXMLLoader.load(getClass().getResource("/newprojekt/raporlar.fxml"));
        border_pane.setCenter(raporlar);
    }

   

    
    
}
