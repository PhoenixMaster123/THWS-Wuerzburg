package Klausurvorberaitung.Bibliothek;

public class Hoerbuch extends Buch {
    private String sprecher;
    private int spieldauer;
    public Hoerbuch(String name, String author, String verlag, int preisInCent, String sprecher, int spieldauer) {
        super(name, author, verlag, preisInCent);
        this.sprecher = sprecher;
        this.spieldauer = spieldauer;
    }
}
