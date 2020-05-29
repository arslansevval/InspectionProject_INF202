
package newprojekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;


public class RaporlarController implements Initializable {

    @FXML
    private Text text_anabaslik;
    @FXML
    private Button exportToXLS;
    @FXML
    private Text text_üst;
    @FXML
    private Text text_altbaslik;
    @FXML
    private ChoiceBox<String> musteri_box;
    @FXML
    private ChoiceBox<String> projektName_box;
    @FXML
    private Text text_musteri;
    @FXML
    private Text text_customer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               ExportToExcel ex = new ExportToExcel();
        exportToXLS.setOnAction(e->{
            
        });
    }    

    @FXML
    private void exportToExcel(ActionEvent event) throws IOException {
        
        

    }
    
    
}
