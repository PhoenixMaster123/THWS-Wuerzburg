package Klausurvorberaitung.Bibliothek;
public abstract class Buch implements IBuch {
    private String name;
    private String author;
    private String verlag;
    private int preisInCent;
    private Reihe reihe;

    // Map<String, List<String>> reihe = new HashMap<>();

    public Buch(String name, String author, String verlag, int preisInCent) {
        this.name = name;
        this.author = author;
        this.verlag = verlag;
        this.preisInCent = preisInCent;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
