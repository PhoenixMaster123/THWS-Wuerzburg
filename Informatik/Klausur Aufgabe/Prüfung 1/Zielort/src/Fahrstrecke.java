public class Fahrstrecke {
    private Zielort firstZielort;

    public Fahrstrecke()
    {
        this.firstZielort = null;
    }

    public void einfuegen(String name, double distanz) {
        Zielort newZielort = new Zielort(name, distanz);
        System.out.println(newZielort);
        if (firstZielort == null) {
            firstZielort = newZielort;
        }
        else {
            Zielort currentZielort = firstZielort;
            while (currentZielort.getNext() != null) {
                currentZielort = currentZielort.getNext();
            }
            currentZielort.setNext(newZielort);
        }
    }

    public double gesamtStrecke() {
        double gesamtEntfernung = 0;
        Zielort currentZielort = firstZielort;

        while (currentZielort != null) {
            gesamtEntfernung += currentZielort.getDistanz();
            currentZielort = currentZielort.getNext();
        }
        return gesamtEntfernung;
    }
    @Override
    public String toString()
    {
        String str = "";
        Zielort currentZielort = firstZielort;

        while (currentZielort != null) {
            str += currentZielort.getNameZielort();
            str += "(" + currentZielort.getDistanz() + ")";
            if (currentZielort.getNext() != null)
            {
                str += " -> ";
            }
            currentZielort = currentZielort.getNext();
        }

        return str;
    }
}
