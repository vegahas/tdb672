package GUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Jenny on 11.03.2016.
 */
public class Mal {
     private final SimpleStringProperty malName;
        private final SimpleIntegerProperty malID;

    public Mal(String malName, Integer malID) {
        this.malName = new SimpleStringProperty(malName);
        this.malID = new SimpleIntegerProperty(malID);
    }
        public int getMalID() {
            return malID.get();
        }

        public SimpleIntegerProperty malIDProperty() {
            return malID;
        }

        public void setMalID(int malID) {
            this.malID.set(malID);
        }



        public String getMalName() {
            return malName.get();
        }

        public SimpleStringProperty malNameProperty() {
            return malName;
        }

        public void setMalName(String malName) {
            this.malName.set(malName);
        }

    }
