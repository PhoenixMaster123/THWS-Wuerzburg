public class Bestellung
{
    private int bestellnummer;
    private Artikel[] artikelListe;

    public Bestellung(int bestellnummer)
    {
        this.bestellnummer = bestellnummer;
        this.artikelListe = new Artikel[50];
    }
    public int getBestellnummer() {
        return bestellnummer;
    }
    public void setBestellnummer(int bestellnummer)
    {
        this.bestellnummer = bestellnummer;
    }
    public Artikel[] getArtikelListe() {
        return artikelListe;
    }

    public void setArtikelListe(Artikel[] artikelListe) {
        this.artikelListe = artikelListe;
    }

    public void einfuegen(Artikel neuerartikel)
    {
        for(int i = 0; i < artikelListe.length; i++)
        {
            if (artikelListe[i] == null)
            {
                artikelListe[i] = neuerartikel;
                {
                    return; // Artikel wurde hinzugefügt, die Schleife kann beendet werden
                }
            }
        }
    }

    public void loeschen(String artikelname) {
        for (int i = 0; i < artikelListe.length; i++) {
            if (artikelListe[i] != null && artikelListe[i].getArtikelname().equals(artikelname)) {
                artikelListe[i] = null;
                return;
            }
        }
    }
}
