package org.example;

public class Kleintransporter extends Fahrzeug
{

    @Override
    public double entgelten(Fahrt fahrt) {
        if(fahrt.min <= 60)
        {
            return 0.30 * fahrt.km;
        }
        else
        {
            return 0.25 * (fahrt.min - 60) + 0.30 * fahrt.km;
        }
    }
}
