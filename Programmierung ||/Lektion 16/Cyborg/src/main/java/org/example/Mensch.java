package org.example;

public class Mensch implements MenschInterface
{

   // public Callable<Gefahrensituationen> entscheide;

    @Override
    public void Essen() {

    }

    @Override
    public void Schlafen() {

    }
    @Override
    public void Arbeiten() {

    }

    @Override
    public void Autofahren() {

    }

    @Override
    public Reaktion entscheide(Gefahrensituationen gefahrensituationen)
    {
        if (gefahrensituationen == null) {
            throw new NullPointerException("gefahrensituationen cannot be null");
        }
        if(random() <= 0.25)
        {
            return Reaktion.UNENTSCHIEDEN;
        }
        return switch (gefahrensituationen)
        {
            case GEFAHR_LINKS -> Reaktion.RECHTS;

            case GEFAHR_RECHTS -> Reaktion.LINKS;

            case GEFAHR_VORNE -> Reaktion.BREMSEN;
            default -> null;
        };
    }
    public double random()
    {
        return Math.random();
    }
}
