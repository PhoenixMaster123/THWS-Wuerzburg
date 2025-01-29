package ChatGPT.Musik;

public interface IMusiktitel {
    String getTitel();
    String getInterpret();
    Album getAlbum();

    void setTitel(String titel);
    void setInterpret(String interpret);
    void setAlbum(Album album);
}
