package Klausurvorberaitung.Bibliothek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Bibliothek {
    private final List<Buch> buchList = new ArrayList<>();
    //private TreeSet<Buch> buchTreeSet = new TreeSet<>(new SortBuch());

    public void addBuch(List<? extends Buch> buch) {
        buchList.addAll(buch);
        //buchList.sort(new SortBuch());
        // buchTreeSet.addAll(buch);
        Collections.sort(buchList, new SortBuch());
    }

    public List<Buch> searchByAuthor(String author) {
       return buchList.stream().
               filter(k -> k.getAuthor().equals(author))
               .toList();
    }

    public List<Buch> getBuchList() {
        return buchList;
    }
}
