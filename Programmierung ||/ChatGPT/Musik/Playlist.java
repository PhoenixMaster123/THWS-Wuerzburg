package ChatGPT.Musik;

import java.util.List;

public class Playlist {
    String name;
    List<Musiktitel> titles;

    public Playlist(String name, List<Musiktitel> titles) {
        this.name = name;
        this.titles = titles;
    }
}
