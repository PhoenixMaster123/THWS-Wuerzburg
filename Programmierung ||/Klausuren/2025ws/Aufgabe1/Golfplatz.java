package Klausurvorberaitung.ws2025.Aufgabe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

// Aufgabe 1 → 15 Punkte
public class Golfplatz {
    public List<GolfBahn> bahnList;
    //........
    public Golfplatz(List<GolfBahn> bahnList) {
        importBahnList();
    }

    // a)
    private void importBahnList() {
        try(BufferedReader br = new BufferedReader(new FileReader("bahnen.csv"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int index = Integer.parseInt(parts[0]);
                int par = Integer.parseInt(parts[1]);
                int hcv = Integer.parseInt(parts[2]);

                GolfBahn bahn = new GolfBahn(index, par, hcv);

                bahnList.add(bahn);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    // b) Du hattest interface mit methode:
    // transform() und mit Hilfe von lambda
}
