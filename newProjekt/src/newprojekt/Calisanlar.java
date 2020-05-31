
package newprojekt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Calisanlar {
    
    private StringProperty cFirstname;
    private StringProperty cLastname;
    private StringProperty cSeviye;
    private StringProperty cID;
	
    public Calisanlar(String cID, String cFirstname, String cLastname, String cSeviye ) {
        this.cFirstname = new SimpleStringProperty(cFirstname);
	this.cLastname = new SimpleStringProperty(cLastname);
	this.cSeviye = new SimpleStringProperty(cSeviye);
	this.cID = new SimpleStringProperty(cID);
    }

    public Calisanlar(String cFirstname, String cLastname) {
        this.cFirstname = new SimpleStringProperty(cFirstname);
        this.cLastname = new SimpleStringProperty(cLastname);
    }
 
    
    public String toString(){
        return this.getcFirstname().getValue() + " " + this.getcLastname().getValue();
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
