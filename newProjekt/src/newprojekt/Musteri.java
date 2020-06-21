// Şevval Arslan 170503031
package newprojekt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Musteri {
    private final StringProperty musteriID;
    private final StringProperty musteriAd;
    private final StringProperty musteriIl;
    private final StringProperty isEmriNo;
    private final StringProperty teklifNo;
   
    
    public Musteri(String musteriID, String musteriAd, String musteriIl, String isEmriNo, String teklifNo){
        this.musteriID = new SimpleStringProperty(musteriID);
        this.musteriAd = new SimpleStringProperty(musteriAd);
        this.musteriIl = new SimpleStringProperty(musteriIl);
        this.isEmriNo = new SimpleStringProperty(isEmriNo);
        this.teklifNo = new SimpleStringProperty(teklifNo);
    }



    /**
     * @return the musteriID
     */
    public StringProperty getMusteriID() {
        return musteriID;
    }

    /**
     * @return the musteriAd
     */
    public StringProperty getMusteriAd() {
        return musteriAd;
    }

    /**
     * @return the musteriIl
     */
    public StringProperty getMusteriIl() {
        return musteriIl;
    }

    /**
     * @return the isEmriNo
     */
    public StringProperty getIsEmriNo() {
        return isEmriNo;
    }

    /**
     * @return the teklifNo
     */
    public StringProperty getTeklifNo() {
        return teklifNo;
    }

}
