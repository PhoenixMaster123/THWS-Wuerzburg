public class Fahrstrecke {
    Zielort firstZielort;

    public Fahrstrecke() {
        this.firstZielort = null;
    }

    public void einfuegen(String name, int distanz) {
        Zielort newZielort = new Zielort(name, distanz);
        if (firstZielort == null) {
            firstZielort = newZielort;
        }
        else {
            Zielort currentZielort = firstZielort;
            while (currentZielort.next != null) {
                currentZielort = currentZielort.next;
            }
            currentZielort.next = newZielort;
        }
    }

    public int gesamtStrecke() {
        int gesamtEntfernung = 0;
        Zielort currentZielort = firstZielort;

        while (currentZielort != null) {
            gesamtEntfernung += currentZielort.distanz;
            currentZielort = currentZielort.next;
        }
        return gesamtEntfernung;
    }
}


