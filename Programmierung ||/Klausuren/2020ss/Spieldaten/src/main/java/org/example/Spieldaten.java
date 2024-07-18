package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spieldaten implements Serializable {

    public double geld;
    public List<String> spielerIDs;

    private Spieldaten(double geld, List<String> spielerIDs) {
        this.geld = geld;
        this.spielerIDs = new ArrayList<>(spielerIDs);
    }
    // I need to implement from exercise  3
    public List<String> getSpielerIDs() {
        return Collections.unmodifiableList(spielerIDs); // this is for UnsupportedOperationException
    }
    public static class SpieldatenBuilder {
        private double geld;
        private final List<String> spielerIDs = new ArrayList<>();

        public SpieldatenBuilder geld(double geld) {
            this.geld = geld;
            return this;
        }

        public SpieldatenBuilder add(String spielerID) {
            spielerIDs.add(spielerID);
            return this;
        }

        public Spieldaten build() {
            return new Spieldaten(geld, spielerIDs);
        }
    }
}
