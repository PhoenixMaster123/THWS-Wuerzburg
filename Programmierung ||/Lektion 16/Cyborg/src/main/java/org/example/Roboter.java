package org.example;

public class Roboter implements RoboterInterface
{
    //public Callable<Gefahrensituationen> entscheide;

    @Override
    public void Aufladen() {

    }

    @Override
    public void Warten() {

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
        if(gefahrensituationen == null)
        {
            throw new NullPointerException("Gefahrensituationen darf nicht null sein");
        }
        return switch (gefahrensituationen)
        {
            case GEFAHR_LINKS -> Reaktion.RECHTS;

            case GEFAHR_RECHTS -> Reaktion.LINKS;

            case GEFAHR_VORNE -> Reaktion.BREMSEN;
            default -> null;
        };
    }

}
