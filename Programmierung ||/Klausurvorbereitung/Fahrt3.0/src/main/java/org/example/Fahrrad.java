package org.example;

public class Fahrrad extends Fahrzeug
{
    @Override
    public double entgelten(Fahrt fahrt)
    {
        return 0.125 * fahrt.min;
    }
}
