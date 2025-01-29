package ChatGPT.Kino;

import java.util.Comparator;

public class SortMovies implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        int result = f1.regisseur.compareTo(f2.regisseur);

        if(result == 0) {
            return f1.title.compareTo(f2.title);
        }
        return result;
    }
}
