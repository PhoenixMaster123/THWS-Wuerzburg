package Klausurvorberaitung.ss2020.Aufgabe4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spieldaten implements Serializable {
    private int geld;
    private List<String> spielerIDs;
    private Spieldaten(SpieldatenBuilder builder) {
        this.geld = builder.geld;
        this.spielerIDs = Collections.unmodifiableList(builder.spielerIDs);
    }

    public int getGeld() {
        return geld;
    }

    public List<String> getSpielerIDs() {
        return spielerIDs;
    }

    public static class SpieldatenBuilder {
        private int geld;
        private final List<String> spielerIDs = new ArrayList<>();

        public SpieldatenBuilder geld(int geld) {
            this.geld = geld;
            return this;
        }

        public SpieldatenBuilder add(String spielerID) {
            this.spielerIDs.add(spielerID);
            return this;
        }

        public Spieldaten build() {
            return new Spieldaten(this);
        }
    }
}
