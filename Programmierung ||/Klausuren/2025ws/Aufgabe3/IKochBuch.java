package Klausurvorberaitung.ws2025.Aufgabe3;

import java.util.ArrayList;
import java.util.List;

public class IKochBuch {
    public List<Gericht> gerichtListe = new ArrayList<>();

    // c)
    public void addGericht(List<? extends Gericht> gerichts) {
        gerichtListe.addAll(gerichts);
    }

    public List<Gericht> filterByZutat(List<Zutat> zutats) {
        List<Gericht> filtered = new ArrayList<>();
        for (Gericht gericht : gerichtListe) {
            for (Zutat zutat : zutats) {
                if (gericht.zutatList.contains(zutat)) {
                    filtered.add(gericht);
                    break;
                }
            }
        }
        return filtered;
    }

    // d) Schreiben Sie JUNIT-Tests für die Methoden aus Teil c)
    // Sie können Iterator verwenden, um die Liste zu durchlaufen
}
