package Klausurvorberaitung.Bibliothek;

import java.util.Comparator;

public class SortBuch implements Comparator<Buch> {
    @Override
    public int compare(Buch b1, Buch b2) {

        int result = b1.getAuthor().compareTo(b2.getAuthor());

        if(result == 0) {
            return b1.getName().compareTo(b2.getName());
        }
        return result;
    }
}
