// Şevval Arslan 170503031
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

    public Calisanlar(String cFirstname, String cLastname, String cSeviye) {
        this.cFirstname = new SimpleStringProperty(cFirstname);
        this.cLastname = new SimpleStringProperty(cLastname);
        this.cSeviye = new SimpleStringProperty(cSeviye);
    }
    public Calisanlar(String cFirstname, String cLastname ) {
        this.cFirstname = new SimpleStringProperty(cFirstname);
        this.cLastname = new SimpleStringProperty(cLastname);
    }    

    public Calisanlar(String cSeviye ) {
        this.cSeviye = new SimpleStringProperty(cSeviye);
    }


    @Override
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

    /**
     * @param cFirstname the cFirstname to set
     */
    public void setcFirstname(StringProperty cFirstname) {
        this.cFirstname = cFirstname;
    }

    /**
     * @param cLastname the cLastname to set
     */
    public void setcLastname(StringProperty cLastname) {
        this.cLastname = cLastname;
    }

    /**
     * @param cSeviye the cSeviye to set
     */
    public void setcSeviye(StringProperty cSeviye) {
        this.cSeviye = cSeviye;
        
    }

    /**
     * @param cID the cID to set
     */
    public void setcID(StringProperty cID) {
        this.cID = cID;
    }
}
