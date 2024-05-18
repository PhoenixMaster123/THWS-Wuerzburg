package org.example;

public class Naehrstoffangaben
{
    //verpflichtenden Feldern
    int portionsgroesse;
    int anzahlPortionen;
    //optionalen Feldern
    double eiweiss;
    double fett;
    double kohlenhydrate;
    double natrium;

    private Naehrstoffangaben(NaehrstoffangabenBuilder builder) {
        this.portionsgroesse = builder.portionsgroesse;
        this.anzahlPortionen = builder.anzahlPortionen;
        this.eiweiss = builder.eiweiss;
        this.fett = builder.fett;
        this.kohlenhydrate = builder.kohlenhydrate;
        this.natrium = builder.natrium;
    }
    public static class NaehrstoffangabenBuilder {
        int portionsgroesse;
        int anzahlPortionen;
        //optionalen Feldern
        double eiweiss;
        double fett;
        double kohlenhydrate;
        double natrium;

        public NaehrstoffangabenBuilder(int portionsgroesse, int anzahlPortionen)
        {
            this.portionsgroesse = portionsgroesse;
            this.anzahlPortionen = anzahlPortionen;
        }
        public NaehrstoffangabenBuilder withEiweiss(double eiweiss) {
            this.eiweiss = eiweiss;
            return this;
        }

        public NaehrstoffangabenBuilder withFett(double fett) {
            this.fett = fett;
            return this;
        }

        public NaehrstoffangabenBuilder withKohlenhydrate(double kohlenhydrate) {
            this.kohlenhydrate = kohlenhydrate;
            return this;
        }

        public NaehrstoffangabenBuilder withNatrium(double natrium) {
            this.natrium = natrium;
            return this;
        }
        public Naehrstoffangaben build()
        {
            return new Naehrstoffangaben(this);
        }
    }
    public String toString()
    {
        return  "Größe: " + portionsgroesse + "\n" +
                "Anzahl: " + anzahlPortionen + "\n" +
                "Eiweiss: " + eiweiss + "\n" +
                "Fett: " + fett + "\n" +
                "Kohlenhydrate: " + kohlenhydrate + "\n" +
                "Natrium: " + natrium + "\n";
    }
}
