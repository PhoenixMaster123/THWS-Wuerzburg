package ChatGPT.Kino;

import java.util.ArrayList;
import java.util.List;

public class Kino {
    List<KinoSaal> kinoSaalList = new ArrayList<>();
    List<Film> filmList = new ArrayList<>();

    public void addFilm(List<? extends Film> film) {
        filmList.addAll(film);
        filmList.sort(new SortMovies());
    }
    public void addKinoSaal(KinoSaal kinoSaal) {
        kinoSaalList.add(kinoSaal);
    }

    public List<Film> getFilmeByRegisseur(String regisseur) {
        return filmList.stream()
                .filter(f -> f.regisseur.equals(regisseur))
                .toList();
    }
}
