
package newprojekt;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.security.x509.UniqueIdentity;


public class Calisanlar {
    
    private final StringProperty cFirstname;
    private final StringProperty cLastname;
    private final StringProperty cSeviye;
    private final StringProperty cID;
	
    public Calisanlar(String cID, String pFirstname, String pLastname, String pSeviye ) {
        this.cFirstname = new SimpleStringProperty(pFirstname);
	this.cLastname = new SimpleStringProperty(pLastname);
	this.cSeviye = new SimpleStringProperty(pSeviye);
	this.cID = new SimpleStringProperty(cID);
    }
	
    public StringProperty getcFirstname() {
	return cFirstname;
    }
	
    public StringProperty getcLastname() {
	return cLastname;
    }
	
	
    public StringProperty getcSeviye() {
	return cSeviye;
    }
    public StringProperty getcID() {
	return cID;
    }
}
