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
            while (currentZielort.next != null) {
                currentZielort = currentZielort.next;
            }
            currentZielort.next = newZielort;
        }
    }

    public double gesamtStrecke() {
        double gesamtEntfernung = 0;
        Zielort currentZielort = firstZielort;

        while (currentZielort != null) {
            gesamtEntfernung += currentZielort.getDistanz();
            currentZielort = currentZielort.next;
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
            if (currentZielort.next != null)
            {
                str += " -> ";
            }
            currentZielort = currentZielort.next;
        }

        return str;
    }
}


