package ChatGPT.Musik;

import java.util.Comparator;

public class SortTitle implements Comparator<Musiktitel> {
    @Override
    public int compare(Musiktitel t1, Musiktitel t2) {

        int result = t1.interpret.compareTo(t2.interpret);

        if(result == 0) {
            return t1.titel.compareTo(t2.titel);
        }

        return result;
    }
}
