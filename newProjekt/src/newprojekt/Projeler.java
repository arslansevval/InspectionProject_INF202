
package newprojekt;

import javafx.beans.property.StringProperty;


public class Projeler {
    private final StringProperty projeID;
    private final StringProperty projeAdı;
    
    public Projeler(StringProperty projeID, StringProperty projeAdı){
        this.projeAdı = projeAdı;
        this.projeID = projeID;
    
    }

    /**
     * @return the projeID
     */
    public StringProperty getProjeID() {
        return projeID;
    }

    /**
     * @return the projeAdı
     */
    public StringProperty getProjeAdı() {
        return projeAdı;
    }
    
}
