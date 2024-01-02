public class Kunde {
    private Bestellung[] bestellungen;

    public Kunde(Bestellung[] bestellungen) {
        this.bestellungen = bestellungen;
    }

    public Bestellung giveBestellung(String artikelName) {
        for (int i = 0; i < bestellungen.length; i++) {
            Bestellung bestellung = bestellungen[i];
            if (bestellung != null) {
                Artikel[] artikelListe = bestellung.getArtikelListe();
                for (int j = 0; j < artikelListe.length; j++) {
                    Artikel artikel = artikelListe[j];
                    if (artikel != null && artikel.getArtikelname().equals(artikelName)) {
                        return bestellung;
                    }
                }
            }
        }
        return null;
    }
}

