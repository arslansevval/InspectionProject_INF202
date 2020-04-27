
package newprojekt;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Calisanlar {
    
    private final StringProperty pFirstname;
    private final StringProperty pLastname;
    private final StringProperty pSeviye;
    private final IntegerProperty pID;
	
    public Calisanlar(int pID, String pFirstname, String pLastname, String pSeviye ) {
        this.pFirstname = new SimpleStringProperty(pFirstname);
	this.pLastname = new SimpleStringProperty(pLastname);
	this.pSeviye = new SimpleStringProperty(pSeviye);
	this.pID = new SimpleIntegerProperty(pID);
    }
	
    public StringProperty getpFirstname() {
	return pFirstname;
    }
	
    public StringProperty getpLastname() {
	return pLastname;
    }
	
	
    public StringProperty getpSeviye() {
	return pSeviye;
    }
    public IntegerProperty getpID() {
	return pID;
    }
}
