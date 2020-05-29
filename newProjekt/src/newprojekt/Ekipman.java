
package newprojekt;

import javafx.beans.property.StringProperty;


public class Ekipman {
    private final StringProperty cihaz;
    private final StringProperty kutupMesafesi;
    private final StringProperty mpTasiyiciOrtam;
    
    public Ekipman(StringProperty cihaz, StringProperty kutupMesafesi, StringProperty mpTasiyiciOrtam){
        this.cihaz = cihaz;
        this.kutupMesafesi = kutupMesafesi;
        this.mpTasiyiciOrtam = mpTasiyiciOrtam;
    }
}
