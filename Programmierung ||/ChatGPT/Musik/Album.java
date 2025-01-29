package ChatGPT.Musik;

import java.util.List;

public class Album {
    String name;
    List<String> titles;
    String date;

    public Album(String name, List<String> titles, String date) {
        this.name = name;
        this.titles = titles;
        this.date = date;
    }
}
