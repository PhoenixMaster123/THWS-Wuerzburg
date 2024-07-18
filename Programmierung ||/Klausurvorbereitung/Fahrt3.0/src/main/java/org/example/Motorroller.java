package org.example;

public class Motorroller extends Fahrzeug
{
    @Override
    public double entgelten(Fahrt fahrt)
    {
        return 3 + 0.15 * fahrt.km;
    }
}
