package GUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Dagbok {
    private final SimpleStringProperty dato;
    private final SimpleStringProperty tid;
    private final SimpleStringProperty notat;

    public Dagbok(String dato, String tid, String notat) {
        this.dato = new SimpleStringProperty(dato);
        this.tid = new SimpleStringProperty(tid);
        this.notat = new SimpleStringProperty(notat);
    }
    public String getDato() {
        return dato.get();
    }

    public SimpleStringProperty datoProperty() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato.set(dato);
    }



    public String getTid() {
        return tid.get();
    }

    public SimpleStringProperty tidProperty() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid.set(tid);
    }


    public String getNotat() {
        return notat.get();
    }

    public SimpleStringProperty notatProperty() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat.set(notat);
    }

}
