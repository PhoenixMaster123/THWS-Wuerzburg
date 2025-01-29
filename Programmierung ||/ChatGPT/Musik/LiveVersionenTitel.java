package ChatGPT.Musik;

public class LiveVersionenTitel extends Musiktitel{
    String ort;

    public LiveVersionenTitel(String titel, String interpret, Album album, int laengeInSekunden, String ort) {
        super(titel, interpret, album, laengeInSekunden);
        this.ort = ort;
    }
}
