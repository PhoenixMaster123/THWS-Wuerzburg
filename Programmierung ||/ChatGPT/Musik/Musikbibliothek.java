package ChatGPT.Musik;

import java.util.ArrayList;
import java.util.List;

public class Musikbibliothek {
    List<Musiktitel> musiktitelList = new ArrayList<>();

    public void addTitles(List<? extends Musiktitel> titles) {
        musiktitelList.addAll(titles);
        titles.sort(new SortTitle());
    }

    public List<Musiktitel> searchByInterpret(String interpret) {
        return musiktitelList.stream()
                .filter(k -> k.interpret.equals(interpret))
                .toList();
    }

    public int gesamtDauer() {
        int total = 0;

        for (Musiktitel musiktitel : musiktitelList) {
            total += musiktitel.laengeInSekunden;
        }
        return total;
    }
}
