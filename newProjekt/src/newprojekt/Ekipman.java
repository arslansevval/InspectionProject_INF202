// Şevval Arslan 170503031
package newprojekt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Ekipman {
    
    private StringProperty cihaz;
    private StringProperty kutupMesafesi;
    private StringProperty mpTasiyiciOrtam;
    private StringProperty miknatislamaTeknigi;
    private StringProperty uvİsikSiddeti;
    private StringProperty isikMesafesi;
    
    public Ekipman(String cihaz, String kutupMesafesi, String mpTasiyiciOrtam,String miknatislamaTeknigi,String uvİsikSiddeti,String isikMesafesi){
        this.cihaz = new SimpleStringProperty(cihaz);
        this.kutupMesafesi = new SimpleStringProperty(kutupMesafesi);
        this.mpTasiyiciOrtam = new SimpleStringProperty(mpTasiyiciOrtam);
        this.miknatislamaTeknigi = new SimpleStringProperty(miknatislamaTeknigi);
        this.uvİsikSiddeti = new SimpleStringProperty(uvİsikSiddeti);
        this.isikMesafesi = new SimpleStringProperty(isikMesafesi);
    }
    public Ekipman(String kutupmesafesi, String mpTasiyiciOrtam, String miknatislamaTeknigi, String uvİsikSiddeti, String isikMesafesi){
        this.kutupMesafesi = new SimpleStringProperty(kutupmesafesi);
        this.mpTasiyiciOrtam = new SimpleStringProperty(mpTasiyiciOrtam);
        this.miknatislamaTeknigi = new SimpleStringProperty(miknatislamaTeknigi);
        this.uvİsikSiddeti = new SimpleStringProperty(uvİsikSiddeti);
        this.isikMesafesi = new SimpleStringProperty(isikMesafesi);
    }

    public String toString(){
        return this.getKutupMesafesi().getValue() + " " + this.getMpTasiyiciOrtam().getValue() + " " + this.getMiknatislamaTeknigi().getValue()
                + " " + this.getUvİsikSiddeti().getValue() + " " + this.getIsikMesafesi().getValue();
    }
    /**
     * @return the cihaz
     */
    public StringProperty getCihaz() {
        return cihaz;
    }

    /**
     * @return the kutupMesafesi
     */
    public StringProperty getKutupMesafesi() {
        return kutupMesafesi;
    }

    /**
     * @return the mpTasiyiciOrtam
     */
    public StringProperty getMpTasiyiciOrtam() {
        return mpTasiyiciOrtam;
    }

    /**
     * @return the miknatislamaTeknigi
     */
    public StringProperty getMiknatislamaTeknigi() {
        return miknatislamaTeknigi;
    }

    /**
     * @return the uvİsikSiddeti
     */
    public StringProperty getUvİsikSiddeti() {
        return uvİsikSiddeti;
    }

    /**
     * @return the isikMesafesi
     */
    public StringProperty getIsikMesafesi() {
        return isikMesafesi;
    }
    
}
