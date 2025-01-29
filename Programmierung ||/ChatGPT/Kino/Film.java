package ChatGPT.Kino;

public abstract class Film {
    String title;
    String regisseur;
    String produktionsfirma;
    int preisInCents;
    int dauerInMinuten;

    Reihe reihe;

    public Film (String title, String regisseur, String produktionsfirma, int preisInCents, int dauerInMinuten, Reihe reihe) {
        this.title = title;
        this.regisseur = regisseur;
        this.produktionsfirma = produktionsfirma;
        this.preisInCents = preisInCents;
        this.dauerInMinuten = dauerInMinuten;
        this.reihe = reihe;
    }
}
