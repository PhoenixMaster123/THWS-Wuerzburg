package ChatGPT.Musik;

public abstract class Musiktitel implements IMusiktitel{
    String titel;
    String interpret;
    Album album;
    int laengeInSekunden;

    public Musiktitel(String titel, String interpret, Album album, int laengeInSekunden) {
        this.titel = titel;
        this.interpret = interpret;
        this.album = album;
        this.laengeInSekunden = laengeInSekunden;
    }

    @Override
    public String getTitel() {
        return this.titel;
    }
    @Override
    public String getInterpret() {
        return this.titel;
    }
    @Override
    public Album getAlbum() {
        return this.album;
    }

    @Override
    public void setTitel(String titel) {
        this.titel = titel;
    }
    @Override
    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }
    @Override
    public void setAlbum(Album album) {
        this.album = album;
    }

}
