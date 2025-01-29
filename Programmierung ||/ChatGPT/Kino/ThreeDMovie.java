package ChatGPT.Kino;

public class ThreeDMovie extends Film {
    int aufpreisInCents;
    String moreInfo;
    public ThreeDMovie(String title, String regisseur, String produktionsfirma, int preisInCents, int dauerInMinuten, Reihe reihe, int aufpreisInCents, String moreInfo) {
        super(title, regisseur, produktionsfirma, preisInCents, dauerInMinuten, reihe);
        this.aufpreisInCents = aufpreisInCents;
        this.moreInfo = moreInfo;
    }
}
