package Klausurvorberaitung.Bibliothek;

import java.util.List;

public class Reihe {
    private String reiheName;
    private List<String> baenden;

    public Reihe(String reiheName, List<String> baenden) {
        this.reiheName = reiheName;
        this.baenden = baenden;
    }
}
